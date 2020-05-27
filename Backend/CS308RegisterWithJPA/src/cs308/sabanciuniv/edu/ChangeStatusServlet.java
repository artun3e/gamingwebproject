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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs308.sabanciuniv.edu.Order.orderStatus;

/**
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
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
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getUserType() == User.userType.Admin){
			String OrderID = request.getParameter("order_id");
			String status = request.getParameter("status");
			int int_orderID = Integer.parseInt(OrderID);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
			EntityManager em = emf.createEntityManager();
			Order order= em.find(Order.class, int_orderID);
			orderStatus orderstatus = orderStatus.valueOf(status);
			em.getTransaction().begin();
			order.setStatus(orderstatus);
			em.getTransaction().commit();
			}
			else{ // stole this bit from dropdownorderupdateservlet.java
				System.out.println("Compile test.");
				session.setAttribute("ChangeStatus-error", "You are not authorized!!!!");
				response.setHeader("ChangeStatus-error","true");
				return;
			}
		}
	}

