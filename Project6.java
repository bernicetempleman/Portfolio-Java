/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 6
Name:                       Bernice Templeman

Project 6 Description-2
Provide a solution for 12.9.  
The solution requires nesting panels 
(i.e., JPanel w/ GridLayout for buttons; JFrame w/ BorderLayout for the JPanel and JTextField). 
The following describes the suggested layout managers and placement of the controls.

Create a JPanel
Set JPanel layout manager to GridLayout, add the buttons to this panel
Add the JPanel to the center of the JFrame (i.e., JFrames use BorderLayout)
Add a JTextField to the "North" of the JFrame
 
Note: Do not implement event-handling for this assignment.
 */
package project.pkg6;

import javax.swing.JFrame;

public class Project6 
{
    // run the application
    public static void main(String[] args) 
    {
        CalculatorGUI calculator = new CalculatorGUI();       
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        calculator.setSize(250, 250);
        calculator.setVisible(true);
        
    }// end main   
}// end Project6
