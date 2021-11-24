/*

*/
package drawpolygons;

// Fig. 13.27: PolygonsJPanel.java
// Drawing polygons.
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class PolygonsJPanel extends JPanel 
{
   // draw polygons and polylines
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      
      /*
      Lines 16–17 of Fig. 13.27 create two int arrays and use them to 
    specify the points for Polygon polygon1. 
    
      */

      // draw polygon with Polygon object
      int[] xValues = {20, 40, 50, 30, 20, 15};
      int[] yValues = {50, 50, 60, 80, 80, 60};
      
      /*
      The Polygon constructor call in line 18 receives array xValues, 
    which contains the x-coordinate of each point; array yValues, 
    which contains the y-coordinate of each point; and 6 
    (the number of points in the polygon). 
      */
      
      Polygon polygon1 = new Polygon(xValues, yValues, 6);
      
      //Line 19 displays polygon1 by passing it as an argument to Graphics method drawPolygon.
      g.drawPolygon(polygon1);
      
      /*
      Lines 22–23 create two int arrays and use them to specify the points 
    for a series of connected lines. 
    Array xValues2 contains the x-coordinate of each point and array yValues2 
    the y-coordinate of each point.
      */

      // draw polylines with two arrays
      int[] xValues2 = {70, 90, 100, 80, 70, 65, 60};
      int[] yValues2 = {100, 100, 110, 110, 130, 110, 90};
      
      /*
      Line 24 uses Graphics method drawPolyline 
        to display the series of connected lines specified with the arguments 
        xValues2, yValues2 and 7 (the number of points).
      */
      g.drawPolyline(xValues2, yValues2, 7);

      
      /*
      Lines 27–28 create two int arrays and use them to specify the points of a polygon.
        Array xValues3 contains the x-coordinate of each point 
        and array yValues3 the y-coordinate of each point. 
      */
      // fill polygon with two arrays
      int[] xValues3 = {120, 140, 150, 190};
      int[] yValues3 = {40, 70, 80, 60};
      
      //Line 29 displays a polygon by passing to Graphics method fillPolygon 
      //the two arrays (xValues3 and yValues3) and the number of points to draw (4).
      g.fillPolygon(xValues3, yValues3, 4);

      //Line 32 creates Polygon polygon2 with no points.
      // draw filled polygon with Polygon object
      Polygon polygon2 = new Polygon();
      
      /*
      Lines 33–37 use Polygon method addPoint to add pairs of x- and y-coordinates to the Polygon.
      */
      polygon2.addPoint(165, 135);
      polygon2.addPoint(175, 150);
      polygon2.addPoint(270, 200);
      polygon2.addPoint(200, 220);
      polygon2.addPoint(130, 180);
      
      //Line 38 displays Polygon polygon2 by passing it to Graphics method fillPolygon
      g.fillPolygon(polygon2);
   } 
} // end class PolygonsJPanel
