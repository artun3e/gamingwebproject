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
			emf = Persistence.createEntityManagerFactory("cs308");
			em = emf.createEntityManager();

			int id = (Integer)em.createQuery("Select MAX(appid) from Games").getSingleResult() + 1; // Get the last appID, increment it by 1.

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
			System.out.println("Trying to update following game: ");
			System.out.println("______________________________________");
			System.out.println("Name: "+ gameName);
			System.out.println("Categories: "+ categories);
			System.out.println("Price: "+ price);
			System.out.println("Screenshots: "+ screenshots);
			System.out.println("______________________________________");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
