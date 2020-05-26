package cs308.sabanciuniv.edu;


import cs308.sabanciuniv.edu.Order.orderStatus;


import javax.persistence.EntityManager;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
=======
>>>>>>> 7f9f9b9971555ff2e5d125c4cb3c6cbbbb5018b8

@Path("fromDB")
public class OrderManager {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allOrders/")
    public List<Order> getAllOrders() {
<<<<<<< HEAD

        List<Order> allOrders = new ArrayList<>();
        try
		{
    		System.out.println("Returning all orders");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
            EntityManager em = emf.createEntityManager();
            allOrders = em.createQuery("Select e from Order e", Order.class).getResultList();

            em.close();
            emf.close();
            em = null;
            emf = null;
=======
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
        List<Order> allOrders = new ArrayList<>();
        try
		{
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("select User.name as username,Orders.*, Games.header_image, Games.name, Orders_Games.Quantity, Games.price from Orders left join Orders_Games on Orders.id = Orders_Games.Order_id left join Games on Orders_Games.products_KEY = Games.appid left join User on Orders.User_Email = User.Email");
			rs = ps.executeQuery();
			while(rs.next()){
				if(!allOrders.contains(new Order(rs.getInt("id")))){
					Order temp = new Order(rs.getInt("id"));
					temp.setAddress(rs.getString("address"));
					temp.setDate(rs.getString("date"));
					User user = new User();
					user.setEmail(rs.getString("User_Email"));
					user.setName(rs.getString("username"));
					temp.setOwner(user);
					String statusEnumValue = rs.getString("status");
					Order.orderStatus statusEnum = orderStatus.valueOf(statusEnumValue);
					temp.setStatus(statusEnum);
					Games game = new Games();
					game.setHeader_image(rs.getString("header_image"));
					game.setName(rs.getString("name"));
					game.setPrice(rs.getDouble("price"));
					temp.addProduct(game,rs.getInt("Quantity"));
					allOrders.add(temp);
				}
				else
				{
					int index = 0;
					for(Order temp : allOrders)
					{
						if(temp.getId() == rs.getInt("id"))
						{
							Games game = new Games();
							game.setHeader_image(rs.getString("header_image"));
							game.setName(rs.getString("name"));
							game.setPrice(rs.getDouble("price"));
							temp.addProduct(game,rs.getInt("Quantity"));
						}
					}
				}
			}
>>>>>>> 7f9f9b9971555ff2e5d125c4cb3c6cbbbb5018b8
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
		System.out.println("Time to filter orders");
		if(!date.contentEquals("null")) {
			System.out.println("filtering date");
			orders = DateConstraint(orders,date);
		}
		if(!email.contentEquals("null")) {
			System.out.println("filtering email");
			orders = emailConstraint(orders , email);
		}	
		if(!price.contentEquals("null")) {
			System.out.println("filtering price");
			orders = priceConstraint(orders,price);
		}
		if(!product.contentEquals("null")) {
			System.out.println("filtering product");
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

	@GET
<<<<<<< HEAD
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ChangeStatus/{OrderID}/{status}")
	public void ChangeStatus(@PathParam("OrderID") String OrderID , @PathParam("status") String status){
		int int_orderID = Integer.parseInt(OrderID);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
        EntityManager em = emf.createEntityManager();
=======
	@Produces(MediaType.APPLICATION_JSON)
	@Path("ChangeStatus/{OrderID}/{status}")
	public void ChangeStatus(@PathParam("OrderID") String OrderID , @PathParam("status") String status){
		int int_orderID = Integer.parseInt(OrderID);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
		EntityManager em = emf.createEntityManager();
>>>>>>> 7f9f9b9971555ff2e5d125c4cb3c6cbbbb5018b8
		Order order= em.find(Order.class, int_orderID);
		orderStatus orderstatus = orderStatus.valueOf(status);
		em.getTransaction().begin();
		order.setStatus(orderstatus);
<<<<<<< HEAD
        em.getTransaction().commit();
        
	}	
=======
		em.getTransaction().commit();

	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("oneMonthSummary")
	public HashMap<String,Double> oneMonthSummary()
	{

		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		HashMap<String,Double> summary = new HashMap<>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("select Orders.date, Games.price from Orders_Games left join Orders on Orders_Games.Order_id = Orders.id left join Games on Orders_Games.products_KEY = Games.appid where Order_id in (Select id from Orders WHERE date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH))");
			rs = ps.executeQuery();
			//2020/04/26 18:22:28
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.add(Calendar.DAY_OF_MONTH, -30);
			Date today30 = cal.getTime();
			while(rs.next())
			{
				String monthAndDay = rs.getString("date").substring(0,10).replace("/","-");
				Double price = rs.getDouble("price");
				if(summary.containsKey(monthAndDay))
				{
					double oldPrice = summary.get(monthAndDay);
					oldPrice += price;
					summary.put(monthAndDay,oldPrice);
				}
				else
				{
					summary.put(monthAndDay,price);
				}
			}
			for (LocalDate date = today30.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); date.isBefore(LocalDate.now()); date = date.plusDays(1))
			{
				String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				//System.out.println("formatted date is: " + formattedDate);
				if(!summary.containsKey(formattedDate))
				{
					summary.put(formattedDate,0.0);
				}
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
		ps = null;
		rs = null;
		return summary;
	}
>>>>>>> 7f9f9b9971555ff2e5d125c4cb3c6cbbbb5018b8
}
   

