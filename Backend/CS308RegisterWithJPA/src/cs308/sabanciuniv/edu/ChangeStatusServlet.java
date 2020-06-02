package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import cs308.sabanciuniv.edu.Order.orderStatus;

/**
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
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
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		response.setHeader("aybars", user.getUserType().toString());
		if(user.getUserType() == User.userType.Admin || user.getUserType() == User.userType.ProductManager) {
			System.out.println("changing status....");
			String OrderID = request.getParameter("order_id");
			String status = request.getParameter("status");
			String oldstatus = request.getParameter("oldstatus");
			int int_orderID = Integer.parseInt(OrderID);			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
				PreparedStatement ps = conn.prepareStatement("UPDATE Orders set status=? where id=?");
				ps.setString(1,status);
				ps.setInt(2,int_orderID);
				ps.executeUpdate();
				ps = conn.prepareStatement("Select User.name,User_Email from Orders left join User on Orders.User_Email = User.Email where id=?"); 
				ps.setInt(1, int_orderID);
				ResultSet rs =  ps.executeQuery();
				rs.next();
				String email = rs.getString("User_Email");
				String name = rs.getString("name");
				String topic = "Updated Order Status";
				String message = "Hello " + name + "\n\nYour order with the order id "+ OrderID +" has changed it\'s status from "+ oldstatus+" to "+ status +"\n\nThanks for your purchase!!!";
				JavaMailUtil.sendMailwithMessageAndTopic(message,email,topic);
				
				ps.close();
				conn.close();
				} 
			catch (SQLException e) {
				e.printStackTrace();
				}
			}
			else{ // stole this bit from dropdownorderupdateservlet.java but then uncommented it
				//System.out.println("Compile test.");
				//session.setAttribute("ChangeStatus-error", "You are not authorized!!!!");
				//response.setHeader("ChangeStatus-error","true");
				
				return;
			}
		}
	}

