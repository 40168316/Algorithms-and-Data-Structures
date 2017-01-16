import java.awt.geom.Point2D;
import java.util.ArrayList;

public class twoopt {
	// The 2-opt Algorithm
	public static ArrayList<Point2D> twooptalgorithm(ArrayList<Point2D> citieslist)
	{
		// Create an arraylist called results
		ArrayList<Point2D> results = new ArrayList<Point2D>(citieslist.size());
	    // Get the size of the data
	    double size = citieslist.size();
	    // Set improve to zero
	    int improve = 0;
	    // Create a while loop and keep going until improve is less than a value - Depends on the datasize the value may want to be larger
	    // as more than n amount of loops may be required to give an accurate result
	    while (improve < 2)
	    {
	    	// Get the best distance from the list of cities
	        double best_distance = Routelengths.routeLength(citieslist);
	        // Create a for loop to loop through the data
	        for ( int i = 0; i < size - 1; i++ ) 
	        {
	        	// Create a nested for loop to loop through the data
	            for ( int k = i + 1; k < size; k++) 
	            {
	            	// Call the swap method, which changes the results arraylist
	                results = theswap(i, k, citieslist);
	                // Get the new distance of the alter results arraylist
	                double new_distance = Routelengths.routeLength(results);
	                // If the altered new distance is less than the original best distance then 
	                if (new_distance < best_distance) 
	                {
	                    // Set improve back to zero
	                    improve = 0;
	                    // Make the results equal to the citieslist
	                    citieslist = results;
	                    // Make the best original distance equal to the new distance
	                    best_distance = new_distance;
	                }
	            }
	        }
	        // Increment improve for the while loop
	        improve++;
	    }
	    // Return citieslist once finished
	    return citieslist;
	}

	// Mehtod which carries out the swapping of points
	 public static ArrayList<Point2D> theswap(int i, int k, ArrayList<Point2D> citieslist) 
	 {
		 // Create a arraylist called results
		 ArrayList<Point2D> results = new ArrayList<Point2D>(citieslist.size());
		 // Get the size of the citieslist input data
	     int size = citieslist.size();
	     // Take route[0] to route[i-1] and add them in order to new_route
	     for (int c = 0; c <= i - 1; ++c)
	     {
	         results.add(c, citieslist.get(c));
	         //System.out.println(c);
	     }
	     //  Take route[i] to route[k] and add them in reverse order to new_route
	     int dec = 0;
	     for (int c = i; c <= k; ++c)
	     {
	         results.add(c, citieslist.get(k - dec));
	         dec++;

	     }
	     // Take route[k+1] to end and add them in order to new_route
	     for ( int c = k + 1; c < size; ++c )
	     {
	    	 results.add(c, citieslist.get(c));	 
	     }
	     // Return the results once done
	     return results;
	 }
}
