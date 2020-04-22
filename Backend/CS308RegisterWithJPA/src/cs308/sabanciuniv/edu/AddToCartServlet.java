package cs308.sabanciuniv.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "addtocart", urlPatterns = {"/addtocart"})
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
            if (user == null) {
                System.out.println("You are not logged in!!!");
            }
            else {
                System.out.println("You are logged in!!!");
            }
            request.setCharacterEncoding("UTF-16");
            String itemName = request.getParameter("itemName");
            byte[] bytes = itemName.getBytes(StandardCharsets.ISO_8859_1);
            itemName = new String(bytes, StandardCharsets.UTF_8);
            System.out.println("New Item Name2 is: " + itemName);
            Games temp = GamesManager.getDeviceByName(itemName);
            // Add products to card variable in the session...
            if (session.getAttribute("cart") == null) {
                Map<Games, Integer> cartMap = new HashMap<>();
                cartMap.put(temp, 1);
                session.setAttribute("cart", cartMap);
                System.out.println("The cart is emty adding: " + temp.getName());

            } else { // cart is not null, however we don't know if the game that we want to add
                // exists in the cart. If it exists we neet to increment the count of purchased
                // games
                Map<Games, Integer> cartMap = (HashMap)session.getAttribute("cart");
                if (cartMap.get(temp) != null) { // the game we want
                    int count = cartMap.get(temp);
                    count = count + 1;
                    cartMap.put(temp, count);
                    System.out.println("Alredy have the game: " + temp.getName() + " count: " + count);
                } else { // it is the first one
                    cartMap.put(temp, 1);
                    System.out.println("Added game for the first time: " + temp.getName());
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
