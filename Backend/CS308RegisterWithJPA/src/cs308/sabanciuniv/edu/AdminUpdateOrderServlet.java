package cs308.sabanciuniv.edu;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminUpdateOrderServlet
 */
@WebServlet("/AdminUpdateOrderServlet")
public class AdminUpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateOrderServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user.getUserType() == User.userType.Admin){
			String ID = request.getParameter("order_id");
			String adress = request.getParameter("adress");
			String status = request.getParameter("status");
			//Order.orderStatus orderStatus = (Order.orderStatus) status; 
			// below code is fucking retarded
			
			//PreparingPackage,Shipped,OutOnDelivery,Delivered
			//if(status == "PreparingPackage")
			//	 Order.orderStatus.PreparingPackage;
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
			EntityManager em = emf.createEntityManager();
			
			try {
				
				Object obj = em.createQuery("from Orders where id=:order_id").setParameter("order_id", ID).setMaxResults(1).getSingleResult();
				//Order game = em.find(.class, gameID);
				Order temp = (Order) obj;
				em.merge(temp);
				em.getTransaction().begin();
				temp.setAddress(adress);
				// Below code is fucking retarded
				if(status == "PreparingPackage")
					temp.setStatus(Order.orderStatus.PreparingPackage);
				if(status == "Shipped")
					temp.setStatus(Order.orderStatus.Shipped);
				if(status == "OutOnDelivery")
					temp.setStatus(Order.orderStatus.OutOnDelivery);
				if(status == "Delivered")
					temp.setStatus(Order.orderStatus.Delivered);
				
				em.merge(temp);
				em.getTransaction().commit();

				em.close();
				emf.close();

				em = null;
				emf = null;
					
				System.out.println("Successfully updated the order...");
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		else{
			System.out.println("Compile test.");
			session.setAttribute("adminupdateorder-error", "You are not authorized!!!!");
			response.setHeader("adminupdateorder-error","true");
			return;
		}
	}

}
