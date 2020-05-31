package cs308.sabanciuniv.edu;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.annotation.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cs308.sabanciuniv.edu.Order.orderStatus;

import com.fasterxml.jackson.databind.JsonMappingException;

import javax.persistence.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("fromDB")
public class OrderManager {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allOrders/")
    public List<Order> getAllOrders() {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
        List<Order> allOrders = new ArrayList<>();
        try
		{
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("select Games.appid as appid,User.name as username,Orders.*, Games.header_image, Games.name, Orders_Games.Quantity, Games.price, Orders_Games_Prices.Price as priceAtThatTime from Orders left join Orders_Games on Orders.id = Orders_Games.Order_id left join Games on Orders_Games.products_KEY = Games.appid left join User on Orders.User_Email = User.Email inner join Orders_Games_Prices on (Orders_Games_Prices.pricesAtThatTime_KEY = Games.appid and Orders_Games_Prices.Order_id = Orders.id)");
			rs = ps.executeQuery();
			while(rs.next()){
				if(!allOrders.contains(new Order(rs.getInt("id")))){
					Order temp = new Order(rs.getInt("id"));
					Map<Games, Double> pricesAtThatTime = new HashMap<>();
					temp.setAddress(rs.getString("address"));
					temp.setDate(rs.getString("date"));
					User user = new User();
					user.setEmail(rs.getString("User_Email"));
					user.setName(rs.getString("username"));
					temp.setOwner(user);
					String statusEnumValue = rs.getString("status");
					Order.orderStatus statusEnum = orderStatus.valueOf(statusEnumValue);
					temp.setStatus(statusEnum);
					temp.setTotalCost(rs.getDouble("totalCost"));
					Games game = new Games();
					game.setHeader_image(rs.getString("header_image"));
					game.setName(rs.getString("name"));
					game.setPrice(rs.getDouble("price"));
					game.setAppID(rs.getInt("appid"));
					temp.addProduct(game,rs.getInt("Quantity"));
					pricesAtThatTime.put(game,rs.getDouble("priceAtThatTime"));
					temp.setPricesAtThatTime(pricesAtThatTime);
					allOrders.add(temp);
				}
				else
				{
					int index = 0;
					for(int i = 0; i < allOrders.size(); i++)
					{
						Order temp = allOrders.get(i);
						if(temp.getId() == rs.getInt("id"))
						{
							Games game = new Games();
							game.setHeader_image(rs.getString("header_image"));
							game.setName(rs.getString("name"));
							game.setPrice(rs.getDouble("price"));
							game.setAppID(rs.getInt("appid"));
							temp.addProduct(game,rs.getInt("Quantity"));
							Map<Games, Double> pricesAtThatTime = temp.getPricesAtThatTime();
							pricesAtThatTime.put(game,rs.getDouble("priceAtThatTime"));
							temp.setPricesAtThatTime(pricesAtThatTime);
							allOrders.set(i, temp);
						}
					}
				}
			}
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
	
	// I'm accepting date in the format of dd-MM-yyyydd-MM-yyyy where the part before - is the lower date constraint and the part after - is the upper date constraint. 
	//the second date should be bigger (please)
	private List<Order> DateConstraint(List<Order> orders,String date){
		List<Order> toRemove = new ArrayList<>();
		String [] dates = date.split("_");
		try {
			Date lowerDate =new SimpleDateFormat("dd-MM-yyyy").parse(dates[0]);
            Date upperDate =new SimpleDateFormat("dd-MM-yyyy").parse(dates[1]);
			for(Order order : orders) {
				Date our_date = new SimpleDateFormat("yyyy/MM/dd").parse(order.getDate()); // our database was this format, i might change the input if it can't compare properly but i think it will
				// compare to returns 0 if dates are equal, a positive integer if the object calling it(ourdate) occurs after the parameter(lowerdate), negative otherwise
				if(our_date.compareTo(lowerDate) < 0 || our_date.compareTo(upperDate) > 0) { // our date occurs before lowerdate or our date occurs after upperdate
					//orders.remove(order);
					toRemove.add(order);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
		orders.removeAll(toRemove);
		return orders;
	}
	
	
	private List<Order> emailConstraint(List<Order> orders, String email){
	    List<Order> toRemove = new ArrayList<>();

		for(Order order : orders) {
			if(!order.getOwner().getEmail().contentEquals(email)) {
				//orders.remove(order);
				toRemove.add(order);

			}
		}
		orders.removeAll(toRemove);
		return orders;
	}
    

	private List<Order> priceConstraint(List<Order> orders,String price){
        List<Order> toRemove = new ArrayList<>();
		String [] prices = price.split("-");
		Double lowerprice = Double.parseDouble(prices[0]);
		Double upperprice = Double.parseDouble(prices[1]);
		/*for(Order order : orders) {
			double total_price = 0;
			Map<Games, Integer> hashmap = order.getProducts();
			for (Map.Entry mapElement : hashmap.entrySet()) {       // for each game in the order
	            Games game = (Games) mapElement.getKey(); 
	            int quantity = (int) mapElement.getValue(); 
	            total_price = total_price + (game.getPrice() * quantity);
	        }
	    */
		for(Order order : orders) {
			Double total_price = order.getTotalCost();
			if(total_price > upperprice || total_price < lowerprice){ // price doesn't fit our range so we remove the order
				//orders.remove(order); // uncomment this to see the ConcurrentModificationException :)
				toRemove.add(order);
			}
		}
		orders.removeAll(toRemove);
		return orders;
	}
	
	
	
	
	private List<Order> productConstraint(List<Order> orders,String product){
		List<Order> toRemove = new ArrayList<>();
		for(Order order : orders) {
			boolean GameExists = false;
			Map<Games, Integer> hashmap = order.getProducts();
			for (Map.Entry mapElement : hashmap.entrySet()) {       // for each game in the order
	            Games game = (Games) mapElement.getKey(); 
	            if(game.getName().contentEquals(product)) {
	            	GameExists = true;	// the desired game exists in our list of games so we will display the whole order
	            }
			}
			if(!GameExists){ // game doesn't exist in this order so we delete the order
				//orders.remove(order);
				toRemove.add(order);

			}
		}
		orders.removeAll(toRemove);	
		return orders;
	}

	

	public class denizIstedi
	{
		public String date;
		public double profit;

		denizIstedi(String date, double profit)
		{
			this.date = date;
			this.profit = profit;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("oneMonthSummary")
	public List<denizIstedi> oneMonthSummary()
	{

		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		HashMap<String,Double> summary = new HashMap<>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			//ps = conn.prepareStatement("select Orders.date, Games.price from Orders_Games left join Orders on Orders_Games.Order_id = Orders.id left join Games on Orders_Games.products_KEY = Games.appid where Order_id in (Select id from Orders WHERE date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH))");
			ps = conn.prepareStatement("select Orders.date, Orders.totalCost from Orders where Orders.id in (Select id from Orders WHERE date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH))");
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
				/*Double price = rs.getDouble("price");
				if(summary.containsKey(monthAndDay))
				{
					double oldPrice = summary.get(monthAndDay);
					oldPrice += price;
					summary.put(monthAndDay,oldPrice);
				}
				else
				{
					summary.put(monthAndDay,price);
				}*/
				Double totalCost = rs.getDouble("totalCost");
				if(summary.containsKey(monthAndDay))
				{
					double oldPrice = summary.get(monthAndDay);
					oldPrice += totalCost;
					summary.put(monthAndDay,oldPrice);
				}
				else
				{
					summary.put(monthAndDay,totalCost);
				}
			}
			for (LocalDate date = today30.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); date.isBefore(LocalDate.now()); date = date.plusDays(1))
			{
				String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

		SortedSet<String> keys = new TreeSet<>(summary.keySet());
		HashMap<String, Double> sortedSummary = new HashMap<>();
		List<denizIstedi> sortedList = new ArrayList<>();
 		for (String key : keys) {
 			//System.out.println(key);
 			//System.out.println("_____________");
			Double value = summary.get(key);
			sortedList.add(new denizIstedi(key, value));
		}
		return sortedList;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("drawChart/{date1}/{date2}")
	public List<denizIstedi> drawChart(@PathParam("date1") String date1, @PathParam("date2") String date2){
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		HashMap<String,Double> summary = new HashMap<>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			//ps = conn.prepareStatement("select Orders.date, Games.price from Orders_Games left join Orders on Orders_Games.Order_id = Orders.id left join Games on Orders_Games.products_KEY = Games.appid where Order_id in (Select id from Orders WHERE date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH))");
			ps = conn.prepareStatement("select Orders.date, Orders.totalCost from Orders where Orders.id in (Select id from Orders WHERE date between ? and ?)");
			date1 = date1.replace("-","/");
			date2 = date2.replace("-","/");
			ps.setString(1,date1);
			ps.setString(2,date2);
			rs = ps.executeQuery();
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyy/MM/dd");
			Date parsedDate1 = formatter.parse(date1.substring(0,10));
			Date parsedDate2 = formatter.parse(date2.substring(0,10));
			//2020/04/26 18:22:28
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.add(Calendar.DAY_OF_MONTH, -30);
			Date today30 = cal.getTime();
			while(rs.next())
			{
				String monthAndDay = rs.getString("date").substring(0,10).replace("/","-");
				/*Double price = rs.getDouble("price");
				if(summary.containsKey(monthAndDay))
				{
					double oldPrice = summary.get(monthAndDay);
					oldPrice += price;
					summary.put(monthAndDay,oldPrice);
				}
				else
				{
					summary.put(monthAndDay,price);
				}*/
				Double totalCost = rs.getDouble("totalCost");
				if(summary.containsKey(monthAndDay))
				{
					double oldPrice = summary.get(monthAndDay);
					oldPrice += totalCost;
					summary.put(monthAndDay,oldPrice);
				}
				else
				{
					summary.put(monthAndDay,totalCost);
				}
			}
			for (LocalDate date = parsedDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); date.isBefore(parsedDate2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); date = date.plusDays(1))
			{
				String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				//System.out.println("formatted date is: " + formattedDate);
				if(!summary.containsKey(formattedDate))
				{
					summary.put(formattedDate,0.0);
				}
			}			conn.close();
			ps.close();
			rs.close();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		conn = null;
		ps = null;
		rs = null;

		SortedSet<String> keys = new TreeSet<>(summary.keySet());
		HashMap<String, Double> sortedSummary = new HashMap<>();
		List<denizIstedi> sortedList = new ArrayList<>();
		for (String key : keys) {
			//System.out.println(key);
			//System.out.println("_____________");
			Double value = summary.get(key);
			sortedList.add(new denizIstedi(key, value));
		}
		return sortedList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getTotalProfit")
	public double getTotalProfit()
	{
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		double totalProfit = 0.0;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("select sum(totalCost) as totalProfit from Orders");
			rs = ps.executeQuery();
			while(rs.next())
			{
				totalProfit = rs.getDouble("totalProfit");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return totalProfit;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getNumberOfOrders")
	public double getNumberOfOrders()
	{
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		int totalCount = 0;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("select count(*) as totalcount from Orders");
			rs = ps.executeQuery();
			while(rs.next())
			{
				totalCount = rs.getInt("totalcount");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getNumberOfShippedOrders")
	public double getNumberOfShippedOrders()
	{
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		int totalCount = 0;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("select count(*) as totalcount from Orders where status='Delivered'");
			rs = ps.executeQuery();
			while(rs.next())
			{
				totalCount = rs.getInt("totalcount");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

/* DONT RUN THE BELOW CODE, IT WAS FOR FIXING THE ARTUN'S PASSWORD.
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("fixPassword")
	public String fixPassword()
	{
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
			ps = conn.prepareStatement("select * from User where Email=?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,"pri.dilemma@gmail.com");
			rs = ps.executeQuery();
			while(rs.next())
			{
				String password = rs.getString("password");
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
				rs.updateString("password",new String(hash, "UTF-8"));
				rs.updateRow();
			}
			return "Successfully updated the password :)";
		}
		catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "An error occured while updating the password :(";
	}
*/
/* DONT RUN THE BELOW CODE, IT WAS FOR FIXING THE TOTALCOSTS OF ORDERS.
	@GET
	@Path("fixOrderTotalCost")
	public void fixOrderTotalCost()
	{
		EntityManagerFactory emf;
		EntityManager em;

		try
		{
			emf = Persistence.createEntityManagerFactory("cs308");
			em = emf.createEntityManager();

			List<Order> allOrders = em.createQuery("Select e from Order e", Order.class).getResultList();
			for(Order o : allOrders)
			{
				em.getTransaction().begin();
				double totalCost = 0;
				Map<Games, Integer> products = o.getProducts();
				for(Games game : products.keySet())
				{
					totalCost += (game.getPrice()*products.get(game));
				}
				o.setTotalCost(totalCost);
				em.merge(o);
				em.getTransaction().commit();
			}

			emf.close();
			em.close();

			emf = null;
			em = null;
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}*/

/*  DONT RUN THE BELOW CODE, IT WAS FOR FIXING THE PRICES OF GAMES AT THE TIME OF SPECIFIC ORDERS.
	@GET
	@Path("fixOrderPriceAtThatTime")
	public void fixOrderPriceAtThatTime()
	{
		EntityManagerFactory emf;
		EntityManager em;

		try
		{
			emf = Persistence.createEntityManagerFactory("cs308");
			em = emf.createEntityManager();

			List<Order> allOrders = em.createQuery("Select e from Order e", Order.class).getResultList();
			for(Order o : allOrders)
			{
				em.getTransaction().begin();
				Map<Games, Integer> products = o.getProducts();
				Map<Games, Double> priceAtThatTime = new HashMap<>();
				for(Games game : products.keySet())
				{
					priceAtThatTime.put(game, game.getPrice());
				}
				o.setPricesAtThatTime(priceAtThatTime);
				em.merge(o);
				em.getTransaction().commit();
			}

			emf.close();
			em.close();

			emf = null;
			em = null;
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}*/
}