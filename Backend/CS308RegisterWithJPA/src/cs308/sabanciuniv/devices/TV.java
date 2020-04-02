package cs308.sabanciuniv.devices;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "TV")
@DiscriminatorValue("TV")
public class TV extends ElectronicDevice {
	private int resolution;
	private int refreshRate;
	private double weight;
	private double width;
	private double Lenght;
	private double screenSize;
	private int totalHDMIPorts;
	public int getResolution() {
		return resolution;
	}
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	public int getRefreshRate() {
		return refreshRate;
	}
	public void setRefreshRate(int refreshRate) {
		this.refreshRate = refreshRate;
	}
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
	public double getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	public int getTotalHDMIPorts() {
		return totalHDMIPorts;
	}
	public void setTotalHDMIPorts(int totalHDMIPorts) {
		this.totalHDMIPorts = totalHDMIPorts;
	}
	public TV(String name, int price, String manufacturer, deviceTypes type, int resolution, int refreshRate,
			double weight, double width, double lenght, double screenSize, int totalHDMIPorts) {
		super(name, price, manufacturer, type);
		this.resolution = resolution;
		this.refreshRate = refreshRate;
		this.weight = weight;
		this.width = width;
		Lenght = lenght;
		this.screenSize = screenSize;
		this.totalHDMIPorts = totalHDMIPorts;
	}
	public TV(String name, int price, String manufacturer, deviceTypes type) {
		super(name, price, manufacturer, type);
	}
	public TV() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override 
	public String toString() {
		return "Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"
				+"\nResolution: " + this.getResolution() + "\nRefreshRate: " + this.getRefreshRate() 
				+"\nWeight: " + this.getWeight() + "\nWidth: " + this.getWeight() + "\nLenght: " + this.getLenght() +
				"\nScreenSize: " + this.getScreenSize() +"\nTotal HDMI Ports: " + this.getTotalHDMIPorts();
	}
}
