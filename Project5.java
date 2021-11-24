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

import java.awt.Color;
import javax.swing.JFrame;

public class Project5 
{
    // run the application
    public static void main(String[] args) 
    {
        // create frame for Grid_5X5
        JFrame frame = new JFrame("Drawing 5 by 5 Grid");
        
        // When window is closed, Exit the application, using System.exit(0). This is recommended for applications only.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        // create new object called grid
        Grid_5X5 grid = new Grid_5X5(); 
        grid.setBackground(Color.WHITE); 
        
        //add the object to JFrame frame
        frame.add(grid); 
        frame.setSize(240,240);
        frame.setVisible(true);
    } //end main 
}// end Class
