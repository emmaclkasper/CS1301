
/*
* Stat.java
* Author: Emma Kasper
* Submission Date: 17 November 2017
* Purpose: This program takes an array of data and manipulates it to 
* return the values of the array. It returns the minimum value, maximum
* value, average of the array, and the mode. The equals method compares 2 arrays
* to see if they are identical or not. 
* Stat2ement of Academic Honesty: 
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

import java.util.Arrays;

public class Stat {

	private double[] data;

	// default constructor, creates a double array with length 0
	public Stat() {
		data = new double[0];
	}

	// Constructs a stat object using the values held in the parameter array.
	// Creates a
	// double array of the same length as the parameter array and holds copies.
	public Stat(double[] d) {
		if (d == null) {
			data = new double[0];
			return;
		}
		double[] array = new double[d.length];
		if (d != null) {
			for (int i = 0; i < array.length; i++) {
				array[i] = d[i];
			}
		}
		data = array;
	}

	public Stat(float[] f) {
		double[] array = new double[f.length];
		if (f != null) {
			for (int i = 0; i < array.length; i++) {
				array[i] = f[i];
			}
		}
		data = array;
	}

	public Stat(int[] i) {
		double[] array = new double[i.length];
		if (i != null) {
			for (int x = 0; x < array.length; x++) {
				array[x] = i[x];
			}
		}
		data = array;
	}

	public Stat(long[] lo) {
		double[] array = new double[lo.length];
		if (lo != null) {
			for (int i = 0; i < array.length; i++) {
				array[i] = lo[i];
			}
		}
		data = array;
	}

	// set the values of data array. creates a new array containing elements of d
	// and assign to data a reference
	// of this array
	public void setData(double[] d) {
		if (d != null) {
			data = new double[d.length];
			for (int i = 0; i < d.length; i++) {
				data[i] = d[i];
			}
		}
		if (d == null) {
			data = new double[0];
		}
	}

	public void setData(float[] f) {
		data = new double[f.length];
		if (f != null) {
			for (int i = 0; i < f.length; i++) {
				data[i] = f[i];
			}
		}
	}

	public void setData(int[] i) {
		data = new double[i.length];
		if (i != null) {
			for (int x = 0; x < i.length; x++) {
				data[x] = i[x];
			}
		}
	}

	public void setData(long[] lo) {
		data = new double[lo.length];
		if (lo != null) {
			for (int i = 0; i < lo.length; i++) {
				data[i] = lo[i];
			}
		}
	}

	// retrieves the values of data, should create a new array containing the values
	// in data and return this reference
	public double[] getData() {
		return data;
	}

	// returns true if the data objects have the same values and in same order else
	// returns false
	public boolean equals(Stat s) {
		boolean equals = false;
		if (s == null || s.data.length == 0) {
			if (data == null) {
				return true;
			} else {
				return false;
			}
		}
		for (int i = 0; i < data.length; i++) {
			if (this.data[i] == s.data[i]) {
				equals = true;
				continue;
			} else
				equals = false;
			break;
		}
		if (this.data.length != s.data.length) {
			equals = false;
		}
		return equals;
	}

	// Clears the data array, a new empty double array is created and assigned to
	// data
	public void reset() {
		double[] array = new double[0];
		data = array;
	}

	// These methods create a new double array containing exactly those elements of
	// data
	// followed by those of the array passed as a parameter
	public void append(double[] d) {
		if (d == null) {
			return;
		}
		double[] array = new double[data.length + d.length];
		if (d != null) {
			int i = 0;
			while (i < data.length) {
				array[i] = data[i];
				i++;
			}
			int j = 0;
			while (j < d.length) {
				array[j + data.length] = d[j];
				j++;
			}
		}
		data = array;
	}

	public void append(int[] i) {
		double[] array = new double[data.length + i.length];
		int x = 0;
		while (x < data.length) {
			array[x] = data[x];
			x++;
		}
		int j = 0;
		while (j < i.length) {
			array[j + data.length] = i[j];
			j++;
		}
		data = array;
	}

	public void append(float[] f) {
		double[] array = new double[data.length + f.length];
		int i = 0;
		while (i < data.length) {
			array[i] = data[i];
			i++;
		}
		int j = 0;
		while (j < f.length) {
			array[j + data.length] = f[j];
			j++;
		}
		data = array;
	}

	public void append(long[] lo) {
		double[] array = new double[data.length + lo.length];
		int i = 0;
		while (i < data.length) {
			array[i] = data[i];
			i++;
		}
		int j = 0;
		while (j < lo.length) {
			array[j + data.length] = lo[j];
			j++;
		}
		data = array;
	}

	// returns the boolean value true if the data object is created and assigned to
	// data
	public boolean isEmpty() {
		if (data.length == 0)
			return true;
		else
			return false;
	}

	// returns a string representation of the dara elements stored in the stat
	// object
	public String toString() {
		String dataString = Arrays.toString(data);
		return dataString;

	}

	// Returns the minimum of the data array
	public double min() {
		if (data.length == 0) {
			return Double.NaN;
		}
		double min = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] < min) {
				min = data[i];
			}
		}
		return min;
	}

	// Returns the maximum of the data array
	public double max() {
		if (data.length == 0) {
			return Double.NaN;
		}
		double max = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		return max;
	}

	// Returns the average of the data array
	public double average() {
		if (data.length == 0) {
			return Double.NaN;
		}
		double sum = 0;
		for (int i = 0; i < data.length; i++)
			sum = sum + data[i];
		double average = sum / data.length;
		return average;
	}

	// returns the value that occurs most frequently otherwise returns NaN
	public double mode() {
		if (data.length == 0) {
			return Double.NaN;
		}
		Arrays.sort(data);
		double mode = 0.0;
		double maxCount = 0.0;
		for (int i = 0; i < data.length; i++) {
			int count = 0;
			int j = i;
			while (j < data.length) {
				if (data[i] == data[j]) {
					count++;
					j++;
				} else {
					break;
				}
			}

			if (count > maxCount) {
				maxCount = count;
				mode = data[i];
			} else if (count == maxCount) {
				maxCount = count;
				mode = Double.NaN;
			}
		}

		return mode;
	}

	// returns the number of times the value occurs in the data array
	private int occursNumberOfTimes(double value) {
		int count = 0;
		int i = 0;
		for (i = 0; i < data.length; i++) {
			if (data[i] == value)
				count++;
		}
		return count;
	}

	// returns the variance of the data in the data array
	public double variance() {
		if (data.length == 0) {
			return Double.NaN;
		}
		double[] variances = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			variances[i] = Math.pow((data[i] - average()), 2);
		}
		double sum = 0;
		for (int i = 0; i < data.length; i++)
			sum = sum + variances[i];
		double variance = sum / variances.length;
		return variance;
	}

	// Returns the square root of the variance, if the array is empty, then should
	// return NaN
	public double standardDeviation() {
		if (data.length == 0) {
			return Double.NaN;
		}
		double standardDeviation = Math.sqrt(variance());
		return standardDeviation;
	}

	public static void main(String[] args) {
		// Example 1

		// double[] data1 = {};
		// Stat stat1 = new Stat(data1);
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " +
		// stat1.standardDeviation());
		// System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

		// Example 1 output
		//
		// stat1 data = []
		// stat1 min = NaN
		// stat1 max = NaN
		// stat1 average = NaN
		// stat1 mode = NaN
		// stat1 variance = NaN
		// stat1 standard deviation = NaN
		// stat1 is empty = true
		//
		// Example 2
		// double[] data1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// Stat stat1 = new Stat(data1);
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " +
		// stat1.standardDeviation());
		// System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");
		// stat1.reset();
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " +
		// stat1.standardDeviation());
		// System.out.println("stat1 is empty = " + stat1.isEmpty() + "\n");

		// Example 2 output
		//
		// stat1 data = [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
		// stat1 min = 1.0
		// stat1 max = 9.0
		// stat1 average = 5.0
		// stat1 mode = NaN
		// stat1 variance = 6.666666666666667
		// stat1 standard deviation = 2.581988897471611
		// stat1 is empty = false
		// stat1 data = []
		// stat1 min = NaN
		// stat1 max = NaN
		// stat1 average = NaN
		// stat1 mode = NaN
		// stat1 variance = NaN
		// stat1 standard deviation = NaN
		// stat1 is empty = true
		//
		//
		// Example 3
		// float[] data1 = {10.0F,10.0F};
		// Stat stat1 = new Stat(data1);
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " + stat1.standardDeviation()
		// + "\n");
		// long[] data2 = {80L, 60L};
		// stat1.append(data2);
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " + stat1.standardDeviation()
		// + "\n");

		// Example 3 output
		// stat1 data = [10.0, 10.0]
		// stat1 min = 10.0
		// stat1 max = 10.0
		// stat1 average = 10.0
		// stat1 mode = 10.0
		// stat1 variance = 0.0
		// stat1 standard deviation = 0.0
		// stat1 data = [10.0, 10.0, 80.0, 60.0]
		// stat1 min = 10.0
		// stat1 max = 80.0
		// stat1 average = 40.0
		// stat1 mode = 10.0
		// stat1 variance = 950.0
		// stat1 standard deviation = 30.822070014844883
		//
		//
		// Example 4
		//
		// double[] data = {-5.3, 2.5, 88.9, 0, 0.0, 28, 16.5, 88.9, 109.5, -90, 88.9};
		// Stat stat1 = new Stat();
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.append(data);
		// System.out.println("stat1 has been altered.");
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " + stat1.standardDeviation()
		// + "\n");

		// Example 4 output
		// stat1 data = []
		// stat1 has been altered.
		// stat1 data = [-5.3, 2.5, 88.9, 0.0, 0.0, 28.0, 16.5, 88.9, 109.5, -90.0,
		// 88.9]
		// stat1 min = -90.0
		// stat1 max = 109.5
		// stat1 average = 29.80909090909091
		// stat1 mode = 88.9
		// stat1 variance = 3192.369917355372
		// stat1 standard deviation = 56.50106120556827
		//
		// example 5
		//
		// double[] data1 = {50.0, 60.0};
		// float[] data2 = {70.0F, 80.0F};
		// int[] data3 = {90, 100};
		// long[] data4 = {100L, 110L};
		// Stat stat1 = new Stat();
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.setData(data1);
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.setData(data2);
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.setData(data3);
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.setData(data4);
		// System.out.println("stat1 data = " + stat1.toString());
		// data1 = null;
		// stat1.setData(data1);
		// System.out.println("stat1 data = " + stat1.toString());

		// example 5 output
		// stat1 data = []
		// stat1 data = [50.0, 60.0]
		// stat1 data = [70.0, 80.0]
		// stat1 data = [90.0, 100.0]
		// stat1 data = [100.0, 110.0]
		// stat1 data = []
		//
		// example 6
		// double[] data1 = {50.0, 60.0};
		// float[] data2 = {70.0F, 80.0F};
		// int[] data3 = {90, 100};
		// long[] data4 = {100L, 110L};
		// Stat stat1 = new Stat();
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.append(data1);
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.append(data2);
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.append(data3);
		// System.out.println("stat1 data = " + stat1.toString());
		// stat1.append(data4);
		// System.out.println("stat1 data = " + stat1.toString());
		// data1 = null;
		// stat1.append(data1);
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " + stat1.standardDeviation()
		// + "\n");

		// example 6 output
		// stat1 data = []
		// stat1 data = [50.0, 60.0]
		// stat1 data = [50.0, 60.0, 70.0, 80.0]
		// stat1 data = [50.0, 60.0, 70.0, 80.0, 90.0, 100.0]
		// stat1 data = [50.0, 60.0, 70.0, 80.0, 90.0, 100.0, 100.0, 110.0]
		// stat1 data = [50.0, 60.0, 70.0, 80.0, 90.0, 100.0, 100.0, 110.0]
		// stat1 min = 50.0
		// stat1 max = 110.0
		// stat1 average = 82.5
		// stat1 mode = 100.0
		// stat1 variance = 393.75
		// stat1 standard deviation = 19.84313483298443
		//
		// example 7
		// double[] data1 = {10,10};
		// int[] data2 = {10,10};
		// Stat stat1 = new Stat(data1);
		// Stat stat2 = new Stat(data2);
		// Stat stat3 = new Stat();
		// Stat stat4 = null;
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat2 data = " + stat2.toString());
		// System.out.println("stat2 data = " + stat2.toString());
		// System.out.println("stat1 equals stat2 = " + stat1.equals(stat2));
		// System.out.println("stat1 equals stat3 = " + stat1.equals(stat3));
		// System.out.println("stat1 equals stat4 = " + stat1.equals(stat4));
		//
		// example 7 output
		// stat1 data = [10.0, 10.0]
		// stat2 data = [10.0, 10.0]
		// stat2 data = [10.0, 10.0]
		// stat1 equals stat2 = true
		// stat1 equals stat3 = false
		// stat1 equals stat4 = false
		//
		// example 8
		//
		// double[] data1 = {};
		// double[] data2 = { 25 };
		// float[] data3 = {};
		// float[] data4 = { 25 };
		// int[] data5 = {};
		// int[] data6 = { 50 };
		// long[] data7 = {};
		// long[] data8 = { 12 };
		// Stat stat1 = new Stat();
		// stat1.append(data1);
		// stat1.append(data2);
		// stat1.append(data3);
		// stat1.append(data4);
		// stat1.append(data5);
		// stat1.append(data6);
		// stat1.append(data7);
		// stat1.append(data8);
		// data1 = null;
		// stat1.append(data1);
		// System.out.println("stat1 data = " + stat1.toString());
		// System.out.println("stat1 min = " + stat1.min());
		// System.out.println("stat1 max = " + stat1.max());
		// System.out.println("stat1 average = " + stat1.average());
		// System.out.println("stat1 mode = " + stat1.mode());
		// System.out.println("stat1 variance = " + stat1.variance());
		// System.out.println("stat1 standard deviation = " + stat1.standardDeviation()
		// + "\n");
		//
		// example 8 output
		// stat1 data = [25.0, 25.0, 50.0, 12.0]
		// stat1 min = 12.0
		// stat1 max = 50.0
		// stat1 average = 28.0
		// stat1 mode = 25.0
		// stat1 variance = 189.5
		// stat1 standard deviation = 13.765899897936205
	}
}
