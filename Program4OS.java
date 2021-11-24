/*
Use the Java Interface Queue<E> to demonstrate the following functionalities:

(1) Create a queue that will be used to implement a scheduling policy.
(2) Create a GUI to include: 
    Insert (add item to Queue), 
    Remove(remove an item from Queue), and
    Show(show all items in Queue – Show object id, time entered). 
(3) Create an object of your favorite class (make sure your object has an Id field).
(4) Insert an object into a Queue (show the time hh:mm:ss).
(5) Repeat item (4) for up to 10 objects.
(6) Remove an object from the Queue (show the time hh:mm:ss).
(7) Also, show the time the object was in Queue (the difference of entered/remove) time. 
 */
package program.pkg4.os;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Program4OS extends JFrame 
{
    private final JButton insertJButton;// button 
    private final JButton removeJButton;// button 
    private final JButton showJButton;  // button 
    private JTextArea displayField;     // Text Area
          
    //Create an object of your favorite class (make sure your object has an Id field).
    Employee[] employees = new Employee[10];
           
    //Create a queue that will be used to implement a scheduling policy.
    Queue<Employee> queue = new LinkedList<Employee>();

    // ButtonFrame adds JButtons to JFrame
    public Program4OS()
    {
        super("Demonstrating: Java Interface Queue<E>");
       
        //create array of employee objects
        for( int i = 0; i< 10; i++)
        {           
            employees[i] = new Employee();
            System.out.println("creating: " +  employees[i].getId());
        }
           
        Container container  = getContentPane();
        container.setLayout(new FlowLayout()); 

        insertJButton = new JButton("Insert into Queue"); // button with text
        container.add(insertJButton); // add insertJButton to JFrame

        removeJButton = new JButton("Remove from Queue"); // set image
        container.add(removeJButton); // add removeJButton to JFrame

        showJButton = new JButton("Show Queue"); // set image
        container.add(showJButton); // add showJButton to JFrame
        
        displayField = new JTextArea(50,50);
        displayField.setEditable(false);
        container.add(displayField);
      
        // create new ButtonHandler for button event handling 
        ButtonHandler handler = new ButtonHandler();
        insertJButton.addActionListener(handler);
        removeJButton.addActionListener(handler);
        showJButton.addActionListener(handler);
    }

    // inner class for button event handling
    private class ButtonHandler implements ActionListener 
    {
        // handle button event
        @Override
        public void actionPerformed(ActionEvent event)
        {
            // check which button was pressed
            if(event.getActionCommand().equals("Insert into Queue"))
            {
                // check if there are employees available to put into the queue
                if (Employee.waitingCount < 10)
                {
                    //look for employee to add to queue
                    boolean found = false;
                    int i = 0;
                    
                    // loop to find an employee not in the queue
                    while((  i < 10)&&(!found))
                    {
                        //if employee isn't in the queue add them to queue
                        if(!employees[i].isWaiting())
                        {
                            System.out.println("adding: " +  i);
                            employees[i].setWaiting(true);
                            try{
                                queue.add(employees[i]);
                            }
                            catch(IllegalStateException e )
                            {
                                System.out.printf("IllegalStateException");
                            }
                            catch(ClassCastException e)
                            {
                                System.out.printf("ClassCastException");
                            }
                            catch(NullPointerException e)
                            {
                                System.out.printf("NullPointerException");
                            }
                            catch(IllegalArgumentException e)
                            {
                                System.out.printf("IllegalArgumentException");
                            }
                            
                            // set time employee entered queue
                            Time time = new Time(System.currentTimeMillis());
                            employees[i].setWaitStartTime( time);
                            
                            //display employee added to queue
                            displayField.setText(null);
                            displayField.append("Employee Added to queue:\nID: "+ employees[i].getId()+ "\tTime: " + employees[i].getWaitStartTime());
                            found = true;                              
                        }
                        i++;
                    }
                }
                else // no available employees
                {
                    System.out.println("No available employees");  
                }
            } // check if button remove was pressed
            else if(event.getActionCommand().equals("Remove from Queue"))
            {    
                //check if employee in the queue
                if(!queue.isEmpty()) 
                {  
                    displayField.setText(null); //clear text area
                    Employee emp = new Employee(); //create an employee object
                    
                    try
                    {
                        emp = queue.remove(); //remove employee from queue
                    
                        // set the time removed from queue
                        Time time = new Time(System.currentTimeMillis());
                        emp.setWaitEndTime( time);
                        emp.setWaiting(false);
                    }
                    catch(NoSuchElementException e)
                    {
                        System.out.println("NoSuchElementException");
                    }
                    
                    // display the employee removed and time
                    displayField.append("Employee Removed from queue:\nID: "+ emp.getId()
                            + "\tExit Time: " + emp.getWaitEndTime() 
                            + "\tTotal Time in Queue: " + emp.getTotalWaitTime() );
                }   
            } // else display queue pressed
            else //Display Queue
            {
                displayField.setText(null); //clear the text area
                
                // display the headings
                displayField.append("Display Queue: \n");
                displayField.append("ID\tStartTime ");
                
                //loop to display employees
                for (Employee element : queue) 
                {
                    String text = "\n" + element.getId() + "\t" + element.getWaitStartTime();
                    displayField.append(text);
                    System.out.println(element.getId());
                }           
            }
        }
    } 

    public static void main(String[] args) throws InterruptedException 
    { 
        //create GUI
        Program4OS buttonFrame = new Program4OS(); 
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setSize(700, 700); 
        buttonFrame.setVisible(true);   
    }
}