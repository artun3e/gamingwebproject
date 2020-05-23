package cs308.sabanciuniv.edu;

import java.io.IOException;
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
		EntityManagerFactory emf;
		EntityManager em;
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(appid) appid from Games");
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next())
			{
				id = rs.getInt("appid") + 1;
			}

			conn.close();
			ps.close();
			rs.close();
			conn = null;
			rs = null;
			ps = null;

			emf = Persistence.createEntityManagerFactory("cs308");
			em = emf.createEntityManager();

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
			System.out.println("Trying to add following game: ");
			System.out.println("______________________________________");
			System.out.println("Name: "+ gameName);
			System.out.println("Categories: "+ categories);
			System.out.println("Price: "+ price);
			System.out.println("Screenshots: "+ screenshots);
			System.out.println("______________________________________");

			String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

			Games game = new Games();
			game.setAppID(id);
			game.setName(gameName);
			game.setPublisher(publisher);
			game.setCategories(categories);
			game.setPrice(price);
			game.setSteampsyTags(steamspyTags);
			game.setShort_description(shortDescription);
			game.setDetailed_description(detailedDescription);
			game.setMinimum(minimum);
			game.setAbout_the_game(aboutTheGame);
			game.setBackground(background);
			game.setScreenshots(screenshots);
			game.setPlatforms(platforms);
			game.setHeader_image(headerImage);
			game.setDeveloper(publisher);
			game.setReleaseDate(timeStamp);


			em.getTransaction().begin();
			em.persist(game);
			em.getTransaction().commit();

			em.close();
			emf.close();

			em = null;
			emf = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
