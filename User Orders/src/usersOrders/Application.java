package usersOrders;

import java.util.ArrayList;
import logIn.Login;
import userAddress.Address;
import userInfo.Users;

public class Application {
	
	//List for Users, addresses, and orders
	public static ArrayList<Users> users = new ArrayList<Users>();
	public static ArrayList<Address> address = new ArrayList<Address>();
	public static ArrayList<Orders> orders = new ArrayList<Orders>();
	
	//the int for the current logged in user
	public static int currentuser;
	
	//Start the app at login
	public static void main(String[] args) {
		
		
		//add an admin to the lists
		Users admin = new Users(0, "admin", "null", "admin", "admin");
		Address adminAddress = new Address(0, "Kennebunk", "Maine", "123 Park St.", "01111");
		users.add(admin);
		address.add(adminAddress);
		
		//Start the login
		Login newlogin = new Login();
		newlogin.main(null);
	}
}
