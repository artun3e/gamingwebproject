package cs308.sabanciuniv.edu;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="Orders") 
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	private String date;
	@ManyToOne
	@JoinColumn(name = "User_Email")
	private User owner;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Orders_Games", joinColumns =  @JoinColumn(name = "Order_id"))
	@MapKeyJoinColumn(name = "appid", unique = false)
	@Column(name = "Quantity")
	@Fetch(FetchMode.SELECT)
	Map<Games, Integer> products;
	public void addProduct(Games device, int howMany)
	{
		products.put(device, howMany);
	}
	public Map<Games,Integer> getProducts()
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
	public Order(String address, User owner){
		this.id = 0;
		this.owner = owner;
		this.address = address;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.date = dtf.format(now);
		this.products = new HashMap<>();
	}
	public void setMap(Map<Games,Integer> hashmap)
	{
		this.products = hashmap;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", address='" + address + '\'' +
				", date='" + date + '\'' +
				", owner=" + owner.getName() +
				'}';
	}
	@Override
	public boolean equals(Object o)
	{
		Order temp = (Order)o;
		if(this.id == temp.getId())
		{
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
