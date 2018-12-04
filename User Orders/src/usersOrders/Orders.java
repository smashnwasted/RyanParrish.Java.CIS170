package usersOrders;

public class Orders {
	
	//Bolt Prices
	public float bolt18 = (float) .18;
	public float bolt14 = (float) .20;
	public float bolt38 = (float) .24;
	public float bolt12 = (float) .30;
	
	//Bolt Quantities
	public int bolt18quantity;
	public int bolt14quantity;
	public int bolt38quantity;
	public int bolt12quantity;
	
	//Subtotal
	public float combinedprice;
	//Shipping
	public float shipping = (float) 20.00;
	//Total
	public float total;
	//userID
	public int userId;
	
	//setters and getters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBolt18quantity() {
		return bolt18quantity;
	}
	public void setBolt18quantity(int bolt18quantity) {
		this.bolt18quantity = bolt18quantity;
	}
	public int getBolt14quantity() {
		return bolt14quantity;
	}
	public void setBolt14quantity(int bolt14quantity) {
		this.bolt14quantity = bolt14quantity;
	}
	public int getBolt38quantity() {
		return bolt38quantity;
	}
	public void setBolt38quantity(int bolt38quantity) {
		this.bolt38quantity = bolt38quantity;
	}
	public int getBolt12quantity() {
		return bolt12quantity;
	}
	public void setBolt12quantity(int bolt12quantity) {
		this.bolt12quantity = bolt12quantity;
	}
	public float getCombinedprice() {
		return combinedprice;
	}
	public void setCombinedprice(float combinedprice) {
		this.combinedprice = combinedprice;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	

}
