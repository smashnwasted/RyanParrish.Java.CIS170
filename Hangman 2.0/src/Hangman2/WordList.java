package Hangman2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class WordList {
	
    // Create a list of words
    public static LinkedList<String> getWordList() throws IOException{
    	File file = new File("\"wordList.txt\"");
    	BufferedReader in = new BufferedReader(new FileReader(file));
    	
    	String inputLine;
    	LinkedList<String> list = new LinkedList<String>();
    		
    	while ((inputLine = in.readLine()) !=null) {
    		list.add(inputLine);
    	}
    	in.close();
    	return list;   	
    }


}
