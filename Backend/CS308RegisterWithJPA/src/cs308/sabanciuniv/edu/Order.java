package cs308.sabanciuniv.edu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Orders") 
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	@ManyToOne
	private User owner;
	private String date;
	@OneToMany
	@MapKeyColumn(name="Quantity")
	Map<Integer, ElectronicDeviceTemp> products;
	public void addProduct(ElectronicDeviceTemp device, int howMany)
	{
		products.put(howMany, device);
	}
	public Map<Integer,ElectronicDeviceTemp> getProducts()
	{
		return products;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Order() {
		//super();
		this.products = new HashMap<>();
	}
	public Order(String address, User owner) {
		this.id = 0;
		this.address = address;
		this.owner = owner;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.date = dtf.format(now);
		this.products = new HashMap<>();
	}
	
}
