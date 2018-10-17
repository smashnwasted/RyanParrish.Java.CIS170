package ryan.parrish.java.system;

public class App {

	public static void main(String[] args) {
		
		Car car1 = new Car(12, 32, 30);
		
		//int mpg, int tankSize, int milesdriven
		System.out.println(car1.getMilesTillnextPitStop(car1.mpg, car1.tankSize, car1.milesdriven));

		
	}
	

}
