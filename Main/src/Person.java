import java.text.DecimalFormat;

/*
 * Person.java
 * Author: Emma Kasper
 * Submission Date: 11/03/17
 *
 * Purpose: This class simulates creates a person with the attributes of name, 
 * age, how much cash they have, and if they own a house. It either gathers user information, 
 * or defaults to constructor that I have written. This class returns all the details 
 * about a person and if they are able to purchase/sell a house. 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 CSCI 1301: Project 1 Page 3
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

/**
 * Class representing a person (a human user) on a real estate market. A person
 * has a name, age, cash, and (potentially) a house.
 */
public class Person {

	/* Instance variables */

	private String name;
	private int age;
	private double cash;
	private House house;

	/* Constructors */

	/**
	 * The Default constructor creates a 20 year old John L. with a penny of cash
	 * and no home.
	 */
	public Person() {

		this.name = "John L.";
		this.age = 21;
		this.cash = .01;
		this.house = null;

	}

	/**
	 * A second constructor that enables the creation of a custom instance of the
	 * Person class. The house instance variable is set to null.
	 * 
	 * @param name
	 *            : the person's name
	 * @param age
	 *            : the person's age
	 * @param cash
	 *            : the amount of money the person has
	 */
	public Person(String name, int age, double cash) {

		this.name = name;
		this.age = age;
		this.cash = cash;
		this.house = null;
	}

	/**
	 * A third constructor including a parameter for the persons house. The house is
	 * also updated because it is no longer for sale.
	 * 
	 * @param name
	 *            : the person's name
	 * @param age
	 *            : the person's age
	 * @param cash
	 *            : the amount of money the person has
	 * @param house
	 *            : the person's home
	 */
	public Person(String name, int age, double cash, House house) {

		this.name = name;
		this.age = age;
		this.cash = cash;
		this.house = house;
		house.setForSale(false);

	}

	/**
	 * Show the name and age of the person as well as their assets (cash and home if
	 * they have one). E.g. Name: John L. Age: 20 years old Cash: $ 0.01
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormatObj = (DecimalFormat) DecimalFormat.getInstance();
		decimalFormatObj.setMinimumFractionDigits(2);
		decimalFormatObj.setMaximumFractionDigits(2);

		String info;
		if (this.house == null) {
			info = "Name: " + this.name + "\nAge " + this.age + " years old" + "\nCash: $"
					+ decimalFormatObj.format(this.cash) + "\n";
		}

		else {
			info = "Name: " + this.name + "\nAge " + this.age + " years old" + "\nCash: $"
					+ decimalFormatObj.format(this.cash) + "\nHome: " + this.house.toString();
			;
		}

		return info;
	}

	/* Accessors / Getters */

	/**
	 * @return the person's name
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * @return the person's age
	 */
	public int getAge() {

		return this.age;
	}

	/**
	 * @return the amount of cash this person has
	 */
	public double getCash() {

		return this.cash;
	}

	/**
	 * @return a reference the house object currently owned by this person
	 */
	public House getHouse() {

		return this.house;
	}

	/**
	 * @return true if this person has a home
	 */
	public boolean ownsAHouse() {

		boolean ownsHouse;
		if (this.house == null) {
			ownsHouse = false;
		}

		else
			ownsHouse = true;

		return ownsHouse;
	}

	/* Mutators */

	/**
	 * @param amount
	 *            : the amount of cash to give this person
	 */
	public void addCash(double amount) {

		this.cash = this.cash + amount;
	}

	/**
	 * If this person owns home, put it up for sale and pay the person the price of
	 * the home.
	 */
	public void sellHome() {

		if (ownsAHouse() == true) {
			house.setForSale(true);
			double price = house.getPrice();
			addCash(price);
			this.house = null;
			System.out.println(this.name + " has sold their house to the market!");
		} else {
			System.out.println(this.name + " doesn't own a home");
		}

	}

	/**
	 * This method lets the person buy a home if they do not already have a home,
	 * have the cash and the home is for sale. If the person successfully buys a
	 * home, their cash is decreased by the cost of the home.
	 * 
	 * @param h
	 *            the house to be bought
	 */
	public void buyHouse(House h) {

		if (this.house == null) {
			double price = h.getPrice();
			if (getCash() > price) {
				if (h.isForSale() == true) {
					addCash(-price);
					this.house = h;
					h.setForSale(false);
					System.out.println(name + " is now a proud homeowner!");

				} else {
					System.out.println("House isn't for sale");
				}
			}

			else {
				System.out.println(this.name + " doesn't have enough cash");
			}

		} else {
			System.out.println(this.name + " already owns a home");
		}

	}
}
