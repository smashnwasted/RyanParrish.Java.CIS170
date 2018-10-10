import java.util.Scanner;

public class MainGame {

    public static void main(String[] args)
    {
        //Add scanner
        Scanner scanner = new Scanner(System.in);


        //method to tell if the game is running
        boolean gameisRunning = true;
        //Array of words
        String[] wordbank = {"hangman"};
        //Changing the word into an array of char
        char[] selectedword = wordbank[0].toCharArray();
        //Changing the array into and intager
        int wordInt = selectedword.length;


        while (gameisRunning) {

            //Welcome the player
            System.out.println("Welcome to my game of Hangman");
            System.out.print("Would you like to play a game? (y/n):");

            char input = scanner.nextLine().charAt(0);

            //Ask to play the game
            //if 'n' then end
            if (input == 'n') {
                System.out.println("Thanks for Playing");
                gameisRunning = false;
            }

            //discount invalid entry's to this question.
            else if (input != 'y')
            {
                System.out.println("That is not a valid entry");
                gameisRunning = true;
            }
            //Else start the guessing game
            else if (input == 'y')
            {

                //Setting number of Tries
                int numberofTries = wordInt + 2;

                int tries = 0;

                //Array to store the players guesses
                char[] playerGuesses = new char[selectedword.length];

                //Boolean for is the word still masked
                boolean isWordGuessed = false;

                //mask for the word
                for (int i = 0; i < playerGuesses.length; i++)
                {
                    playerGuesses[i] = '*';
                }


                //Maine guessing loop
                while (!isWordGuessed && tries != numberofTries)
                {

                    System.out.print("Current guesses:");
                    printArray(playerGuesses);

                    //Print Tries left
                    System.out.printf("you have %d tries left.\n", numberofTries - tries);
                    System.out.print("Enter a new Single Character guess:");
                    char Guessinginput = scanner.nextLine().charAt(0);
                    tries++;
                    
                    //If the word is masked, start guessing game
                    if (Guessinginput == '*')
                    {
                        gameisRunning = false;
                        isWordGuessed = true;
                    }
                    //
                    else
                        {
                        for (int i = 0; i < selectedword.length; i++)
                            {
                            if (selectedword[i] == Guessinginput)
                                {
                                playerGuesses[i] = Guessinginput;
                                }
                            }
                            if (wordMatchesGuess(playerGuesses))
                            {
                                isWordGuessed = true;
                                System.out.println("Congratulations you have Won!");
                                gameisRunning = true;
                            }
                        }

                    }

                //As the guessing game ends, if the user ran out of guesses, Game over, ask if they want to play again.
                if (!isWordGuessed)
                {
                    System.out.println("you ran out of guesses");
                    System.out.println("Game Over");
                    gameisRunning = true;
                }

            }

        }

    }
    public static boolean wordMatchesGuess(char[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == '*')
            {
                return false;
            }
        }
        return true;
    }

    //Method for printing and array of the players guesses
    public static void printArray(char[] array)
        {
            for (int i = 0; i < array.length; i++)
                {
                    System.out.print(array[i] + "");
                }
            System.out.println();
        }
}

