package cs308.sabanciuniv.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailsServlet
 */
@WebServlet("/SendMailsServlet")
public class SendMailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailsServlet() {
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
		String messageInput = request.getParameter("messageInput");
		String topic = request.getParameter("topic");
		String RecipientString = request.getParameter("RecipientString");
		
		List<String> fixedLenghtList = Arrays.asList(RecipientString);
		ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);
		for(String recipient : listOfString) {
        	JavaMailUtil.sendMailwithMessageAndTopic(messageInput,recipient,topic); 	//String messageInput, String recipient,String topic
		}
	}

}
