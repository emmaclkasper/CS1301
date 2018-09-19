/*
* Palindrome.java
* Author: Emma Kasper
* Submission Date: 28 September 2017 *
* Purpose: A brief paragraph description of the
* Program. Takes a number from the user and determines if the number
* is a palindrome. If it is, the program returns the summation of that number.
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

public class Palindrome {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter an integer > 0: ");

		int n = input.nextInt();
		input.close();

		if (n <= 0) {
			System.out.println("Sorry, you must enter an integer greater than zero.");
			System.exit(0);
		}

		else

		{
			int palindrome = 0, remainder = 0, number = n;
			while (n > 0) {

				remainder = n % 10;
				palindrome = palindrome * 10 + remainder;
				n = n / 10;
			}

			int start = 1, sum = 0;
			while (start <= number)

			{
				sum += start++;
			}

			if (palindrome == number) {
				System.out.print("The integer " + number);
				System.out.println(" is the palindrome.");
				System.out.print("The sum of the numbers from 1 to " + number);
				System.out.println(" is " + sum);
			}

			else {
				System.out.print("The integer " + number);
				System.out.println(" is not a palindrome.");

			}
		}
	}
}
