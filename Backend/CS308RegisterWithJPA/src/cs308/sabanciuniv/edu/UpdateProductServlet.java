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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			//int gameID = Integer.parseInt(request.getParameter("ssid"));
			String gameName = request.getParameter("streamer_id");
			String publisher = request.getParameter("stream_name");
			String categories = request.getParameter("streamed_game");
			double price = Double.parseDouble(request.getParameter("revenue"));
			
			Games update = new Games();
			//update.setAppID(gameID);
			update.setName(gameName);
			update.setPublisher(publisher);
			update.setCategories(categories);
			update.setPrice(price);
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
			EntityManager em = emf.createEntityManager();
			
			Object obj =em.createQuery("UPDATE Games SET name = "+update.getName()+",publisher = "+update.getPublisher()+","
					+ "categories = "+update.getCategories()+",price = "+update.getPrice()+"").getSingleResult();
			
			em.close();
			emf.close(); 
			
			
			//Games update = new Games(gameID,gameName,null,null,publisher,null,null,categories,null,null,null,price,null,null,null,null,null,null,null,null);
			
			

			/*
			 Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
             PreparedStatement ps = conn.prepareStatement("UPDATE Games SET name = "+update.getName()+",release_date = "+update.getReleaseDate()+","
             		+ "developer = "+update.getDeveloper()+",publihser = "+update.getPublisher()+",platforms = "+update.getPlatforms()+",required_age = "+update.getRequiredAge()+","
             				+ "categories = "+update.getCategories()+", genres = "+ update.getGenres()+",steamspy_tags = "+update.getSteampsyTags()+","
             						+ "owners = "+update.getOwners()+", price = "+update.getPrice()+", rating = "+update.getRating()+","
             								+ "header_image = "+update.getHeader_image()+",screenshots = "+update.getScreenshots()+","
             										+ "backgorund = "+update.getBackground()+",minimum = "+update.getMinimum()+","
             												+ "detailed_description = "+update.getDetailed_description()+",about_the_game = "+update.getAbout_the_game()+","
             														+ "short_description = "+update.getShort_description()+" WHERE appid = " + ID + "");
             ResultSet rs = ps.executeQuery();
             conn.close(); 
             conn = null;
             ps = null;
             rs = null;
			*/
           
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
