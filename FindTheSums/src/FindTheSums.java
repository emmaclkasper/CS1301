/*
* FindTheSums.java
* Author: Emma Kasper
* Submission Date: 1 December 2017
* Purpose: This program gives the methods of printing a 2D array while computing the valid horizontal sums and the valid vertical sums.
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
public class FindTheSums {

	/*
	 * will return a string that is a representation of the values in a. The values
	 * in each column of a have a single space between them and the rows have a
	 * single newline character between them. There should not be a space before the
	 * first value in a column or after the last value in a column. Also, there
	 * should not be a newline before the first row or after the last row.
	 */
	public static String arrayToString(int[][] a) {
		// initializing string variables
		String finalArray = "";
		String array = "";
		for (int i = 0; i < a.length; i++) { // running through rows and columns of array
			for (int j = 0; j < a[0].length; j++) {
				if (j == 0)

				// putting spaces between the columns and rows

				{
					array = ("" + a[i][j]);
				} else

				{
					array = (" " + a[i][j]);
				}

				finalArray = finalArray + array;
			}

			// starts a new line for each r0w in the array except the last one
			if (i != (a.length - 1))

			{
				finalArray = (finalArray + "\n");
			}
		}

		return finalArray;
	}

	/*
	 * This method will create a new output array called b that has the same
	 * dimensions as a. For each a[i][j], where i and j are valid indices in a, if
	 * a[i][j] is part of a horizontal sum in a that equals sumToFind, then b[i][j]
	 * = a[i][j]; otherwise, b[i][j] = 0. The method should return b.
	 */
	public static int[][] horizontalSums(int[][] a, int sumToFind) {
		// initializing new array
		int[][] b = new int[a.length][a[0].length];
		int sum;
		int location;
		boolean isSum;

		// running through rows
		for (int i = 0; i < a.length; i++)

		{
			// running through columns
			for (int k = 0; k < a[0].length; k++)

			{
				location = 0;
				sum = 0;
				isSum = false;

				for (int j = k; j >= 0; j--)

				{
					// adding vertical adjacent indices
					sum += a[i][j];
					// evaluates if the sums are equal
					if (sum == sumToFind)

					{
						isSum = true;
						location = j;
					}
				}

				if (isSum == true)

				{

					// copies values into b
					for (int l = k; l >= location; l--)

					{
						b[i][l] = a[i][l];
					}
				}

			}

		}

		return b;
	}

	/*
	 * This method will create a new output array called b that has the same
	 * dimensions as a. For each a[i][j], where i and j are valid indices in a, if
	 * a[i][j] is part of a vertical sum in a that equals sumToFind, then b[i][j] =
	 * a[i][j]; otherwise, b[i][j] = 0. The method should return b.
	 */
	public static int[][] verticalSums(int[][] a, int sumToFind) {

		int[][] b = new int[a.length][a[0].length];
		int sum;
		int location;
		boolean isSum;

		// runs through rows
		for (int i = 0; i < a[0].length; i++)

		{
			// running through columns

			for (int k = 0; k < a.length; k++) {
				location = 0;
				sum = 0;
				isSum = false;

				// adding vertical adjacent indices
				for (int j = k; j >= 0; j--) {
					sum += a[j][i];

					// evaluates if the sum is equal to the sum we are looking for
					if (sum == sumToFind) {
						isSum = true;
						location = j;
					}
				}
				if (isSum == true) {

					for (int h = k; h >= location; h--) {
						b[h][i] = a[h][i];
					}
				}

			}
		}
		return b;

	}

}
