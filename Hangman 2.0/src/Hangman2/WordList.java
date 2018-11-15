package Hangman2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class WordList {
	
    // Create a list of words
    public LinkedList<String> getWordList() throws IOException{
    	File file = new File("C:\\Users\\sryanparrish\\cis170-2018\\RyanParrish.Java.CIS170\\Hangman 2.0\\wordList.txt");
    	//System.out.println(file.exists());
    	
    	LinkedList<String> list = new LinkedList<String>();
    	if (file.exists()) 
    	{
    		BufferedReader in = new BufferedReader(new FileReader(file));
        	
        	String inputLine;
        	
        		
        	while ((inputLine = in.readLine()) !=null) {
        		list.add(inputLine);
        	}
    	}
		return list;
		
}
}
