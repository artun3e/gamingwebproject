package cs308.sabanciuniv.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.persistence.EntityManager;

@Path("fromDB")
public class Payment {
			private int id;
	    	private String cardNumber;
	    	private String cvc;
	    	private String expirationDate;
	    	private String email;
	    	public int getID() {
	    		return id;
	    	}
	    	public void setID(int id) {
	    		this.id = id;
	    	}
	    	public String getCardNumber() {
	    		return cardNumber;
	    	}
	    	public void setCardNumber(String cardNumber) {
	    		this.cardNumber = cardNumber;
	    	}
	    	public String getCVC() {
	    		return cvc;
	    	}

	    	public void setCVC(String cvc) {
	    		this.cvc = cvc;
	    	}
	    	public String getEmail() {
	    		return email;
	    	}

	    	public void setEmail(String email) {
	    		this.email = email;
	    	}
	    	public String getExpirationDate() {
	    		return expirationDate;
	    	}

	    	public void setExpirationDate(String expirationDate) {
	    		this.expirationDate = expirationDate;
	    	}
	    	
	    	public Payment(int id,String cardNumber, String email, String cvc, String expirationDate) {
	    		this.id = id;
	    		this.cardNumber = cardNumber;
	    		this.email = email;
	    		this.cvc = cvc;	
	    		this.expirationDate = expirationDate;
	    }
	    	public Payment() {
	    	}	
	    	  @GET
	    	    @Produces(MediaType.APPLICATION_JSON)
	    	    @Path("byPayment/{n}")
	    	    public List<Payment> getPayment(@PathParam("n")String query) {
	    	        List<Payment> resultReviews = new ArrayList<Payment>();
	    	        try {
	    	            Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
	    	            PreparedStatement ps = conn.prepareStatement("Select * from Payment where email=?");
	    	            ps.setString(1, query);
	    	            ResultSet rs = ps.executeQuery();

	    	            while (rs.next()) {
	    	            	Payment p = new Payment();
	    	            	 p.setID(rs.getInt("id"));
	    	            	 p.setCardNumber(rs.getString("cNumber"));
	    	            	 p.setEmail(rs.getString("email"));
	    	            	 p.setCVC(rs.getString("cvc"));
	    	            	 p.setExpirationDate(rs.getString("date"));
//	    	            	 System.out.println("Review " + r.getComment());
	    	            	 resultReviews.add(p);
	    	            }
	    	            
	    	            conn.close();
	    	            conn = null;
	    	            ps = null;
	    	            rs = null;
	    	            return resultReviews;
	    	        } 
	    	        catch (Exception e) {
	    	            e.printStackTrace();
	    	            return resultReviews;
	    	        }
	    	    }

	    	   
}



