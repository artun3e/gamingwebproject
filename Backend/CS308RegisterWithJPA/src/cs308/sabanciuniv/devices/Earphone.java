package cs308.sabanciuniv.devices;

import javax.persistence.DiscriminatorValue;

@Entity(name = "Earphone")
@DiscriminatorValue("Earphone")

public class Earphone extends ElectronicDevice implements AudioSpecs{
	
	private String Battery;
	private String Fit;
	private String WaterResistance;
	private String Microphone;
	private String Bluetooth;
	
	@Override
	public void setBattery(String Battery) {
		this.Battery = Battery;
	}
	
	@Override
	public String getBattery() {
		return this.Battery;
	}
	
	@Override 
	public void setFit(String Fit) {
		this.Fit = Fit;
	}
	
	@Override
	public String getFit() {
		return this.Fit;
	}
	
	@Override
	public void setWaterResistance(String  WaterResistance) {
		this.WaterResistance = WaterResistance;
	} 
	
	@Override
	public String getWaterResistance() {
		return this.WaterResistance;
	}
	
	@Override
	public void setMicrophone(String Microphone) {
		this.Microphone = Microphone;
	}
	
	@Override
	public String getMicrophone(){
		return this.Microphone;
	}
	
	@Override 
	public void setBluetooth(String Bluetooth){
		this.Bluetooth = Bluetooth;
	}
	
	@Override
	public string getBluetooth(){
		return this.Bluetooth;
	}
	
	//Constructor
	public Earphone(String name, int price, String manufacturer, deviceTypes type, String Battery, String Fit,
			String WaterResistance, String Microphone, String Bluetooth) {
		super(name, price, manufacturer, type);
		this.Battery = Battery;
		this.Fit = Fit;
		this.WaterResistance = WaterResistance;
		this.Microphone = Microphone;
		this.Bluetooth = Bluetooth;
	}
	
	//Constructor
	public Earphone(String name, int price, String manufacturer, deviceTypes type) {
		super(name, price, manufacturer, type);
		
	@Override
	public String toString() {
		return "Earphone Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"  + "\nSpecs:" + "\n\tBattery Capacity: "+ this.getBattery() +
				 "\n\tFit: " + this.getFit() + "\n\tWater Resistance: " + this.getWaterResistance() + "\n\tMicrophone: " + this.getMicrophone() +
				"\n\tBluetooth: " + this.getBluetooth() ;
	}
	
	
	/*TODO
	 * beyler yeni spec ler ekleyebiliriz  classlara ben en temel ozellikleri ekledim,buradan devam edersiniz.
	 */
	
	
	
}