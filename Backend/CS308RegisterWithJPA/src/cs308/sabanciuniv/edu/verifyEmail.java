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
 * Servlet implementation class verifyEmail
 */
@WebServlet("/verify")
public class verifyEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyEmail() {
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
		
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(session.getAttribute("password").toString().getBytes(StandardCharsets.UTF_8));
			String correctCode = session.getAttribute("mycode").toString();
			String userInput = request.getParameter("usercode");
			
			if(correctCode.contentEquals(userInput))
			{
				User temp = new User(session.getAttribute("name").toString(), session.getAttribute("email").toString(), new String(hash, "UTF-8"));
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				EntityManager entityManager = emf.createEntityManager();
				entityManager.getTransaction().begin();
				temp.setUserType(User.userType.User);
				entityManager.persist(temp);
				
				entityManager.getTransaction().commit();
				response.sendRedirect("index.jsp");
			}
			else
			{

				session.setAttribute("verify-error", "Your verification code is invalid.");
				response.sendRedirect("verify2.jsp");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
