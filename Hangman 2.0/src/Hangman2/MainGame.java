package Hangman2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

//A generic container to hold any hangman game.
//Each instance will..
//have a list of words
//have a list user guesses
//be able to generate a mask of the word based on user guesses.
/*
 * 	
 *  
	//add the word too the gamelog
	bw.append(word);
	bw.newLine();
	//add guess list to the game log
	bw.append(guesses);
	bw.newLine();
	*/

public class MainGame {

	//Constructor for the main game
	public MainGame(String word) {
		this.word = word;
	}
	
	//List of words, and a string of that list
	public ArrayList<String> guesses = new ArrayList<String>();
	String playedguesses = guesses.toString();
	
	//String for the word, getters and setters
	public String word;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	//Generate a mask
    public String generateMask()
    {
    	String mask = "";
        //Make a mask
        for(int i = 0; i < word.length(); i++)
        {
            //Look at each char in word
            String currentChar = String.valueOf(word.charAt(i));
            //Determine if user guessed that char
            if(guesses.contains(currentChar))
            {
                //if they did, append append char
                mask += currentChar;
            }
            else
            {
                //if they did not, a *
                mask += "*";
            }
         
        }
        return mask;
    	}

    public boolean isSolved() {
    	if(guesses.contains(word)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
}
