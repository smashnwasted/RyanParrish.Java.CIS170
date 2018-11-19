package Hangman2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
*/

public class Hangman {
		
    //is the game running
	public static boolean gameisrunning = true;
	
	//Create game log
	public static File file = new File("gamelog.txt");
	
	//list of games
	public static ArrayList<String> games = new ArrayList<String>();
	
	
	public void playgame(String wordselect) throws IOException 
	{
		//Start the game to running
		boolean  gameisrunning = true;
		
		//Add a new game
	    MainGame newgame = new MainGame(wordselect);
	    //Add the word to the game log
	    games.add(wordselect);
	    //Start the scanner for input
		Scanner guess = new Scanner(System.in);
		//amount of guesses
		int amountofguesses = newgame.getWord().length() + 2;
		
		//for the length of the amount of guesses
		for(int i = 0; i < amountofguesses; i++)
		{	
			//if the amount of guesses is less than the amount of player guesses and the game is not solved
				while(gameisrunning)
				{						
					//If the amount of guesses is not = to 0 and the word is not solved ask for input 
					if (amountofguesses != 0 && !newgame.isSolved()) 
					{
						//prompt the user
						System.out.println("Current Mask " + newgame.generateMask());
						System.out.println("Please Guess a letter");
						System.out.printf("You have %d amount of guesses left", amountofguesses);
						//collect user input
						String userguess = guess.nextLine();
						//add the input to the guesses list
						newgame.guesses.add(userguess);
						//subtract 1 from the guesses list
						amountofguesses--;
					}
					//Else if the word is solved
					else if (newgame.isSolved()) 
					{
						//print the the word and announce the win
						System.out.println(newgame.getWord().toUpperCase());
						System.out.println("Congradulations you have won!");
						
						//stop the game from running
						gameisrunning = false;
					}
					
					//else if the game is not solved and the user runs out of guesses
					else if(!newgame.isSolved() && amountofguesses == 0) 
					{
						//print the word and announce the lose
						System.out.println("The word was:" + newgame.getWord().toUpperCase());
						System.out.println("you have run out of guesses");
						System.out.println("Game Over");  
						gameisrunning = false;
						
					}

				}
				games.addAll(newgame.guesses);
            	String gamestolog = games.toString();
            	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            	bw.write(gamestolog);
            	bw.close();
		}
		//Close the user input
	}
	
	
	
	//Main start
    public static void main(String[] args) throws IOException
    {	
    	
    	Scanner kp = new Scanner(System.in);
    	boolean keepplaying = true;
    	
    	while(keepplaying == true) 
    	{
    		
    		System.out.println("Would you like to play?");
    		String playAgame = kp.nextLine();
    		char pg = playAgame.charAt(0);
    		
    		try 
    		{
        		if (pg == 'y') 
        		{   
        			//Initialize random, and word list
        			Random random = new Random();
        			//get the word list
        			WordList getlist = new WordList();
        			//get random number bound in word list
        			int randInt = random.nextInt(getlist.wordBank.size());
        			//pick a random word within that list
        			String wordselect = getlist.wordBank.get(randInt).toLowerCase();
        		
        		    //Initialize hangman
                    Hangman hangman = new Hangman();
            		//Start the game process
                    hangman.playgame(wordselect);
        		}
        		
            	else if(pg == 'n')
            	{
            		keepplaying = false;
            		System.out.println("Goodbye");
            		
            	}
    		}
    		catch (Exception e)
    		{
    			System.out.println("Error");
    		}
    		
    	}
    }

}
