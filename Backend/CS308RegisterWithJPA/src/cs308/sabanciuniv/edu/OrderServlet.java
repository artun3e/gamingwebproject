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
import java.sql.ResultSet;
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
				ResultSet rs = null;
				//String userEmail = user.getEmail();
				String[] itemNames = request.getParameter("list_names").split(",");
				String[] itemQuantities = request.getParameter("list_q").split(",");
				String aID = request.getParameter("addressID");
				String pID = request.getParameter("paymentID");
				Map<Games, Integer> hashmap = new HashMap<>();
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				EntityManager em = emf.createEntityManager();
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
						Object obj = em.createQuery("from Games where name=:nameTemp").setParameter("nameTemp", itemName).setMaxResults(1).getSingleResult();
						Games temp = (Games) obj;
						em.getTransaction().begin();
						hashmap.put(temp, Integer.parseInt(itemQuantities[countingVariable]));
						htmlText += "<H2>"+itemQuantities[countingVariable] + " copies of " + itemName + "\n"+"</H2><img src=\""+ temp.getHeader_image() +"\"><br>";
						temp.reduceFromStock(Integer.parseInt(itemQuantities[countingVariable]));
						em.merge(temp);
						em.getTransaction().commit();
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
				em.getTransaction().begin();
				/*
				 * TODO : orderda adresi string olarak tutalim
				 * constructor TODO -> address
				 *  sectigi addressi tek stringte yollanmasi lazim -> parametre olarak al
				 */
				// get users address 
				Order newOrder = new Order(user.getAddress(), user);
				newOrder.setStatus(Order.orderStatus.PreparingPackage);
				newOrder.setMap(hashmap);
				newOrder.setTotalCost(totalCost);
				newOrder.setPricesAtThatTime(pricesAtThatTime);
				em.persist(newOrder);
				System.out.println("We are here!v3");
				user.addOrder(newOrder);
				em.merge(user);
				em.getTransaction().commit();
				em.close();
				emf.close();
				System.out.println("Done v2!!!!!");
				System.out.println("Done placing the order in the database v2.");
				System.out.println("All user orders are : ");
				int countTime = 1;
				for(Order o : user.getOrders())
				{
					System.out.println("-------------------------- "+ countTime + "  --------------------------");
					System.out.println(o);
					countTime++;
				}
				session.removeAttribute("cart");
				htmlText += "<H3>Thank you for your purchase! You can always check your order status from our website. We will also e-mail you when your order status changes<H3>";
				JavaMailUtil.sendHTMLMail(htmlText,user.getEmail());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
