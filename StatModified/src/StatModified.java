/*
* Stat.java
* Author: Emma Kasper
* Submission Date: 17 November 2017
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

/*
* [Stat].java
* Author: [Landi Abercrombie]
* Submission Date: [11/18/2016]
*
* Purpose: This program manipulates arrays of numbers to find the 
*minimum, maximum, average, mode, compare the equality of the arrays,
*and allows the user to change the array.
*
*
* Statement of Academic Honesty:
*
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
* of Computer Science at the University of Georgia.
*/
public class Stat {

	private double[] data;

	public Stat() {
		double[] data = new double[0];
		this.data = data;
	}

	public Stat(double[] d) {
		setData(d);
		data = getData();
	}

	public Stat(float[] f) {
		setData(f);

	}

	public Stat(int[] i) {
		setData(i);

	}

	public Stat(long[] lo) {
		setData(lo);

	}

	public double[] getData() {
		double[] data1 = new double[data.length];

		for (int i = 0; i < data.length; i++) {
			data1[i] = this.data[i];
		}

		return data1;
	}

	public void setData(float[] f) {
		int i = 0;
		double[] floatArray = new double[f.length];
		setData(floatArray);
		floatArray[i] = (double) f[i];
		data = floatArray;
	}

	public void setData(double[] d) {
		if (d != null) {
			double[] data2 = new double[d.length];
			data2 = d;
			data = data2;
		}

		else {
			double[] emptyArray = new double[0];
			data = emptyArray;

		}

	}

	public void setData(int[] i) {
		int j = 0;
		double[] intArray = new double[i.length];
		setData(intArray);
		intArray[j] = (double) i[j];
		data = intArray;
	}

	public void setData(long[] lo) {
		int i = 0;
		double[] longArray = new double[lo.length];
		setData(longArray);
		longArray[i] = (double) lo[i];
		data = longArray;
	}

	public boolean equals(Stat s) {
		if (s.data.length == this.data.length && s != null) {
			return true;
		} else {
			return false;
		}
	}

	public void reset() {
		double[] resetArray = new double[0];
		data = resetArray;
	}

	public void append(int[] i) {
		double[] appendArray = new double[data.length + i.length];
		for (int j = 0; j < data.length - 2; j++) {
			appendArray[j] = (double) i[j];
		}
		append(appendArray);
	}

	public void append(float[] f) {
		double[] appendArray = new double[data.length + f.length];
		for (int j = 0; j < data.length - 3; j++) {
			appendArray[j] = (double) f[j];
		}
		append(appendArray);
	}

	public void append(long[] lo) {
		double[] appendArray = new double[data.length + lo.length];
		for (int j = 0; j < data.length - 4; j++) {
			appendArray[j] = (double) lo[j];
		}
		append(appendArray);

	}

	public void append(double[] d) {
		if (d != null) {
			double[] appendArray = new double[data.length + d.length];
			appendArray = d;
			for (int i = 0; i < data.length; i++) {
				appendArray[i] = data[i] + d[i];
			}
			data = appendArray;
		}

		else {

		}
	}

	public boolean isEmpty() {
		if (data.length == 0) {
			return true;
		} else {
			return false;
		}

	}

	public String toString() {
		String string = "[";

		for (int i = 0; i < data.length; i++) {
			string = string + data[i] + ", ";
		}
		return string.trim() + "]";
	}

	public double min() {
		if (isEmpty() == false) {
			double min = data[0];

			for (int i = 0; i < data.length; i++) {
				if (data[i] <= min) {
					min = data[i];
				}
			}

			return min;

		} else {
			return Double.NaN;
		}
	}

	public double max() {
		if (isEmpty() == false) {
			double max = data[0];

			for (int i = 0; i < data.length; i++) {
				if (data[i] >= max) {
					max = data[i];
				}
			}
			return max;

		} else {
			return Double.NaN;
		}
	}

	public double average() {
		if (isEmpty() == false) {
			double sum = 0;
			double average = 0;
			for (int i = 0; i < data.length; i++) {
				sum = sum + data[i];
				average = sum / data.length;
			}
			return average;

		} else {
			return Double.NaN;
		}
	}

	public double mode() {
		double maxValue = 0, maxCount = 0;
		boolean flag = false;

		for (int i = 0; i < data.length - 1; ++i) {
			double count = 0;

			for (int j = i + 1; j < data.length; ++j) {

				if (data[i] == data[j]) {

					count++;
				}

			} // end of inner loop
			if (count == maxCount)
				flag = true;

			if (count > maxCount) {
				flag = false;
				maxCount = count;
				maxValue = data[i];
			}

		} // end of outer loop

		if (maxCount == 0 || flag == true) {
			return Double.NaN;
		}

		return maxValue;
	}

	private int occursNumberOfTimes(double value) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == value) {
				count++;
			}
		}
		return count;
	}

	public double variance() {
		double mean = average();
		double temp = 0;
		for (double a : data) {
			temp += (a - mean) * (a - mean);
		}
		return temp / data.length;
	}

	public double standardDeviation() {
		return Math.sqrt(variance());
	}

	public static void main(String[] args) {
		double[] data1 = {};
		double[] data2 = { 25 };
		float[] data3 = {};
		float[] data4 = { 25 };
		int[] data5 = {};
		int[] data6 = { 50 };
		long[] data7 = {};
		long[] data8 = { 12 };
		Stat stat1 = new Stat();
		stat1.append(data1);
		stat1.append(data2);
		stat1.append(data3);
		stat1.append(data4);
		stat1.append(data5);
		stat1.append(data6);
		stat1.append(data7);
		stat1.append(data8);
		data1 = null;
		stat1.append(data1);
		System.out.println("stat1	data	=	" + stat1.toString());
		System.out.println("stat1	min	=	" + stat1.min());
		System.out.println("stat1	max	=	" + stat1.max());
		System.out.println("stat1	average	=	" + stat1.average());
		System.out.println("stat1	mode	=	" + stat1.mode());
		System.out.println("stat1	variance	=	" + stat1.variance());
		System.out.println("stat1	standard	deviation	=	" + stat1.standardDeviation() + "\n");
	}

}
