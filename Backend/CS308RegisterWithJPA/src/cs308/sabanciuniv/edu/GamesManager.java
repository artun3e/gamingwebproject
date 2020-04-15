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
	@Path("byName/{n}")
	public List<Games> getDevice(@PathParam("n") String query)
	{
		List<Games> resultList = new ArrayList<Games>();
		try 
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/XiiV7ZFMQd", "XiiV7ZFMQd", "XHEMcSeLpd");
			PreparedStatement ps = conn.prepareStatement("Select * from Games WHERE name LIKE " + "'%"+query+"%'"  );
			ResultSet rs = ps.executeQuery();
			
			// attributes for the Games class : name', 'release_date', 'developer', 'publisher', 'platforms',
		    //'required_age', 'categories', 'genres', 'steamspy_tags',
		    //'number_of_players', 'price', 'rating'],
			
			while(rs.next())
			{
				Games obj = new Games();
				obj.setName(rs.getString("Name"));
				obj.setReleaseDate(rs.getString("Release Date"));
				obj.setDeveloper(rs.getString("Developer"));
				obj.setPublisher(rs.getString("Publisher"));
				obj.setPlatforms(rs.getString("Platforms"));
				obj.setRequiredAge(rs.getInt("Required Age"));
				obj.setCategories(rs.getString("Categories"));
				obj.setGenres(rs.getString("Genres"));
				obj.setSteampsyTags(rs.getString("Steamspy Tags"));
				obj.setNumberOfPlayers(rs.getString("Number of Players"));
				obj.setPrice(rs.getDouble("Price"));
				obj.setRating(rs.getDouble("Rating"));
				obj.setImageUrl(rs.getString("Image"));
				obj.setRequirements(rs.getString("Requirements"));
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
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/XiiV7ZFMQd", "XiiV7ZFMQd", "XHEMcSeLpd");
			PreparedStatement ps = conn.prepareStatement("Select * from Games WHERE name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			Games obj = new Games();
			while(rs.next())
			{
				obj.setName(rs.getString("Name"));
				obj.setReleaseDate(rs.getString("Release Date"));
				obj.setDeveloper(rs.getString("Developer"));
				obj.setPublisher(rs.getString("Publisher"));
				obj.setPlatforms(rs.getString("Platforms"));
				obj.setRequiredAge(rs.getInt("Required Age"));
				obj.setCategories(rs.getString("Categories"));
				obj.setGenres(rs.getString("Genres"));
				obj.setSteampsyTags(rs.getString("Steamspy Tags"));
				obj.setNumberOfPlayers(rs.getString("Number of Players"));
				obj.setPrice(rs.getDouble("Price"));
				obj.setRating(rs.getDouble("Rating"));
				obj.setImageUrl(rs.getString("Image"));
				obj.setRequirements(rs.getString("Requirements"));
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