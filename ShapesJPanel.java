/*
This example demonstrates several Java 2D shapes from package java.awt.geom,
including Line2D.Double, Rectangle2D.Double, RoundRectangle2D.Double, 
Arc2D.Double and Ellipse2D.Double. Note the syntax of each class name.
Each class represents a shape with dimensions specified as double values. 
There’s a separate version of each represented with float values 
(e.g., Ellipse2D.Float). In each case, Double is a public static nested class 
of the class specified to the left of the dot (e.g., Ellipse2D).
To use the static nested class, we simply qualify its name with the outer-class name.
In Figs. 13.29–13.30, we draw Java 2D shapes and modify their drawing
characteristics, such as changing line thickness, filling shapes with patterns
and drawing dashed lines. These are just a few of the many capabilities provided by Java 2D.
 */
package shapes;

// Fig. 13.29: ShapesJPanel.java
// Testing ShapesJPanel.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.TexturePaint;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ShapesJPanel extends JPanel 
{
   // draw shapes with Java 2D API
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      /*
      Line 25 of Fig. 13.29 casts the Graphics reference received by 
      paintComponent to a Graphics2D reference and assigns it to g2d 
      to allow access to the Java 2D features.
      */
      Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D
      
      /*
      The first shape we draw is an oval filled with gradually changing colors. 
      Lines 28–29 invoke Graphics2D method setPaint to set the Paint object that
      determines the color for the shape to display. 
      A Paint object implements interface java.awt.Paint. 
      It can be something as simple as one of the predeclared Color objects 
      introduced in Section 13.3 (class Color implements Paint), 
      or it can be an instance of the Java 2D API’s GradientPaint, SystemColor, 
      TexturePaint, LinearGradientPaint or RadialGradientPaint classes. 
      In this case, we use a GradientPaint object.
      
      Class GradientPaint helps draw a shape in gradually changing colors—called 
      a gradient. 
      The GradientPaint constructor used here requires seven arguments. 
      The first two specify the starting coordinates for the gradient. 
      The third specifies the starting Color for the gradient.
      The fourth and fifth specify the ending coordinates for the gradient. 
      The sixth specifies the ending Color for the gradient. 
      The last argument specifies whether the gradient is cyclic (true) or
      acyclic (false). The two sets of coordinates determine the direction of 
      the gradient. Because the second coordinate (35, 100) is down and to the
      right of the first coordinate (5, 30), the gradient goes down and to the
      right at an angle. Because this gradient is cyclic (true),
      the color starts with blue, gradually becomes yellow, then gradually
      returns to blue. If the gradient is acyclic, the color transitions from
      the first color specified (e.g., blue) to the second color (e.g., yellow).
      */

      // draw 2D ellipse filled with a blue-yellow gradient
      g2d.setPaint(new GradientPaint(5, 30, Color.BLUE, 35, 100, 
         Color.YELLOW, true));  
      
      /*
      Line 30 uses Graphics2D method fill to draw a filled Shape object
      —an object that implements interface Shape (package java.awt). 
      In this case, we display an Ellipse2D.Double object. 
      The Ellipse2D.Double constructor receives four arguments specifying 
      the bounding rectangle for the ellipse to display.
      */
      g2d.fill(new Ellipse2D.Double(5, 30, 65, 100));
      
      /*
      Next we draw a red rectangle with a thick border. 
      Line 33 invokes setPaint to set the Paint object to Color.RED. 
      */
      // draw 2D rectangle in red
      g2d.setPaint(Color.RED); 
      
      /*
       Line 34 uses Graphics2D method setStroke to set the characteristics 
      of the rectangle’s border (or the lines for any other shape). 
      Method setStroke requires as its argument an object that implements 
      interface Stroke (package java.awt). In this case, we use an instance 
      of class BasicStroke. Class BasicStroke provides several constructors
      to specify the width of the line, how the line ends (called the end caps),
      how lines join together (called line joins) and the dash attributes of 
      the line (if it’s a dashed line). 
      The constructor here specifies that the line should be 10 pixels wide.
      */
      
      g2d.setStroke(new BasicStroke(10.0f)); 
      
      /*
      Line 35 uses Graphics2D method draw to draw a Shape object—in this case, 
      a Rectangle2D.Double. The Rectangle2D.Double constructor receives arguments
      specifying the rectangle’s upper-left x-coordinate, upper-left y-coordinate,
      width and height.
      */
      g2d.draw(new Rectangle2D.Double(80, 30, 65, 100));
      
      /*
      Next we draw a rounded rectangle filled with a pattern created in a 
      BufferedImage (package java.awt.image) object. 
      Lines 38–39 create the BufferedImage object. 
      Class BufferedImage can be used to produce images in color and grayscale. 
      This particular BufferedImage is 10 pixels wide and 10 pixels tall 
      (as specified by the first two arguments of the constructor). 
      The third argument BufferedImage.TYPE_INT_RGB indicates that the image 
      is stored in color using the RGB color scheme.
      */
      // draw 2D rounded rectangle with a buffered background
      BufferedImage buffImage = new BufferedImage(10, 10, 
         BufferedImage.TYPE_INT_RGB);
      
      /*To create the rounded rectangle’s fill pattern, we must first draw into the
      BufferedImage. Line 42 creates a Graphics2D object
      (by calling BufferedImage method createGraphics) 
      that can be used to draw into the BufferedImage.*/
      // obtain Graphics2D from buffImage and draw on it
      Graphics2D gg = buffImage.createGraphics();       
      /*Lines 43–50 use methods setColor, fillRect and drawRect to create the pattern.*/
      gg.setColor(Color.YELLOW); 
      gg.fillRect(0, 0, 10, 10); 
      gg.setColor(Color.BLACK);  
      gg.drawRect(1, 1, 6, 6); 
      gg.setColor(Color.BLUE); 
      gg.fillRect(1, 1, 3, 3); 
      gg.setColor(Color.RED); 
      gg.fillRect(4, 4, 3, 3); 
      
      /*
      Lines 53–54 set the Paint object to a new TexturePaint (package java.awt)
      object. A TexturePaint object uses the image stored in its associated 
      BufferedImage (the first constructor argument) as the fill texture for a
      filled-in shape. The second argument specifies the Rectangle area from 
      the BufferedImage that will be replicated through the texture. 
      In this case, the Rectangle is the same size as the BufferedImage. 
      However, a smaller portion of the BufferedImage can be used.
      */
      // paint buffImage onto the JFrame
      g2d.setPaint(new TexturePaint(buffImage, 
         new Rectangle(10, 10)));
      
      /*
      Lines 55–56 use Graphics2D method fill to draw a filled Shape object—in this case,
      a RoundRectangle2D.Double. The constructor for class RoundRectangle2D.Double 
      receives six arguments specifying the rectangle dimensions and the arc width 
      and arc height used to determine the rounding of the corners.
      */
      g2d.fill(
         new RoundRectangle2D.Double(155, 30, 75, 100, 50, 50));
      
      /*
      Next we draw a pie-shaped arc with a thick white line. 
      Line 59 sets the Paint object to Color.WHITE.
      */
      // draw 2D pie-shaped arc in white
      g2d.setPaint(Color.WHITE);
      
      /*
      Line 60 sets the Stroke object to a new BasicStroke for a line 6 pixels wide. 
      */
      g2d.setStroke(new BasicStroke(6.0f)); 
      
      /*
      Lines 61–62 use Graphics2D method draw to draw a Shape object—in this case,
      an Arc2D.Double. The Arc2D.Double constructor’s first four arguments 
      specify the
      * upper-left x-coordinate, 
      * upper-left y-coordinate, 
      * width and 
      * height of the bounding rectangle for the arc. 
      * The fifth argument specifies the start angle. 
      * The sixth argument specifies the arc angle. 
      * The last argument specifies how the arc is closed. 
      Constant Arc2D.PIE indicates that the arc is closed by drawing two lines
      —one line from the arc’s starting point to the center of the bounding rectangle 
      and one line from the center of the bounding rectangle to the ending point. 
      Class Arc2D provides two other static constants for specifying how the arc 
      is closed. 
      Constant Arc2D.CHORD draws a line from the starting point to the ending point. 
      Constant Arc2D.OPEN specifies that the arc should not be closed.
      */
      g2d.draw(
         new Arc2D.Double(240, 30, 75, 100, 0, 270, Arc2D.PIE));
      
      /*
      Finally, we draw two lines using Line2D objects—one solid and one dashed.
      Line 65 sets the Paint object to Color.GREEN.
      */
      // draw 2D lines in green and yellow
      g2d.setPaint(Color.GREEN);
      
      /*
      Line 66 uses Graphics2D method draw to draw a Shape object—in this case, 
      an instance of class Line2D.Double.
      The Line2D.Double constructor’s arguments specify the starting coordinates
      and ending coordinates of the line.
      */
      g2d.draw(new Line2D.Double(395, 30, 320, 150));
      
      /*
      Line 69 declares a one-element float array containing the value 10. 
      This array describes the dashes in the dashed line. In this case, 
      each dash will be 10 pixels long. To create dashes of different lengths 
      in a pattern, simply provide the length of each dash as an element in 
      the array.
      */
      // draw 2D line using stroke
      float[] dashes = {10}; // specify dash pattern
      
      /*
      Line 70 sets the Paint object to Color.YELLOW. 
      */
      g2d.setPaint(Color.YELLOW);    
      
      /*
       Lines 71–72 set the Stroke object to a new BasicStroke.
      The line will be 4 pixels wide and will have rounded ends 
      (BasicStroke.CAP_ROUND). If lines join together 
      (as in a rectangle at the corners), their joining will be rounded 
      (BasicStroke.JOIN_ROUND). The dashes argument specifies the dash lengths 
      for the line. The last argument indicates the starting index in the dashes
      array for the first dash in the pattern. 
      */
      g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
         BasicStroke.JOIN_ROUND, 10, dashes, 0)); 
      
      /*
      Line 73 then draws a line with the current Stroke.
      */
      g2d.draw(new Line2D.Double(320, 30, 395, 150));
   } 
} // end class ShapesJPanel