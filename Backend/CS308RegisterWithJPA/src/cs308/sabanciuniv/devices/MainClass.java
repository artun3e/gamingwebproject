package cs308.sabanciuniv.devices;

import cs308.sabanciuniv.devices.ElectronicDevice.deviceTypes;

public class MainClass {

	public static void main(String[] args) {
		Laptop l1 = new Laptop("XPS 13", 5000, "DELL", deviceTypes.Laptop);
		Phone p1 = new Phone("OnePlus 5T", 3000, "Oneplus", deviceTypes.Phone, "2,45 GHz Quad Core + 1,9 GHz Quad Core", "6 GB", "1080 x 2160", "6,01", "64 GB", "3300 mAh", "16 MP + 20 MP");
		System.out.println(l1);
		/*#############################################################
		 * 															  *
		 *                                                            *
		 * 				DO THE DATA BASE TESTS BELOW                  *           
		 * 															  *
		 * 															  *
		 *############################################################# 															 */
		
		
		System.out.println("____________________Database tests below_________________");
		
		JPAManager.insertDeviceToDB(l1);
		JPAManager.insertDeviceToDB(p1);
		
	}

}
