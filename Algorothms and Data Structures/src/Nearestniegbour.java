import java.awt.geom.Point2D;
import java.util.ArrayList;
// Nearest Neighbour Class
public class Nearestniegbour {
	public static ArrayList<Point2D> letour(ArrayList<Point2D> citieslist){
		// Set and initialise variables
		double distance;
		double obtaineddistance = 0.00;
		Point2D closest = null;
		ArrayList<Point2D> cities = new ArrayList<Point2D>();
		cities = citieslist;//cities – a data structure containing all cities
		ArrayList<Point2D> result = new ArrayList<Point2D>();//result – a list of cities in the order they are to be visited
		Point2D currentCity = cities.remove(0); //Use the first city in cities as a starting point
		while (cities.size() >0) // Repeat until all cities have been added
		{
			result.add(currentCity); //Add current city to the result
			distance = 99999.99;// Infinity 
			// For all the possible cities
			for (Point2D possible:cities)
			{
				// If the distance between he current city and the possible city is less than the distance then
				if (Point2D.distance(currentCity.getX(), currentCity.getY(), possible.getX(), possible.getY()) < distance)
				{
					// Make the distance between he current city and the possible city is less than the distance equal to a variable
					obtaineddistance = Point2D.distance(currentCity.getX(), currentCity.getY(), possible.getX(), possible.getY());
					// Make the closest city equal to the possible city
					closest = possible;
					// Make distance equal to the obtained distance 
					distance = obtaineddistance;	
				}		
			}
			cities.remove(closest);//Remove the closest city so we don’t consider it angain
			currentCity = closest; // The closest city is now the current city
		}
		result.add(currentCity); //Add current city to the result to complete the data set
		//End while
		// Then return the final results
		return result;
	}
}
