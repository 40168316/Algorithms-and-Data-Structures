import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

// Class for drawing the Polygon which sets the points and colours
public class drawpolygon {
	Polygon P;
	Color c;
	
	// Setting of the Polygon with the points
	public drawpolygon(int[] x, int []y, Color c){
		P = new Polygon();
		P.xpoints = x;
		P.ypoints = y;
		P.npoints = x.length;
		this.c = c;
	}
	
	// The drawing of the Polygon
	void drawthepolygon(Graphics g){
		g.setColor(c);
		g.drawPolygon(P);
	}
}
