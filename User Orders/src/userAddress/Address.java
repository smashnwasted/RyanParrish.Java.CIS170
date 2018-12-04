package userAddress;

//Class for the Address
public class Address {
	
	public String state;
	public String city;
	public String street;
	public String zipCode;
	public int userId;
	
	//Constructor
	public Address(int userId, String state, String city, String street, String zipCode) 
	{
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.userId = userId;
	}
}