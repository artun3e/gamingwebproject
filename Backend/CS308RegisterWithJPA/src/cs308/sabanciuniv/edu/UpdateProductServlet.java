package cs308.sabanciuniv.edu;

import java.io.IOException;

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
		EntityManagerFactory emf;
		EntityManager em;
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
			emf = Persistence.createEntityManagerFactory("cs308");
			em = emf.createEntityManager();


			Games game = em.find(Games.class, gameID);
			em.merge(game);
			em.getTransaction().begin();
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
			game.setStock(stock);
			game.setSalePrice(salePrice);
			game.setOnSale(onSale);
			
			//game.setOwners(); We shouldn't be able to edit how many people own the game or the rating from the admin panel...
			//game.setRating();

			em.merge(game);
			em.getTransaction().commit();

			em.close();
			emf.close();

			em = null;
			emf = null;

			System.out.println("Successfully updated the game...");
			String url = ((HttpServletRequest)request).getRequestURL().toString();
			String queryString = ((HttpServletRequest)request).getQueryString();
			System.out.println("StackoverFlow: " + url + "?" + queryString);
			System.out.println("Referer: " + request.getHeader("referer"));
			System.out.println("javax.servlet: " + request.getAttribute("javax.servlet.forward.request_uri"));
			response.sendRedirect(request.getHeader("referer"));

		}catch (Exception e){
			e.printStackTrace();
			em = null;
			emf = null;
		}

	}

}
