/*
The application of Figs. 13.18–13.19 demonstrates 
drawing a variety of lines, rectangles, 
three-dimensional rectangles, rounded rectangles and ovals. 
*/
package linesrectsovals;
// Fig. 13.18: LinesRectsOvalsJPanel.java
// Drawing lines, rectangles and ovals.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LinesRectsOvalsJPanel extends JPanel 
{
   // display various lines, rectangles and ovals
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);
  
      g.setColor(Color.RED);
      
      // line 17 draws a red line
      g.drawLine(5, 30, 380, 30);

      g.setColor(Color.BLUE);
      
      // line 20 draws an empty blue rectangle
      g.drawRect(5, 40, 90, 55);
      
      //line 21 draws a filled blue rectangle
      g.fillRect(100, 40, 90, 55);

      g.setColor(Color.BLACK);
      
      /*
       Methods fillRoundRect (line 24) and drawRoundRect 
      (line 25) draw rectangles with rounded corners. 
      Their first two arguments specify the coordinates of 
      the upper-left corner of the bounding rectangle
      —the area in which the rounded rectangle will be drawn. 
      The upper-left corner coordinates are not the edge of the rounded rectangle,
      but the coordinates where the edge would be if the rectangle had square corners. 
      The third and fourth arguments specify the width and height of the rectangle. 
      The last two arguments determine the horizontal and vertical diameters of the arc 
      (i.e., the arc width and arc height) used to represent the corners.
      */
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.drawRoundRect(290, 40, 90, 55, 20, 20);

      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, true);
      g.fill3DRect(100, 100, 90, 55, false);

      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.fillOval(290, 100, 90, 55);
   } 
} // end class LinesRectsOvalsJPanel

