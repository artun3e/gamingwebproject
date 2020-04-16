package cs308.sabanciuniv.devices;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Keyboard")
@DiscriminatorValue("Keyboard")
public class Keyboard extends ElectronicDevice {
	private double weight;
	private double width;
	private double Lenght;
	private String colour;
	boolean wireless;
	//super(name, price, manufacturer, type);

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


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public boolean isWireless() {
		return wireless;
	}


	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}


	public Keyboard() {
		super();
	}

	public Keyboard(String name, int price, String manufacturer, deviceTypes type, double weight, double width,
			double lenght, String colour, boolean wireless) {
		super(name, price, manufacturer, type);
		this.weight = weight;
		this.width = width;
		Lenght = lenght;
		this.colour = colour;
		this.wireless = wireless;
	}

	public Keyboard(String name, int price, String manufacturer, deviceTypes type) {
		super(name, price, manufacturer, type);
	}

	@Override 
	public String toString() {
		return "Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"
				+"\nWeight: " + this.getWeight() + "\nWidth: " + this.getWeight() + "\nLenght: " + this.getLenght() +
				"\nColour: " + this.getColour();
	}
	 // TODO json instead of toString for compatabilty with front end
	 
}
	


