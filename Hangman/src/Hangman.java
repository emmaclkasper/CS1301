
/*
 * Hangman.java
 * Author: Emma Kasper
 * Submission Date: 20 October 2017 *
 * Purpose: A brief paragraph description of the
 * Program. Takes letters and indexes from user to complete a game of hangman
 * Statement of Academic Honesty: *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. */
import java.util.Scanner;

public class Hangman {
	private static final boolean test = true;

	public static void main(String[] args) {

		// declaring variables
		Scanner input = new Scanner(System.in);
		String replay = "", difficulty, userSpaces = "", userGuessS = "", solve = "";
		String secretWord, dashWord;

		int totalGames = 20, numGuesses = 0, wordLength = 0;
		int spaceOne = -20, spaceTwo = -20, spaceThree = -20, spaceFour = -20;

		boolean replayGame = true;
		boolean correctGuess = false, checkAgain = false;
		boolean validDifficulty = true, validSpace = true, isLetter = true;
		boolean easy = false, intermediate = false, hard = false;
		char charIndex = ' ', userGuess = ' ';

		// loop repeats until 20 games are played, or the player chooses not to play
		// another game
		while (totalGames != 0 && replayGame == true) {
			// determines validity of the difficulty chosen
			while (validDifficulty == true) {

				System.out.println("Enter your difficulty: Easy(e), Intermediate (i),or Hard (h)");

				difficulty = input.nextLine().trim();
				char level = difficulty.toLowerCase().charAt(0);

				if (level == 'e')// easy
				{
					numGuesses = 15;
					validDifficulty = false;
					easy = true;
					System.out.println("You can guess up to 4 spaces");
					System.out.println();

				} else if (level == 'i') // intermediate
				{
					numGuesses = 12;
					validDifficulty = false;
					intermediate = true;
					System.out.println("You can guess up to 3 spaces");
					System.out.println();

				} else if (level == 'h')// hard
				{
					numGuesses = 10;
					validDifficulty = false;
					hard = true;
					System.out.println("You can guess up to 2 spaces");
					System.out.println();

				} else

					System.out.println("Invalid difficulty. Try again...");

			}
			validDifficulty = true;

			secretWord = RandomWord.newWord(); // pulls a random word from the random class
			wordLength = secretWord.length();
			dashWord = "";

			// replaces the secret word with dashes and prints
			for (int i = secretWord.length(); i > 0; i--)

			{
				dashWord = dashWord + "-";
			}

			System.out.println("The secret word is: " + secretWord);
			System.out.println("The word is: " + dashWord);

			// loop runs until the word is guessed correctly or the user runs out of guesses
			while (numGuesses != 0) {

				// gathering user input
				do {
					System.out.print("Please enter the letter you want to guess: ");
					userGuessS = input.next();
					userGuess = userGuessS.charAt(0);
					isLetter = Character.isLetter(userGuess); // checks validity of the guess to make sure it's a letter
					if (isLetter == false) {
						System.out.println("Your input is not valid. Try Again.");
						System.out.println("Guesses Remaining: " + numGuesses);
					}

					// allows the user to solve the word
					if (userGuessS.equalsIgnoreCase("solve")) {

						System.out.print("Please solve the answer: ");
						input.nextLine();
						solve = input.nextLine();

						if (solve.equalsIgnoreCase(secretWord)) {
							System.out.println("You win!");
							System.out.println("You have guessed the word! Congratulations");
							System.out.println("Would you like to play again? Yes(y) or No(n)");
							replay = input.nextLine();

							if (replay.equalsIgnoreCase("y")) {
								replayGame = true;
								continue;
							}

							else if (replay.equalsIgnoreCase("n")) {
								replayGame = false;
								System.exit(0);
							}

						}

						else

						{
							System.out.println("That is not the secret word.");
							numGuesses--;
							System.out.println("Guesses Remaining: " + numGuesses);
							isLetter = false;
						}
					}
				} while (isLetter == false);

				outerloop: {

					// gathering user input for spaces to check
					System.out.println("Please enter the spaces you want to check (separated by spaces): ");
					input.nextLine();

					if (easy) {
						userSpaces = input.nextLine().trim();
						int length = userSpaces.length();

						// asks for another guess if the input is not 7
						if (length != 7) {
							System.out.println("Your input is invalid. Try Again");
							System.out.println("Guesses Remaining: " + numGuesses);
							break outerloop;
						} else if (length == 7) {

						}
						// checks to make sure there are numbers separated by whitespace
						for (int i = 0; i <= 6; i += 2) {
							charIndex = userSpaces.charAt(i);
							if (Character.isDigit(charIndex)) {
								// check invalid space
								validSpace = true;
							}
						}

						if (validSpace == false) {
							System.out.println("Your input is invalid. Try Again");
							System.out.println("Guesses Remaining: " + numGuesses);

							continue;
						}

						// stores each numeric value of the character at each space
						else {
							for (int j = 0; j < 4; j++) {
								switch (j) {
								case 0:
									spaceOne = Character.getNumericValue(userSpaces.charAt(0));
									break;
								case 1:
									spaceTwo = Character.getNumericValue(userSpaces.charAt(2));
									break;
								case 2:
									spaceThree = Character.getNumericValue(userSpaces.charAt(4));
									break;
								case 3:
									spaceFour = Character.getNumericValue(userSpaces.charAt(6));
								}
							}

							// checks space one against the guess
							if (userGuess == secretWord.charAt(spaceOne))
								if (spaceOne == 0)

								{
									checkAgain = Character.isLetter(dashWord.charAt(spaceOne));
									dashWord = userGuess + dashWord.substring(1, dashWord.length());

									correctGuess = true;
									wordLength--;
									if (checkAgain) // determines if letter is entered twice
										wordLength++;
								} else {

									checkAgain = Character.isLetter(dashWord.charAt(spaceOne));
									dashWord = dashWord.substring(0, spaceOne) + userGuess
											+ dashWord.substring(spaceOne + 1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)// determines if letter is entered twice
										wordLength++;
								}

							// checks space two against the guess
							if (userGuess == secretWord.charAt(spaceTwo))
								if (spaceTwo == 0) {
									checkAgain = Character.isLetter(dashWord.charAt(spaceTwo));
									dashWord = userGuess + dashWord.substring(1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								} else {
									checkAgain = Character.isLetter(dashWord.charAt(spaceTwo));
									dashWord = dashWord.substring(0, spaceTwo) + userGuess
											+ dashWord.substring(spaceTwo + 1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								}

							// checks space three against the guess
							if (userGuess == secretWord.charAt(spaceThree))
								if (spaceThree == 0) {
									checkAgain = Character.isLetter(dashWord.charAt(spaceThree));
									dashWord = userGuess + dashWord.substring(1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								} else {
									checkAgain = Character.isLetter(dashWord.charAt(spaceThree));
									dashWord = dashWord.substring(0, spaceThree) + userGuess
											+ dashWord.substring(spaceThree + 1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								}
						}
						// checks space four against the guess
						if (userGuess == secretWord.charAt(spaceFour))
							if (spaceFour == 0) {
								checkAgain = Character.isLetter(dashWord.charAt(spaceFour));
								dashWord = userGuess + dashWord.substring(1, dashWord.length());
								correctGuess = true;
								wordLength--;
								if (checkAgain)
									wordLength++;
							} else {
								checkAgain = Character.isLetter(dashWord.charAt(spaceFour));
								dashWord = dashWord.substring(0, spaceFour) + userGuess
										+ dashWord.substring(spaceFour + 1, dashWord.length());
								correctGuess = true;
								wordLength--;
								if (checkAgain)
									wordLength++;
							}

					}

					// intermediate
					else if (intermediate) {
						userSpaces = input.nextLine().trim();
						int length = userSpaces.length();

						// asks for another guess if the input is not 5

						if (length != 5) {
							System.out.println("Your input is invalid. Try Again");
							System.out.println("Guesses Remaining: " + numGuesses);
							break outerloop;
						} else if (length == 5) {

						}

						// checks to make sure there are numbers separated by whitespace
						for (int i = 0; i <= 4; i += 2) {
							charIndex = userSpaces.charAt(i);
							if (Character.isDigit(charIndex)) {
								// check invalid space
								validSpace = true;
							}
						}

						if (validSpace == false) {
							System.out.println("Your input is invalid. Try Again");
							System.out.println("Guesses Remaining: " + numGuesses);

							continue;
						}

						else {
							for (int i = 0; i < 3; i++)// 3 cases for intermediate selection so check 4 spaces
							{
								switch (i) {
								case 0:
									spaceOne = Character.getNumericValue(userSpaces.charAt(0));
									break;

								case 1:
									spaceTwo = Character.getNumericValue(userSpaces.charAt(2));
									break;

								case 2:
									spaceThree = Character.getNumericValue(userSpaces.charAt(4));
									break;

								}
							}

							// checks space one against the guess
							if (userGuess == secretWord.charAt(spaceOne))
								if (spaceOne == 0) {
									checkAgain = Character.isLetter(dashWord.charAt(spaceOne));
									dashWord = userGuess + dashWord.substring(1, dashWord.length());
									correctGuess = true;
									wordLength--;

									if (checkAgain)
										wordLength++;
								} else {
									checkAgain = Character.isLetter(dashWord.charAt(spaceOne));
									dashWord = dashWord.substring(0, spaceOne) + userGuess
											+ dashWord.substring(spaceOne + 1, dashWord.length());
									correctGuess = true;
									wordLength--;

									if (checkAgain)

										wordLength++;
								}

							// checks space two against the guess
							if (userGuess == secretWord.charAt(spaceTwo))
								if (spaceTwo == 0) {
									checkAgain = Character.isLetter(dashWord.charAt(spaceTwo));
									dashWord = userGuess + dashWord.substring(1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)

										wordLength++;
								} else {
									checkAgain = Character.isLetter(dashWord.charAt(spaceTwo));
									dashWord = dashWord.substring(0, spaceTwo) + userGuess
											+ dashWord.substring(spaceTwo + 1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								}

							// checks space three against the guess
							if (userGuess == secretWord.charAt(spaceThree))
								if (spaceThree == 0)

								{
									checkAgain = Character.isLetter(dashWord.charAt(spaceThree));
									dashWord = userGuess + dashWord.substring(1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								} else {
									checkAgain = Character.isLetter(dashWord.charAt(spaceThree));
									dashWord = dashWord.substring(0, spaceThree) + userGuess
											+ dashWord.substring(spaceThree + 1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								}
						}

					}
					// hard
					else {
						userSpaces = input.nextLine().trim();
						int length = userSpaces.length();

						// asks for another guess if the input is not 3

						if (length != 3) {
							System.out.println("Your input is invalid. Try Again");
							System.out.println("Guesses Remaining: " + numGuesses);
							break outerloop;
						} else if (length == 3) {

						}

						// checks to make sure there are numbers separated by whitespace
						for (int i = 0; i <= 2; i += 2) {
							charIndex = userSpaces.charAt(i);
							if (Character.isDigit(charIndex)) {
								// check invalid space
								validSpace = true;
							}
						}

						if (validSpace == false) {
							System.out.println("Your input is invalid. Try Again");
							System.out.println("Guesses Remaining: " + numGuesses);

							continue;
						}

						else {
							for (int i = 0; i < 2; i++) // hard only checks two spaces
							{
								switch (i) {
								case 0:
									spaceOne = Character.getNumericValue(userSpaces.charAt(0));
									break;

								case 1:
									spaceTwo = Character.getNumericValue(userSpaces.charAt(2));
									break;
								}
							}

							// checks space one against the guess
							if (userGuess == secretWord.charAt(spaceTwo))
								if (spaceTwo == 0) {
									checkAgain = Character.isLetter(dashWord.charAt(spaceTwo));
									dashWord = userGuess + dashWord.substring(1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								} else {
									checkAgain = Character.isLetter(dashWord.charAt(spaceTwo));
									dashWord = dashWord.substring(0, spaceTwo) + userGuess
											+ dashWord.substring(spaceTwo + 1, dashWord.length());
									correctGuess = true;
									wordLength--;
									if (checkAgain)
										wordLength++;
								}
						}

					}
					// checks space two against the guess

					if (userGuess == secretWord.charAt(spaceOne))
						if (spaceOne == 0) {
							checkAgain = Character.isLetter(dashWord.charAt(spaceOne));
							dashWord = userGuess + dashWord.substring(1, dashWord.length());
							correctGuess = true;
							wordLength--;

							if (checkAgain)

								wordLength++;
						} else {
							checkAgain = Character.isLetter(dashWord.charAt(spaceOne));
							dashWord = dashWord.substring(0, spaceOne) + userGuess
									+ dashWord.substring(spaceOne + 1, dashWord.length());
							correctGuess = true;
							wordLength--;

							if (checkAgain)
								wordLength++;
						}

					if (correctGuess && wordLength == 0) // when the user has guessed the word correctly

					{
						// Winning statements
						System.out.println("Your guess is in the word!");
						System.out.println("The updated word is: " + dashWord);
						System.out.println("Guesses Remaining: " + numGuesses);
						System.out.println("You have guessed the word! Congratulations");
						System.out.println("Would you like to play again? Yes(y) or No(n)");
						replay = input.nextLine();

						// Asks user if they want to replay
						if (replay.equalsIgnoreCase("y")) {
							replayGame = true;
						}

						else {
							replayGame = false;
						}

						totalGames--;
						break;
					}

					else if (correctGuess)

					{
						// updates the word and guesses remaining when the user guesses a letter and
						// space correctly
						System.out.println("Your guess is in the word!");
						System.out.println("The updated word is: " + dashWord);
						correctGuess = false;
						checkAgain = false;
						System.out.println("Guesses Remaining: " + numGuesses);
					}

					else

					{
						// updates guesses remaining when the user does not guess a letter and space
						// correctly

						System.out.println("Your letter was not found in the spaces you provided.");
						numGuesses--;
						System.out.println("Guesses Remaining: " + numGuesses);
					}

					if (numGuesses == 0)

					{
						// prints when the user has not guesses the word with the allotted guesses, asks
						// if they want to play again
						System.out.println("You have failed to guess the word... :(");
						System.out.println("Would you like to play again? Yes(y) or No(n)");
						replay = input.nextLine();

						if (replay.equalsIgnoreCase("y")) {
							replayGame = true;
						}

						else if (replay.equalsIgnoreCase("n")) {
							replayGame = false;
							System.exit(0);
						}
						intermediate = false;
						hard = false;
						easy = false;
						totalGames--;
					}
					// Program terminates if 20 games have been played
					if (totalGames == 0) {
						System.out.println("Max games reached, program terminating");
						System.exit(0);
					}

				}
			}

		}
	}
}
