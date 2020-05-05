package cs308.sabanciuniv.edu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
		EntityManager em = emf.createEntityManager();
		try{
			String name = request.getParameter("name");
			String password = request.getParameter("pass");
			String email = request.getParameter("email");
			//User searchResult = User.findByEmail(email);
			User searchResult = em.find(User.class, email);
			if(searchResult != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("register-error", "The e-mail is already in use.");
				response.sendRedirect("register.jsp");
				return;
			}
			else
			{
				/*
				User temp = new User(name, lastname, email, new String(hash, "UTF-8"));
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				EntityManager entityManager = emf.createEntityManager();
				entityManager.getTransaction().begin();
				
				entityManager.persist(temp);
				
				entityManager.getTransaction().commit();
				*/
				
				SecureRandom random = new SecureRandom();
				int num = random.nextInt(1000000);
				String formatted = String.format("%05d", num); 
				
				JavaMailUtil.sendMail(name, request.getParameter("email"), formatted);
				
				HttpSession session = request.getSession();
				
				session.setAttribute("mycode", formatted);
				session.setAttribute("name", name);
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				
				response.sendRedirect("verify.jsp");
				
				//RequestDispatcher rd = request.getRequestDispatcher("verify.html");
				
				//rd.forward(request, response);

			}
		} catch (Exception e) {
			HttpSession session = request.getSession();
			session.setAttribute("register-error", "Make sure to fill all the entries.");
			response.sendRedirect("register.jsp");
			e.printStackTrace();
		}
		em.close();
		emf.close();
	}

}
