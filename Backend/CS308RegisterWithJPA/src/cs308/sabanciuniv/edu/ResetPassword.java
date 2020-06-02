package cs308.sabanciuniv.edu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet(name = "resetpassword", urlPatterns = { "/resetpassword" })
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
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
		Connection conn;
		PreparedStatement ps;
		try {
			HttpSession session = request.getSession();
			String correctCode = session.getAttribute("mycode").toString();
			String useremail = session.getAttribute("email").toString();
			String userCode = request.getParameter("usercode");
			if(correctCode.contentEquals(userCode))
			{
				conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
				ps = conn.prepareStatement("UPDATE User set password=? where Email=?");

				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(request.getParameter("password").getBytes(StandardCharsets.UTF_8));

				ps.setString(1,new String(hash, "UTF-8"));
				ps.setString(2,useremail);
				int number = ps.executeUpdate();

				System.out.println(number + " of rows have been updated...");

				conn.close();
				ps.close();
				session.setAttribute("order-error", "Password has changed successfully.");
				session.removeAttribute("forgotPasswordCorrect");
				response.sendRedirect("login.jsp");
			}
			else
			{
				session.setAttribute("verify-error", "Your verification code is invalid.");
				response.sendRedirect("verify2.jsp");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
