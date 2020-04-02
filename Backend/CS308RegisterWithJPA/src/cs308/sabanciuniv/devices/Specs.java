package cs308.sabanciuniv.devices;
// specs class is for phone,computer and tablet for now, we inherit the common attributes of specific Electronic devices
// from specs class
public interface Specs {
	public void setCPU(String CPU);
	public String getCPU();
	public void setRAM(String RAM);
	public String getRAM();
	public String getResolution();
	public void setResolution(String resolution);
	public String getScreenWidth();
	public void setScreenWidth(String screenWidth);
	public String getStorage();
	public void setStorage(String storage);
	public String getBattery();
	public void setBattery(String battery);
	public String getCamera();
	public void setCamera(String camera);
}
