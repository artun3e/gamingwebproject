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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try {
			String emailInput = request.getParameter("email");
			String passInput = request.getParameter("pass");
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			//ps = conn.prepareStatement("select Orders.date, Games.price from Orders_Games left join Orders on Orders_Games.Order_id = Orders.id left join Games on Orders_Games.products_KEY = Games.appid where Order_id in (Select id from Orders WHERE date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH))");
			ps = conn.prepareStatement("select * from User where Email=?");
			ps.setString(1,emailInput);
			rs = ps.executeQuery();
			//EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
			//EntityManager em = emf.createEntityManager();
			//User searchResult = em.find(User.class,emailInput);
			//PrintWriter out = response.getWriter();
			//User.userType type = em.find(arg0, arg1)
			//emf.close();
			//em.close();
			//em=null;
			//emf=null;
			if(rs.next())
			{
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(passInput.getBytes(StandardCharsets.UTF_8));
				User searchResult = new User();
				searchResult.setName(rs.getString("name"));
				searchResult.setEmail(rs.getString("Email"));
				searchResult.setPassword(rs.getString("password"));
				searchResult.setUserType(User.userType.valueOf(rs.getString("user_type")));
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
			conn.close();
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn = null;
		ps = null;
		rs = null;
	}

}
