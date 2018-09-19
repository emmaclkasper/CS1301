/*
* ClassifyMessage.java
* Author: Emma Kasper
* Submission Date: 13 September 2017 
* Purpose: A brief paragraph description of the program. 
* This program takes user input and categorizes each emergency according
* to the first word of the statement. It gives what kind of emergency, 
* what the original statement was, a brief description of the emergency, 
* the location of the emergency, and whether the location is within 
* a given range of coordinates. 
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

// Importing java scanner to allow user input from the keyboard

import java.util.Scanner;

public class ClassifyMessage {

	// Declaration of Constants

	enum MessageCategory { NEED, OFFER, ALERT, INFO, UNKNOWN};

	public static final double SOUTH = 39.882343;
	public static final double NORTH = 40.231315;
	public static final double WEST = -105.743511;
	public static final double EAST = -104.907864;

	public static void main(String[] args) {

		// declaring variables
		String catString, payload;
		MessageCategory category;
		double latitude, longitude;
		boolean isInRange;

		// prompting user for information
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter a formatted message:");

		catString = keyboard.next();
		latitude = keyboard.nextDouble();
		longitude = keyboard.nextDouble();
		payload = keyboard.nextLine().trim();

		keyboard.close();

		// comparing strings

		if (catString.equalsIgnoreCase("fire") || catString.equalsIgnoreCase("smoke"))

		{
			category = MessageCategory.ALERT;

		} else if (catString.equalsIgnoreCase("need"))

		{
			category = MessageCategory.NEED;

		}
		
		else if (catString.equalsIgnoreCase("structure") || catString.equalsIgnoreCase("road") || catString.equalsIgnoreCase("photo") || catString.equalsIgnoreCase("evac"))
		{
			category = MessageCategory.INFO;
			
		}

		else if (catString.equalsIgnoreCase("offer"))
		
		{
			category = MessageCategory.OFFER;

		} else 
		
		{
			category = MessageCategory.UNKNOWN;

		}

		if (latitude >= SOUTH && (latitude <= NORTH) && (longitude >= WEST && longitude <= EAST))

		{
			isInRange = true;

		} else 
		
		{
			isInRange = false;

		}

		// printing outputs

		System.out.println("Category:" + "\t" + category);
		System.out.println("Raw Cat:" + "\t\t" + catString);
		System.out.println("Message:" + "\t\t" + payload);
		System.out.println("Latitude:" + "\t" + latitude);
		System.out.println("Longitude:" + "\t" + longitude);
		System.out.println("In Range:" + "\t" + isInRange);

	}

}
