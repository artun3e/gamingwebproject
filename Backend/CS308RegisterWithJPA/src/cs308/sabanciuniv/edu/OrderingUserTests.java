package cs308.sabanciuniv.edu;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderingUserTests {
	public static void main(String args[])
	{
		try 
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
			EntityManager entityManager = emf.createEntityManager();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String email = "aybarsyazici@sabanciuniv.edu";
			String password = "12345";
			String name = "Aybars Yazici";
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			String hashedPassword = new String(hash, "UTF-8");
			User testUser = new User(name,email,hashedPassword);
			

			Order newOrder = new Order("Istanbul, Pendik, Kurtkoy", testUser);
			
			ElectronicDeviceTemp device1 = entityManager.find(ElectronicDeviceTemp.class, 1);
			ElectronicDeviceTemp device2 = entityManager.find(ElectronicDeviceTemp.class, 50);
			ElectronicDeviceTemp device3 = entityManager.find(ElectronicDeviceTemp.class, 87);
			
			newOrder.addProduct(device1, 5);
			newOrder.addProduct(device2, 3);
			newOrder.addProduct(device3, 1);
			
			testUser.addOrder(newOrder);
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(testUser);
			entityManager.persist(newOrder);
			
			entityManager.getTransaction().commit();
			
			System.out.println("Done!!!");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
