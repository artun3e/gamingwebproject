package cs308.sabanciuniv.edu;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Path("fromDB")
public class GamesManager {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("byNamee/{n}")
	public List<Games> getDevice(@PathParam("n") String query)
	{
		List<Games> resultList = new ArrayList<Games>();
		try 
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			PreparedStatement ps = conn.prepareStatement("Select * from Games WHERE name LIKE " + "'%"+query+"%'"  );
			ResultSet rs = ps.executeQuery();
			
			// attributes for the Games class : name', 'release_date', 'developer', 'publisher', 'platforms',
		    //'required_age', 'categories', 'genres', 'steamspy_tags',
		    //'number_of_players', 'price', 'rating'],
			
			while(rs.next())
			{
				Games obj = new Games();
				obj.setAppID(rs.getInt("appid"));
				obj.setName(rs.getString("name"));
				obj.setReleaseDate(rs.getString("release_date"));
				obj.setDeveloper(rs.getString("developer"));
				obj.setPublisher(rs.getString("publisher"));
				obj.setPlatforms(rs.getString("platforms"));
				obj.setRequiredAge(rs.getInt("required_age"));
				obj.setCategories(rs.getString("categories"));
				obj.setGenres(rs.getString("genres"));
				obj.setSteampsyTags(rs.getString("steamspy_tags"));
				obj.setOwners(rs.getString("owners"));
				obj.setPrice(rs.getDouble("price"));
				obj.setRating(rs.getDouble("rating"));
				obj.setHeader_image(rs.getString("header_image"));
				obj.setScreenshots(rs.getString("screenshots"));
				obj.setBackground(rs.getString("background"));
				obj.setMinimum(rs.getString("minimum"));
				obj.setDetailed_description(rs.getString("detailed_description"));
				obj.setAbout_the_game(rs.getString("about_the_game"));
				obj.setShort_description(rs.getString("short_description"));
			}
			conn.close();
			conn = null;
			ps = null;
			rs = null;
			return resultList;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return resultList;
		}
	}
	public static Games getDeviceByName(String name)
	{
		try 
		{
			System.out.println("Hey");
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			PreparedStatement ps = conn.prepareStatement("Select * from Games WHERE name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			Games obj = new Games();
			if(rs.next())
			{
				obj.setAppID(rs.getInt("appid"));
				obj.setName(rs.getString("name"));
				obj.setReleaseDate(rs.getString("release_date"));
				obj.setDeveloper(rs.getString("developer"));
				obj.setPublisher(rs.getString("publisher"));
				obj.setPlatforms(rs.getString("platforms"));
				obj.setRequiredAge(rs.getInt("required_age"));
				obj.setCategories(rs.getString("categories"));
				obj.setGenres(rs.getString("genres"));
				obj.setSteampsyTags(rs.getString("steamspy_tags"));
				obj.setOwners(rs.getString("owners"));
				obj.setPrice(rs.getDouble("price"));
				obj.setRating(rs.getDouble("rating"));
				obj.setHeader_image(rs.getString("header_image"));
				obj.setScreenshots(rs.getString("screenshots"));
				obj.setBackground(rs.getString("background"));
				obj.setMinimum(rs.getString("minimum"));
				obj.setDetailed_description(rs.getString("detailed_description"));
				obj.setAbout_the_game(rs.getString("about_the_game"));
				obj.setShort_description(rs.getString("short_description"));
			}
			conn.close();
			conn = null;
			ps = null;
			rs = null;
			return obj;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}