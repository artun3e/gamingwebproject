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
import java.util.Random;

@Path("fromDB")
public class GamesManager {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("byName/{n}")
    public List<Games> getDevice(@PathParam("n") String query) {
        List<Games> resultList = new ArrayList<Games>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
            PreparedStatement ps = conn.prepareStatement("Select * from Games WHERE name LIKE " + "'%" + query + "%'");
            ResultSet rs = ps.executeQuery();

            // attributes for the Games class : name', 'release_date', 'developer', 'publisher', 'platforms',
            //'required_age', 'categories', 'genres', 'steamspy_tags',
            //'number_of_players', 'price', 'rating'],

            while (rs.next()) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return resultList;
        }
    }

    public static Games getDeviceByName(String name) {
        try {
            //System.out.println("Hey");
            Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
            PreparedStatement ps = conn.prepareStatement("Select * from Games WHERE name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            Games obj = new Games();
            if (rs.next()) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("byCategory/{cat1}/{cat2}/{cat3}/{cat4}/{cat5}")
    public List<Games> findByCategory(@PathParam("cat1") String category0, @PathParam("cat2") String category1, @PathParam("cat3") String category2, @PathParam("cat4") String category3, @PathParam("cat5") String category4) {
        List<Games> resultArray = new ArrayList<Games>();
        System.out.println("Function called...");
        try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
            PreparedStatement ps = conn.prepareStatement("Select * from Games where steamspy_tags like ? and steamspy_tags like ? and steamspy_tags like ? and steamspy_tags like ? and steamspy_tags like ? LIMIT 9");
            if (category0 != "null")
                ps.setString(1, "'%" + category0 + "%'");
            else
                ps.setString(1, "'% %'");
            if (category1 != "null")
				ps.setString(2, "'%" + category1 + "%'");
            else
				ps.setString(2, "'% %'");
            if (category2 != "null")
				ps.setString(3, "'%" + category2 + "%'");
            else
				ps.setString(3, "'% %'");
            if (category3 != "null")
				ps.setString(4, "'%" + category3 + "%'");
            else
				ps.setString(4, "'% %'");
            if (category4 != "null")
				ps.setString(5, "'%" + category4 + "%'");
            else
				ps.setString(5, "'% %'");
            ResultSet rs = ps.executeQuery();
            System.out.println("On top of the while loop");
			while (rs.next()) {
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
				System.out.println("Game name is " + obj.getName());
				resultArray.add(obj);
			}
            System.out.println("at the end of the while loop");
            /*while(rs.next()) {
                Random r = new Random();
                Integer random = r.nextInt((30 - 20) + 1) + 20;
				System.out.println("Game found game is: " + rs.getString("name"));
                String temp = "<div class=\"col-md-4 col-xs-6\">"
                        + "<div class=\"product\">"
                        + "<div class=\"product-img\">"
                        + "<img src=\"" + rs.getString("header_image") + " alt=\"\">"
                        + "<div class=\"product-label\">"
                        + "<span class=\"new\">NEW</span>"
                        + "</div>"
                        + "</div>"
                        + "<div class=\"product-body\">"
                        + "<p class=\"product-category\">" + rs.getString("steamspy_tags") + "</p>"
                        + "<h3 class=\"product-name\"><a onclick=\"toDetails(this)\" href=\"#\">" + rs.getString("name") + "</a></h3>"
                        + "<h4 class=\"product-price\">$" + rs.getDouble("price") + "<del class=\"product-old-price\">$" + ((int) rs.getDouble("price") + random) + ".00</del></h4>"
                        + "<div class=\"product-rating\">"
                        + "<i class=\"fa fa-star\"></i>"
                        + "<i class=\"fa fa-star\"></i>"
                        + "<i class=\"fa fa-star\"></i>"
                        + "<i class=\"fa fa-star\"></i>"
                        + "<i class=\"fa fa-star-o\"></i>"
                        + "</div>"
                        + "<div class=\"product-btns\">"
                        + "<button class=\"add-to-wishlist\"><i class=\"fa fa-heart-o\"></i><span class=\"tooltipp\">add to wishlist</span></button>"
                        + "<button class=\"add-to-compare\"><i class=\"fa fa-exchange\"></i><span class=\"tooltipp\">add to compare</span></button>"
                        + "<button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">quick view</span></button>"
                        + "</div>"
                        + "</div>"
                        + "<div class=\"add-to-cart\">"
                        + "<button class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> cart</button>"
                        + "</div>"
                        + "</div>"
                        + "</div>";
                resultArray.add(temp);
            }*/
            conn.close();
            ps.close();
            rs.close();
            conn = null;
            ps = null;
            rs = null;
            return resultArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Games> getRandomGames() {
        try {

            List<Games> resultList = new ArrayList<Games>();

            Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Games ORDER BY RAND() LIMIT 9");
            ResultSet rs = ps.executeQuery();
            //Query q1 = em.createQuery("SELECT * FROM Games ORDER BY RAND() LIMIT 1");
            while (rs.next()) {
                //rs.first();

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
            ps.close();
            conn.close();
            ps = null;
            conn = null;
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}