
/*
* StringFun.java
* Author: Emma Kasper
* Submission Date: 06 October 2017 *
* Purpose: A brief paragraph description of the
* Program. Manipulates a string given by the user to print the string in reverse, 
* replace all instances of a given character, replace a single character, or remove all instances
* from the string. 
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

public class StringFun {

	public static void main(String[] args) {
		Scanner keyboard1 = new Scanner(System.in);
		System.out.println("Enter the string to be manipulated"); // gathering user input from the scanner

		String original = keyboard1.nextLine();

		String command;

		// program runs until the user inputs "quit"
		do

		{

			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter your command (quit, print reverse, replace all, replace single, remove)");
			// program will keep asking for next command until user says to quit

			command = keyboard.nextLine().trim();

			if (command.equalsIgnoreCase("print reverse")) { // first command prints the string in reverse

				String reverse = "";

				for (int i = original.length() - 1; i >= 0; i--)
					reverse = reverse + original.charAt(i);
				System.out.println(reverse);
			}

			else if (command.equalsIgnoreCase("replace all")) // replaces all characters chosen by the user

			{
				{
					System.out.println("Enter the character to replace");
					String letter = keyboard.nextLine();
					char oldChar = letter.charAt(0);
					System.out.println("Enter the new character");
					String newLetter = keyboard.nextLine();
					String output = "";
					int count = 0;

					for (int i = 0; i < original.length(); i++) {

						count++;
						if (original.charAt(i) == oldChar) {
							original = original.substring(0, i) + newLetter + original.substring(i + 1);
							output = "The new string is: " + original;

						}

						if (count == 0) {
							output = "Error: the letter you are trying to replace does not exist";
						}

					}

					System.out.println(output);

				}
			}

			else if (command.equalsIgnoreCase("replace single")) { // replaces a single character chosen by the user
				System.out.println("Enter the character to replace");
				String letter = keyboard.nextLine().trim();
				char oldChar = letter.charAt(0);
				System.out.println("Enter the new character");
				String newLetter = keyboard.nextLine().trim();
				char newChar = newLetter.charAt(0);
				System.out.println("Which " + letter + " would you like to replace?");
				int indexOfLetter = keyboard.nextInt();

				int count = 0;
				String output = "";
				for (int i = 0; i < original.length(); i++) {

					if (original.charAt(i) == oldChar) {
						count++;
					}

					if (count == 0) {
						output = "Error: the letter you are trying to replace does not exist"; // prints an error if the
																								// character can't be
																								// found
					}

					else if (count == indexOfLetter) {
						original = original.substring(0, i) + newChar + original.substring(i + 1);
						output = "The new string is: " + original;
						break;
					}
				}

				System.out.println(output);
			}

			else if (command.equalsIgnoreCase("remove")) // removes all instances of a character provided by the user

			{
				System.out.println("Enter the character to remove: ");
				String letter = keyboard.nextLine();
				char oldChar = letter.charAt(0);

				String output = "";
				int count = 0;

				for (int i = 0; i < original.length(); i++) {
					if (oldChar == original.charAt(i)) {
						String start = original.substring(0, i);
						String end = original.substring(i + 1, original.length());
						original = start + end;
						count++;
						i--;
					}
				}

				if (count == 0) {
					output = "Error: the letter you are trying to remove does not exist"; // if the letter to be removed
																							// doesn't exist prints an
																							// error
				}

				else {
					output = "The new string is: " + original;
				}

				System.out.println(output);
			} else if (command.equalsIgnoreCase("Quit")) // terminates the program

				System.exit(0);

		}

		while (true);

	}

}
