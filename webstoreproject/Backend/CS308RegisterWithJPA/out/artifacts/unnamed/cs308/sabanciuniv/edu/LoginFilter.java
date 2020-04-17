package cs308.sabanciuniv.edu;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();

        if(session.getAttribute("user")==null)
        {
            System.out.println("User not yet logged in...");
            chain.doFilter(req, resp);
        }
        else
        {
            System.out.println("User already logged in...");
            HttpServletResponse response = (HttpServletResponse) resp;

            response.sendRedirect("home_Deniz.html");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
