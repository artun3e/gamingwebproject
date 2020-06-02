package cs308.sabanciuniv.edu;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Orders") 
public class Order {
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "Orders_Games_Prices", joinColumns =  @JoinColumn(name = "Order_id"))
	@MapKeyJoinColumn(unique = false)
	@Column(name = "Price")
	@Fetch(FetchMode.SELECT)
	private Map<Games, Double> pricesAtThatTime;
	public enum orderStatus {PreparingPackage,Shipped,OutOnDelivery,Delivered}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	//private Payment payment;
	private String date;
	@Column(name = "totalCost" ,columnDefinition = "double")
	private double totalCost;
	@Enumerated(EnumType.STRING)
	private orderStatus status;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "User_Email")
	private User owner;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "Orders_Games", joinColumns =  @JoinColumn(name = "Order_id"))
	@MapKeyJoinColumn(unique = false)
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
	public String  getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/*
	public Payment getPayment() {
		return this.payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}*/
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
	public Order(int id) {
		this.id = id;
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
		this.pricesAtThatTime = new HashMap<>();
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

	public orderStatus getStatus() {
		return status;
	}

	public void setStatus(orderStatus status) {
		this.status = status;
	}


	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setPricesAtThatTime(Map<Games,Double> pricesAtThatTime) {
		this.pricesAtThatTime = pricesAtThatTime;
	}

	public void setProducts(Map<Games, Integer> products) {
		this.products = products;
	}

	public Map<Games,Double> getPricesAtThatTime() {
		return pricesAtThatTime;
	}

	@Override
	public int hashCode() {
		return id;
	}

}
