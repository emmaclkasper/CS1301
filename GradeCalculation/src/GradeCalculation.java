/*
* GradeCalculation.java
* Author: Emma Kasper
* Submission Date: 21 September 2017
* Purpose: A brief paragraph description of the program. 
* This program takes user input to calculate the user's current 
* grade in their course and informs the user if they have met
* their desired goal, and if not what they need to score 
* in remaining assignments to obtain that grade.  
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

//importing scanner for user input
import java.util.Scanner;

public class GradeCalculation {

	public static void main(String[] args) {

		// declaring variables
		Scanner input = new Scanner(System.in);
		int exam1W, exam2W, finalExamW, labsW, projectsW, attendanceW, quizzesW;
		int exam1Score, exam2Score, finalExamScore, labAv, projectAv, attendanceAv, quizAv;
		int exam1WS, exam2WS, finalWS, labWS, projectWS, attendanceWS, quizWS;
		int finalOverallScore, totalKnownGradeWeight, knownWeightScore;
		double currentScore;

		// printing grading scale to the screen
		System.out.println("Grading Scale:");
		System.out.println("A \t" + "90 - 100");
		System.out.println("B \t" + "80-89");
		System.out.println("C \t" + "70-79");
		System.out.println("D \t" + "60-69");
		System.out.println("F \t" + "below 60");

		// Gathering user input
		System.out.print("What letter grade do you want to achieve for the course?  ");
		String desiredGrade = input.next();
		desiredGrade = desiredGrade.trim();
		finalOverallScore = 0;

		// if else statements to assign the final overall score to calculate average
		// final letter grade later on
		if (desiredGrade.equalsIgnoreCase("A"))

		{
			finalOverallScore = 90;
		}

		else if (desiredGrade.equalsIgnoreCase("B")) {
			finalOverallScore = 80;
		}

		else if (desiredGrade.equalsIgnoreCase("C")) {
			finalOverallScore = 70;
		}

		else if (desiredGrade.equalsIgnoreCase("D")) {
			finalOverallScore = 60;
		}

		else if (desiredGrade.equalsIgnoreCase("F")) {
			finalOverallScore = 0;

		}

		else {
			System.out.println("Input Error"); // program terminates if the desired grade is not on the scale
			System.exit(0);
		}

		// Gathering percentage weights
		System.out.println("Enter Percentage Weights:");
		System.out.print("Exam 1:\t\t");
		exam1W = input.nextInt();

		System.out.print("Exam 2:\t\t");
		exam2W = input.nextInt();

		System.out.print("Final Exam:\t");
		finalExamW = input.nextInt();

		System.out.print("Labs:\t\t");
		labsW = input.nextInt();

		System.out.print("Projects:\t");
		projectsW = input.nextInt();

		System.out.print("Attendance:\t");
		attendanceW = input.nextInt();

		System.out.print("Quizzes:\t\t");
		quizzesW = input.nextInt();

		// the sum of all weights
		int totalWeight;
		totalWeight = exam1W + exam2W + finalExamW + labsW + projectsW + attendanceW + quizzesW;

		// terminates the program if weights don't add up to 100
		if (totalWeight != 100)

		{
			System.out.println("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}

		// Gathering scores
		System.out.println("Enter your scores out of a 100:");
		System.out.print("Do you know your Exam 1 score?");
		String answer = input.next().trim();
		totalKnownGradeWeight = 0;
		exam1WS = 0;
		exam2WS = 0;
		finalWS = 0;
		labWS = 0;
		projectWS = 0;
		quizWS = 0;
		attendanceWS = 0;

		// if else statements to decide what information to gather from the user
		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

			System.out.print("Score received on exam 1: ");
			exam1Score = input.nextInt();
			totalKnownGradeWeight += exam1W;
			exam1WS = exam1Score * exam1W;
			System.out.print("Do you know your Exam 2 score? ");
			answer = input.next();

		}

		else {
			exam1W = 0;
		}

		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))

		{

			System.out.print("Score received on exam 2: ");
			exam2Score = input.nextInt();
			totalKnownGradeWeight += exam2W;
			exam2WS = exam2Score * exam2W;
			System.out.print("Do you know your Final Exam score? ");
			answer = input.next();

		}
		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))

		{
			System.out.print("Score received on final exam ");
			finalExamScore = input.nextInt();
			totalKnownGradeWeight += finalExamW;
			finalWS = finalExamScore * finalExamW;
			System.out.print("Do you know your lab average ?");
			answer = input.next();
		}

		else {
			System.out.print("Do you know your lab average? ");
			answer = input.next();
			exam2W = 0;
			finalExamW = 0;

		}

		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))

		{
			System.out.print("Average Lab Grade: ");
			labAv = input.nextInt();
			totalKnownGradeWeight += labsW;
			labWS = labAv * labsW;
			System.out.print("Do you know your project average? ");
			answer = input.next();
		}

		else if (!(answer.equalsIgnoreCase("yes")) || !(answer.equalsIgnoreCase("y"))) {

			System.out.print("Do you know your project average? ");
			answer = input.next();
			labsW = 0;
		}

		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))

		{

			System.out.print("Average Project Grade: ");
			projectAv = input.nextInt();
			totalKnownGradeWeight += projectsW;
			projectWS = projectAv * projectsW;
			System.out.print("Do you know your quiz average? ");
			answer = input.next();

		} else if (!(answer.equalsIgnoreCase("yes")) || !(answer.equalsIgnoreCase("y"))) {

			System.out.print("Do you know your quiz average? ");
			answer = input.next();
			projectsW = 0;
		}

		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))

		{
			System.out.print("Average Quiz Grade: ");
			quizAv = input.nextInt();
			totalKnownGradeWeight += quizzesW;
			quizWS = quizAv * quizzesW;
			System.out.print("Do you know your attendance average? ");
			answer = input.next();
		}

		else if (!(answer.equalsIgnoreCase("yes")) || !(answer.equalsIgnoreCase("y"))) {

			System.out.print("Do you know your attendance average? ");
			answer = input.next();
			quizzesW = 0;
		}

		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))

		{
			System.out.print("Average Attendance Grade: ");
			attendanceAv = input.nextInt();
			totalKnownGradeWeight += attendanceW;
			attendanceWS = attendanceAv * attendanceW;
		}

		else if (!(answer.equalsIgnoreCase("yes")) || !(answer.equalsIgnoreCase("y"))) {

			attendanceW = 0;
		}

		input.close(); // closes the scanner

		// calculations for current grade

		knownWeightScore = (exam1WS + exam2WS + finalWS + labWS + projectWS + quizWS + attendanceWS);

		currentScore = ((double) knownWeightScore) / totalKnownGradeWeight;

		System.out.println("Current Grade Score: " + (Math.round(currentScore * 100.0)) / 100.0);

		String currentGrade;

		// calculating current letter grade
		if (currentScore >= 90)

		{

			currentGrade = "A";
		} else if (currentScore >= 80)

		{

			currentGrade = "B";
		} else if (currentScore >= 70)

		{

			currentGrade = "C";
		}

		else if (currentScore >= 60) {

			currentGrade = "D";
		}

		else {

			currentGrade = "F";
		}

		double avgToFinalLetterGrade = 0;

		// out put to the screen, informs user of the current grade and if their desired
		// grade was met or is not attainable

		System.out.println("Your current letter grade is a " + currentGrade);

		if (currentGrade.equals(desiredGrade)) {
			System.out.println("Congratulations! You received the " + desiredGrade + " that you wanted!");
			System.exit(0);
		}

		else if (totalKnownGradeWeight == 100)

		{
			if (desiredGrade.equals("A"))

			{
				if (currentScore >= 90 && currentScore <= 100) {
					System.out.println("You already have an A in the course");
				}

				else {
					System.out.println("Sorry, you cannot receive an A in the course");
				}
			}

			else if (desiredGrade.equals("B")) {
				if (currentScore >= 80 && currentScore <= 89)

				{
					System.out.println("You already have a B in the course");
				}

				else {
					System.out.println("Sorry, you cannot receive a B in the course");
				}
			}

			else if (desiredGrade.equals("C")) {
				if (currentScore >= 70 && currentScore <= 79) {
					System.out.println("You already have a C in the course");
				}

				else {
					System.out.println("Sorry, you cannot receive a C in the course");
				}
			}

			else if (desiredGrade.equals("D")) {
				if (currentScore >= 60 && currentScore <= 69) {
					System.out.println("You already have a D in the course");

				}

				else {
					System.out.println("Sorry, you cannot receive a D in the course");
				}
			}

			else if (desiredGrade.equals("F")) {
				if (currentScore >= 0 && currentScore <= 59) {
					System.out.println("You already have a F in the course");

				}

				else {
					System.out.println("Sorry you cannot receive a F in the course");
				}
			}

		}

		else {
			avgToFinalLetterGrade = (double) ((100 * finalOverallScore) - (knownWeightScore)) // equation to calculate
																								// the score needed to
																								// obtain the desired
																								// grade
					/ (100 - totalKnownGradeWeight);
			avgToFinalLetterGrade = (Math.round(avgToFinalLetterGrade * 100.0)) / 100.0;
		}

		if (avgToFinalLetterGrade > 100) {
			System.out.println("Sorry, you cannot receive an " + desiredGrade + " in the course");

		}

		else if (avgToFinalLetterGrade < 0) {
			System.out.println("Congratulations! You already have the grade you want in the course");
		}

		else {
			System.out.println("You have to score an average greater than or equal to " + avgToFinalLetterGrade
					+ " in the \nremaining grade items to receive an " + desiredGrade + " in the course");
		}
	}

}
