package Login;

import java.util.ArrayList;

import Trips.Trips;
import Trips.TripPlanner;

public class Application {
	
	//List for Users and Trips
	public static ArrayList<Users> users = new ArrayList<Users>();
	public static ArrayList<Trips> trips = new ArrayList<Trips>();
	public static ArrayList<Rangers> rangers = new ArrayList<Rangers>();
	
	//the int for the current logged in user
	public static int currentuser;
	
	//Start the app at login
	public static void main(String[] args) {
		
		
		//add an admin to the lists
		Users admin = new Users(0, "admin", "null", "admin", "admin", "800-111-2222");
		users.add(admin);
		Rangers r1 = new Rangers("Sargent", "John", "McNeil", "(207)-456-2342");
		Rangers r2 = new Rangers("Captain", "Danielle", "Dwarf", "(207)-456-2344");
		Rangers r3 = new Rangers("Lieutenant", "Mark", "Daniels", "(207)-456-2341");
		
		rangers.add(r1);
		rangers.add(r2);
		rangers.add(r3);

		//Start the login
		Login newlogin = new Login();
		newlogin.main(null);
	}
}
