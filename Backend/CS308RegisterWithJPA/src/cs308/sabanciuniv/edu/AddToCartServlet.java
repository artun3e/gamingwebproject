package cs308.sabanciuniv.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs308.sabanciuniv.devices.ElectronicDevice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addtocart", urlPatterns = { "/addtocart" })
public class AddToCartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In the doPost of add to cart!!!");
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println("You are not logged in!!!");
			String itemName = request.getParameter("itemName");
			ElectronicDeviceTemp temp = ElectronicDeviceManager.getDeviceByName(itemName);
			// Add products to card variable in the session...
			if (session.getAttribute("cart") == null) {
				List<ElectronicDeviceTemp> electronicdevicelist = new ArrayList<ElectronicDeviceTemp>();
				electronicdevicelist.add(temp);
				session.setAttribute("cart", electronicdevicelist);
			} else {
				Object object = session.getAttribute("cart");
				List<ElectronicDeviceTemp> electronicdevicelist = (List) object;
				electronicdevicelist.add(temp);
				session.removeAttribute("cart");
				session.setAttribute("cart", electronicdevicelist);
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
