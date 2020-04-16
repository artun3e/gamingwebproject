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
import java.util.HashMap;
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
				session.setAttribute("order-error", "Please login before placing an order!!!!");
				response.setHeader("order-error","true");
				return;
			}
			else{
				ResultSet rs = null;
				String userEmail = user.getEmail();
				String[] itemNames = request.getParameter("list_names").split(",");
				String[] itemQuantities = request.getParameter("list_q").split(",");
				Map<Integer, Games> hashmap = new HashMap<>();
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
				EntityManager em = emf.createEntityManager();
				int countingVariable = 0;
				for(String itemName : itemNames)
				{
					System.out.println("Query is " + itemName);
					try
					{
						Object obj = em.createQuery("from Games where name=:nameTemp").setParameter("nameTemp", itemName).setMaxResults(1).getSingleResult();
						Games temp = (Games) obj;
						hashmap.put(Integer.parseInt(itemQuantities[countingVariable]),temp);
					}
					catch(NoResultException e)
					{
						System.out.println("Item could not be found in the database!!!");
					}
					countingVariable++;
				}
				Order newOrder = new Order("TODO", user);
				newOrder.setMap(hashmap);
				user.addOrder(newOrder);
				em.getTransaction().begin();
				em.persist(newOrder);
				em.getTransaction().commit();
				em.close();
				emf.close();
				System.out.println("Done!!!!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
