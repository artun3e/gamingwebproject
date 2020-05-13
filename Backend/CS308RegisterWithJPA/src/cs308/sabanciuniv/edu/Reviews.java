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
public class Reviews {
	    	private String name;
	    	private String user;
	    	private String comment;
	    	private String date;
	    	private String rating;
	    	public String getName() {
	    		return name;
	    	}
	    	public void setName(String name) {
	    		this.name = name;
	    	}
	    	public String getUser() {
	    		return user;
	    	}

	    	public void setUser(String user) {
	    		this.user = user;
	    	}
	    	public String getComment() {
	    		return comment;
	    	}

	    	public void setComment(String comment) {
	    		this.comment = comment;
	    	}
	    	public String getDate() {
	    		return date;
	    	}

	    	public void setDate(String date) {
	    		this.date = date;
	    	}
	    	public String getRating() {
	    		return rating;
	    	}

	    	public void setRating(String rating) {
	    		this.rating = rating;
	    	}
	    	public Reviews(String name, String user, String comment, String date, String rating) {
	    		this.name = name;
	    		this.user = user;
	    		this.comment = comment;	
	    		this.date = date;
	    		this.rating = rating;
	    }
	    	public Reviews() {
	    	}	
	    	  @GET
	    	    @Produces(MediaType.APPLICATION_JSON)
	    	    @Path("byNamee/{n}")
	    	    public List<Reviews> getReview(@PathParam("n")String query) {
	    	        List<Reviews> resultReviews = new ArrayList<Reviews>();
	    	        try {
	    	            Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
	    	            PreparedStatement ps = conn.prepareStatement("Select * from Reviews where name=?");
	    	            ps.setString(1, query);
	    	            ResultSet rs = ps.executeQuery();

	    	            while (rs.next()) {
	    	            	 Reviews r = new Reviews();
	    	            	 r.setName(rs.getString("name"));
	    	            	 r.setUser(rs.getString("user_email"));
	    	            	 r.setComment(rs.getString("user_comment"));
	    	            	 r.setRating(rs.getString("rating"));
	    	            	 r.setDate(rs.getString("date"));
//	    	            	 System.out.println("Review " + r.getComment());
	    	            	 resultReviews.add(r);
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



