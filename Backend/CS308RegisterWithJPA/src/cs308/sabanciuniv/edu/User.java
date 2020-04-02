package cs308.sabanciuniv.edu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class User {
	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int id;
	private String name;
	@Id
	@Column(name="Email")
	private String email;
	private String password;
	//public int getId() {
	//	return id;
	//}
	//public void setId(int id) {
	//	this.id = id;
	//}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String name, String email, String password) {
		//super();
		//this.id = 0;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static User findByEmail(String email)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
		EntityManager em = emf.createEntityManager();
		try {
			Object obj = em.createQuery("From User WHERE EMAIL LIKE :email").setParameter("email", email).getSingleResult();
			User user = (User)obj;
			return user;
		} catch (Exception e) {
			return null;
		}
	}
	public User() {
		//this.id = 0;
	}
}
