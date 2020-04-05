package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login servlet, executed!");
		// TODO Auto-generated method stub
		try {
			String emailInput = request.getParameter("email");
			String passInput = request.getParameter("pass");
			User searchResult = User.findByEmail(emailInput);
			if(searchResult != null)
			{
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(passInput.getBytes(StandardCharsets.UTF_8));
				if(searchResult.getPassword().contentEquals(new String(hash, "UTF-8")))
				{
					HttpSession session = request.getSession();
					session.setAttribute("loggedIn", true);
					response.sendRedirect("secure2.html");
				}
				else
				{
					PrintWriter out = response.getWriter();
					out.println("<html><meta http-equiv='refresh' content='3;URL=register.html'>"); //redirects after 3 seconds
					out.println("<p style='color:red;'>Wrong Password!!!!!</p></html>");
				}
			}
			else
			{
				PrintWriter out = response.getWriter();
				out.println("<html><meta http-equiv='refresh' content='3;URL=register.html'>"); //redirects after 3 seconds
				out.println("<p style='color:red;'>No such email was found, redirecting to the register page</p></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
