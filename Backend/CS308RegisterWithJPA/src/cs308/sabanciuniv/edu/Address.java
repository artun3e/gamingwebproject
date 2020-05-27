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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Path("fromDB")
public class Address {
			private int id;
	    	private String address;
	    	private String city;
	    	private String phoneNumber;
	    	
	    	@ManyToOne
	        @JoinColumn(name = "email")
	    	private User user;
	    	
	    	public void setUser(User myUser) {
	    		this.user = myUser;
	    	}
	    	//private String email;
	    	public int getID() {
	    		return id;
	    	}
	    	public void setID(int id) {
	    		this.id = id;
	    	}
	    	public String getAddress() {
	    		return address;
	    	}
	    	public void setAddress(String address) {
	    		this.address = address;
	    	}
	    	public String getCity() {
	    		return city;
	    	}

	    	public void setCity(String city) {
	    		this.city = city;
	    	}
	    	public String getEmail() {
	    		return user.getEmail();
	    	}
	    	
	    	
	    	public String getPhoneNumber() {
	    		return phoneNumber;
	    	}

	    	public void setPhoneNumber(String phoneNumber) {
	    		this.phoneNumber = phoneNumber;
	    	}
	    	
	    	public Address(int id,String address, User user, String city, String phoneNumber) {
	    		this.id = id;
	    		this.address = address;
	    		this.user = user;
	    		this.city = city;	
	    		this.phoneNumber = phoneNumber;
	    }
	    	public Address() {
	    	}	
	    	  @GET
	    	    @Produces(MediaType.APPLICATION_JSON)
	    	    @Path("byAddress/{n}")
	    	    public List<Address> getAddress(@PathParam("n")String query) {
	    	        List<Address> resultReviews = new ArrayList<Address>();
	    	        try {
	    	            Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
	    	            PreparedStatement ps = conn.prepareStatement("Select * from Addresses where email=?");
	    	            ps.setString(1, query);
	    	            ResultSet rs = ps.executeQuery();

	    	            while (rs.next()) {
	    	            	Address a = new Address();
	    	            	 a.setID(rs.getInt("id"));
	    	            	 a.setAddress(rs.getString("address"));
	    	            	 a.setUser(new User(rs.getString("email")));
	    	            	 a.setCity(rs.getString("city"));
	    	            	 a.setPhoneNumber(rs.getString("phoneNumber"));
//	    	            	 System.out.println("Review " + r.getComment());
	    	            	 resultReviews.add(a);
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



