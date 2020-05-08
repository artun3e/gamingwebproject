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
			int gameID = Integer.parseInt(request.getParameter("id"));
			String gameName = request.getParameter("name");
			String publisher = request.getParameter("publisher");
			String categories = request.getParameter("categories");
			String steamspyTags = request.getParameter("steamspytags");
			double price = Double.parseDouble(request.getParameter("revenue"));
			String shortDescription = request.getParameter("shortdescription");
			String detailedDescription = request.getParameter("detaileddescription");
			String minimum = request.getParameter("minimum");
			String aboutTheGame = request.getParameter("aboutthegame");
			String background = request.getParameter("background");
			String screenshots = request.getParameter("screenshots");
			String headerImage = request.getParameter("headerimage");

			emf = Persistence.createEntityManagerFactory("cs308");
			em = emf.createEntityManager();

			Games game = em.find(Games.class, gameID);
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
			game.setHeader_image(headerImage);
			//game.setOwners(); We shouldn't be able to edit how many people own the game or the rating from the admin panel...
			//game.setRating();

			em.merge(game);

			em.close();
			emf.close();

			em = null;
			emf = null;

		}catch (Exception e){
			e.printStackTrace();
			em = null;
			emf = null;
		}

	}

}
