package cs308.sabanciuniv.edu;

import javax.persistence.*;

@Entity
public class Admin extends User  {
	
	/*
	 * TODO : add properties of admin class
	 */
	
	// also add the attributes of the admin class in another constructor
	//Constructor
	public Admin(String name, String email, String password){
		super(name,email,password);
		
	}
	
	//Constructor with admin specs goes below
	

}
