package cs308.sabanciuniv.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addtocart", urlPatterns = { "/addtocart" })
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In the doPost of add to cart!!!");
        try {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if(user == null)
            {
                System.out.println("You are not logged in!!!");
            }
            else
            {
                request.getParameter("itemName");
                //TODO
                //Add products to card variable in the session...
                session.setAttribute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
