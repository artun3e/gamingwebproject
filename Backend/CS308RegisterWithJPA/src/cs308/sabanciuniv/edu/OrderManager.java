package cs308.sabanciuniv.edu;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.annotation.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import javax.persistence.EntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
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
    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        try
		{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
            EntityManager em = emf.createEntityManager();
            allOrders = em.createQuery("Select e from Order e", Order.class).getResultList();

            em.close();
            emf.close();
            em = null;
            emf = null;
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return allOrders;
    }

	//byName/{n}
	// possible filters: date, e-mail, price , product
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("filteredOrders/{date}/{email}/{price}/{product}")
	public List<Order> filteredOrders(@PathParam("date") String date , @PathParam("email") String email,
			@PathParam("price") String price , @PathParam("product") String product){
		
		OrderManager uselessOBJ = new OrderManager();
		List<Order> orders = uselessOBJ.getAllOrders();
		
		if(date != null) {
			orders = DateConstraint(orders,date);
		}
		if(email != null) {
			orders = emailConstraint(orders , email);

		}	
		if(price != null) {
			orders = priceConstraint(orders,price);

		}
		if(product != null) {
			orders = productConstraint(orders,product);
		}	
		return orders;
	}
	
	// I'm accepting date in the format of dd/MM/yyyy-dd/MM/yyyy where the part before - is the lower date constraint and the part after - is the upper date constraint. 
	//the second date should be bigger (please)
	private List<Order> DateConstraint(List<Order> orders,String date){
		String [] dates = date.split("-");
		try {
			Date lowerDate =new SimpleDateFormat("dd/MM/yyyy").parse(dates[0]);
			Date upperDate =new SimpleDateFormat("dd/MM/yyyy").parse(dates[1]);
			for(Order order : orders) {
				Date our_date = new SimpleDateFormat("yyyy/MM/dd").parse(order.getDate()); // our database was this format, i might change the input if it can't compare properly but i think it will
				// compare to returns 0 if dates are equal, a positive integer if the object calling it(ourdate) occurs after the parameter(lowerdate), negative otherwise
				if(our_date.compareTo(lowerDate) < 0 || our_date.compareTo(upperDate) > 0) { // our date occurs before lowerdate or our date occurs after upperdate
					orders.remove(order);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}  
		return orders;
	}
	
	private List<Order> emailConstraint(List<Order> orders, String email){
		for(Order order : orders) {
			if(order.getOwner().getEmail() != email) {
				orders.remove(order);
			}
		}
		return orders;
	}
	
	private List<Order> priceConstraint(List<Order> orders,String price){
		String [] prices = price.split("-");
		Double lowerprice = Double.parseDouble(prices[0]);
		Double upperprice = Double.parseDouble(prices[1]);
		for(Order order : orders) {
			double total_price = 0;
			Map<Games, Integer> hashmap = order.getProducts();
			for (Map.Entry mapElement : hashmap.entrySet()) {       // for each game in the order
	            Games game = (Games) mapElement.getKey(); 
	            double quantity = (double)mapElement.getValue(); 
	            total_price = total_price + (game.getPrice() * quantity);
	        }
			if(total_price > upperprice || total_price < lowerprice){ // price doesn't fit our range so we remove the order
				orders.remove(order);
			}
		}
		return orders;
	}
	
	private List<Order> productConstraint(List<Order> orders,String product){
		for(Order order : orders) {
			boolean GameExists = false;
			Map<Games, Integer> hashmap = order.getProducts();
			for (Map.Entry mapElement : hashmap.entrySet()) {       // for each game in the order
	            Games game = (Games) mapElement.getKey(); 
	            if(product == game.getName()) {
	            	GameExists = true;	// the desired game exists in our list of games so we will display the whole order
	            }
			}
			if(!GameExists){ // game doesn't exist in this order so we delete the order
				orders.remove(order);
			}
		}
		return orders;
	}
	
}
   

