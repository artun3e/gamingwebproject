package cs308.sabanciuniv.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.*;

@Entity
public class Admin extends User  {
	
	/*
	 * TODO : add properties of admin class
	 */
	
	
	
	// also add the attributes of the admin class in another constructor
	//Constructor
	public Admin(String name, String email, String password){
		super(name,email,password);
		
	}
	
	/*
	 *TODO add Admin constructor with  specs IF NEEDED!
	 * */
	 
	
	
	
	
	
	// 
	//addproduct adds new game to database 
	public void addProduct(Games newGame){ // adds new function to database 
		// first we need to connect to the database
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			/*INSERT INTO table_name (column1, column2, column3, ...)
			VALUES (value1, value2, value3, ...);*/
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
	
	// remove a product from the database with respect to gameName
	public void removeProduct(int ID){
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
		PreparedStatement ps = conn.prepareStatement("DELETE FROM Games WHERE appid = "+ID+"");
		ResultSet rs = ps.executeQuery();
		
		conn.close(); 
        conn = null;
        ps = null;
        rs = null;
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void changeProduct(Games update,int ID) {
		
		// get the game using appid
		// appid is primary key, it shall not changed
		
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
	
	
	/*
	 * admin must be able to add categories to the function
	 */
	// we need to add the to the "categories string" of the game class ? --deniztura
	//
	public void addCategory(String category){
		
		
	}
	 
	
	

}
