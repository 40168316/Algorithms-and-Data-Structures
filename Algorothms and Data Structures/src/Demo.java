// Libraries used for either drawing the Polygon or the Data
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Demo {
	// Declaring variables all used for drawing the Polygon
	static int size;
	static int[] xvalues;
	static int[] yvalues;
	private JFrame mainMap;
    private Polygon poly;
    
	public Demo(){
		initComponents();
	}
	
	// Private method which create a JFrame and draws a Polygon to display the data
	private void initComponents() {
		// Create a new JFrame which is drawn on
		mainMap = new JFrame();
        mainMap.setResizable(false);
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Create arrays to store the x and y values of the points
        final int finalxposition[] = xvalues;
        final int finalyposition[] = yvalues;
        double scalex[] = new double [size];
        double scaley[] = new double [size];
        // Scale points
        for (int i=0; i<size; i++)
        {
        	// Cast point to double
        	scalex[i] = (double) finalxposition[i];
        	// Multiply by value to scale
        	scalex[i] = scalex[i]*0.5;
        	// Cast back to int as data must be int to be drawn
        	// Repeat for Y
        	finalxposition[i] = (int)scalex[i];
        	scaley[i] = (double) finalyposition[i];
        	scaley[i] = scaley[i]*0.5;
        	finalyposition[i] = (int)scaley[i];
        }
        // Add postions to the Polygon
        poly = new Polygon(finalxposition, finalyposition, finalxposition.length);
        // Set certain points to different colours to identify where the data starts and stops
        final Color[] colourpoint = new Color[size];
        colourpoint[0] = Color.GREEN;
        colourpoint[1] = Color.YELLOW;
        colourpoint[size-1] = Color.RED;
        
        // Create a new JPanel
        JPanel p = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i =0; i < size; i++)
                {
                	// Add all the points and give them appropriate colours
                	g.setColor(Color.BLACK);
                	g.drawOval(finalxposition[i]-3,finalyposition[i]-5, 10, 10);
                	g.setColor(Color.WHITE);
                	g.setColor(colourpoint[i]);
                	g.fillOval(finalxposition[i]-3,finalyposition[i]-5, 10, 10);
                }
                // Draw the Polygon
                g.setColor(Color.BLUE);
                g.drawPolygon(poly);
            }

			
            // Set Dimesnsions of the window
            public Dimension getPreferredSize() {
                return new Dimension(1000, 1000);
            }
        };
        // Set mouse properties
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                if (poly.contains(me.getPoint())) {
                    System.out.println("Clicked polygon");
                }
            }
        };
        p.addMouseListener(ma);
        mainMap.add(p);

        mainMap.pack();
        mainMap.setVisible(true);
    }
	
	// Method which adds the points to the x and y values array, which is later used to print the points and create a polygon
	public static void printdataset(ArrayList<Point2D> dataset)
	{
		size = dataset.size();
		xvalues = new int[size];
		yvalues = new int[size];
		for (int i=0; i<dataset.size(); i++)
		{
			xvalues[i] = (int)dataset.get(i).getX();
			yvalues[i] = (int)dataset.get(i).getY();
		}
	}
	
	// The mainmethod  where the program is run from
	public static void main(String[] args) {
		// Create an arraylist and read in the input values from the file
		long startTime = System.currentTimeMillis();
		ArrayList<Point2D> inputvalues = new ArrayList<Point2D>();
		inputvalues = DataLoader.loadTSPLib("F:\\FInal ADS Coursework\\Copy of ADS\\src\\berlin52.tsp");
		
		// Obtain the amount of input results
		double sizeofinputresults = inputvalues.size();
		
		//Remove any duplicates from the list
		Object[] st = inputvalues.toArray();
	    for (Object s : st) {
	    	if (inputvalues.indexOf(s) != inputvalues.lastIndexOf(s)) 
	    	{
	      		inputvalues.remove(inputvalues.lastIndexOf(s));
	      	}
	    }
	    
	    // Get information on the inputvalues
	    double inputvalueslength = Routelengths.routeLength(inputvalues);
		System.out.println("Inputvalues Default Length = " + inputvalueslength);
		
		// Get information on Nearest Neighbour
		long startTimeNearestNeighbour = System.currentTimeMillis();
		ArrayList<Point2D> Nearestneighbouroutput = Nearestniegbour.letour(inputvalues);
		double Nearesyneighbourlength = Routelengths.routeLength(Nearestneighbouroutput);
		long endTimeNearestNeighbour   = System.currentTimeMillis();
		long totalTimeNearestNeighbour = endTimeNearestNeighbour - startTimeNearestNeighbour;
		System.out.println("Nearest Neighbour Length = " + Nearesyneighbourlength + " and the time taken = " + totalTimeNearestNeighbour + "milliseconds");
		//printdataset(Nearestneighbouroutput);
		
		// Get information on my Algorithm
		long startTimeMyalgorith = System.currentTimeMillis();
		ArrayList<Point2D> Myalgorithmoutput = Myalgorithm.Mysolution(Nearestneighbouroutput);
	    double MyalgorithmLength = Routelengths.routeLength(Myalgorithmoutput);
		long endTimeMyalgorith   = System.currentTimeMillis();
		long totalTimeMyalgorith = endTimeMyalgorith - startTimeMyalgorith;
		System.out.println("My Random Length = " + MyalgorithmLength + " and the time taken = " + totalTimeMyalgorith + "milliseconds");
		printdataset(Myalgorithmoutput);
		
		// Get information on 2-opt Algorithm
		long startTimeTwoout = System.currentTimeMillis();
		ArrayList<Point2D> Twooutoutput = twoopt.twooptalgorithm(Nearestneighbouroutput);
		double Twooptlength = Routelengths.routeLength(Twooutoutput);
		long endTimeTwoout   = System.currentTimeMillis();
		long totalTimeTwoout = (endTimeTwoout - startTimeTwoout);
		System.out.println("Two-opt Length = " + Twooptlength + " and the time taken = " + totalTimeTwoout + "milliseconds");
		//printdataset(Twooutoutput);
		
		// Get the sizes of all the different Algorithms and print them to make sure none are missing
		double sizeofNearestNeighbour = Nearestneighbouroutput.size();
		double sizeofMyalgorithm = Myalgorithmoutput.size();
		double sizeofTwoopt = Twooutoutput.size();
		System.out.println("Input values size = " + sizeofinputresults + " Nearest Neighbour size = " + sizeofNearestNeighbour + " My Algorthim = " + sizeofMyalgorithm + " Two-opt = "  + sizeofTwoopt);
				
		// Run Polygon creation
		SwingUtilities.invokeLater(new Runnable() 
		{
            public void run() 
            {
                new Demo();
            }
        });
		long endTime   = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		System.out.println("Time taken to run the whole program = " + totalTime + "milliseconds");
	}
}
