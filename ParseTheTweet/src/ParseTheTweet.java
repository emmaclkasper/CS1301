/*
* ParseTheTweet.java
* Author: Emma Kasper
* Submission Date: 06 September 2017
* Purpose: A brief paragraph description of the program. 
* This program takes a statement entered by the user and breaks it up into 
* categories that are distinguised by #s and its respective value. Using the string class 
* and methods I was able to pull out substrings of the statement and categorize those 
* substrings into variables. When the variables are printed, a more organized and detailed
* version of the statement is given. 
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

public class ParseTheTweet {

	public static void main(String[] args)

	{
		// Declaring string and int variables
		String tweet, typ, det, loc, lat, lng;
		int start, finish;

		// Gathering user input
		Scanner input = new Scanner(System.in);
		tweet = input.nextLine();
		input.close();

		// Retrieving substring for type
		System.out.println("");
		System.out.print("Type:\t\t");
		start = tweet.indexOf('#');
		finish = tweet.indexOf(';');
		typ = tweet.substring(start + 4, finish);
		typ = typ.trim().toUpperCase();

		System.out.println(typ + "\n");

		// Retrieving substring for detail
		System.out.print("Detail:\t\t");
		tweet = tweet.substring(finish + 1).trim();
		start = tweet.indexOf("#");
		finish = tweet.indexOf(';');
		det = tweet.substring(start + 4, finish);
		det = det.trim().replace(",", ".");
		System.out.println(det + "\n");

		// Retrieving substring for location
		System.out.print("Location:\t");
		tweet = tweet.substring(finish + 1).trim();
		start = tweet.indexOf('#');
		finish = tweet.indexOf(';');
		loc = tweet.substring(start + 4, finish);
		loc = loc.trim().replace(',', '-');
		System.out.println(loc + "\n");

		// Retrieving substring for latitude
		System.out.print("Latitude:\t");
		tweet = tweet.substring(finish + 1).trim();
		start = tweet.indexOf('#');
		finish = tweet.indexOf(';');
		lat = tweet.substring(start + 4, finish);
		lat = lat.trim();
		System.out.println(lat + "\n");

		// Retrieving substring for longitude
		System.out.print("Longitude:\t");
		tweet = tweet.substring(finish + 1).trim();
		start = tweet.indexOf('#');
		finish = tweet.indexOf(';');
		lng = tweet.substring(start + 4, finish);
		lng = lng.trim();
		System.out.println(lng);

	}

}
