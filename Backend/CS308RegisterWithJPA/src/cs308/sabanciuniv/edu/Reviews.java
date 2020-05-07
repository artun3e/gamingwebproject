package cs308.sabanciuniv.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	    	public Reviews(String name, String user, String comment) {
	    		this.name = name;
	    		this.user = user;
	    		this.comment = comment;	
	    }
	    	public Reviews() {
	    	}	
	    	  @GET
	    	    @Produces(MediaType.APPLICATION_JSON)
	    	    @Path("byNamee/{n}")
	    	    public List<Reviews> getReview(@PathParam("n")String query) {
	    	    	 System.out.println("Review ");
	    	        List<Reviews> resultReviews = new ArrayList<Reviews>();
	    	        try {
	    	            Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/MnojkxD0Cc", "MnojkxD0Cc", "O44cHM61gZ");
	    	            PreparedStatement ps = conn.prepareStatement("Select * from Reviews WHERE name like "+ "'%" + query + "%'");
	    	            ResultSet rs = ps.executeQuery();
	    	            System.out.println("Review");

	    	            while (rs.next()) {
	    	            	 Reviews r = new Reviews();
	    	            	 r.setName(rs.getString("name"));
	    	            	 r.setUser(rs.getString("user_email"));
	    	            	 r.setComment(rs.getString("user_comment"));
	    	            	 System.out.println("Review " + r.getComment());
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



