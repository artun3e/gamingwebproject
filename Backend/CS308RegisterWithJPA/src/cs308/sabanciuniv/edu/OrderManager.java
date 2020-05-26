package cs308.sabanciuniv.edu;

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
	public List<Order> getAllOrders(){
		  List<Order> allOrders = new ArrayList<Order>();
		  try {
			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				EntityManager em = emf.createEntityManager();
				allOrders = em.createQuery("Select * from Orders", Order.class).getResultList();
				em.close();
				emf.close();
				em=null;
				emf=null;
		  }catch(Exception e){
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
	//the second date should be bigger
	private List<Order> DateConstraint(List<Order> orders,String date){
		/*
		  EXAMPLE USAGE OF DATE OBJECTS
		  String sDate1="31/12/1998";  
    	  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
          System.out.println(sDate1+"\t"+date1)
		 */
		String [] dates = date.split("-");
		try {
			Date lowerDate =new SimpleDateFormat("dd/MM/yyyy").parse(dates[0]);
			Date upperDate =new SimpleDateFormat("dd/MM/yyyy").parse(dates[1]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		for(Order order : orders) {
			Date our_date = new SimpleDateFormat("yyyy/MM/dd").parse(order.getDate());
			if(our_date >= upperDate) {
				orders.remove(order);
			}
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
		return orders;
	}
	
	private List<Order> productConstraint(List<Order> orders,String product){
		for(Order order : orders) {
			if(order.getOwner().getEmail() != product) {
				orders.remove(order);
			}
		}
		return orders;
	}

}

