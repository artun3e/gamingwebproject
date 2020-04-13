package cs308.sabanciuniv.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Path("fromDB")
public class ElectronicDeviceManager {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("byName/{n}")
	public List<ElectronicDeviceTemp> getDevice(@PathParam("n") String query)
	{
		List<ElectronicDeviceTemp> resultList = new ArrayList<ElectronicDeviceTemp>();
		try 
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/XiiV7ZFMQd", "XiiV7ZFMQd", "XHEMcSeLpd");
			PreparedStatement ps = conn.prepareStatement("Select * from ElectronicDevice WHERE name LIKE " + "'%"+query+"%'"  );
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ElectronicDeviceTemp obj = new ElectronicDeviceTemp();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setBrand(rs.getString("brand"));
				obj.setCategory(rs.getString("category"));
				obj.setPrimaryCategory(rs.getString("primaryCategory"));
				obj.setPrice(rs.getDouble("price"));
				obj.setCurrency(rs.getString("currency"));
				obj.setOnSale(rs.getBoolean("onSale"));
				obj.setMerchant(rs.getString("merchant"));
				obj.setImageURLs(rs.getString("imageURLs"));
				obj.setManufacturer(rs.getString("manufacturer"));
				obj.setSourceURL(rs.getString("sourceURL"));
				resultList.add(obj);
			}
			return resultList;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return resultList;
		}
	}
}
