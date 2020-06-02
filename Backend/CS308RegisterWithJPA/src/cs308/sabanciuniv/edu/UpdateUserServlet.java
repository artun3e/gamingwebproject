package cs308.sabanciuniv.edu;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class UpdateUserServlet
 */

@WebServlet(name = "UpdateUserServlet", urlPatterns = {
        "/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                System.out.println("You are not logged in!!!");
            } else {
                System.out.println("You are logged in!!!");

                String name = request.getParameter("name");
                String oldPassword = request.getParameter("cpassword");
                String newPassword = request.getParameter("npassword");
                String email = user.getEmail();
                String newEmail = request.getParameter("newEmail");

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(oldPassword.getBytes(StandardCharsets.UTF_8));  // hash the input password
                byte[] hash2 = digest.digest(newPassword.getBytes(StandardCharsets.UTF_8));

                if (user.getPassword().contentEquals(new String(hash, "UTF-8"))) // check whether users match
                {
                    request.removeAttribute("user");
                    conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
                    ps = conn.prepareStatement("UPDATE User set name=?, password=? where Email=?");
                    ps.setString(1, name);
                    if (newPassword.length() != 0) {
                        ps.setString(2, new String(hash2, "UTF-8"));
                        user.setPassword(newPassword);
                    } else {
                        ps.setString(2, new String(hash, "UTF-8"));
                    }
                    ps.setString(3, email);
                    ps.executeUpdate();
                    conn.close();
                    ps.close();
                    user.setName(name);
					if (!email.contentEquals(newEmail))
					{
						System.out.println("Email was changed");
						user.setEmail(newEmail);

						URL urlForGetRequest = new URL("http://localhost:8080/CS308RegisterWithJPA/search/fromDB/changeEmail/"+email+"/"+newEmail);
						String readLine = null;
						HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
						conection.setRequestMethod("GET");
						int responseCode = conection.getResponseCode();
						response.setHeader("userUpd	ateError", "false");
						if (responseCode == HttpURLConnection.HTTP_OK)
						{
							BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
							StringBuffer strBuffer = new StringBuffer();
							while ((readLine = in .readLine()) != null)
							{
								strBuffer.append(readLine);
							}
							in.close();
							System.out.println("JSON String Result " + strBuffer.toString());
						}
					}
					session.setAttribute("user",user);
				}
                else {
                    response.setHeader("userUpdateError", "true");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
