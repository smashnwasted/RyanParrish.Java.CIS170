package userInfo;

//Class for creating a user
public class Users {
	
	//Constructor for the user
	public Users(int userId, String fName, String lName, String eMail, String password) 
	{
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.eMail = eMail;
		this.password = password;
	}
	
	
	public int userId;
	public String fName;
	public String lName;
	public String eMail;
	public String password;
	
}
