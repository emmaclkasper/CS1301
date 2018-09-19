/*
* NetPay.java
* Author: Emma Kasper
* Submission Date: 28 August 2017 *
* Purpose: A brief paragraph description of the
* Program. Calculates gross pay and net pay based on how many hours worked per week.
* 		   Takes into account the deductions from taxes.  
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

// Importing java scanner to allow user input from the keyboard

import java.util.Scanner;

public class NetPay {

	// declaration of constants
	public static final double FEDERAL_TAX_PERCENT = 10.00;
	public static final double STATE_TAX_PERCENT = 4.5;
	public static final double SS_PERCENT = 6.2;
	public static final double MEDICARE_PERCENT = 1.45;
	public static final double PAY_PER_HOUR = 7.25;

	public static void main(String[] args) {

		// declaration of variables
		int hoursPerWeek;
		double grossPay, netPay, federal, state, socialSecurity, medicare, deductions;

		// user input
		System.out.println("How many hours have you worked?");

		Scanner hours = new Scanner(System.in);

		hoursPerWeek = hours.nextInt();
		hours.close();

		// math calculations and initialization of variables
		grossPay = hoursPerWeek * PAY_PER_HOUR;
		federal = FEDERAL_TAX_PERCENT / 100 * grossPay;
		state = STATE_TAX_PERCENT / 100 * grossPay;
		socialSecurity = SS_PERCENT / 100 * grossPay;
		medicare = MEDICARE_PERCENT / 100 * grossPay;
		deductions = federal + state + socialSecurity + medicare;
		netPay = grossPay - deductions;

		// output
		System.out.println("Hours per Week:\t\t" + hoursPerWeek);
		System.out.println("Gross Pay:\t\t" + grossPay);
		System.out.println("Net Pay:\t\t\t" + netPay);
		System.out.println(" ");
		System.out.println("Deductions");
		System.out.println("Federal:\t\t\t" + federal);
		System.out.println("State:\t\t\t" + state);
		System.out.println("Social Security:\t\t" + socialSecurity);
		System.out.println("Medicare:\t\t" + medicare);

	}

}
