
import java.util.Scanner;
import java.util.Random;

public class MinesweeperMethods {

	public boolean 
	public void reveal(Scanner input) {
		int endCommand2 = commandStatement.indexOf(" ");
		String rIndex = commandStatement.substring(0, endCommand2);
		String cIndex = commandStatement.substring(endCommand2 + 1);

		int rowIndex = Integer.parseInt(rIndex);
		int colIndex = Integer.parseInt(cIndex);

		System.out.println("row " + rowIndex + " column " + colIndex);// coordinate 1
		System.out.println();
		//

		// for (int i = 0; i < playerBoard.length; i++) {
		// System.out.print(i + " | ");
		// for (int j = 0; j < playerBoard[i].length; j++) {
		//
		// System.out.print(" | ");
		// }
		//
		// System.out.println();
		// }
		//
		// for (int i = 0; i < playerBoard.length; i++) {
		// System.out.print(" " + i);
		// }
		// checks to see if index is a mine

		if (adjMines[rowIndex][colIndex] != -1) // if not a mine reveal how many mines it is touching
		{
			playerBoard[rowIndex][colIndex] = adjMines[rowIndex][colIndex];
		}

		else {
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
		for (int i = 0; i < playerBoard.length; i++) {
			System.out.print(i + " |  ");

			for (int j = 0; j < playerBoard[i].length; j++) {

				System.out.print(playerBoard[i][j]);
				System.out.print("  |  ");

			}

			System.out.println();
		}

		for (int i = 0; i < playerBoard.length; i++) {
			System.out.print("     " + i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rows, cols;
		rows = 10;
		cols = 10;
		char[][] board = new char[rows][cols];
		int[][] playerBoard = new int[rows][cols];

		for (int i = 0; i < playerBoard.length; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < playerBoard[i].length; j++) {

				System.out.print(" | ");
			}

			System.out.println();
		}

		for (int i = 0; i < playerBoard.length; i++) {
			System.out.print(" " + i);
		}

		System.out.println();
		System.out.println();

		System.out.println("There are " + rows + " rows and there are " + cols + " cols");
		int numMines = (int) Math.ceil(1.0 * rows * cols / 3.0);
		System.out.println("The number of mines are " + numMines);
		Random random = new Random();
		int[][] adjMines = new int[rows][cols];
		int numAdjMines = 0;

		while (numMines > 0) {

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					int mineSpace = random.nextInt(3);
					if (mineSpace == 1) {
						board[i][j] = 'X';
						adjMines[i][j] = -1;

					}

					else {

						board[i][j] = 'o';
						adjMines[i][j] = 0;
					}
				}
			}

			numMines--;
		}

		System.out.println("there are " + numMines + " mines left");
		// printing the board with numbers
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < board[i].length; j++) {

				System.out.print(board[i][j]);
				System.out.print("  | ");

			}

			System.out.println();
		}

		for (int i = 0; i < board.length; i++) {
			System.out.print("    " + i);
		}

		System.out.println();
		System.out.println();

		// check for neighbors
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

		// for (int i = 0; i < board.length; i++) {
		// System.out.print(i + " | ");
		// for (int j = 0; j < board[i].length; j++) {
		//
		// System.out.print(adjMines[i][j]);
		// System.out.print(" | ");
		//
		// }
		//
		// System.out.println();
		// }
		//
		// for (int i = 0; i < board.length; i++) {
		// System.out.print(" " + i);
		// }

		System.out.println();
		System.out.println();

		Scanner input = new Scanner(System.in);

		// start of commands
		System.out.print("minesweeper-alpha$ ");
		String commandStatement = input.nextLine().trim();
		commandStatement += " ";
		int endCommand = commandStatement.indexOf(" ");
		String command = commandStatement.substring(0, endCommand);

		commandStatement = commandStatement.replace(command, "");
		commandStatement = commandStatement.trim();

		if (command.equals("help") || command.equals("h")) {

			System.out.println();
			System.out.println("Commands Available...");
			System.out.println(" - Reveal: r/reveal row col");
			System.out.println(" -   Mark: m/mark   row col");
			System.out.println(" -  Guess: g/guess  row col");
			System.out.println(" -   Help: h/help");
			System.out.println(" -   Quit: q/quit");
			System.out.println();

		}
		if (command.equals("mark") || command.equals("m")) {
			int endCommand2 = commandStatement.indexOf(" ");
			String rIndex = commandStatement.substring(0, endCommand2);
			String cIndex = commandStatement.substring(endCommand2 + 1);

			int rowIndex = Integer.parseInt(rIndex);
			int colIndex = Integer.parseInt(cIndex);

			System.out.println(rowIndex);// coordinate 1
			System.out.println(colIndex);

			if (adjMines[rowIndex][colIndex] != -1) // if not a mine reveal how many mines it is touching
			{
				playerBoard[rowIndex][colIndex] = (int) 'F';
			}

			else {
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

		}

		if (command.equals("guess") || command.equals("g")) {
			int endCommand2 = commandStatement.indexOf(" ");
			String rIndex = commandStatement.substring(0, endCommand2);
			String cIndex = commandStatement.substring(endCommand2 + 1);

			int rowIndex = Integer.parseInt(rIndex);
			int colIndex = Integer.parseInt(cIndex);

			System.out.println(rowIndex);// coordinate 1
			System.out.println(colIndex);

			if (adjMines[rowIndex][colIndex] != -1) // if not a mine reveal how many mines it is touching
			{
				playerBoard[rowIndex][colIndex] = (int) '?';
			}

			else {
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

		}

		if (command.equals("reveal") || command.equals("r")) {
			int endCommand2 = commandStatement.indexOf(" ");
			String rIndex = commandStatement.substring(0, endCommand2);
			String cIndex = commandStatement.substring(endCommand2 + 1);

			int rowIndex = Integer.parseInt(rIndex);
			int colIndex = Integer.parseInt(cIndex);

			System.out.println("row " + rowIndex + " column " + colIndex);// coordinate 1
			System.out.println();
			//

			// for (int i = 0; i < playerBoard.length; i++) {
			// System.out.print(i + " | ");
			// for (int j = 0; j < playerBoard[i].length; j++) {
			//
			// System.out.print(" | ");
			// }
			//
			// System.out.println();
			// }
			//
			// for (int i = 0; i < playerBoard.length; i++) {
			// System.out.print(" " + i);
			// }
			// checks to see if index is a mine

			if (adjMines[rowIndex][colIndex] != -1) // if not a mine reveal how many mines it is touching
			{
				playerBoard[rowIndex][colIndex] = adjMines[rowIndex][colIndex];
			}

			else {
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
			for (int i = 0; i < playerBoard.length; i++) {
				System.out.print(i + " |  ");

				for (int j = 0; j < playerBoard[i].length; j++) {

					System.out.print(playerBoard[i][j]);
					System.out.print("  |  ");

				}

				System.out.println();
			}

			for (int i = 0; i < playerBoard.length; i++) {
				System.out.print("     " + i);
			}

		}
		if (command.equals("quit") || command.equals("q")) {

			System.out.println();
			System.out.println("ლ(ಠ_ಠლ)");
			System.out.println("Y U NO PLAY MORE?");
			System.out.println("BYE!");
			System.exit(0);
		}

	}

}
