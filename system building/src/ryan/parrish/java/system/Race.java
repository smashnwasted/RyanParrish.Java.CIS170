package ryan.parrish.java.system;

public class Race {
	
	
	Track track = new Track();
	
	public Race(int winner, int numberoflaps) 
	{
		
	}
	
	
	//String for winner
	public int winner;
	
	//integer for start time
	private int startTime;
	
	//integer for end time
	private int finishTime;
	
	//integer for number of laps
	public int numberoflaps;
	
	//the distance of the track * number of laps
	public int totalracedistance = numberoflaps * track.distance;
	
	boolean isRaceFinished = false;
	
	
	//how does a race progress, while race is going cars gain miles, and lose gas. 
	/*while(!isRaceFinished)
	{
		
		//cars race till one car wins. 
		//cars lose gas
		
		//cars cover distance
		for (int i = 0; i != totalracedistance; i++) {
			//this is where we add distance to the cars 
		}
	}*/
	
}
