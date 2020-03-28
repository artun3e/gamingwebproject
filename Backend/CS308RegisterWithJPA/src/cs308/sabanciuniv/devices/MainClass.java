package cs308.sabanciuniv.devices;

import cs308.sabanciuniv.devices.ElectronicDevice.deviceTypes;

public class MainClass {

	public static void main(String[] args) {
		Laptop l1 = new Laptop("XPS 13", 5000, "DELL", deviceTypes.Laptop);
		//ElectronicDevice e1 = new ElectronicDevice("TestElectronic", 300, "Tester", deviceTypes.DEFAULT);
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
	}

}
