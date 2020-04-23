package cs308.sabanciuniv.edu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

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
		try {
			String emailInput = request.getParameter("email");
			String passInput = request.getParameter("pass");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
			EntityManager em = emf.createEntityManager();
			User searchResult = em.find(User.class,emailInput);
			emf.close();
			em.close();
			em=null;
			emf=null;
			if(searchResult != null)
			{
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(passInput.getBytes(StandardCharsets.UTF_8));
				if(searchResult.getPassword().contentEquals(new String(hash, "UTF-8")))
				{
					HttpSession session = request.getSession();
					//PrintWriter out = response.getWriter();
					session.setAttribute("user", searchResult);
					response.sendRedirect("index.jsp");
					//out.println("<html><meta http-equiv='refresh' content='1;URL=index.jsp'>"); //redirects after 1 second
					//.println("<p style='color:red;'>Successfully logged in, redirecting to home page...</p></html>");
					//response.sendRedirect("home_Deniz.html");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("order-error", "Wrong password!!!");
					response.sendRedirect("login.jsp");
					//PrintWriter out = response.getWriter();
					//out.println("<html><meta http-equiv='refresh' content='3;URL=register.jsp'>"); //redirects after 3 seconds
					//out.println("<p style='color:red;'>Wrong Password!!!!!</p></html>");
				}
			}
			else
			{
				//PrintWriter out = response.getWriter();
				//out.println("<html><meta http-equiv='refresh' content='3;URL=register.jsp'>"); //redirects after 3 seconds
				//out.println("<p style='color:red;'>No such email was found, redirecting to the register page</p></html>");
				HttpSession session = request.getSession();
				session.setAttribute("order-error", "No such e-mail found!!!");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
