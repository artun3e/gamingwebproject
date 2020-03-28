package cs308.sabanciuniv.devices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAManager {
	public static void insertDeviceToDB(ElectronicDevice device)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(device);
		
		entityManager.getTransaction().commit();
		
		System.out.println("Electronic device with the following information: " + device + " has been inserted into db");
	}
}
