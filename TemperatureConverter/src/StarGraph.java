
/*
* StarGraph.java
* Author: Emma Kasper
* Submission Date: 13 October 2017
* Purpose: A brief paragraph description of the program. 
* This program takes user input and stores a number of values decided by the user
* into arrays. Array x holds the x value and array y holds the value given by 
* 20 * |sinx|. The program then takes the int value of y and prints the 
* respective number of asterisks in the form of a graph. 
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
import java.util.Scanner;

public class StarGraph {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter the number of x values to process: ");
		int size = keyboard.nextInt();
		if (size <= 0) {
			System.out.println("The number of x values must be an integer greater than 0.");
			keyboard.close();
			System.exit(0);
		}
		System.out.print("Enter a minimum value for x: ");
		double minimum = keyboard.nextDouble();

		System.out.print("Enter the amount to increment x: ");
		double increment = keyboard.nextDouble();
		System.out.println("");
		if (increment <= 0) {
			System.out.print("The increment must be a decimal number greater than 0.");
			System.exit(0);
		}

		double[] x = new double[size];
		double[] y = new double[size];

		System.out.println("Values");
		for (int i = 0; i < x.length; i++) {
			x[i] = minimum;
			minimum = minimum + increment;
			y[i] = ((20.0) * (Math.abs(Math.sin(x[i]))));

			System.out.printf("x: %.3f", x[i]);
			System.out.printf(", y: %.3f", y[i]);
			System.out.println("");

		}
		System.out.println("");
		System.out.println("Graph");

		for (int i = 0; i < x.length; i++)

		{
			System.out.print(":");

			for (int j = 0; j < (int) y[i]; j++) {
				System.out.print("*");

			}

			System.out.println("");
		}

		System.exit(0);
		keyboard.close();
	}
}
