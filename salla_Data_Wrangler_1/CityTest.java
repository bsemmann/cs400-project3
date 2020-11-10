
// --== CS400 File Header Information ==--
// Name: Kenneth Ring
// Email: kgring@wisc.edu
// Team: FF
// Role: Test Engineer 2
// TA: Abhay Kumar
// Lecturer: Gary Dahl
// Notes to Grader: N/A
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {

	Cities testCities; // Cities object that will be used to test the Cities class
	CitiesBackEnd testCBE; // CitiesBackEnd object that will be used to test the CitiesBackEnd class

	@BeforeEach
	/**
	 * Creates test objects for both Cities and CitiesBackEnd to test the
	 * functionality of both
	 */
	public void createCities() {
		testCities = new Cities(); // assigns a new Cities object to testCities
		testCBE = new CitiesBackEnd(); // assigns a new CitiesBackEnd object to testCBE
	}

	/**
	 * Tests if the Cities class correctly creates a graph by checking if the graph
	 * is null or not.
	 */
	@Test
	public void testCities() {
		assertTrue(testCities != null); // If the graph exists, the test passes.
	}

	/**
	 * A series of basic tests that look for the distance between two connected
	 * Cities. The purpose of which is to see if all the cities are properly loaded
	 * into the graph.
	 */
	@Test
	public void distanceTest() {
		assertTrue(testCBE.getDistance("Milwaukee", "Appleton") == 107); // Checks if the edge between Milwaukee and
																			// Appleton is 107
		assertTrue(testCBE.getDistance("Wausau", "Appleton") == 103); // Checks if the edge between Wausau and Appleton
																		// is 103
		assertTrue(testCBE.getDistance("Kenosha", "Janesville") == 71); // Checks if the edge between Kenosha and
																		// Janesville is 103
		assertTrue(testCBE.getDistance("La Crosse", "Eau Claire") == 85); // Checks if the edge between La Crosse and
																			// Eau Claire is 85
		assertTrue(testCBE.getDistance("Oshkosh", "Eau Claire") == 183); // Checks if the edge between Oshkosh and Eau
																			// Claire is 183
		assertTrue(testCBE.getDistance("Wausau", "Green Bay") == 97); // Checks if the edge between Wausau and GreenBay
																		// is 97
		assertTrue(testCBE.getDistance("Madison", "La Crosse") == 140); // Checks if the edge between Madison and La
																		// Crosse is 140
	}

	/**
	 * A series of basic tests that checks if the graph properly finds the correct
	 * route between two cities. The purpose of this is to see if all cities are
	 * loaded in the proper order.
	 */
	@Test
	public void routeTest() {
		assertTrue(testCBE.getRoute("Milwaukee", "Eau Claire").toString().equals("[Milwaukee, Oshkosh, Eau Claire]")); // Checks
																														// if
																														// the
																														// shortest
																														// path
																														// between
																														// Milwaukee
																														// and
																														// Eau
																														// Claire
																														// is
																														// correct
		assertTrue(testCBE.getRoute("Kenosha", "Green Bay").toString().equals("[Kenosha, Milwaukee, Green Bay]")); // Checks
																													// if
																													// the
																													// shortest
																													// path
																													// between
																													// Kenosha
																													// and
																													// Green
																													// Bay
																													// is
																													// correct\
		assertTrue(testCBE.getRoute("La Crosse", "Oshkosh").toString().equals("[La Crosse, Appleton, Oshkosh]")); // Checks
																													// if
																													// the
																													// shortest
																													// path
																													// between
																													// Kenosha
																													// and
																													// Green
																													// Bay
																													// is
																													// correct
	}

	/**
	 * Tests if the random destination method within the backend works correctly. It
	 * will test if the method does not lead to the same city as the parameter city.
	 */
	@Test
	public void testRandom() {
		assertTrue(!testCBE.getRandomDestination("Kenosha").equalsIgnoreCase("Kenosha")); // Tests if the random city
																							// function
																							// doesn't create a
																							// duplicate.
	}

	/**
	 * Tests the getTravelTime method in the backend that finds the time in minutes
	 * it takes to travel between cities at a certain speed.
	 */
	@Test
	public void testTime() {
		assertTrue(testCBE.getTravelTime(120, 60) == 120); // Tests if the time in minutes to travel 120 mi at 60 mph is
															// correct.
		assertTrue(testCBE.getTravelTime(107, 50) == 128); // Tests if the time in minutes to travel 107 mi at 50 mph is
															// correct.
	}

}