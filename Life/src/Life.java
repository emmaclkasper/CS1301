
/*
* Life.java
* Author: Emma Kasper
* Submission Date: 27 October 2017
* Purpose: This program uses methods and loops to create a grid. It is a never ending program that turns cells
* cells of a grid different colors based on the parameters given. 
* Statement of Academic Honesty: 
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

import java.util.Random; //importing random class

public class Life {

	public static void main(String[] args) {

		int gridSize = 200; // initializing the size of the grid
		int cellSize = 3;
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life");
		grid.setDelay(10);

		// sets the color of the cells based on numbers from 0-11

		int aliveColor = 1; // white
		int deadColor = 0; // black

		Random r = new Random();

		// loops to set the starting grid, assigns random color to cells

		for (int row = 0; row < grid.getGridRowSize(); row++) {
			for (int col = 0; col < grid.getGridColSize(); col++) {
				int w = r.nextInt(100);

				if (w > 49) {
					grid.setPos(row, col, aliveColor);
				}

				else {
					grid.setPos(row, col, deadColor);
				}

			}

		}
		grid.initialize();

		boolean t = true;
		while (t) {
			for (int row = 0; row < grid.getGridRowSize(); row++) {
				for (int col = 0; col < grid.getGridColSize(); col++) {
					if (grid.getPos(row, col) == deadColor) // if the color of the cell is black it goes into the loop
					{
						if (grid.matchingNeighbors(row, col, aliveColor) == 3) // evaluates if 3 surrounding cells are
																				// black
						{
							grid.setPos(row, col, aliveColor); // if true, sets the current cell to white
						} else {
							grid.setPos(row, col, deadColor); // if false, sets the current cell to black
						}
					}

					if (grid.getPos(row, col) == aliveColor) // if the color of the cell is white it goes into the loop
					{
						if ((grid.matchingNeighbors(row, col, aliveColor) == 2)
								|| (grid.matchingNeighbors(row, col, aliveColor) == 3))
						// evaluates if 3 surrounding cells are white
						{
							grid.setPos(row, col, aliveColor); // if true, sets the current cell to white

						}

						else

						{
							grid.setPos(row, col, deadColor); // if false, sets the current cell to black
						}
					}
				} // inner for

			} // outer for
			grid.update(); // constantly updates the current positions of the grid

		} // while

	}// main

}
