package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// first we need to connect to the database
		String emailInput = request.getParameter("email");
		String passInput = request.getParameter("pass");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Games(appid,name,release_date,developer,publisher,platforms,required_age,categories,genres,steamspy_tags,owners,price,rating,header_image,screenshots,background,minimum,detailed_description,about_the_game,short_description)"
					+ "                                   VALUES("+ newGame.getAppID() +", " + newGame.getName()+", "+newGame.getReleaseDate()+","+newGame.getDeveloper()+","+newGame.getPublisher()+","+newGame.getPlatforms()+","+newGame.getRequiredAge()+", "+newGame.getCategories()+", "+newGame.getGenres()+","+newGame.getSteampsyTags()+","
							+ "								"+newGame.getOwners()+", "+newGame.getPrice()+","+newGame.getRating()+","+newGame.getHeader_image()+","
									+ "						"+newGame.getScreenshots()+", "+newGame.getBackground()+","+newGame.getMinimum()+","+newGame.getDetailed_description()+","+newGame.getAbout_the_game()+","+newGame.getShort_description()+")");
			ResultSet rs = ps.executeQuery(); // we don't need to get any object, executing the query is enough
			
			
			 conn.close();
	         conn = null;
	         ps = null;
	         rs = null;
			
		}catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
