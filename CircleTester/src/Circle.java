/*
* ClassifyMessage.java
* Author: Emma Kasper
* Submission Date: 20 October 2017
* Purpose: this program shows how object oriented programming works. Using a circle class it
* tests if two circles are equal, concentric, calculates distance, and checks if they intersect
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

//*******************************************************
// Circle.java
//
// 
//*******************************************************
public class Circle {

	private double radius; // declare the private double instance radius
	private double x; // declare the private double instance x
	private double y; // declare the private double instance y

	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	// ----------------------------------------------
	// getX - returns the value of x
	// ----------------------------------------------
	public double getX() {

		// Your code goes here
		return x;
	}

	// ----------------------------------------------
	// getY - returns the value of y
	// ----------------------------------------------
	public double getY() {

		// Your code goes here
		return y;
	}

	// ----------------------------------------------
	// getRadius - returns the value of radius
	// ----------------------------------------------
	public double getRadius() {

		// Your code goes here
		return radius;
	}

	// ----------------------------------------------
	// setX - assigns a new value to x
	// ----------------------------------------------
	public void setX(double X) {

		// Your code goes here
		this.x = X;
	}

	// ----------------------------------------------
	// setY - assigns a new value to y
	// ----------------------------------------------
	public void setY(double Y) {

		// Your code goes here
		this.y = Y;
	}

	// ----------------------------------------------
	// setRadius - assigns a new value to radius
	// ----------------------------------------------
	public void setRadius(double Radius) {

		// Your code goes here
		if (Radius >= 0) {
			this.radius = Radius;
		}
	}

	// --------------------------------------------------------
	// diameter - calculates the diameter of the circle
	// --------------------------------------------------------
	public double diameter() {

		// Your code goes here
		double diameter = (2 * radius);
		return diameter;
	}

	// --------------------------------------------------------
	// area - returns the area of the circle
	// --------------------------------------------------------
	public double area() {

		// Your code goes here
		double area = ((Math.PI) * radius * radius);
		return area;
	}

	// --------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	// --------------------------------------------------------
	public double perimeter() {

		// Your code goes here
		double perimeter = (2 * (Math.PI) * radius);
		return perimeter;
	}

	// --------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	// is 1 and its center is (0,0) and false
	// otherwise.
	// --------------------------------------------------------
	public boolean isUnitCircle() {

		// Your code goes here
		boolean isUnitCircle;
		if (radius == 1 && x == 0 && y == 0) {
			isUnitCircle = true;
		} else {
			isUnitCircle = false;
		}

		return isUnitCircle;
	}

	// --------------------------------------------------------
	// toString - return a String representation of
	// this circle in the following format:
	// center:(x,y)
	// radius: r
	// --------------------------------------------------------
	public String toString() {

		// Your code goes here
		String z = "Center:(" + x + "," + y + ")" + "\n" + "Radius:" + radius;
		return z;
	}

	public boolean equals(Circle anotherCircle) {
		if (x == anotherCircle.x && y == anotherCircle.y && radius == anotherCircle.radius) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isConcentric(Circle anotherCircle) {
		if (x == anotherCircle.x && y == anotherCircle.y && radius != anotherCircle.radius) {
			return true;
		} else {
			return false;
		}
	}

	public double distance(Circle anotherCircle) {
		double distance = Math.sqrt(Math.pow(x - anotherCircle.x, 2) + Math.pow(y - anotherCircle.y, 2));
		return distance;

	}

	public boolean intersects(Circle anotherCircle) {
		if (distance(anotherCircle) < (radius + anotherCircle.radius)) {
			return true;
		} else {
			return false;
		}
	}

}
