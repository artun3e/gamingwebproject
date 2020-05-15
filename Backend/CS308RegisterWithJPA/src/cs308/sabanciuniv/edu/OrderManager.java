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
import java.util.Map;
import java.util.Random;


@Path("fromDB")
public class OrderManager {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allOrders/")
	public List<Order> getAllOrders(){
		  List<Order> resultList = new ArrayList<Order>();
		  
		  try {
			  
			  Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
	          PreparedStatement ps = conn.prepareStatement("Select * from Orders");
	          ResultSet rs = ps.executeQuery();
	          
	          
	          while (rs.next()) 
	          {
	        	  
	          Order obj = new Order();
	          obj.setId(rs.getInt("id"));
	          obj.setAddress(rs.getString("address"));
	          obj.setDate(rs.getString("date"));
	          
	          User user = new User();
	          // fetch user from email
	          String email = rs.getString("User_Email");
	          PreparedStatement getuser = conn.prepareStatement("Select * from Users Where Email = "+email+" ");
	          ResultSet userRs = getuser.executeQuery();
	          // fill user 
	          while(userRs.next()){
	        	  user.setName(userRs.getString("name"));
	        	  user.setEmail(email);
	        	  user.setPassword(userRs.getString("password"));
	        	  String userType = userRs.getString("user_type");
	        	  //below code is fucking retarded
	        	  if(userType == "Admin")
	        		  user.setUserType(User.userType.Admin);
	        	  else if(userType == "User")
	        		  user.setUserType(User.userType.User);
	        	  else if(userType == "SalesManager")
	        		  user.setUserType(User.userType.SalesManager);
	        	  else
	        		  user.setUserType(User.userType.ProductManager);
	        	  //user.setUserType();
	          }
	          obj.setOwner(user);
	          
	          Map<Games, Integer> products; // get the names
	          
	          PreparedStatement games = conn.prepareStatement("Select * from Games Where Email = "+email+" ");
	          ResultSet gamers = getuser.executeQuery();
	          
	          /*
	           * TODO
	           * Get games using appid from orders_games table with below algorithm
	           * use the id to get product_key from the orders_games table which is the
	           * equivalent to appid in Games table -> update the map as game and how many games are there
	           * complete obj(Order variable) by using setters.
	           * Do not forget to close the CONNECTIONS!!!!	
	           */
	          
	          }
			  
		  }catch(Exception e){
			  e.printStackTrace();
			  
		  }
		  
		  
		  return resultList;
	}
	

}
