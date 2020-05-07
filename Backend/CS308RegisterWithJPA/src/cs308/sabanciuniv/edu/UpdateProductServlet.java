package cs308.sabanciuniv.edu;

import java.io.IOException;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response,Games update, int ID) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			Games oldgame = GamesManager.getGameByID(ID);
			oldgame = update;
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
           
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
