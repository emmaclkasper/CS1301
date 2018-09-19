import java.util.Scanner;

public class MainRubric {

	/* class level variables */
	
	public static final String options = "Pick an option:\n"
			+ "1. List houses for sale\n"
			+ "2. Buy a house\n"
			+ "3. Sell your house.\n"
			+ "4. Show your profile.\n"
			+ "5. Exit\n";

	public static void main(String[] args) {
		
		// Instantiate houses array and the scanner
		Scanner scan = new Scanner(System.in);
		House [] houses = new House[3];
		
		//populate 3 hard-coded houses & person
		houses[0] = new House(House.Color.RED, 2000.0, 10.0, 10.0, 10.0);
		houses[1] = new House(House.Color.BLUE, 15000.256, 20, 20, 20);
		houses[2] = new House(House.Color.YELLOW, 30000.33, 50, 45, 40);

		Person user = new Person("Mr. Rubric", 25, 20000.12345);
		
		//Show profile
		System.out.println("\n----------Test 1 (Person Constructor & toString): ");
		System.out.println(user);
		
		//Check House Constructor - print first house
		System.out.println("\n----------Test 2 (House Constructor): ");
		System.out.println(houses[0]);	
		
		
		//Try to sell house
		System.out.println("\n----------Test 3 (sellHome() when house is null): ");
		user.sellHome();
		
		System.out.println();
		//Buy too expensive house
		System.out.println("\n----------Test 4 (buyHouse() for house you can't afford): ");
		user.buyHouse(houses[2]);
		System.out.println(user);
		
		//Resetting user in-case buying expensive house failed
		user = new Person("Mr. Rubric", 25, 20000.12345);
		
		//Buy affordable house
		System.out.println("\n----------Test 5 (buyHouse() success): ");
		user.buyHouse(houses[1]);
		System.out.println(user);
		
		//Try to buy another affordable house
		System.out.println("\n----------Test 6 (buyHouse() when you already own one): ");
		user.buyHouse(houses[0]);
		System.out.println(user);
		
		//Sell house
		System.out.println("\n----------Test 7 (sellHome() success): ");
		user.sellHome();
		
		//View Profile
		System.out.println(user);


		//Test constructor with House parameter
		System.out.println("\n----------Test 8 (Person Constructor with House param.): \n");
		House myHouse = new House(House.Color.RED, 2000.0, 10.0, 10.0, 10.0);
		user = new Person("Mr. Rubric", 30, 2000, myHouse);
		System.out.print("isForSale set to false: ");
			if(!myHouse.isForSale())
				System.out.println("Passed \n");
			else
				System.out.println("Failed \n");
		System.out.println(user);
		
		System.out.println("\n----------Test 9 (Equals method): \n");

		
		System.out.print("Equals method test: ");
			if(myHouse.equals(houses[0]))
				System.out.println("Passed");
			else
				System.out.println("Failed");
			
		//Default Person constructor
		System.out.println("\n----------Test 10 (default Person constructor): ");
		user = new Person();
		System.out.println(user);
		
		System.out.println("\n----------Test 11 (House volume & area): ");
		System.out.print("Volume test: ");
			if(houses[0].volume() == 1000.0)
				System.out.println("Passed");
			else
				System.out.println("Failed");
		System.out.print("Area test: ");
			if(houses[0].area() == 100.0)
				System.out.println("Passed");
			else
				System.out.println("Failed");

		
	}
}
