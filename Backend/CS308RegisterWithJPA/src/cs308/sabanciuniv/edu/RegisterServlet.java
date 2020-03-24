package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		try {
			String name = request.getParameter("name");
			String lastname = request.getParameter("lastname");
			String password = request.getParameter("pass");
			String email = request.getParameter("email");
			User searchResult = User.findByEmail(email);
			if(searchResult != null)
			{
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='2;URL=login.html'>"); 
				out.println("<p style='color:green;'>The email is already in use...</p>");
				return;
			}
			else
			{
<<<<<<< HEAD
				//validate email address
				Validations validations = new Validations(); // new object
				// maybe add try catch later
				//out.println(validations.validateEmailAddress(email));
				if(validations.validateEmailAddress(email).contentEquals("Valid Email Address"))
				{
					User temp = new User(name, lastname, email, new String(hash, "UTF-8"));
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
					EntityManager entityManager = emf.createEntityManager();
					entityManager.getTransaction().begin();
					
					entityManager.persist(temp);
					
					entityManager.getTransaction().commit();
					
					response.sendRedirect("secure.html");
				}
				
				else
				{
					// trial purposes
					out.println("invalid email!!!");
				}
	
			
=======
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
				session.setAttribute("lastname", lastname);
				session.setAttribute("password", password);
				
				response.sendRedirect("verify.html");
				
				//RequestDispatcher rd = request.getRequestDispatcher("verify.html");
				
				//rd.forward(request, response);
				
>>>>>>> Aybars
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<meta http-equiv='refresh' content='2;URL=register.html'>"); 
			out.println("<p style='color:orange;'>Please make sure to fill all the entries...</p>");
			e.printStackTrace();
		}
	}

}
