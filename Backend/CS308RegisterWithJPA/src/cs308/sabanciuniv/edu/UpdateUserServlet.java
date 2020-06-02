package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try {
		 HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
         if (user == null) {
             System.out.println("You are not logged in!!!");
         }
         else {
             System.out.println("You are logged in!!!");
         
			String name = request.getParameter("name");
			String oldPassword = request.getParameter("cpassword");
			String newPassword = request.getParameter("npassword");
			String email = user.getEmail();
			String newEmail = request.getParameter("newEmail");

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(oldPassword.getBytes(StandardCharsets.UTF_8));  // hash the input password
			byte[] hash2 = digest.digest(newPassword.getBytes(StandardCharsets.UTF_8));

			 if(user.getPassword().contentEquals(new String(hash, "UTF-8"))) // check whether users match
			{
				if(newEmail.contentEquals(email))
				{
					request.removeAttribute("user");
					conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
					ps = conn.prepareStatement("UPDATE User set name=?, password=? where Email=?");
					ps.setString(1,name);
					if(newPassword.length()!=0) {
						ps.setString(2, new String(hash2, "UTF-8"));
						user.setPassword(newPassword);
					}
					else {
						ps.setString(2, new String(hash, "UTF-8"));
					}
					ps.setString(3, email);
					ps.executeUpdate();
					conn.close();
					ps.close();
					user.setName(name);
					request.setAttribute("user",user);
				}
				else
				{
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
					EntityManager em = emf.createEntityManager();
					User myuser = em.find(User.class,email);
					User user2 = new User(user);
					user2.setEmail(newEmail);
					user2.setName(name);
					if(newPassword.length()!=0)
						user2.setPassword(new String(hash2, "UTF-8"));
					else
						user2.setPassword(new String(hash, "UTF-8"));
					for(Order o : user2.getOrders())
					{
						o.setOwner(user2);
					}
					for(Address a : user2.getAddress())
					{
						a.setUser(user2);
					}
					for(Payment p : user2.getPayment())
					{
						p.setUser(user2);
					}
					System.out.println("Transaction beginning.");
					em.remove(user);
					em.persist(user2);
					em.getTransaction().commit();
					em.close();
					emf.close();
					em = null;
					emf = null;
					request.removeAttribute("user");
					request.setAttribute("user",user2);
					System.out.println("Done changing email and other parameters.");
				}
				response.setHeader("userUpdateError", "false");
			}
			
			else
			{
				response.setHeader("userUpdateError", "true");
			}
         }
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
