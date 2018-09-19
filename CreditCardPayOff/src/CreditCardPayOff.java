
/*
* CreditCardPayOff.java
* Author: Emma Kasper
* Submission Date: 30 August 2017 *
* Purpose: A brief paragraph description of the
* program.This program calculates total amount paid, total interest paid, 
* overpayment, and how how many months needed to pay off a credit card given 
* the principal, annual interest rate, and monthly payment from the user. 
* Statement of Academic Honesty: *
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
CSCI 1301: Project 1 Page 2
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department * of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class CreditCardPayOff {

	public static void main(String[] args) {

		// declaration of variables
		double principal, interestRate, monthlyPayment, monthsNeeded, totalAmount, totalInterest, overpayment,
				numerator, denominator, part1, part2;

		// gathering user input
		System.out.print("Principal:\t\t\t");
		Scanner input = new Scanner(System.in);
		principal = input.nextDouble();
		
		System.out.print("Annual Interest Rate (%):\t");
		interestRate = input.nextDouble();
		
		System.out.print("Monthly payment:\t\t\t");
		monthlyPayment = input.nextDouble();
		input.close(); //close scanner

		// Math Calculations
		// calculation of months needed to pay off
		part1 = (monthlyPayment - (interestRate / 1200.0) * principal);
		part2 = (interestRate / 1200.0) + 1.0;
		numerator = Math.log(monthlyPayment) - Math.log(part1);
		denominator = Math.log(part2);
		monthsNeeded = Math.ceil(numerator / denominator);

		// equation for overpayment
		overpayment = (Math.ceil(numerator / denominator) - numerator / denominator) * monthlyPayment;

		// equation for total amount paid
		totalAmount = monthsNeeded * monthlyPayment;

		// equation for total interest
		totalInterest = totalAmount - principal;

		// output
		System.out.println("");
		System.out.println("Months Needed To Pay Off:\t" + Math.round(monthsNeeded));
		System.out.print("Total Amount Paid:\t\t");
		System.out.printf("$%.2f", totalAmount);
		System.out.println("");
		System.out.print("Total Interest Paid:$\t\t");
		System.out.printf("$%.2f", totalInterest);
		System.out.println("");
		System.out.print("Overpayment:$\t\t\t");
		System.out.printf("$%.2f", overpayment);

	}

}
