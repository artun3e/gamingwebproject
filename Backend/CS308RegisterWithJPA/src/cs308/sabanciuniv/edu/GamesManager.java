package cs308.sabanciuniv.edu;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
				resultList.add(obj);
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
			//System.out.println("Hey");
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
	public static List<Games> findByCategory(List<String> categories)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
		EntityManager em = emf.createEntityManager();
		try {
			Query q1 = em.createQuery("from Games where steamspy_tags like ?0 and steamspy_tags like ?1 and steamspy_tags like ?2 and steamspy_tags like ?3 and steamspy_tags like ?4 and steamspy_tags like ?5");
			int i = 0;
			for(; i < categories.size(); i++)
			{
				//q1.setParameter("tag"+Integer.toString(i), categories.get(i));
				q1.setParameter(i, "%" + categories.get(i) + "%");
			}
			while(i < 6)
			{
				//q1.setParameter("tag"+Integer.toString(i), " ");
				q1.setParameter(i, "% %");
				i++;
			}
			List<Object> objects = q1.getResultList();
			List<Games> gameList = new ArrayList<>();
			for(Object o : objects)
			{
				gameList.add((Games)o);
			}
			em.close();
			emf.close();
			return gameList;
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			emf.close();
			return null;
		}
	}
	
	public static List<Games> getRandomGames()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
		EntityManager em = emf.createEntityManager();
		try 
		{
			
			List<Games> resultList = new ArrayList<Games>();
			// count is the size of the database 
			
			for(int i = 0; i < 45 ; i++) // add 45 times in a row
			{
				Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Games ORDER BY RAND() LIMIT 1");
				ResultSet rs = ps.executeQuery();
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
				resultList.add(obj);
				
			}
			
			return resultList;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			em.close();
			emf.close();
			return null;
		}
	}
}