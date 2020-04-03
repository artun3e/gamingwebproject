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
				obj.setName(rs.getString("name"));
				obj.setBrand(rs.getString("brand"));
				obj.setCategory(rs.getString("categories"));
				obj.setPrimaryCategory(rs.getString("primaryCategories"));
				obj.setPrice(rs.getDouble("prices.amountMax"));
				obj.setCurrency(rs.getString("prices.currency"));
				obj.setOnSale(rs.getBoolean("prices.isSale"));
				obj.setMerchant(rs.getString("prices.merchant"));
				obj.setImageURLs(rs.getString("imageURLs"));
				obj.setManufacturer(rs.getString("manufacturer"));
				obj.setSourceURL(rs.getString("sourceURLs"));
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
