package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddPaymentServlet
 */

@WebServlet(name = "AddPaymentServlet", urlPatterns = {
"/AddPaymentServlet"})
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentServlet() {
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
		Connection conn;
		PreparedStatement ps;
		try {
			HttpSession session = request.getSession();
	         User user = (User) session.getAttribute("user");
	         if (user == null) {
	             System.out.println("You are not logged in!!!");
	         }
	         else {
	             System.out.println("You are logged in!!!");
	             String email = user.getEmail(); // also you can use request.getParameter for email
	             //int id =Integer.parseInt(request.getParameter("user_id")); // get users id
	             String cardNumber = request.getParameter("card_number");
	             String cvc = request.getParameter("cvc");
	 	    	 String expirationDate = request.getParameter("expiration_date");
				 conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
				 ps = conn.prepareStatement("insert into Payment(email,cNumber,cvc,date) VALUES(?,?,?,?)");
				 ps.setString(1,user.getEmail());
				 ps.setString(2,cardNumber);
				 ps.setString(3,cvc);
				 ps.setString(4,expirationDate);
				 ps.execute();

				 ps.close();
				 conn.close();

	         }
		}catch(Exception e){
			e.printStackTrace();
		}
		conn = null;
		ps = null;
	}

}
