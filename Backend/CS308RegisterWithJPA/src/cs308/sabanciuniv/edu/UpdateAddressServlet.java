package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
 * Servlet implementation class UpdateAddressServlet
 */
@WebServlet("/UpdateAddressServlet")
public class UpdateAddressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddressServlet() {
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
            } else {
                System.out.println("You are logged in!!!");
                String email = user.getEmail(); // also you can use request.getParameter for email
                int id = Integer.parseInt(request.getParameter("address_id"));
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String phoneNumber = request.getParameter("phone_number");
                //String email;
				conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
				ps = conn.prepareStatement("UPDATE Addresses set address=?, city=?, phoneNumber=?");
				ps.setString(1,address);
				ps.setString(2,city);
				ps.setString(3,phoneNumber);
				conn.close();
				ps.close();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        conn = null;
        ps = null;
    }

}
