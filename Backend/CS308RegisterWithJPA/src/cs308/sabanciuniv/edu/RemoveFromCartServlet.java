package cs308.sabanciuniv.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "removefromcart", urlPatterns = {"/removefromcart"})
public class RemoveFromCartServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In the doPost of remove from cart!!!");
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                System.out.println("You are not logged in!!!");
            }
            else {
                System.out.println("You are logged in!!!");
            }
            String itemName = request.getParameter("itemName");
            System.out.println("Item Name is: " + itemName);
            Games temp = GamesManager.getDeviceByName(itemName);
            
            if (session.getAttribute("cart") == null) {
                System.out.println("The cart is emty.");

            } else { // cart is not null, however we don't know if the game that we want to remove is in the cart.
                // If it exists we need delete the whole item.
                // games
                Map<Games, Integer> cartMap = (HashMap)session.getAttribute("cart");
                if (cartMap.get(temp) != null) { // the game we want
                    cartMap.remove(temp);
                    System.out.println("Removed Revised: " + temp.getName());
                }
                System.out.println("Cart at final: " + cartMap);
                session.removeAttribute("cart");
                session.setAttribute("cart", cartMap);
            }

        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
