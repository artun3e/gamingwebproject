package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCategoryServlet
 */
@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategoryServlet() {
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
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			String toBeUpdated = request.getParameter("oldcategory");
			String newCategory = request.getParameter("newCategory");
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("update categories set category=? where category=?");
			ps.setString(1,newCategory);
			ps.setString(2,toBeUpdated);
			ps.executeUpdate();

			ps = conn.prepareStatement("select * from Games where categories like '%"+toBeUpdated+"%'",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String categoryString = rs.getString("categories");
				//System.out.println("Current: " + categoryString);
				categoryString = categoryString.replace(toBeUpdated,newCategory);
				//System.out.println("Updated: " + categoryString);
				//System.out.println("____________________________________________");
				rs.updateString("categories",categoryString);
				rs.updateString("steamspy_tags", categoryString);
				rs.updateRow();
			}

			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
		ps = null;
		rs = null;
	}

}
