package cs308.sabanciuniv.devices;

import javax.persistence.DiscriminatorValue;

@Entity(name = "Tablet")
@DiscriminatorValue("Tablet")
public class Tablet extends ElectronicDevice implements Specs // means we inherit from specs class
{
	// specifications of Tablet Class
	private String CPU;
	private String RAM;
	private String resolution;
	private String screenWidth;
	private String Camera;
	private String Battery;
	private String Storage;
	
	//functions 
	@Override
	public String getCPU() {
		return CPU;
	}
	@Override
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	@Override
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	@Override
	public String getResolution() {
		return resolution;
	}
	@Override
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	@Override
	public String getScreenWidth() {
		return screenWidth;
	}
	@Override
	public void setScreenWidth(String screenWidth) {
		this.screenWidth = screenWidth;
	}
	@Override
	public String getCamera() {
		return Camera;
	}
	@Override
	public void setCamera(String camera) {
		Camera = camera;
	}
	@Override
	public String getBattery() {
		return Battery;
	}
	@Override
	public void setBattery(String battery) {
		Battery = battery;
	}
	@Override
	public String getStorage() {
		return Storage;
	}
	@Override
	public void setStorage(String storage) {
		Storage = storage;
	}
	
	// constructor for Tablet Class
	public Tablet(String name, int price, String manufacturer, deviceTypes type, String cPU, String rAM,
			String resolution, String screenWidth, String Storage, String Battery, String Camera) {
	super(name, price, manufacturer, type);
	CPU = cPU;
	RAM = rAM;
	this.resolution = resolution;
	this.screenWidth = screenWidth;
	this.Storage = Storage;
	this.Battery = Battery;
	this.Camera = Camera;
	}
	
	public Tablet(String name,int price,String manufacturer, deviceTypes type){
		super(name, price, manufacturer, type);
	}
	
	@Override
	public String toString() {
		return "Tablet Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"  + "\nSpecs:" + "\n\tCPU: "+ this.getCPU() +
				 "\n\tResolution: " + this.getResolution() + "\n\tScreen Width: " + this.getScreenWidth() + "\n\tBattery Capacity: " + this.getBattery() +
				"\n\tCamera: " + this.getCamera() + "\n\tStorage: " + this.getStorage();
	}
	
	
	
	
	
	
	
	
}