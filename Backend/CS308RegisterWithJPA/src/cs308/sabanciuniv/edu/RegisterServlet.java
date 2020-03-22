package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			String passwordRepeated = request.getParameter("passRepeated");
			String email = request.getParameter("email");
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			User searchResult = User.findByEmail(email);
			if(searchResult != null)
			{
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='2;URL=login.html'>"); 
				out.println("<p style='color:green;'>The email is already in use...</p>");
				return;
			}
			if(!password.contentEquals(passwordRepeated))
			{
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='2;URL=register.html'>"); //redirects after 2 seconds
				out.println("<p style='color:red;'>Passwords don't match!!!!</p>");
			}
			else
			{
				User temp = new User(name, lastname, email, new String(hash, "UTF-8"));
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				EntityManager entityManager = emf.createEntityManager();
				entityManager.getTransaction().begin();
				
				entityManager.persist(temp);
				
				entityManager.getTransaction().commit();
				
				response.sendRedirect("secure.html");
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<meta http-equiv='refresh' content='2;URL=register.html'>"); 
			out.println("<p style='color:orange;'>Please make sure to fill all the entries...</p>");
			e.printStackTrace();
		}
	}

}
