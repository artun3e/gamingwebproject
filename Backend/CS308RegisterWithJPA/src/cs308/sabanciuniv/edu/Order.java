package cs308.sabanciuniv.edu;

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
	private User owner;
//<<<<<<< HEAD
	@ManyToMany(fetch = FetchType.EAGER)
	@MapKeyColumn(name="Quantity")
	Map<Integer, Games> products;
//=======
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Orders_Games", joinColumns =  @JoinColumn(name = "Order_id"))
	@MapKeyJoinColumn(name = "products_appid", unique = false)
	@Column(name = "Quantity")
	//Map<Games, Integer> products;
//>>>>>>> 22ad9288440c89a6dc9ace6e6bbeaf4843b3a17a
	public void addProduct(Games device, int howMany)
	{
		products.put(howMany, device);
	}
	public Map<Integer,Games> getProducts()
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
	public void setMap(Map<Integer,Games> hashmap)
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
