// --== CS400 File Header Information ==--
// Name: Brian Semmann
// Email: bsemmann@wisc.edu
// Team: FF
// TA: Abhay
// Role: Front End Engineer
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.List;
import java.util.Scanner;

/**
 * This class allows for a user to interact with the map of Wisconsin, providing a handful of
 * options for the user to view information about distance between cities, route and travel
 * time.
 * 
 * @author Brian Semmann
 *
 */
public class FrontEndWisconsinMap {

	
	  /**
	   * Prompts the user for a value by displaying prompt.
	   *
	   * After prompting the user, the method will consume an entire line of input while reading an
	   * String and return that string to the desired variable.
	   *
	   * @param sc     The Scanner instance to read from System.in.
	   * @param prompt The name of the value for which the user is prompted.
	   * @return Returns the value read from the user.
	   */	
	public static String promptString(Scanner sc, String prompt) {
	      String next; // first valid integer token will be stored here
	      String inputVal = null; // do-while loop runs until this is no longer null

	      do {
	          // start each loop cycle by showing user prompt
	          System.out.print(prompt);

	          if (!sc.hasNext()) {
	              sc.nextLine();
	              continue; // jump back to beginning of the loop
	          }
	         
	          next = sc.nextLine();

	          inputVal = next;
	          sc.nextLine();
	         

	      } while (inputVal == null);

	      return inputVal;
	  }
	
	  /**
	   * Prompts the user for a value by displaying prompt.
	   *
	   * After prompting the user, the method will consume an entire line of input while reading an
	   * int. If the value read is between min and max (inclusive), that value is returned. Otherwise,
	   * "Invalid value." terminated by a new line is output and the user is prompted again.
	   *
	   * @param sc     The Scanner instance to read from System.in.
	   * @param prompt The name of the value for which the user is prompted.
	   * @param min    The minimum acceptable int value (inclusive).
	   * @param max    The maximum acceptable int value (inclusive).
	   * @return Returns the value read from the user.
	   */
	public static int promptInt(Scanner sc, int min, int max) {
	      Integer nextInt; // first valid integer token will be stored here
	      Integer inputVal = null; // do-while loop runs until this is no longer null

	      do {
	          // start each loop cycle by showing user prompt

	          // when first token isn't an integer, output error msg and consume line of input
	          if (!sc.hasNextInt()) {
	              System.out.println("Please enter a number between " + min + " and " + max + ".");
	              sc.nextLine();
	              continue; // jump back to beginning of the loop
	          }

	          // first token on the line is an integer, so read it in
	          nextInt = sc.nextInt();

	          // int token is within min and max, save it to inputVal to break out of the loop
	          if (nextInt >= min && nextInt <= max) {
	              inputVal = nextInt;
	              sc.nextLine();
	          }

	          // int token is not within min and max, output error msg and consume line of input
	          else {
	              System.out.println("Please enter a number between " + min + " and " + max + ".");
	              sc.nextLine(); // inputVal is still null, so loop will continue
	          }

	      } while (inputVal == null);

	      return inputVal;
	  }
	
	
	/**
	 * Main method for FrontEndWisconsinMap.java that takes in user input using a scanner and displays
	 * options and requested information to the user.
	 * 
	 * @param args not used by this program.
	 */
	public static void main(String[] args) {
		CitiesBackEnd cbe = new CitiesBackEnd();
		Scanner scnr = new Scanner(System.in);
		Cities cities = new Cities();
		
		CS400Graph map = cities.cities;
		
		String startCity;
		String destination;
		int choice;
		String startPrompt = "What city are you coming from?";
		String endPrompt = "What city do you want to travel too?";
		
		System.out.println("****************************************************\n"
		        + "Welcome to the interactive map of Wisconsin!");
		System.out.println("(Type exit anytime to exit the map)");
		System.out.println();
		
		startCity = promptString(scnr, startPrompt);
		
		while (!startCity.equalsIgnoreCase("exit")) {
			
			System.out.println("Would you like to input a destination or get a random one?");
			System.out.println("(Enter 1 for input/2 for random)");
			choice = promptInt(scnr,1,2);
			if (choice == 1) {
				destination = promptString(scnr, endPrompt);
			} else {
				destination = cbe.getRandomDestination(startCity);
				System.out.println("Your random destination is " + destination);
			}
			System.out.println();
			System.out.println("What would you like to know about this route?");
			System.out.println("1. Distance between cities");
			System.out.println("2. Shortest route from start city to destination");
			System.out.println("3. Time it will take you to get to your destination");
			
			
			choice = promptInt(scnr,1,3);
			
			if (choice == 1) {
				System.out.println();
				System.out.println("The distance between " + startCity + " and " + destination +
						" is " + cbe.getDistance(startCity, destination) + " miles.");
				System.out.println();
				
				
			} else if (choice == 2) {
				List<String> list = cbe.getRoute(startCity, destination);
				System.out.println();
				System.out.println("The route to your destination is: ");
				for (int i = 0; i < list.size(); ++i) {
					System.out.println((i+1) + ") " + list.get(i));
				}
				System.out.println();
			} else {
				System.out.println();
				System.out.println("How fast do you plan to be traveling? (in MPH)");
				int milesPerHour = scnr.nextInt();
				int time = cbe.getTravelTime(cbe.getDistance(startCity, destination), milesPerHour);
				System.out.println("It will take you " + time + " minutes to get from " + startCity
						+ " to " + destination + ", if you were traveling at " 
						+ milesPerHour + " miles per hour.");
				System.out.println();
			}
			
			
			
			
			startCity = promptString(scnr, startPrompt);
		}
		
		
		System.out.println("\nClosing the interactive Wisconsin map.\n"
		        + "****************************************************");
		
		scnr.close();
	}
}
