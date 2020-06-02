package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet(name = "addproductservlet", urlPatterns = { "/addproductservlet" })
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		try {

			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("SELECT MAX(appid) appid from Games");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next())
			{
				id = rs.getInt("appid") + 1;
			}


			String gameName = request.getParameter("name");
			String publisher = request.getParameter("publisher");
			String categories = request.getParameter("categories").replace(",", ";");
			//String steamspyTags = request.getParameter("steamspytags").replace(",", ";");
			double price = Double.parseDouble(request.getParameter("price").replace("$", ""));
			String shortDescription = request.getParameter("shortdescription").replaceAll("[^\\x00-\\x7F]", "");
			String detailedDescription = request.getParameter("detaileddescription").replaceAll("[^\\x00-\\x7F]", "");

			String minimum = request.getParameter("minimum").replaceAll("[^\\x00-\\x7F]", "");

			String aboutTheGame = request.getParameter("aboutthegame").replaceAll("[^\\x00-\\x7F]", "");

			String background = request.getParameter("background");
			String[] screenshotsArray = request.getParameter("screenshots").split(",");
			String headerImage = request.getParameter("headerimage");
			String platforms = request.getParameter("platforms");
			String steamspyTags = categories;
			String screenshots = "[";
			for(int i = 0; i< screenshotsArray.length; i++)
			{
				screenshots += "{'id': " + Integer.toString(i) + ", 'path_thumbnail': '" + screenshotsArray[i] + "', 'path_full': '" + screenshotsArray[i] + "'}, ";
			}
			screenshots = screenshots.substring(0,screenshots.length()-2);
			screenshots += "]";
			
			double salePrice = Double.parseDouble(request.getParameter("salePrice").replace("$", ""));
			int stock = Integer.parseInt(request.getParameter("stock"));
			boolean onSale = Boolean.parseBoolean(request.getParameter("onSale"));
			
			System.out.println("Trying to add following game: ");
			System.out.println("______________________________________");
			System.out.println("Name: "+ gameName);
			System.out.println("Categories: "+ categories);
			System.out.println("Price: "+ price);
			System.out.println("Screenshots: "+ screenshots);
			System.out.println("______________________________________");

			String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

			ps = conn.prepareStatement("insert into Games(appid,name,release_date,developer,publisher,platforms,categories,genres,steamspy_tags,price,header_image,screenshots,background,minimum,detailed_description,about_the_game,short_description,onSale,stock,salePrice) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,gameName);
			ps.setString(3,timeStamp);
			ps.setString(4,publisher);
			ps.setString(5,publisher);
			ps.setString(6,platforms);
			ps.setString(7,categories);
			ps.setString(8,categories);
			ps.setString(9,categories);
			ps.setDouble(10,price);
			ps.setString(11,headerImage);
			ps.setString(12,screenshots);
			ps.setString(13,background);
			ps.setString(14,minimum);
			ps.setString(15,detailedDescription);
			ps.setString(16,aboutTheGame);
			ps.setString(17,shortDescription);
			ps.setBoolean(18,onSale);
			ps.setInt(19,stock);
			if(onSale)
				ps.setDouble(20,salePrice);
			else
				ps.setDouble(20,price);

			ps.execute();

			conn.close();
			ps.close();
			rs.close();
			conn = null;
			rs = null;
			ps = null;

			PrintWriter out = response.getWriter();

			out.println("<html><script type=\"text/javascript\">");
			out.println("alert('Your game has been added!');");
			out.println("location='product.jsp?name="+gameName+"';");
			out.println("</script></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
