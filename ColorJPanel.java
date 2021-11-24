package showcolors;
// Fig. 13.5: ColorJPanel.java
// Changing drawing colors.
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class ColorJPanel extends JPanel 
{      
    /*demonstrate several methods from Fig. 13.4 by drawing 
    filled rectangles and Strings in several different colors. 
    When the application begins execution, class ColorJPanel’s paintComponent 
    method (lines 10–37 of Fig. 13.5) is called to paint the window. 
    line 10 begins with Override */
    
   // draw rectangles and Strings in different colors
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);
      
    //Line 17 uses Graphics method setColor to set the drawing color. 
    //Method setColor receives a Color object. 
    //The expression new Color(255, 0, 0) creates a new Color object that 
    //represents red (red value 255, and 0 for the green and blue values). 

      // set new drawing color using integers
      g.setColor(new Color(255, 0, 0));
      
      //Line 18 uses Graphics method fillRect to draw a filled rectangle in the
      //current color. Method fillRect draws a rectangle based on its four arguments.
       //The first two integer values represent the upper-left x-coordinate and upper-left 
       //y-coordinate, where the Graphics object begins drawing the rectangle. 
       //The third and fourth arguments are nonnegative integers that represent 
       //the width and the height of the rectangle in pixels, respectively. 
       //A rectangle drawn using method fillRect is filled by the current color 
       //of the Graphics object. 
      g.fillRect(15, 25, 100, 20);
      
      //Line 19 uses Graphics method drawString to draw a String in the current color. 
     //The expression g.getColor() retrieves the current color from the Graphics object. 
     //We then concatenate the Color with string "Current RGB: ", 
     //resulting in an implicit call to class Color’s toString method. 
     //The String representation of a Color contains the class name and package 
     //(java.awt.Color) and the red, green and blue values. 
      g.drawString("Current RGB: " + g.getColor(), 130, 40);
      
      //Lines 22–24 and 27–29 perform the same tasks again. Line 22 uses the 
       //Color constructor with three float arguments to create a dark green color 
       //(0.50f for red, 0.75f for green and 0.0f for blue). Note the syntax of the values. 
       //The letter f appended to a floating-point literal indicates that the literal 
       //should be treated as type float. 
       //Recall that by default, floating-point literals are treated as type double.
      // set new drawing color using floats
      g.setColor(new Color(0.50f, 0.75f, 0.0f));
      g.fillRect(15, 50, 100, 20);
      g.drawString("Current RGB: " + g.getColor(), 130, 65);

      //Line 27 sets the current drawing color to one of the predeclared 
       //Color constants (Color.BLUE). The Color constants are static, 
       //so they’re created when class Color is loaded into memory at execution time.
      // set new drawing color using static Color objects
      g.setColor(Color.BLUE);
      g.fillRect(15, 75, 100, 20);
      g.drawString("Current RGB: " + g.getColor(), 130, 90);

      // display individual RGB values
      Color color = Color.MAGENTA;
      g.setColor(color);
      g.fillRect(15, 100, 100, 20);
      
      //35:The statement in lines 35–36 makes calls to Color methods getRed, 
       //getGreen and getBlue on the predeclared Color.MAGENTA constant. 
       //Method main of class ShowColors (lines 8–18 of Fig. 13.6) 
       //creates the JFrame that will contain a ColorJPanel object where the 
       //colors will be displayed.
      g.drawString("RGB values: " + color.getRed() + ", " +
         color.getGreen() + ", " + color.getBlue(), 130, 115);
   } 
} // end class ColorJPanel