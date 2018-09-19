import java.util.Scanner;

public class Bagels {

	public static void main(String[] args) {

		System.out.print("\nWelcome!");
		Scanner keyboard = new Scanner(System.in);
		Player player = new Player();
		Engine engine = new Engine();
		Validator validator = new Validator();

		boolean reset = true;

		while (reset == true) {
		
			System.out.print("\nEnter the number of digits to use: ");

			int digits = keyboard.nextInt();
			engine.setNumDigits(digits);

			System.out.print("Enter the player's name: ");
			String name = keyboard.next();
			player.setName(name);

			boolean run = true;

			while (run == true) {
				for (int gameCount = 1; gameCount > 0; gameCount++) {
					System.out.print("\nStarting game #" + gameCount + ".");
					engine.generateNewSecret();
					int numberOfGuesses = 0;
					int numberOfMovesTakenToWin = 0;

					while (true) {
						numberOfMovesTakenToWin = numberOfGuesses;
						String playerGuess = player.askForGuess(); ;
						System.out.println("\nEnter your guess: ");
						player.askForGuess();
						Validator.validateGuess(engine.getSecretNumber(), engine.convertNumToDigitArray(playerGuess),
								engine.getNumDigits());
						if (Validator.validateGuess(engine.getSecretNumber(), engine.convertNumToDigitArray(playerGuess),
								engine.getNumDigits()) == false) {
							numberOfGuesses++;
							continue;
						}

						else
							numberOfMovesTakenToWin = numberOfGuesses;
						break;
					}
					gameCount++;
					System.out.println("Congratulations! You won in " + numberOfMovesTakenToWin + "moves");
					if (numberOfMovesTakenToWin < numberOfGuesses)
						numberOfMovesTakenToWin = player.getFastestWin();
					else
						numberOfGuesses = player.getFastestWin();
					System.out.println("Statistics for " + player.getName());
					System.out.println("Games Completed:" + player.getGamesCompleted());
					System.out.println("Number of Digits: " + engine.getNumDigits());
					System.out.println("Fastest win: " + player.getFastestWin() + "guesses");

					}
				System.out.println("p - Play again");
				System.out.println("r - Reset game");
				System.out.println("q - Quit ");

				System.out.println("What would you like to do?");
				String letter = keyboard.nextLine().toLowerCase().substring(0, 1);
				if (letter == "p") {
					run = true;
					reset = false;

				} else if (letter == "r") {
					run = false;
					reset = true;

				}

				else if (letter == "q") {
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					System.out.println("Not recognized");
				}

			}

		}

	}

}
