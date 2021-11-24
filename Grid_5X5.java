/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 5 
Name:                       Bernice Templeman

Description: 
Create an application that provides a solution for problem 13.11 by modifying the solution as follows.
Book: 13.11 (Grid Using Method drawLine) Write an application that draws an 8-by-8 grid. Use Graphics method drawLine.
• Provide a 5 x 5 grid instead of 8 x 8
Make all other necessary modifications necessary to run the application.
 */
package project.pkg5;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

// class extends JPanel
class Grid_5X5 extends JPanel
{
    // paint the window
    @Override 
    public void paintComponent(Graphics g)
    {
        // The first statement in every paintComponent method you create should always be
        // super.paintComponent(g);
        // which ensures that the panel is properly rendered before we begin drawing on it.
        super.paintComponent(g); 
        
        // set the background to white
        this.setBackground(Color.WHITE);
               
        //this.setBackground(new Color(155,161,162)); // set background to gray
        
        /*
            public abstract void drawLine(int x1, int y1, int x2, int y2)
            Draws a line, using the current color, between the points 
            (x1, y1) and (x2, y2) in this graphics context's coordinate system.
        */
        int x1 = 30;
        int y1 = 30;
        int x2 = 180;
        int y2 = 180;
        
        // create new color objects
        Color color1 = new Color(0, 21, 50);
        Color color2 = new Color(105,190,40);
  
        // Loop to draw 6 horizontal lines and 6 vertical lines to make 5*5 Grid
        for( int i = 1; i <= 6; i++)
        {
            //set the color to Navy Blue
            g.setColor(color1);

            //use Graphics method drawLIne() to draw a horizontal line
            g.drawLine(x1, i*y1, x2, i*y1);
            
            //set the color to Green
            g.setColor(color2);

            // use Graphics method drawLIne() draw a vertical line 
            g.drawLine(i*x1, y1, i*x1, y2);
        }//end for loop to draw lines
    }//end paintComponent
}//end class
