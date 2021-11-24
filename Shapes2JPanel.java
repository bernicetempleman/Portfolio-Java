/*
Creating Your Own Shapes with General Paths

Next we present a general path—a shape constructed from straight lines and complex curves. 
A general path is represented with an object of class GeneralPath (package java.awt.geom).
The application of Figs. 13.31 and 13.32 demonstrates drawing a general path
in the shape of a five-pointed star.
 */
package shapes2;

// Fig. 13.31: Shapes2JPanel.java
// Demonstrating a general path.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.security.SecureRandom;
import javax.swing.JPanel;

public class Shapes2JPanel extends JPanel 
{
   // draw general paths
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      SecureRandom random = new SecureRandom(); 
      
      /*
      Lines 19–20 (Fig. 13.31) declare two int arrays representing the
      x- and y-coordinates of the points in the star. 
      */

      int[] xPoints = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
      int[] yPoints = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};

      Graphics2D g2d = (Graphics2D) g;
      GeneralPath star = new GeneralPath(); // create GeneralPath object star

      /*
      Line 26 uses GeneralPath method moveTo to specify the first point in the star.
      */
      // set the initial coordinate of the General Path
      star.moveTo(xPoints[0], yPoints[0]);
      
      /*
      The for statement in lines 29–30 uses GeneralPath method lineTo to draw a 
      line to the next point in the star. Each new call to lineTo draws a line 
      from the previous point to the current point. 
      */

      // create the star--this does not draw the star
      for (int count = 1; count < xPoints.length; count++)
         star.lineTo(xPoints[count], yPoints[count]);

      /*
      Line 32 uses GeneralPath method closePath to draw a line from the last point 
      to the point specified in the last call to moveTo.
      This completes the general path.*/    
      star.closePath(); // close the shape
      
      /*
      Line 34 uses Graphics2D method translate to move the drawing origin to 
      location (150, 150). 
      All drawing operations now use location (150, 150) as (0, 0).
      */
      g2d.translate(150, 150); // translate the origin to (150, 150)
      
      /*
      The for statement in lines 37–46 draws the star 20 times by rotating 
      it around the new origin point. Line 39 uses Graphics2D method rotate 
      to rotate the next displayed shape. The argument specifies the rotation
      angle in radians (with 360° = 2π radians). 
      Line 45 uses Graphics2D method fill to draw a filled version of the star.
      */
      // rotate around origin and draw stars in random colors
      for (int count = 1; count <= 20; count++) 
      {
         g2d.rotate(Math.PI / 10.0); // rotate coordinate system

         // set random drawing color
         g2d.setColor(new Color(random.nextInt(256),
            random.nextInt(256), random.nextInt(256)));
         g2d.fill(star); // draw filled star
      } 
   } 
} // end class Shapes2JPanel