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
				obj.setName(rs.getString("name"));
				obj.setReleaseDate(rs.getString("release_date"));
				obj.setDeveloper(rs.getString("developer"));
				obj.setPublisher(rs.getString("publisher"));
				obj.setPlatforms(rs.getString("platforms"));
				obj.setRequiredAge(rs.getInt("required_age"));
				obj.setCategories(rs.getString("categories"));
				obj.setGenres(rs.getString("genres"));
				obj.setSteampsyTags(rs.getString("steamspy_tags"));
				obj.setNumberOfPlayers(rs.getString("number_of_players"));
				obj.setPrice(rs.getDouble("price"));
				obj.setRating(rs.getDouble("rating"));
//				obj.setImageUrl(rs.getString("Image"));
//				obj.setRequirements(rs.getString("requirements"));
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
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			PreparedStatement ps = conn.prepareStatement("Select * from Games WHERE name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			Games obj = new Games();
			while(rs.next())
			{
				obj.setName(rs.getString("name"));
				obj.setReleaseDate(rs.getString("release_date"));
				obj.setDeveloper(rs.getString("developer"));
				obj.setPublisher(rs.getString("publisher"));
				obj.setPlatforms(rs.getString("platforms"));
				obj.setRequiredAge(rs.getInt("required_age"));
				obj.setCategories(rs.getString("categories"));
				obj.setGenres(rs.getString("genres"));
				obj.setSteampsyTags(rs.getString("steamspy_tags"));
				obj.setNumberOfPlayers(rs.getString("number_of_players"));
				obj.setPrice(rs.getDouble("price"));
				obj.setRating(rs.getDouble("rating"));
//				obj.setImageUrl(rs.getString("Image"));
//				obj.setRequirements(rs.getString("requirements"));
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