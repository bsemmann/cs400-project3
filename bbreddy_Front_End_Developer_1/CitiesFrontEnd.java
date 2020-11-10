// --== CS400 File Header Information ==--
// Name: <Bhuvanesh Reddy Bathala>
// Email: <bbreddy@wisc.edu email address>
// Team: <the team name: ff>
// Role: <Front End Engineer>
// TA: <Abhaya Kumar>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
import java.util.*;
import java.util.List;

public class CitiesFrontEnd {
  static CitiesBackEnd city = new CitiesBackEnd();// declaring a CitiesBackEnd object
  static CS400Graph obj = new CS400Graph();
  static Cities city2 = new Cities();

  public static void main(String[] args) {
    try {
      System.out.println("****************************************************");
      System.out.println("Welcome to Interactive Map Of Wisconsin");
      System.out.println("Choose an Option to get Started");
      System.out.println("1->Get shortest route to your destination");
      System.out.println("2->Get distance to your destination");
      System.out.println("3->Get travel time to your destination");
      System.out.println("4->Get random destination");
      System.out.println("****************************************************");
      Scanner input = new Scanner(System.in);// declaring a scanner object

      int option = input.nextInt();// inputing an integer
      if (option != 1 && option != 2 && option != 3 && option != 4) {
        throw new NoSuchElementException("no number ");//throws exception if user inputs number 
                                                       //other than 1,2,3,4
      }
      if (option == 1) { // checking if the option is equal to 1
        System.out.println("Choose Starting point");
        String startPoint = input.nextLine();// inputting the user's initial location
        startPoint = input.nextLine();
        if ((city.cityGraph.containsVertex(startPoint)) == false) {
          throw new NoSuchElementException("no initialpoint ");//throws exception if location not in
                                                              //graph 
        }
        System.out.println("Choose Destination");// inputting the user's destination
        String destination = input.nextLine();
        // destination = input.nextLine();
        if ((city.cityGraph.containsVertex(destination)) == false) {
          throw new NoSuchElementException("no destination ");//throws exception if destination not 
                                                             // in graph
        }
        System.out.println("****************************************************");
        System.out.println("The shortest route to your destination is");
        List<String> route = option1(startPoint, destination);// storing the route in a list
        System.out.println(route);
        System.out.println("****************************************************");
        System.out.println("Choose 0 to end and 1 to continue");
        option = input.nextInt();// inputing an integer
        if (option != 1 && option != 0 ) {
          throw new NoSuchElementException("Not able to continue ");//throws exception if user inputs number 
          //other than 0,1
        }
        System.out.println("****************************************************");
        if (option == 0) {
          System.out.println("Have a Great Trip. Bye!!");
          System.out.println("****************************************************");
        }
        if (option == 1) {
          System.out.println("What do you want to do next");
          System.out.println("1->Get shortest route to your path");
          System.out.println("2->Get Distance to your destination");
          System.out.println("3->Get TravelTime to your destination");
          System.out.println("4->Get Random Destination");
          option = input.nextInt();// inputing an integer
          if (option != 1 && option != 2 && option != 3 && option != 4) {
            throw new NoSuchElementException("no number ");//throws exception if user inputs number 
            //other than 1,2,3,4
          }
          System.out.println("****************************************************");
        }
      }

      if (option == 2) {
        System.out.println("Choose Starting point");
        String startPoint = input.nextLine();// inputting the user's initial location
        startPoint = input.nextLine();
        if ((city.cityGraph.containsVertex(startPoint)) == false) {
          throw new NoSuchElementException("no initialpoint ");//throws exception if location not in
          //graph 
        }
        System.out.println("Choose Destination point");
        String destination = input.nextLine();
        
        if ((city.cityGraph.containsVertex(destination)) == false) {
          throw new NoSuchElementException("no destination ");//throws exception if destination not 
          // in graph
        }
        System.out.println("****************************************************");
        System.out.println("The distance to your destination is");
        int distance = option2(startPoint, destination);// getting the distance between
        // initial point to final point
        System.out.println(distance + " miles");
        System.out.println("****************************************************");
        System.out.println("Choose 0 to end and 1 to continue");

        option = input.nextInt();// inputing an integer
        if (option != 1 && option != 0 ) {
          throw new NoSuchElementException("no number ");//throws exception if user inputs number 
          //other than 0,1
        }
        System.out.println("****************************************************");
        if (option == 0) {
          System.out.println("Have a Great Trip. Bye!!");
          System.out.println("****************************************************");
        }
        if (option == 1) {
          System.out.println("What do you want to do next");
          System.out.println("1->Get shortest route to your path");
          System.out.println("2->Get Distance to your destination");
          System.out.println("3->Get TravelTime to your destination");
          System.out.println("4->Get Random Destination");
          option = input.nextInt();// inputing an integer
          if (option != 1 && option != 2 && option != 3 && option != 4) {
            throw new NoSuchElementException("no number ");//throws exception if user inputs number 
            //other than 1,2,3,4
          }
          System.out.println("****************************************************");
        }

      }

      if (option == 3) {
        System.out.println("Choose Starting point");
        String startPoint = input.nextLine();// inputting the user's initial location
        startPoint = input.nextLine();
        if ((city.cityGraph.containsVertex(startPoint)) == false) {
          throw new NoSuchElementException("no initialpoint ");//throws exception if location not in
          //graph 
        }
        System.out.println("Choose Destination point");
        String destination = input.nextLine();
        // destination = input.nextLine();
        if ((city.cityGraph.containsVertex(destination)) == false) {
          throw new NoSuchElementException("no destination ");//throws exception if destination not 
          // in graph
        }
        System.out.println("Input your speed in mph");
        int speed = input.nextInt();
        if(speed<0) {
          throw new NoSuchElementException(" Impossible speed");
        }
        System.out.println("****************************************************");
        System.out.println("The time taken in minutes to reach your destination is");
        int travelTime = option3(city.getDistance(startPoint, destination), speed);// calling
                                                                                   // option3 method
                                                                                   // to
        // get time required to
        // cover the distance
        System.out.println(travelTime + " min");
        System.out.println("****************************************************");
        System.out.println("Choose 0 to end and 1 to continue");
        option = input.nextInt();// inputing an integer
        if (option != 1 && option != 0 ) {
          throw new NoSuchElementException("no number ");//throws exception if user inputs number 
          //other than 0,1
        }
        System.out.println("****************************************************");
        if (option == 0) {
          System.out.println("Have a Great Trip. Bye!!");
          System.out.println("****************************************************");
        }
        if (option == 1) {
          System.out.println("What do you want to do next");
          System.out.println("1->Get shortest route to your path");
          System.out.println("2->Get Distance to your destination");
          System.out.println("3->Get TravelTime to your destination");
          System.out.println("4->Get Random Destination");
          option = input.nextInt();// inputing an integer
          if (option != 1 && option != 2 && option != 3 && option != 4) {
            throw new NoSuchElementException("no number ");//throws exception if user inputs number 
            //other than 1,2,3,4
          }
          System.out.println("****************************************************");
        }

      }

      if (option == 4) {
        System.out.println("Choose Starting point");
        String startPoint = input.nextLine();// inputting the user's initial location
        startPoint = input.nextLine();
        if ((city.cityGraph.containsVertex(startPoint)) == false) {
          throw new NoSuchElementException("no initialpoint ");
        }
        System.out.println("****************************************************");
        System.out.println("The Random Location is");
        String randomLocation = option4(startPoint);// getting random city
        System.out.println(randomLocation);
        System.out.println("****************************************************");
        System.out.println("The route to random location is");
        List<String> route = option1(startPoint, randomLocation);// getting random city
        System.out.println(route);
        System.out.println("****************************************************");
        System.out.println("The distance to random location is");
        int distance = option2(startPoint, randomLocation);// getting random city
        System.out.println(distance + " miles");
        System.out.println("****************************************************");
        System.out.println("The time to reach the location");
        System.out.println("Input your Speed");
        int speed = input.nextInt();
        if(speed<0) {
          throw new NoSuchElementException(" Impossible speed");//throws exception when negative
                                                                //number is input
        }
        int time = option3(distance, speed);// getting random city
        System.out.println(time + " min");
        System.out.println("****************************************************");
        System.out.println("Choose 0 to end and 1 to continue");
        option = input.nextInt();// inputing an integer
        if (option != 1 && option != 0 ) {
          throw new NoSuchElementException("no number ");//throws exception if user inputs number 
          //other than 0,1
        }
        System.out.println("****************************************************");
        if (option == 0) {
          System.out.println("Have a Great Trip. Bye!!");
          System.out.println("****************************************************");
        }
        if (option == 1) {
          System.out.println("What do you want to do next");
          System.out.println("1->Get shortest route to your path");
          System.out.println("2->Get Distance to your destination");
          System.out.println("3->Get TravelTime to your destination");
          System.out.println("4->Get Random Destination");
          option = input.nextInt();// inputing an integer
          if (option != 1 && option != 2 && option != 3 && option != 4) {
            throw new NoSuchElementException("no number ");//throws exception if user inputs number 
            //other than 1,2,3,4
          }
          System.out.println("****************************************************");
          
        }
      }
    } catch (NoSuchElementException e) {
      System.out.println(e);

    }
  }

  /**
   * get the shortest route between points
   *
   * @param startpoint  initial destination from where user starts
   * @param destination point to be reached
   * @return the shortest route between points
   */
  private static List<String> option1(String startpoint, String destination) {

    List<String> route = city.getRoute(startpoint, destination);// get the shortest route between
                                                                // points
    return route;// return the route
  }

  /**
   * get the distance between points
   *
   * @param startpoint  initial destination from where user starts
   * @param destination point to be reached
   * @return the distance between points
   */
  private static int option2(String startpoint, String destination) {

    int distance = city.getDistance(startpoint, destination);// get distance between 2 points
    return distance;// return the distance
  }

  /**
   * To get the time taken to reach the destination
   *
   * @param distance between 2 points
   * @param speed    at which user is traveling
   * @return time taken to reach the destination
   */
  private static int option3(int distance, int speed) {

    int time = city.getTravelTime(distance, speed);// get the travel time
    return time;// returning the time taken to reach the destination
  }

  /**
   * Get a random location
   *
   * @param startpoint location from where user is starting
   * @return random location
   */
  private static String option4(String startpoint) {

    String randomLocation = city.getRandomDestination(startpoint);// get random location
    return randomLocation;// return the location
  }
}
