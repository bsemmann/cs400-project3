// --== CS400 File Header Information ==--
// Name: Sriram Alla
// Email: salla@wisc.edu
// Team: FF
// TA: Abhay Kumar
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Cities {
    CS400Graph<String> cities; // graph to store the cities in our map

    /**
     * Constructor to read through the text file and create a graph of cities. This
     * code should work properly with all of our implementations of dijkstra's
     * algorithm.
     * 
     */

    public Cities() {
        try {
            cities = new CS400Graph<>();
            File file = new File("Cities.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String names[] = line.split(","); // splitting the lines in the file which is comma-separated

                if (!(cities.containsVertex(names[0])) || !(cities.containsVertex(names[1]))) { // add a vertex to the
                                                                // graph only if it does
                                                        // not already exist
                                                            // in the graph to
                                                        // prevent duplicate
                                                        // vertices
                    cities.insertVertex(names[0]);
                    cities.insertVertex(names[1]);
                }

                cities.insertEdge(names[0], names[1], Integer.parseInt(names[2])); // add the edges to the graph
            }
            sc.close();
        } catch (FileNotFoundException e) { // if file given above does not exist
            System.out.println("File could not be found!");
        }
    }
}