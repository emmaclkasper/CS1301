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
// CircleTester.java
//
//
//  A client to test the functionality of objects
//  of the class Circle
// 
//*******************************************************
public class CircleTester {

	public static void main(String[] args) {

		Circle circle1 = new Circle(0.0, 0.0, 2);
		Circle circle2 = new Circle(2.0, 1.0, 1);
		circle1.setX(0.0);
		circle1.setY(0.0);
		circle1.setRadius(2);
		circle2.setX(2.0);
		circle2.setY(1.0);
		circle2.setRadius(1);

		System.out.println("Circle 1");
		System.out.println(circle1);
		System.out.println();

		System.out.println("Circle 2");
		System.out.println(circle2);

		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		//
		circle1.setRadius(-2.0);

		//
		// Reset the center of circle1 (-3.0,4.0)
		//
		circle1.setX(-3.0);
		circle1.setY(4.0);

		// print circle1 characteristics (center and radius), use a statement
		// similar
		// to the previous println statements. Note that is not necessary to
		// call
		// the method toString, why?
		System.out.println();
		System.out.println("Circle 1");
		System.out.println(circle1.toString());
		System.out.println();

		// set the circle2 radius to 5.3
		circle2.setRadius(5.3);

		// print circle2 characteristics (center and radius), use a statement
		// similar to the first and
		// second println statements

		System.out.println("Circle 2:");
		System.out.println(circle2.toString());
		System.out.println();

		// print circle1 diameter, area and perimeter
		System.out.println("Circle 1");
		System.out.println("Diameter = " + circle1.diameter());
		System.out.println("Area = " + circle1.area());
		System.out.println("Perimeter = " + circle1.perimeter());
		System.out.println();

		// print circle2 diameter, area and perimeter
		System.out.println("Circle 2");
		System.out.println("Diameter = " + circle2.diameter());
		System.out.println("Area = " + circle2.area());
		System.out.println("Perimeter = " + circle2.perimeter());
		System.out.println();

		// display whether circle1 is a unit circle
		System.out.println("Circle 1 is a unit circle = " + circle1.isUnitCircle());

		// display whether circle2 is a unit circle
		System.out.println("Circle 2 is a unit circle = " + circle2.isUnitCircle());
		System.out.println();
		
		
		// your additional tests should be placed below here
		// test for equals method
		circle1.setX(2);
		circle1.setY(1);
		circle1.setRadius(5.3);
		System.out.println("Circle 1");
		System.out.println(circle1);
		System.out.println();
		System.out.println("Circle 2");
		System.out.println(circle2);
		System.out.println("Circle 1 equals circle 2 = " + circle1.equals(circle2)); 
		System.out.println();// will print true
																						
		// testing for isConcentric method
		circle1.setRadius(2.4); // anything but 5.3 will cause to print true
		System.out.println("Circle 1 and circle 2 are concentric = " + circle1.isConcentric(circle2));
		System.out.println();

		// testing for distance
		circle1.setX(3);
		circle1.setY(4);
		System.out.println("The distance between circle 1 and circle 2 is = " + circle1.distance(circle2));
		System.out.println();// will

		// testing for intersection
		circle1.setRadius(4);
		circle2.setRadius(4);
		System.out.println("The circles intersect: " + circle1.intersects(circle2));

	}

}
