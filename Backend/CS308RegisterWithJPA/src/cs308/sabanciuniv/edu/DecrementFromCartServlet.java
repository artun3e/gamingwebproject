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

@WebServlet(name = "decrementfromcart", urlPatterns = {"/decrementfromcart"})
public class DecrementFromCartServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In the doPost of decrement from cart!!!");
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
            // Add products to card variable in the session...
            if (session.getAttribute("cart") == null) {
                System.out.println("The cart is emty.");

            } else { // cart is not null, however we don't know if the game that we want to decrement is in the cart.
                // If it exists we need to decrement the count.
                // games
                Map<Games, Integer> cartMap = (HashMap)session.getAttribute("cart");
                if (cartMap.get(temp) != null && cartMap.get(temp) != 1) { // the game we want
                    int count = cartMap.get(temp);
                    count = count - 1;
                    cartMap.put(temp, count);
                    System.out.println("Alredy have the game: " + temp.getName() + " decremented count: " + count);
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
