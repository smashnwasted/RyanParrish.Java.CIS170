package Hangman3;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


public class Hangman {
	
	public static void main(String[] args) {

		MainGame g1 = new MainGame("Chair", "We sit on a ...");
		MainGame g2 = new MainGame("Wheels", "Mans second great invention");
		MainGame g3 = new MainGame("Guitar", "A common musical instrument");
		MainGame g4 = new MainGame("England", "A major nation steeped in History with the USA");
		MainGame g5 = new MainGame("Pencil", "A common writing Utensil");
		
		
		
		List<MainGame> games = new ArrayList<MainGame>();
		games.add(g1);
		games.add(g2);
		games.add(g3);
		games.add(g4);
		games.add(g5);
	
		for (MainGame g : games) {

			while (!g.isSolved) {

				boolean gameisRunning = true;
				System.out.println("Would you like to play a game? y/n");
				Scanner sc = new Scanner(System.in);
				char input = sc.nextLine().charAt(0);
				
				
				if (input == 'n') {
					gameisRunning = false;
					System.out.println("Goodbye!");
				}
				
				else if (input != 'n') {
					System.out.println("Please enter a valid answer");
				}
				
				else if (input == 'y') {
					gameisRunning = true;
					System.out.println("Welcome to Hangman!");
				}
				while (gameisRunning) {
				
							boolean areWePlaying = true;
							while (areWePlaying) {
								String word = g.word;
								String hint = g.hint;
								char[] guessingword = word.toLowerCase().toCharArray();
								int amountOfGuesses = guessingword.length + 2;
								char[] playerGuesses = new char[amountOfGuesses];
								for (int i = 0; i < playerGuesses.length; i++) {
									playerGuesses[i] = '*';
								}
								
								boolean wordIsGuessed = false;
								int tries = 0;
								while (!wordIsGuessed && tries != amountOfGuesses) {
									System.out.println("Current guesses: ");
									System.out.println(playerGuesses);
									System.out.printf("You have %d tries left. Enter '?' for hint or '-'to exit",
											amountOfGuesses - tries);
									System.out.println(" ");
									System.out.println("Please guess another letter");
									char input2 = sc.nextLine().charAt(0);
									tries++;
								
									for (int i = 0; i < guessingword.length; i++) {
										if (guessingword[i] == input2) {
											playerGuesses[i] = input2;
										}
									}

									if (isTheWordGuessed(playerGuesses)) {

											wordIsGuessed = true;

											areWePlaying = true;

											g.isSolved = true;

											System.out.println("YOU WIN! Would you like to play again?");

										}
									}

								if (tries == amountOfGuesses && wordIsGuessed == false) {
									System.out.println("GAME OVER");
									System.out.println("You have ran out of guesses");
									System.out.println("Would you like to play again? y/n");
									wordIsGuessed = false;
									areWePlaying = false;
									gameisRunning = false;
									g.isSolved = false;
									char anotherGame = sc.nextLine().charAt(0);
									if (anotherGame == 'n') {
										gameisRunning = false;
										areWePlaying = false;
										g.isSolved = false;
									}
									if (anotherGame == ' ')
									{
										gameisRunning = false;
										areWePlaying = false;
									}
									else if (anotherGame == 'y')
									{
							
									}

							}

							}

				}

			}

		}

				}


			public static boolean isTheWordGuessed(char[] array) {
				for (int i = 0; i < array.length; i++) {
					if (array[i] == '*')
						return false;
				}
				return true;
			}

		}
