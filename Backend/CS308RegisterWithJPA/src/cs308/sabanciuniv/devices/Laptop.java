package cs308.sabanciuniv.devices;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Laptop")
@DiscriminatorValue("Laptop")
public class Laptop extends ElectronicDevice implements Specs{
	private String CPU;
	private String GPU;
	private String RAM;
	private String motherboard;
	private String resolution;
	private String screenWidth;
	private String OperatingSystem;
	private String Camera;
	private String Battery;
	private String Storage;
	@Override
	public String getStorage() {
		return Storage;
	}
	@Override
	public void setStorage(String storage) {
		Storage = storage;
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
	public String getOperatingSystem() {
		return OperatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	@Override
	public void setCPU(String CPU)
	{
		this.CPU = CPU;
	}
	@Override
	public String getCPU() {
		return CPU;
	}
	public void setGPU(String gPU) {
		GPU = gPU;
	}
	public String getGPU() {
		return GPU;
	}
	@Override
	public String getRAM() {
		return RAM;
	}
	@Override
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getMotherboard() {
		return motherboard;
	}
	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
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

	public Laptop(String name, int price, String manufacturer, deviceTypes type, String cPU, String gPU, String rAM,
			String motherboard, String resolution, String screenWidth, String operatingSystem, String camera,
			String battery, String storage) {
		super(name, price, manufacturer, type);
		CPU = cPU;
		GPU = gPU;
		RAM = rAM;
		this.motherboard = motherboard;
		this.resolution = resolution;
		this.screenWidth = screenWidth;
		OperatingSystem = operatingSystem;
		Camera = camera;
		Battery = battery;
		this.Storage = storage;
	}
	
	
	public Laptop(String name, int price, String manufacturer, deviceTypes type) {
		super(name, price, manufacturer, type);
	}
	
	@Override
	public String toString() {
		return "Laptop Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"  + "\nSpecs:" + "\n\tCPU: "+ this.getCPU() +
				"\n\tGPU: " + this.getGPU() + "\n\tInstalled RAM: " + this.getRAM() + "\n\tOperating System: " + this.getOperatingSystem() + "\n\tMotherboard: " + this.getMotherboard() +
				"\n\tResolution: " + this.getResolution() + "\n\tMonitorWidth: " + this.getScreenWidth() + "\n\tBattery Capacity: " + this.getBattery() + "\n\tCamera: " + this.getCamera();
	}
}
