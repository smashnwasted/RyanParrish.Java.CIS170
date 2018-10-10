package ryan.parrrish.edu.java;

import java.util.Scanner;

/*			//Start the game process
			
			boolean gameisrunning = true;
			
			while(gameisrunning) {
				
				System.out.println("would you like to play a new game?");
				char input = sc.nextLine().charAt(0);
				

				if (input == 'n') 
				{
					System.out.println("Thank you for playing");
					System.out.println("Goodbye");
					gameisrunning = false;	
				}
				
				else if(input != 'y')
				{
					System.out.println("please use a valid entry");
					gameisrunning = true;
				}
				
				else if(input == 'y') 
				{
				}
				*/





public class Hangman {

	MainGame newgame = new MainGame();
	
	//Array of newGames to play
	MainGame[] newgameArray = {new MainGame("Meow", "Cat"), new MainGame("Woof", "Dog")};
	
	//Control flow of game
	public void playgame() 
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("welcome to my game of hangman");
		
		for(int i = 0; i < newgameArray.length; i++) 
		{
			while(!newgame.isSolved())
			{
				
				//prompt the user
				System.out.println("Guess a letter");
				System.out.println("Hint: " + newgame.getHint());
				//display current mask
				System.out.println("Mask" + newgame.generateMask());
				//collect user input
				String userguess = sc.nextLine();
				newgame.setGuesses(userguess);
			}
		
				
		}
			
	}
		
	
	//Main start
	public static void main(String[] args)
	{
		Hangman hangman = new Hangman();
		hangman.playgame();
	}
	
	
}
