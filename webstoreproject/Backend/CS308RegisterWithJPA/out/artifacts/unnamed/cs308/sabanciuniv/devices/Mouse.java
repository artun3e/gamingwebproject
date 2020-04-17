package cs308.sabanciuniv.devices;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Mouse")
@DiscriminatorValue("Mouse")
public class Mouse extends ElectronicDevice{
	private boolean wireless;
	private int minDPI;
	private int maxDPI;
	private String battery; 
	private String colour;
	public boolean isWireless() {
		return wireless;
	}
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	public int getMinDPI() {
		return minDPI;
	}
	public void setMinDPI(int minDPI) {
		this.minDPI = minDPI;
	}
	public int getMaxDPI() {
		return maxDPI;
	}
	public void setMaxDPI(int maxDPI) {
		this.maxDPI = maxDPI;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
	public Mouse(String name, int price, String manufacturer, deviceTypes type, boolean wireless, int minDPI,
			int maxDPI, String battery, String colour) {
		super(name, price, manufacturer, type);
		this.wireless = wireless;
		this.minDPI = minDPI;
		this.maxDPI = maxDPI;
		this.battery = battery;
		this.colour = colour;
	}
	
	public Mouse(String name, int price, String manufacturer, deviceTypes type) {
		super(name, price, manufacturer, type);
	}
	
	public Mouse() {
		super();
	}
	@Override 
	public String toString() {
		return "Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"
				+"\nWireless: " + this.isWireless() + "\nminimum DPI: " + this.getMinDPI() + "\nMaximum DPI: " + this.getMaxDPI() +
				"\nBattery: " + this.getBattery() + "\nColour: " + this.getColour();
	}
}
