package Hangman2;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
            
				*/

public class Hangman {
	
	public void playgame(){

	    for (MainGame g: games) 
	    {
	    	Scanner sc = new Scanner(System.in);
	    	for(int i = 0; i < g.getWord().length(); i++)
	    	{
	    		while(!g.isSolved())
	    		{
	    			
	    			//prompt the user
	    			System.out.println("Guess a letter");
	    			//display current mask
	    			System.out.println("Mask" + g.generateMask());
	    			//collect user input
	    			String userguess = sc.nextLine();
	    			g.setGuesses(userguess);
	    		}
	    	}
	    	
	    }
	}

	//Main start
    public static void main(String[] args)
    {
    	//Initialize hangman
        Hangman hangman = new Hangman();
        
        //is the game running
        boolean gameisrunning = true;
		//welcome player
        System.out.println("welcome to my game of hangman")
		
        //while the game is running ask the player if they would like to play
        while(gameisrunning) 
		{
			//prompt user
			System.out.println("would you like to play a new game?");
			//ask for input
			char input = sc.nextLine().charAt(0);

			//if no then exit
			if (input == 'n')
			{
				System.out.println("Thank you for playing");
				System.out.println("Goodbye");
				gameisrunning = false;
			}
			
			//If yes then play a game
			else if(input == 'y')
			{
				//Make a list of words
				List<String> wordlist = new ArrayList<String>();
				WordList loadlist = new WordList();
			    
				
			    try {
					wordlist = new ArrayList<String>(loadlist.getWordList());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    Random random = new Random();
			    int ranInt = random.nextInt(wordlist.size());
				
			    
				MainGame game1 = new MainGame(wordlist.get(ranInt));
			    MainGame game2 = new MainGame(wordlist.get(ranInt));
			    MainGame game3 = new MainGame(wordlist.get(ranInt));
			    MainGame game4 = new MainGame(wordlist.get(ranInt));
			    MainGame game5 = new MainGame(wordlist.get(ranInt));
			    
				List<MainGame> games = new ArrayList<MainGame>();
				games.add(game1);
				games.add(game2);
				games.add(game3);
				games.add(game4);
				games.add(game5);
				
				//Start the game process
				hangman.playgame(); 
			}
		}
    }
}
