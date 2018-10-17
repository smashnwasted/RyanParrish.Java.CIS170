package ryan.parrish.java.system;

public class Car {
	
	
	public Car(int mpg, int tankSize, int milesdriven) {
		
	}
	
	//miles the car has driven
	public int milesdriven;
	
	//int for Car number #
	public int carNumber;
	
	//int for top speed in miles per hour
	public int topSpeed;
	
	//int for tank size of car in gallons
	public int tankSize;
	
	//int for miles per gallon
	public int mpg;

	public int getCarNumber() {
		return carNumber;
	}



	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}



	public int getTopSpeed() {
		return topSpeed;
	}



	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}



	public int getTankSize() {
		return tankSize;
	}



	public void setTankSize(int tankSize) {
		this.tankSize = tankSize;
	}



	public int getMpg() {
		return mpg;
	}



	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

	
	public int getMilesdriven() {
		return milesdriven;
	}



	public void setMilesdriven(int milesdriven) {
		this.milesdriven = milesdriven;
	}



	public int getMilesTillnextPitStop(int mpg, int tankSize, int milesdriven) 
	{
		
		//Miles driven = mph * time
		
		//Miles per Gallon * the size of tank = the amount of miles the car is capable of driving with one tank.
		int totalmilesintank = mpg * tankSize;
		
		//total amount of miles the car car drive - the amount of miles the car has driven = amount of miles left.
		int milesleftintank = totalmilesintank - milesdriven;
		
		return milesleftintank;
		
	}

}
