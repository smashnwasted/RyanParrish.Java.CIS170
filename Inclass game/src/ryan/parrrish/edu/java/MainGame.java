package ryan.parrrish.edu.java;


//A generic container to hold any hangman game.
//Each instance will..
//Have a hint
//have a word
//have user guesses
//be able to generate a mask of the word based on user guesses.
public class MainGame {
	
	private String hint;
	private String word;
	private String guesses = "";
	
	//Arg Constructor
	public MainGame(String hint, String word) 
	{
		this.hint = hint;
		this.word = word;
	}
	
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getGuesses() {
		return guesses;
	}
	public void setGuesses(String guesses) {
		this.guesses += guesses;
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
