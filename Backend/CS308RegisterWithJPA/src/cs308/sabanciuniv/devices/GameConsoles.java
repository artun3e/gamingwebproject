package cs308.sabanciuniv.devices;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "GameConsoles")
@DiscriminatorValue("GameConsoles")
public class GameConsoles extends ElectronicDevice {
	private double weight;
	private double width;
	private double Lenght;
	private String battery;
	private String Colour;
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLenght() {
		return Lenght;
	}
	public void setLenght(double lenght) {
		Lenght = lenght;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String batteries) {
		this.battery = batteries;
	}
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}
	public GameConsoles(String name, int price, String manufacturer, deviceTypes type, double weight, double width,
			double lenght, String batteries, String colour) {
		super(name, price, manufacturer, type);
		this.weight = weight;
		this.width = width;
		Lenght = lenght;
		this.battery = batteries;
		Colour = colour;
	}
	public GameConsoles(String name, int price, String manufacturer, deviceTypes type) {
		super(name, price, manufacturer, type);
	}
	public GameConsoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public String toString() {
		return "Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"+
				"\nWeight: " +  this.getLenght() + "\nWidth: "+ "\nLenght: " +this.getLenght() +
				"\nBattery: " + this.getBattery() + "\nColour: " + this.getColour();
	}
	
}
