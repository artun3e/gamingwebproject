package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

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
		User temp = User.findByEmail(useremail);
		if(temp == null)
		{
			PrintWriter out = response.getWriter();
			out.println("<html><meta http-equiv='refresh' content='2;URL=register.html'>"); 
			out.println("<p style='color:red;'>User with that e-mail could not be found</p></html>");
		}
		else
		{
			SecureRandom random = new SecureRandom();
			int num = random.nextInt(1000000);
			String formatted = String.format("%05d", num); 
			
			String message = "Hello, " + temp.getName() + "\n" + "Your code for resetting your password is as follows\n" + formatted;
			JavaMailUtil.sendMailwithMessage(message, useremail);
			
			HttpSession session = request.getSession();
			session.setAttribute("mycode", formatted);
			session.setAttribute("email", useremail);
			
			response.sendRedirect("verify2.jsp");
		}
	}

}
