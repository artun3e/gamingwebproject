package cs308.sabanciuniv.devices;


public class Laptop extends ElectronicDevice{
	private deviceTypes deviceType = deviceTypes.Laptop;
	private String CPU;
	private String GPU;
	private String RAM;
	private String Motherboard;
	private String MonitorResolution;
	private String MonitorWidth;
	private String OperatingSystem;
	
	public String getOperatingSystem() {
		return OperatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public String getGPU() {
		return GPU;
	}
	public void setGPU(String gPU) {
		GPU = gPU;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getMotherboard() {
		return Motherboard;
	}
	public void setMotherboard(String motherboard) {
		Motherboard = motherboard;
	}
	public String getMonitorResolution() {
		return MonitorResolution;
	}
	public void setMonitorResolution(String monitorResolution) {
		MonitorResolution = monitorResolution;
	}
	public String getMonitorWidth() {
		return MonitorWidth;
	}
	public void setMonitorWidth(String monitorWidth) {
		MonitorWidth = monitorWidth;
	}
	public deviceTypes getDeviceType() {
		return deviceType;
	}
	public Laptop(String name, int price, String manufacturer, String cPU, String  gPU,
			String rAM, String motherboard, String monitorResolution, String monitorWidth) {
		super(name, price, manufacturer);
		CPU = cPU;
		GPU = gPU;
		RAM = rAM;
		Motherboard = motherboard;
		MonitorResolution = monitorResolution;
		MonitorWidth = monitorWidth;
	}
	
	public Laptop(String name, int price, String manufacturer) {
		super(name, price, manufacturer);
		CPU = null;
		GPU = null;
		RAM = null;
		Motherboard = null;
		MonitorResolution = null;
		MonitorWidth = null;
	}
	@Override
	public String toString() {
		return "Laptop Name: " + this.getName() +  "\nManufactured by: " + this.getManufacturer() + "\nPrice: "  + this.getPrice() + "$"  + "\nSpecs:" + "\n\tCPU: "+ this.getCPU() +
				"\n\tGPU: " + this.getGPU() + "\n\tInstalled RAM: " + this.getRAM() + "\n\tOperating System: " + this.getOperatingSystem() + "\n\tMotherboard: " + this.getMotherboard() +
				"\n\tResolution: " + this.getMonitorResolution() + "\n\tMonitorWidth: " + this.getMonitorWidth();
	}
}
