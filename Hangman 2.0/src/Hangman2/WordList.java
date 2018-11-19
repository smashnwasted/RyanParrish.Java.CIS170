package Hangman2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//a Class to read a list of words and store them in a list

public class WordList {
	
	
	public ArrayList<String> wordBank = new ArrayList<String>();
	{
		try (BufferedReader br = new BufferedReader(new FileReader("wordlist.txt")))
		{
			String currentLine;
			while ((currentLine = br.readLine()) !=null) 
			{
				wordBank.add(currentLine);
			}
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}
	}
}
