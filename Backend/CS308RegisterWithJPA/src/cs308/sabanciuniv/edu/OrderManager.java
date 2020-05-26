package cs308.sabanciuniv.edu;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.annotation.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
import java.util.Map;
import java.util.Random;

@Path("fromDB")
public class OrderManager {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allOrders/")
    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        try
		{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
            EntityManager em = emf.createEntityManager();
            allOrders = em.createQuery("Select e from Order e", Order.class).getResultList();

            em.close();
            emf.close();
            em = null;
            emf = null;
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return allOrders;
    }


}
