/* Minesweeper.java
 * 
 * Copyright © 2018 Michael E. Cotterell and the University of Georgia. This work is licensed under a 
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License to students and 
 * the public.
 */

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a Minesweeper game.
 *
 * @author YOUR NAME <YOUR EMAIL>
 */
public class Minesweeper {

	char[][] playerBoard;

	int numGuesses = 0;
	int numRounds = 0;
	char[][] board;
	int[][] adjMines;
	int rows, cols;
	int numMarks = 0;
	boolean winner = false;
	int score = 0;
	int mineSpace = 0;
	int numAdjMines = 0;
	int startingMines;

	Random random = new Random();
	Scanner input = new Scanner(System.in);

	/**
	 * Constructs an object instance of the {@link Minesweeper} class using the
	 * information provided in <code>seedFile</code>. Documentation about the format
	 * of seed files can be found in the project's <code>README.md</code> file.
	 *
	 * @param seedFile
	 *            the seed file used to construct the game
	 */
	public Minesweeper(File seedFile) {

		// TODO implement

	} // Minesweeper

	/**
	 * Constructs an object instance of the {@link Minesweeper} class using the
	 * <code>rows</code> and <code>cols</code> values as the game grid's number of
	 * rows and columns respectively. Additionally, the number of positions in the
	 * grid that will be set as a mine should equal the ceiling of
	 * <code>1.0 * rows * cols / 3.0</code>, casted to an <code>int</code>. These
	 * mine positions should be assigned randomly.
	 *
	 * @param rows
	 *            the number of rows in the game grid
	 * @param cols
	 *            the number of cols in the game grid
	 */
	public Minesweeper(int rows, int cols) {

		// TODO implement
		int startingMines = (int) (Math.ceil(1.0 * rows * cols / 3.0));
		char[][] board = new char[rows][cols];
		int[][] adjMines = new int[rows][cols];
		int numPlaceMines = startingMines;

		for (int i = 0; i < board.length; i++) {

			// System.out.print(i + " | ");
			for (int j = 0; j < board[i].length; j++) {

				// System.out.print(" | ");
			}

			// System.out.println();
		}
		for (int i = 0; i < board.length; i++) {
			// System.out.print(" " + i);
		}

		while (numPlaceMines > 0) {

			for (int i = 0; i < board.length; i++) {

				for (int j = 0; j < board[i].length; j++) {

					mineSpace = random.nextInt(3);

					if (mineSpace == 1 && numPlaceMines > 0) {
						numPlaceMines--;

						board[i][j] = 'X';
						adjMines[i][j] = -1;

					}

					else {

						board[i][j] = 'o';
						adjMines[i][j] = 0;

					}

				}

			}

		}

		for (int x = 0; x < adjMines.length; x++) {
			for (int y = 0; y < adjMines[x].length; y++) {
				if (adjMines[x][y] != -1) {

					if (x > 0 && y > 0 && adjMines[x - 1][y - 1] == -1) { // up and left
						numAdjMines++;
					}

					if (y > 0 && adjMines[x][y - 1] == -1) {// up
						numAdjMines++;
					}

					if (x < adjMines.length - 1 && y > 0 && adjMines[x + 1][y - 1] == -1) {// right and up
						numAdjMines++;
					}

					if (x > 0 && adjMines[x - 1][y] == -1) { // left
						numAdjMines++;
					}

					if (x < adjMines.length - 1 && adjMines[x + 1][y] == -1) { // right
						numAdjMines++;
					}
					if (x > 0 && y < adjMines[x].length - 1 && adjMines[x - 1][y + 1] == -1) { // left and down
						numAdjMines++;
					}
					if (y < adjMines[x].length - 1 && adjMines[x][y + 1] == -1) { // down
						numAdjMines++;
					}

					if (x < adjMines.length - 1 && y < adjMines[x].length - 1 && adjMines[x + 1][y + 1] == -1) {// down
																												// right

						numAdjMines++;
					}
					adjMines[x][y] = numAdjMines;
					numAdjMines = 0;
				}

			}
		}

	} // Minesweeper

	/**
	 * Starts the game and execute the game loop.
	 */
	public void run() {

		// TODO implement
		int numMines = startingMines;
		System.out.println("        _");
		System.out.println("  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __");
		System.out.println(" /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
		System.out.println("/ /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |");
		System.out.println("\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|");
		System.out.println("                                     ALPHA |_| EDITION");
		System.out.println();

		System.out.println();
		System.out.println("Rounds Completed: " + numRounds);
		System.out.println();

		for (int i = 0; i < playerBoard.length; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < playerBoard[i].length; j++) {

				System.out.print("  |  ");
			}

			System.out.println();
		}

		for (int i = 0; i < playerBoard.length; i++) {
			System.out.print("    " + i);
		}

		// start of commands
		while (numRounds >= 0)

		{

			System.out.println();
			System.out.println();
			System.out.print("minesweeper-alpha$ ");
			String commandStatement = input.nextLine().trim();
			commandStatement += " ";
			int endCommand = commandStatement.indexOf(" ");
			String command = commandStatement.substring(0, endCommand);

			if (command.equals("help") || command.equals("h")) {
				numRounds++;
				System.out.println();
				System.out.println("Commands Available...");
				System.out.println(" - Reveal: r/reveal row col");
				System.out.println(" -   Mark: m/mark   row col");
				System.out.println(" -  Guess: g/guess  row col");
				System.out.println(" -   Help: h/help");
				System.out.println(" -   Quit: q/quit");
				System.out.println();

			} else if (command.equals("mark") || command.equals("m")) {
				numRounds++;
				numMarks++;

				commandStatement = commandStatement.replace(command, "");
				commandStatement = commandStatement.trim();
				int endCommand2 = commandStatement.indexOf(" ");
				String rIndex = commandStatement.substring(0, endCommand2);
				String cIndex = commandStatement.substring(endCommand2 + 1);

				int rowIndex = Integer.parseInt(rIndex);
				int colIndex = Integer.parseInt(cIndex);

				playerBoard[rowIndex][colIndex] = (int) 'F';

				System.out.println();
				System.out.println("Rounds Completed: " + numRounds);
				System.out.println();

				for (int i = 0; i < playerBoard.length; i++) {
					System.out.print(i + " |  ");

					for (int j = 0; j < playerBoard[i].length; j++) {

						System.out.print((char) playerBoard[i][j]);
						System.out.print("  |  ");

					}

					System.out.println();
				}

				for (int i = 0; i < playerBoard.length; i++) {
					System.out.print("     " + i);
				}

				//
				score = (rows * cols) + (numMines - numGuesses) / (numRounds);
				int count = 0;

				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						if (board[i][j] == 'X' && playerBoard[i][j] == 'F') {
							count++;
						} // if

					} // for j
						// for i

					if (count == numMines && numMarks == numMines) {
						winner = true;
					} else {
						winner = false;
					}

				}
				if (winner) {
					System.out.println();
					System.out.println(" ░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░	\"So Doge\"");
					System.out.println(" ░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░");
					System.out.println(" ░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░	\"Such Score\"");
					System.out.println(" ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░");
					System.out.println(" ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░	\"Much Minesweeping\"");
					System.out.println(" ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░");
					System.out.println(" ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░	\"Wow\"");
					System.out.println(" ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░");
					System.out.println(" ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░");
					System.out.println(" ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░");
					System.out.println(" ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░");
					System.out.println(" ▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌");
					System.out.println(" ▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░");
					System.out.println(" ░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░");
					System.out.println(" ░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░");
					System.out.println(" ░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░");
					System.out.println(" ░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░	CONGRATULATIONS!");
					System.out.println(" ░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░	YOU HAVE WON!");
					System.out.println(" ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░	SCORE: " + score);
					System.out.println("");
					System.exit(0);
				}
				continue;

			}

			else if (command.equals("guess") || command.equals("g")) {
				numGuesses++;
				numRounds++;

				commandStatement = commandStatement.replace(command, "");
				commandStatement = commandStatement.trim();
				int endCommand2 = commandStatement.indexOf(" ");
				String rIndex = commandStatement.substring(0, endCommand2);
				String cIndex = commandStatement.substring(endCommand2 + 1);

				int rowIndex = Integer.parseInt(rIndex);
				int colIndex = Integer.parseInt(cIndex);

				playerBoard[rowIndex][colIndex] = (int) '?';

				System.out.println();
				System.out.println("Rounds Completed: " + numRounds);
				System.out.println();

				for (int i = 0; i < playerBoard.length; i++) {
					System.out.print(i + " |  ");

					for (int j = 0; j < playerBoard[i].length; j++) {

						System.out.print((char) playerBoard[i][j]);
						System.out.print("   |  ");

					}

					System.out.println();
				}

				for (int i = 0; i < playerBoard.length; i++) {
					System.out.print("     " + i);
				}
				score = (rows * cols) + (numMines - numGuesses) / (numRounds);

				continue;
			}

			else if (command.equals("reveal") || command.equals("r")) {
				numRounds++;

				commandStatement = commandStatement.replace(command, "");
				commandStatement = commandStatement.trim();
				int endCommand2 = commandStatement.indexOf(" ");
				String rIndex = commandStatement.substring(0, endCommand2);
				String cIndex = commandStatement.substring(endCommand2 + 1);

				int rowIndex = Integer.parseInt(rIndex);
				int colIndex = Integer.parseInt(cIndex);

				if (adjMines[rowIndex][colIndex] != -1) // if not a mine reveal how many mines it is touching
				{

					int touching = adjMines[rowIndex][colIndex];
					String adj = Integer.toHexString(touching);
					adj = adj.trim();
					char numTouching = adj.charAt(0);
					playerBoard[rowIndex][colIndex] = numTouching;
				}

				else {
					numRounds++;
					System.out.println();
					System.out.println(" Oh no... You revealed a mine!");
					System.out.println(" __ _ __ _ _ __ ___ ___ _____ _____ _ __ ");
					System.out.println(" / _` |/ _` | '_ ` _ \\ / _ \\ / _ \\ \\ / / _ \\ '__|");
					System.out.println("| (_| | (_| | | | | | | __/ | (_) \\ V / __/ | ");
					System.out.println(" \\__, |\\__,_|_| |_| |_|\\___| \\___/ \\_/ \\___|_| ");
					System.out.println(" |___/ ");
					System.out.println();
					System.exit(0);
				}

				System.out.println();
				System.out.println("Rounds Completed: " + numRounds);
				System.out.println();

				for (int i = 0; i < playerBoard.length; i++) {
					System.out.print(i + " |  ");

					for (int j = 0; j < playerBoard[i].length; j++) {

						System.out.print(playerBoard[i][j]);
						System.out.print("   |  ");

					}

					System.out.println();
				}

				for (int i = 0; i < playerBoard.length; i++) {
					System.out.print("     " + i);
				}
				score = (rows * cols) + (numMines - numGuesses) / (numRounds);

				continue;

			} else if (command.equals("quit") || command.equals("q")) {

				System.out.println();
				System.out.println("ლ(ಠ_ಠლ)");
				System.out.println("Y U NO PLAY MORE?");
				System.out.println("BYE!");
				System.exit(0);
			}

			else {
				System.out.println("ಠ_ಠ says, \"Command not recognized!\"");
				numRounds++;

				System.out.println();
				System.out.println(numRounds);
				score = (rows * cols) + (numMines - numGuesses) / (numRounds);

				continue;
			}

		}

	} // run

	/**
	 * The entry point into the program. This main method does implement some logic
	 * for handling command line arguments. If two integers are provided as
	 * arguments, then a Minesweeper game is created and started with a grid size
	 * corresponding to the integers provided and with a number of squares
	 * containing mines, placed randomly, as determined by the overloaded
	 * constructor. If a single word string is provided as an argument then it is
	 * treated as a seed file and a Minesweeper game is created and started using
	 * the information contained in the seed file. If none of the above applies,
	 * then a usage statement is displayed and the program exits gracefully.
	 *
	 * @param args
	 *            the shell arguments provided to the program
	 */
	public static void main(String[] args) {

		/*
		 * The following switch statement has been designed in such a way that if errors
		 * occur within the first two cases, the default case still gets executed. This
		 * was accomplished by special placement of the break statements.
		 */

		Minesweeper game = null;

		switch (args.length) {

		// random game
		case 2:

			int rows, cols;

			// try to parse the arguments and create a game
			try {
				rows = Integer.parseInt(args[0]);
				cols = Integer.parseInt(args[1]);
				game = new Minesweeper(rows, cols);
				break;
			} catch (NumberFormatException nfe) {
				// line intentionally left blank
			} // try

			// seed file game
		case 1:

			String filename = args[0];
			File file = new File(filename);

			if (file.isFile()) {
				game = new Minesweeper(file);
				break;
			} // if

			// display usage statement
		default:

			System.out.println("Usage: java Minesweeper [FILE]");
			System.out.println("Usage: java Minesweeper [ROWS] [COLS]");
			System.exit(0);

		} // switch

		// if all is good, then run the game
		game.run();

	} // main

} // Minesweeper