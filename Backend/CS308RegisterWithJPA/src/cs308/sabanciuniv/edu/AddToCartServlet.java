package cs308.sabanciuniv.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addtocart", urlPatterns = { "/addtocart" })
public class AddToCartServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In the doPost of add to cart!!!");
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if(user==null) {
				System.out.println("You are not logged in!!!");
			}
			System.out.println("You are not logged in!!!");
			String itemName = request.getParameter("itemName");
			Games temp = GamesManager.getDeviceByName(itemName);
			// Add products to card variable in the session...
			if (session.getAttribute("cart") == null) {
				List<Games> gamesList = new ArrayList<Games>();
				gamesList.add(temp);
				session.setAttribute("cart", gamesList);
				
				
			} else {
				Object object = session.getAttribute("cart");
				List<Games> gameslist = (List) object;
				gameslist.add(temp);
				session.removeAttribute("cart");
				session.setAttribute("cart", gameslist);
			}
			// session.setAttribute("cart", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
