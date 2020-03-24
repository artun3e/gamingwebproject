package cs308.sabanciuniv.devices;

public class ElectronicDevice {
	public ElectronicDevice(String name, int price, String manufacturer) {
		//super();
		this.name = name;
		this.price = price;
		Manufacturer = manufacturer;
	}
	private String name;
	private int price;
	private String Manufacturer;
	enum deviceTypes { Laptop, Phone, Headphone, Earphone, PC, DEFAULT } //TODO add more devices here
	
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
}
