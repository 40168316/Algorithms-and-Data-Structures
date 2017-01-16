import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Myalgorithm {
	// This method gets the distance between the 5 points
	public static double gettingthedistaance(ArrayList<Point2D> cities, int h){
		// This method calculates the distance between points 1 and 2, 2 and 3, 3 and 4, 4 and 5 then adds them all together and returns the overall length
		double thelength = 0.0, onetwolength = 0.0, twothreelength = 0.0, threefourlength =0.0, fourfivelength =0.0;
		onetwolength = Point2D.distance(cities.get(h-2).getX(), cities.get(h-2).getY(), cities.get(h-1).getX(), cities.get(h-1).getY());
		twothreelength = Point2D.distance(cities.get(h-1).getX(), cities.get(h-1).getY(), cities.get(h).getX(), cities.get(h).getY());
		threefourlength = Point2D.distance(cities.get(h).getX(), cities.get(h).getY(), cities.get(h+1).getX(), cities.get(h+1).getY());
		fourfivelength = Point2D.distance(cities.get(h+1).getX(), cities.get(h+1).getY(),cities.get(h+2).getX(), cities.get(h+2).getY());
		thelength = onetwolength + twothreelength + threefourlength + fourfivelength;
		return thelength;
	}

	// This method switches points h-2 and h-1 or A and B
	public static ArrayList<Point2D> abswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h-2);
		cities.set(h-2, cities.get(h-1));
		cities.set(h-1, temp);
		return cities;
	}
	
	// This method switches points h-2 and h or A and C
	public static ArrayList<Point2D> acswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h-2);
		cities.set(h-2, cities.get(h));
		cities.set(h, temp);
		return cities;
	}
	
	// This method switches points h-2 and h+1 or A and D
	public static ArrayList<Point2D> adswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h-2);
		cities.set(h-2, cities.get(h+1));
		cities.set(h+1, temp);
		return cities;
	}
	
	// This method switches points h-2 and h+1 or A and E
	public static ArrayList<Point2D> aeswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h-2);
		cities.set(h-2, cities.get(h+2));
		cities.set(h+2, temp);
		return cities;
	}
	
	// This method switches points h-1 and h or B and C
	public static ArrayList<Point2D> bcswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h-1);
		cities.set(h-1, cities.get(h));
		cities.set(h, temp);
		return cities;
	}
	
	// This method switches points h-1 and h+1 or B and D
	public static ArrayList<Point2D> bdswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h-1);
		cities.set(h-1, cities.get(h+1));
		cities.set(h+1, temp);
		return cities;
	}
	
	// This method switches points h-1 and h+2 or B and E
	public static ArrayList<Point2D> beswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h-1);
		cities.set(h-1, cities.get(h+2));
		cities.set(h+2, temp);
		return cities;
	}
	
	// This method switches points h and h+1 or C and D
	public static ArrayList<Point2D> cdswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h);
		cities.set(h, cities.get(h+1));
		cities.set(h+1, temp);
		return cities;
	}
	
	// This method switches points h and h+2 or C and E
	public static ArrayList<Point2D> ceswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h);
		cities.set(h, cities.get(h+2));
		cities.set(h+2, temp);
		return cities;
	}
	
	// This method switches points h+1 and h+2 or D and E
	public static ArrayList<Point2D> deswitch(ArrayList<Point2D> cities, int h)
	{
		Point2D temp;
		temp = cities.get(h+1);
		cities.set(h+1, cities.get(h+2));
		cities.set(h+2, temp);
		return cities;
	}
	
	// This method finds switch between 5 points is the smallest, and then reapply the switch to the data set
	public static void findwhichlengthisthesmallest(double smallestswitch, double abswitchlength, double acswitchlength, double adswitchlength, double aeswitchlength, 
			double bcswitchlength, double bdswitchlength, double beswitchlength, double ceswitchlength, double cdswitchlength, double deswitchlength, ArrayList<Point2D> cities, int h)
	{
		// If the smallest value out of all the switches is equal to the abswitch
		if (smallestswitch == abswitchlength)
		 {
			// Reapply the switch
			 abswitch(cities, h);
		 }
		// This is then continued for ever possibility
		 if (smallestswitch == acswitchlength)
		 {
			 acswitch(cities, h);
		 }
		 if (smallestswitch == adswitchlength)
		 {
			 adswitch(cities, h);
		 }
		 if (smallestswitch == aeswitchlength)
		 {
			 aeswitch(cities, h);
		 }
		 if (smallestswitch == bcswitchlength)
		 {
			 bcswitch(cities, h);
		 }
		 if (smallestswitch == bdswitchlength)
		 {
			 bdswitch(cities, h);
		 }
		 if (smallestswitch == beswitchlength)
		 {
			 beswitch(cities, h);
		 }
		 if (smallestswitch == ceswitchlength)
		 {
			 ceswitch(cities, h);
		 }
		 if (smallestswitch == cdswitchlength)
		 {
			 cdswitch(cities, h);
		 }
		 if (smallestswitch == deswitchlength)
		 {
			 deswitch(cities, h);
		 }
	}
	
	// This method is the main method of the class and where the algorithm is executed
	public static ArrayList<Point2D> Mysolution(ArrayList<Point2D> citieslist){
		// The vreation of the cities arraylist which will hold the cities 
		ArrayList<Point2D> cities = new ArrayList<Point2D>();
		// Make cities arraylis equal to the input data
		cities = citieslist;
		// Initialise variables
		int loop = 0;
		double startlength = 0.0, endlength = 0.0, originallength = 0.0;
		// Get the start length of the overall route
		startlength = Routelengths.routeLength(cities);
		// The start of a do while loop which runs while the endlength is lower than the startlength
		do
		{
			// Only make the startlength equal to the endlength after one loop or greater
			if (loop > 0)
			{
				startlength = endlength;
			}
			// Create a for loop making h equal 2 as we need access to h-2 which is 
			for (int h =2; h < cities.size()-2; h++){	
				// Obtain the oringial length between the 5 cities
				 originallength = gettingthedistaance(cities, h);
				 
				 // Carry out a switch of the 5 points - This case is an a b switch or h-2 and h-1
				 abswitch(cities, h);
				 // Get the new length between the 5 points
				 double abswitchlength = gettingthedistaance(cities, h);
				 // Get the new overall length of the whole data set with this switch applied
				 double abendlength = Routelengths.routeLength(cities);
				 // Undo the switch
				 abswitch(cities, h);
				 
				 // Repeat for all other 9 possibilities 
				 acswitch(cities, h);
				 double acswitchlength = gettingthedistaance(cities, h);
				 double acendlength = Routelengths.routeLength(cities);
				 acswitch(cities, h);
				 
				 adswitch(cities, h);
				 double adswitchlength = gettingthedistaance(cities, h);
				 double adendlength = Routelengths.routeLength(cities);
				 adswitch(cities, h);
				 
				 aeswitch(cities, h);
				 double aeswitchlength = gettingthedistaance(cities, h);
				 double aeendlength = Routelengths.routeLength(cities);
				 aeswitch(cities, h);
				 
				 bcswitch(cities, h);
				 double bcswitchlength = gettingthedistaance(cities, h);
				 double bcendlength = Routelengths.routeLength(cities);
				 bcswitch(cities, h);
				 
				 bdswitch(cities, h);
				 double bdswitchlength = gettingthedistaance(cities, h);
				 double bdendlength = Routelengths.routeLength(cities);
				 bdswitch(cities, h);
				 
				 beswitch(cities, h);
				 double beswitchlength = gettingthedistaance(cities, h);
				 double beendlength = Routelengths.routeLength(cities);
				 beswitch(cities, h);
				 
				 cdswitch(cities, h);
				 double cdswitchlength = gettingthedistaance(cities, h);
				 double cdendlength = Routelengths.routeLength(cities);
				 cdswitch(cities, h);
				 
				 ceswitch(cities, h);
				 double ceswitchlength = gettingthedistaance(cities, h);
				 double ceendlength = Routelengths.routeLength(cities);
				 ceswitch(cities, h);
				 
				 deswitch(cities, h);
				 double deswitchlength = gettingthedistaance(cities, h);
				 double deendlength = Routelengths.routeLength(cities);
				 deswitch(cities, h);
				 
				 // Create a new array which stores the value of the switch combination lengths between 5 points
				 // Add in all the switched lengths to the array
				 double smallestpossibleswitch[] = new double [10];  
				 smallestpossibleswitch[0] = abswitchlength;
				 smallestpossibleswitch[1] = acswitchlength;
				 smallestpossibleswitch[2] = adswitchlength;
				 smallestpossibleswitch[3] = aeswitchlength;
				 smallestpossibleswitch[4] = bcswitchlength;
				 smallestpossibleswitch[5] = bdswitchlength;
				 smallestpossibleswitch[6] = beswitchlength;
				 smallestpossibleswitch[7] = cdswitchlength;
				 smallestpossibleswitch[8] = ceswitchlength;
				 smallestpossibleswitch[9] = deswitchlength;
				 
				 // Create a new array which stores the value of the overall length combinations of the switches between the whole data set
				 // Add all the lengths to the array
				 double smallestlength[] = new double [10];  
				 smallestlength[0] = abendlength;
				 smallestlength[1] = acendlength;
				 smallestlength[2] = adendlength;
				 smallestlength[3] = aeendlength;
				 smallestlength[4] = bcendlength;
				 smallestlength[5] = bdendlength;
				 smallestlength[6] = beendlength;
				 smallestlength[7] = cdendlength;
				 smallestlength[8] = ceendlength;
				 smallestlength[9] = deendlength;
				 
				 // Set smallestswitch to the first value of smallestpossibleswitch and set index to 0
				 double smallestswitch = smallestpossibleswitch[0];
				 int index = 0;
				 // Create a for loop which loops through to find the smallest possible switched
				 for (int i = 0; i < smallestpossibleswitch.length; i++)
				 {
					 // If the smallest possible switch is lower the the current smallest switch then
					 if (smallestpossibleswitch[i] < smallestswitch)
					 {
						 // Make smallest switch equal to the smallest possible switch 
						 smallestswitch = smallestpossibleswitch[i];
						 // Importantly make i equal to index
					     index = i;
					 }
				 }
				 // Whatever the smallest switched length between 5 points is, use the index of that value to get the smallest overall length between all the points in the dataset
				 endlength = smallestlength[index];
				 // If the smallestlength between 5 points is less than the original length between 5 points AND if the starting length between all the points is more than the end length with the smallest switch between 5 points applied then
				 // Both these statements are need because even though the smallest length between 5 points is lower than the original length between 5 points, it can increase the overall distance 
				 if(smallestswitch < originallength && endlength < startlength){
					 // Find the smallest switch between the 5 points and re apply the switch to the data set
					 findwhichlengthisthesmallest(smallestswitch, abswitchlength, acswitchlength, adswitchlength, aeswitchlength, bcswitchlength, bdswitchlength, beswitchlength, ceswitchlength, cdswitchlength, deswitchlength, cities, h);	 
				 }
			} 
			// Get the overall endlength which is the distance between all the cities/points
			endlength = Routelengths.routeLength(cities);
			// Increment the loop
			loop++;
			// Print to help show working
			//System.out.println(startlength + " - " + endlength + " so the overall distance decreases by " + (startlength - endlength));
			// Loop while the endlength, which is the length of all of the points at the end of the algorithm, smaller than all of the points at the start of the algorithm
		}while (endlength < startlength);	
		// Return the results once complete
		return cities;
	}
}