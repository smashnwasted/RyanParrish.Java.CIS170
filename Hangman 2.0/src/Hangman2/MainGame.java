package Hangman2;

import java.util.LinkedList;

//A generic container to hold any hangman game.
//Each instance will..
//Have a hint
//have a word
//have user guesses
//be able to generate a mask of the word based on user guesses.

public class MainGame {

    private String word;
    
    //CHange to a list
    private static LinkedList<String> guesses = new LinkedList<String>();

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public boolean isSolved() {

        //determine if solved.
        return generateMask().equals(word);
    }

    public String generateMask()
    {

        //Make a mask
        String mask = "";

        //Loop over word
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
}
