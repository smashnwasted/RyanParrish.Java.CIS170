package Hangman2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random; 
import java.util.LinkedList;
import java.util.Scanner;
/*
            //Start the game process

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
    
    
    //Control flow of game
    public void playgame()
    {

    	WordList wordlist = WordList();
    	
    	
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("welcome to my game of hangman");
        
        //Pose the question if they want to play the game
        	//If yes
        		// Select a random word from the List of words
        		// Pass that word to Main Game
        
        
        
        

        for(int i = 0; i < newgame.getWord().length(); i++)
        {
            while(!newgame.isSolved())
            {

                //prompt the user
                System.out.println("Guess a letter");
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
