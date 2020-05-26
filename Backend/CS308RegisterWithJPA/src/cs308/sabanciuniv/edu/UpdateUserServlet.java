package cs308.sabanciuniv.edu;

import java.io.IOException;

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
 * Servlet implementation class UpdateUserServlet
 */

@WebServlet(name = "UpdateUserServlet", urlPatterns = {
	    "/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
		 HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
         if (user == null) {
             System.out.println("You are not logged in!!!");
         }
         else {
             System.out.println("You are logged in!!!");
         
			String name = request.getParameter("name");
			System.out.println(name);
			String oldPassword = request.getParameter("cpassword");
			System.out.println(oldPassword);
			String newPassword = request.getParameter("npassword");
			System.out.println(newPassword);
			String email = user.getEmail();
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
			EntityManager em = emf.createEntityManager();
			
			// update user info from the database
			//if(oldPassword == user.getPassword()){
			user.setName(name);
			//user.setEmail(email); // to do
			user.setPassword(newPassword);
			Object obj = em.createQuery("from Users where Email:=emailTemp").setParameter("emailTemp", email).getSingleResult();
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit(); // updated the database 
			em.close();
			emf.close();
			
			//}
			/*
			else {
				/*TODO
				 * print passwords dont match 
				 */
			//}
         }
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
