package cs308.sabanciuniv.edu;

import java.io.IOException;
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

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		//doGet(request, response);
		Connection conn;
		PreparedStatement ps;
		try {
			System.out.println("Edited for new items.");
			int gameID = Integer.parseInt(request.getParameter("id"));
			String gameName = request.getParameter("name");
			String publisher = request.getParameter("publisher");
			String categories = request.getParameter("categories").replace(",", ";");
			//String steamspyTags = request.getParameter("steamspytags").replace(",", ";");
			double price = Double.parseDouble(request.getParameter("price").replace("$", ""));
			String shortDescription = request.getParameter("shortdescription").replaceAll("[^\\x00-\\x7F]", "");
			String detailedDescription = request.getParameter("detaileddescription").replaceAll("[^\\x00-\\x7F]", "");;
			String minimum = request.getParameter("minimum").replaceAll("[^\\x00-\\x7F]", "");;
			String aboutTheGame = request.getParameter("aboutthegame").replaceAll("[^\\x00-\\x7F]", "");;
			String background = request.getParameter("background");
			String[] screenshotsArray = request.getParameter("screenshots").split(",");
			String headerImage = request.getParameter("headerimage");
			String platforms = request.getParameter("platforms");
			double salePrice = Double.parseDouble(request.getParameter("salePrice").replace("$", ""));
			int stock = Integer.parseInt(request.getParameter("stock"));
			boolean onSale = Boolean.parseBoolean(request.getParameter("onSale"));
			String steamspyTags = categories;

			String screenshots = "[";
			for(int i = 0; i< screenshotsArray.length; i++)
			{
				screenshots += "{'id': " + Integer.toString(i) + ", 'path_thumbnail': '" + screenshotsArray[i] + "', 'path_full': '" + screenshotsArray[i] + "'}, ";
			}
			screenshots = screenshots.substring(0,screenshots.length()-2);
			screenshots += "]";
			System.out.println("Trying to update following game: ");
			System.out.println("______________________________________");
			System.out.println("Name: "+ gameName);
			System.out.println("Categories: "+ categories);
			System.out.println("Price: "+ price);
			System.out.println("Screenshots: "+ screenshots);
			System.out.println("______________________________________");
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("update Games set name=?, developer=?, publisher=?, platforms=?, categories=?, genres=?, steamspy_tags=?, price=?, header_image=?, screenshots=?, background=?, minimum=?, detailed_description=?, about_the_game=?, short_description=?, onSale=?, stock=?, salePrice=? where appid=?");

			ps.setString(1,gameName);
			ps.setString(2,publisher);
			ps.setString(3,publisher);
			ps.setString(4,platforms);
			ps.setString(5, categories);
			ps.setString(6, categories);
			ps.setString(7,steamspyTags);
			ps.setDouble(8,price);
			ps.setString(9,headerImage);
			ps.setString(10,screenshots);
			ps.setString(11,background);
			ps.setString(12,minimum);
			ps.setString(13,detailedDescription);
			ps.setString(14,aboutTheGame);
			ps.setString(15,shortDescription);
			ps.setBoolean(16,onSale);
			ps.setInt(17,stock);
			if(onSale)
				ps.setDouble(18,salePrice);
			else
				ps.setDouble(18,price);

			ps.setInt(19,gameID);
			ps.executeUpdate();
			//game.setOwners(); We shouldn't be able to edit how many people own the game or the rating from the admin panel...
			//game.setRating();

			conn.close();
			ps.close();

			System.out.println("Successfully updated the game...");
			String url = ((HttpServletRequest)request).getRequestURL().toString();
			String queryString = ((HttpServletRequest)request).getQueryString();
			System.out.println("StackoverFlow: " + url + "?" + queryString);
			System.out.println("Referer: " + request.getHeader("referer"));
			System.out.println("javax.servlet: " + request.getAttribute("javax.servlet.forward.request_uri"));
			response.sendRedirect(request.getHeader("referer"));

		}catch (Exception e){
			e.printStackTrace();
		}
		conn = null;
		ps = null;
	}

}
