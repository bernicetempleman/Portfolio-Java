/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 5 
Name:                       Bernice Templeman

Provide a solution for 12.9.  
The solution requires nesting panels 
(i.e., JPanel w/ GridLayout for buttons; 
JFrame w/ BorderLayout for the JPanel and JTextField). 
The following describes the suggested layout managers and placement of the controls.

Create a JPanel
Set JPanel layout manager to GridLayout, add the buttons to this panel
Add the JPanel to the center of the JFrame (i.e., JFrames use BorderLayout)
Add a JTextField to the "North" of the JFrame
 */
package project.pkg6;

// import Java core packages
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// CalculatorGUI class extends JFrame (superclass that provides the basic attributes of a window
// (title bar, buttons to minimize, max & close the window
public class CalculatorGUI extends JFrame
{ 
    private final JButton buttons[];
    private final String names[] = { "7","8", "9", "/","4","5", "6","*","1","2", "3","-","0",".","=","+"};
    private GridLayout grid1; // grid for buttons
    private Container container;
    private BorderLayout layout;
    private final JTextField textField1; // text field with set size

    // set up GUI   
    public CalculatorGUI()
    {
        super( "Calculator");
                  
        // create a JPanel
        JPanel buttonPanel = new JPanel();
        
        // Set JPanel layout manager to GridLayout, add the buttons to this panel
        // GridLayout with 4 rows & 4 columns    
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
                    
        // buttons array
        buttons = new JButton[ names.length ];
        
        // create and add the buttons to the buttonPanel
        for (int count = 0; count < names.length; count++)
        {
            buttons[count] = new JButton(names[count]);
            buttonPanel.add(buttons[count]);
        }
        
        //Create JTextField for input above buttons
        textField1 = new JTextField(20);
        
        // create a new JPanel
        JPanel content = new JPanel();     
        
        // set content JPanel to BorderLayout
        content.setLayout(new BorderLayout(2, 2));
        
        // Add textField to North
        content.add( textField1, BorderLayout.NORTH );
        
        // Add the buttons to the center of the JFrame (i.e., JFrames use BorderLayout)
        content.add( buttonPanel, BorderLayout.CENTER);
        
        //Finish building the window (JFrame)
        add(content);
    }
}//end class

