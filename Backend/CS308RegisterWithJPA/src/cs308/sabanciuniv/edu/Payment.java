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
import javax.persistence.*;

@Entity
@Table(name="Payment")
@Path("fromDB")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cNumber")
	    	private String cardNumber;
	    	private String cvc;
	    	 @Column(name = "date")
	    	private String expirationDate;
	    	//private String email;
	    	 
	    	 @ManyToOne
		     @JoinColumn(name = "email")
	    	private User user;
	    	 
	    	public void setUser(User user){
	    		this.user = user;
	    	}
	    	 
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
	    		return user.getEmail();
	    	}

	    	
	    	public String getExpirationDate() {
	    		return expirationDate;
	    	}

	    	public void setExpirationDate(String expirationDate) {
	    		this.expirationDate = expirationDate;
	    	}
	    	
	    	public Payment(int id,String cardNumber, User user, String cvc, String expirationDate) {
	    		this.id = id;
	    		this.cardNumber = cardNumber;
	    		this.user = user;
	    		this.cvc = cvc;	
	    		this.expirationDate = expirationDate;
	    }
	    	
	    	public Payment(User user){
	    		this.user = user;	
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
	    	            	 p.setUser(new User(rs.getString("email")));
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



