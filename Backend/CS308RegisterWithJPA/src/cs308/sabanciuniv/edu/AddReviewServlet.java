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
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "addreview", urlPatterns = {
    "/addreview"
})
public class AddReviewServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In do post of order servlet!!!!");
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                session.setAttribute("order-error", "Please login before writing a comment!");
                response.setHeader("order-error", "true");
                return;
            } else {
                String gameName = request.getParameter("itemName");
                System.out.println(gameName);
                String comment = request.getParameter("comment");
                System.out.println(comment);
                String SQL = "INSERT INTO Reviews(user_email,name, user_comment,date) " +
                    "VALUES(?,?,?,?)";

                Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
                PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getEmail());
                ps.setString(2, gameName);
                ps.setString(3, comment);
                ps.setString(4, java.time.LocalDate.now().toString());

                int numRowsChanged = ps.executeUpdate();

                conn.close();
                conn = null;
                ps = null;
                //	    	            rs = null;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}