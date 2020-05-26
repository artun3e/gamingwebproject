package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveCategoryServlet
 */
@WebServlet("/RemoveCategoryServlet")
public class RemoveCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			String toBeDeleted = request.getParameter("category");
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("delete from categories where category =?");
			ps.setString(1,toBeDeleted);
			ps.executeUpdate();

			ps = conn.prepareStatement("select * from Games where categories like CONCAT( '%',?,'%')",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,toBeDeleted);

			rs = ps.executeQuery();
			while(rs.next())
			{
				String categoryString = rs.getString("categories");
				String[] arrayString = categoryString.split(";");
				categoryString = "";
				for(String s : arrayString){
					if(!s.equals(toBeDeleted)){
						categoryString += s + ";";
					}
				}
				categoryString = categoryString.substring(0,categoryString.length()-1);
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
		rs = null;*/
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
			String toBeDeleted = request.getParameter("category");
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("delete from categories where category =?");
			ps.setString(1,toBeDeleted);
			ps.executeUpdate();

			ps = conn.prepareStatement("select * from Games where categories like CONCAT( '%',?,'%')",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,toBeDeleted);

			rs = ps.executeQuery();
			while(rs.next())
			{
				String categoryString = rs.getString("categories");
				System.out.println("CategoryString is: " + categoryString);
				String[] arrayString = categoryString.split(";");
				categoryString = "";
				int count = 0;
				for(String s : arrayString){
					System.out.println("	"+ count+ ".)" + s);
					if(!s.equals(toBeDeleted)){
						categoryString += s + ";";
					}
					count++;
				}
				System.out.println("_________________________________");
				if(categoryString.length()!= 0)
					categoryString = categoryString.substring(0,categoryString.length()-1);
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
