package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

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
		try {
			HttpSession session = request.getSession();
			String correctCode = session.getAttribute("mycode").toString();
			String useremail = session.getAttribute("email").toString();
			String userCode = request.getParameter("usercode");
			if(correctCode.contentEquals(userCode))
			{
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				EntityManager em = emf.createEntityManager();
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(request.getParameter("password").getBytes(StandardCharsets.UTF_8));
				
				em.getTransaction().begin();
				
				Query query = em.createQuery("UPDATE User SET password = :newpass WHERE EMAIL = :email");
				query.setParameter("newpass", new String(hash, "UTF-8"));
				query.setParameter("email", useremail);
				int number = query.executeUpdate();
				System.out.println(number + " of rows have been updated...");
				
				
				em.getTransaction().commit();
				
				PrintWriter out = response.getWriter();
				out.println("<html><meta http-equiv='refresh' content='3;URL=login.html'>"); 
				out.println("<p style='color:green;'>Password changed successfully, redirecting to the login page in 3 seconds</p></html>");
			}
			else
			{
				PrintWriter out = response.getWriter();
				out.println("<html><meta http-equiv='refresh' content='3;URL=forgotpassword.html'>"); 
				out.println("<p style='color:red;'>Verification code is incorrect!!!</p></html>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
