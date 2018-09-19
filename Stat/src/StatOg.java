
/*
* Stat.java
* Author: Emma Kasper
* Submission Date: 10 November 2017
* Purpose: This program takes an array of data and manipulates it to 
* return the values of the array. It returns the minimum value, maximum
* value, average of the array, and the mode. The equals method compares 2 arrays
* to see if they are identical or not. 
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

public class StatOg {

	private double[] data;

	// default constructor creates a double array having a single element of 0.0
	public StatOg() {
		data = new double[] { 0.0 };
	}

	// constructs a stat object using values in d. constructor creates double array
	// of the same length
	// as d and holds copies of what is in d. A reference to the new array is
	// assigned to data
	public StatOg(double[] d) {

		data = new double[d.length];
		for (int i = 0; i < d.length; i++) {
			data[i] = d[i];
		}

	}

	// retrieves the values of data, should create a new array containing the values
	// in data and return this reference
	public double[] getData()

	{
		double[] newGetData = new double[data.length];

		for (int i = 0; i < data.length; i++) {
			newGetData[i] = data[i];
		}
		return newGetData;
	}

	// set the values of data array. creates a new array containing elements of d
	// and assign to data a reference
	// of this array
	public void setData(double[] d) {
		if (data.length == 0) {
			data = new double[0];

		}

		else {
			data = new double[d.length];
			for (int i = 0; i < d.length; i++) {
				data[i] = d[i];
			}
		}

	}

	public void reset() {
		data = new double[0];
	}

	// returns true if the data objects have the same values and in same order else
	// returns false
	public boolean equals(StatOg s) {

		boolean isTrue = true;
		double[] equalsArray = s.getData();

		if (data.length != equalsArray.length) {
			isTrue = false;
		}
		for (int i = 0; i < data.length; i++) {
			if (data[i] != equalsArray[i])
				isTrue = false;
		}
		return isTrue;

	}

	// returns a string representation of the dara elements stored in the stat
	// object
	public String toString() {

		String temp = "[";

		for (int i = 0; i < data.length; i++) {
			temp = temp + data[i];
			if (i < data.length - 1) {
				temp = temp + ", ";
			}
		}
		return temp + "]";

	}

	// returns minimum of the data array
	public double min() {

		if (data.length == 0) {
			return Double.NaN;
		}

		double min = data[0];

		for (int i = 1; i < data.length; i++) {
			if (min > data[i]) {
				min = data[i];
			}
		}
		return min;

	}

	// returns the maximum of the data array
	public double max() {
		if (data.length == 0) {
			return Double.NaN;
		}
		double max = data[0];

		for (int i = 1; i < data.length; i++) {
			if (max < data[i]) {
				max = data[i];
			}
		}
		return max;
	}

	// returns the average of the data array
	public double average() {

		if (data.length == 0) {
			return Double.NaN;
		}

		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i];
		}
		return sum / data.length;
	}

	// returns the value that occurs most frequently otherwise returns NaN
	public double mode() {

		if (data.length == 0) {
			return Double.NaN;
		}

		if (data.length == 1) {
			return data[0];
		}

		if (data.length == 2) {
			if (data[0] == data[1]) {
				return data[0];
			} else {
				return Double.NaN;
			}

		}

		double[] newVal = new double[data.length];
		int[] occurrence = new int[data.length];

		int index = 0;

		for (int i = 0; i < data.length; i++) {

			boolean found = false;
			for (int j = 0; j < index; j++) {
				if (data[i] == newVal[j]) {

					found = true;
					occurrence[j]++;

					break;
				}
			}
			if (!found) {

				newVal[index] = data[i];
				occurrence[index] = 1;
				index++;
			}
		}

		int max = occurrence[0];
		int maxIndex = 0;
		for (int i = 1; i < index; i++) {
			if (occurrence[i] > max) {
				max = occurrence[i];
				maxIndex = i;
			}
		}

		int maxCount = 0;
		for (int i = 0; i < index; i++) {
			if (occurrence[i] == max)
				maxCount++;
		}

		if (maxCount == 1) {
			return newVal[maxIndex];
		} else {
			return Double.NaN;
		}

	}

	public static void main(String[] args) {

		double[] data1 = { 10.0, 20.0, 30.0 };
		StatOg stat1 = new StatOg();
		stat1.setData(data1);
		StatOg stat2 = new StatOg(data1);
		double[] data2 = stat1.getData();

		System.out.println("The arrays are identical: " + (data1 == data2));
		System.out.println("Stat2 equals stat1: " + stat2.equals(stat1));
		System.out.println("stat 1 equals stat2: " + stat2.equals(stat1));
	}

}
