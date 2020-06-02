package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet(name = "forgotpassword", urlPatterns = { "/forgotpassword" })
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useremail = request.getParameter("email");
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("Select * from User where Email=?");
			ps.setString(1,useremail);
			rs = ps.executeQuery();
			HttpSession session = request.getSession();
			if(rs.next()){
				SecureRandom random = new SecureRandom();
				int num = random.nextInt(1000000);
				String formatted = String.format("%05d", num);

				String message = "Hello, " + rs.getString("name") + "\n" + "Your code for resetting your password is as follows\n" + formatted;
				JavaMailUtil.sendMailwithMessage(message, useremail);


				session.setAttribute("forgotPasswordCorrect", "true");
				session.setAttribute("mycode", formatted);
				session.setAttribute("email", useremail);
				response.sendRedirect("verify2.jsp");
			}
			else
			{
				session.setAttribute("forgotPasswordIncorrect","true");
				response.sendRedirect("forgotPassword.jsp");
			}
			conn.close();
			ps.close();
			rs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		conn = null;
		ps = null;
		rs = null;
	}
}
