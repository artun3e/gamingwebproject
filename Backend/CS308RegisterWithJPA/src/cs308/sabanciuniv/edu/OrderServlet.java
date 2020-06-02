package cs308.sabanciuniv.edu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(name = "placeorder", urlPatterns = { "/placeorder" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do post of order servlet!!!!");
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		try
		{			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user == null)
			{
				System.out.println("Compile test.");
				session.setAttribute("order-error", "Please login before placing an order!!!!");
				response.setHeader("order-error","true");
				return;
			}
			
		
			else{
				//String userEmail = user.getEmail();
				//System.out.println("itemQuantitiesBeforeSplit is " + request.getParameter("list_q"));
				String[] itemNames = request.getParameter("list_names").split(";;;");
				String[] itemQuantities = request.getParameter("list_q").split(",");
				//System.out.println("After Split is " + itemQuantities);
				String aID = request.getParameter("addressID");
				String pID = request.getParameter("paymentID");
				Map<Games, Integer> hashmap = new HashMap<>();
				//EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				//EntityManager em = emf.createEntityManager();
				conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
				int countingVariable = 0;
				String htmlText = "<H1>"+"Hello " + user.getName()+"\n" + "You have made the following purchase from our website: "+"<H1>";
				Map<Games, Double> pricesAtThatTime = new HashMap<>();
				double totalCost = 0;

				for(String itemName : itemNames)
				{
					System.out.println("Address ID sent is: " + aID);
					System.out.println("Payment ID sent is: " +pID);
					System.out.println("Query is " + itemName);
					try
					{
						//Object obj = em.createQuery("from Games where name=:nameTemp").setParameter("nameTemp", itemName).setMaxResults(1).getSingleResult();
						ps = conn.prepareStatement("Select onSale,stock,salePrice,Price,appid,header_image from Games where name like CONCAT( '%',?,'%')");
						ps.setString(1,itemName);
						rs = ps.executeQuery();
						rs.next();
						Games temp = new Games();
						temp.setAppID(rs.getInt("appid"));
						temp.setHeader_image(rs.getString("header_image"));
						temp.setSalePrice(rs.getDouble("salePrice"));
						temp.setPrice(rs.getDouble("price"));
						temp.setStock(rs.getInt("stock"));
						temp.setOnSale(rs.getBoolean("onSale"));
						//em.getTransaction().begin();
						hashmap.put(temp, Integer.parseInt(itemQuantities[countingVariable]));
						htmlText += "<H2>"+itemQuantities[countingVariable] + " copies of " + itemName + "\n"+"</H2><img src=\""+ temp.getHeader_image() +"\"><br>";
						//temp.reduceFromStock(Integer.parseInt(itemQuantities[countingVariable]));
						ps = conn.prepareStatement("UPDATE Games SET stock = ? where appid = ?");
						ps.setInt(1,temp.getStock()-Integer.parseInt(itemQuantities[countingVariable]));
						ps.setInt(2,temp.getAppID());
						ps.executeUpdate();
						//em.merge(temp);
						//em.getTransaction().commit();
						if(temp.isOnSale()){
							totalCost += (temp.getSalePrice()*Integer.parseInt(itemQuantities[countingVariable]));
							pricesAtThatTime.put(temp,temp.getSalePrice());
						}
						else {
							totalCost += (temp.getPrice() * Integer.parseInt(itemQuantities[countingVariable]));
							pricesAtThatTime.put(temp,temp.getPrice());
						}
					}
					catch(NoResultException e)
					{
						System.out.println("Item could not be found in the database!!!");
					}
					countingVariable++;
				}
				//em.getTransaction().begin();
				/*
				 * TODO : orderda adresi string olarak tutalim
				 * constructor TODO -> address
				 *  sectigi addressi tek stringte yollanmasi lazim -> parametre olarak al
				 */
				// get users address
				ps = conn.prepareStatement("select address from Addresses where id=?");
				ps.setInt(1,Integer.parseInt(aID));
				rs = ps.executeQuery();
				rs.next();
				//Address address = em.find(Address.class, Integer.parseInt(aID));
				String orderAddress = rs.getString("address");
				System.out.println("address is: " + orderAddress);
				ps = conn.prepareStatement("INSERT into Orders(address,date,User_Email,status,totalCost) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,orderAddress);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				ps.setString(2,dtf.format(now));
				ps.setString(3,user.getEmail());
				ps.setString(4,"PreparingPackage");
				ps.setDouble(5,totalCost);
				ps.execute();
				rs = ps.getGeneratedKeys();
				rs.next();
				for(Games game: hashmap.keySet())
				{
					ps = conn.prepareStatement("insert into Orders_Games(Order_id,Quantity,products_KEY) VALUES(?,?,?)");
					int tempId = rs.getInt(1);
					ps.setInt(1,tempId);
					ps.setInt(2,hashmap.get(game));
					ps.setInt(3,game.getAppID());
					ps.execute();
					ps = conn.prepareStatement("insert into Orders_Games_Prices(Order_id,Price,pricesAtThatTime_KEY) VALUES(?,?,?)");
					ps.setInt(1,tempId);
					ps.setDouble(2,pricesAtThatTime.get(game));
					ps.setInt(3,game.getAppID());
					ps.execute();
				}
				conn.close();
				ps.close();
				rs.close();
				//Order newOrder = new Order(orderAddress, user);
				//newOrder.setStatus(Order.orderStatus.PreparingPackage);
				//newOrder.setMap(hashmap);
				//newOrder.setTotalCost(totalCost);
				//newOrder.setPricesAtThatTime(pricesAtThatTime);
				//em.persist(newOrder);
				//System.out.println("We are here!v3");
				//user.addOrder(newOrder);
				//em.merge(user);
				//em.getTransaction().commit();
				//em.close();
				//emf.close();
				//System.out.println("Done v2!!!!!");
				System.out.println("Done placing the order in the database.");
				/*System.out.println("Added order is : ");
				int countTime = 1;
				for(Order o : user.getOrders())
				{
					System.out.println("-------------------------- "+ countTime + "  --------------------------");
					System.out.println(o);
					countTime++;
				}*/
				session.removeAttribute("cart");
				htmlText += "<H2>Total Cost: " + totalCost + "</H2>";
				htmlText += "<H3>Thank you for your purchase! You can always check your order status from our website. We will also e-mail you when your order status changes<H3>";
				JavaMailUtil.sendHTMLMail(htmlText,user.getEmail());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn = null;
		rs = null;
		ps = null;
	}

}
