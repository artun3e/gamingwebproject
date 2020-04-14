package cs308.sabanciuniv.devices;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "ElectronicDevices")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ElectronicDevice {
	private String name;
	private int price;
	private String Manufacturer;
	enum deviceTypes { Laptop, Phone, Tablet, Headphone,Earphone, Keyboard, PC, Mouse, TV, PC_Parts, GameConsoles, Accessories, DEFAULT } //TODO add more devices here
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private deviceTypes Type = deviceTypes.DEFAULT;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public deviceTypes getType() {
		return Type;
	}
	public void setType(deviceTypes type) {
		Type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public ElectronicDevice(String name, int price, String manufacturer, deviceTypes type) {
		//super();
		this.id = 0;
		this.name = name;
		this.price = price;
		Manufacturer = manufacturer;
		Type = type;
	}
	
	public ElectronicDevice() {
		//super();
	}
	
	public ArrayList<ElectronicDevice> findByManufacturer(String manufacturerName)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs308");
		EntityManager em = emf.createEntityManager();
		try 
		{
			ArrayList<ElectronicDevice> deviceList = new ArrayList<ElectronicDevice>();
			for(Object o:em.createQuery("From ElectronicDevices WHERE Manufacturer LIKE :manufacturerName").setParameter("manufacturerName", manufacturerName).getResultList())
			{
				deviceList.add((ElectronicDevice)o);
			}
			return deviceList;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}	
	
	// WARNING!! I DON'T KNOW IF THE COLUM NAME IS NAME IN THE DATABASE, I JUST ASSUMED IT IS SINCE I DON'T HAVE THE DATABASE.
	
	
	@Override
	public abstract String toString();
	
}
