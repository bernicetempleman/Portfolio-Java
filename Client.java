/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 9
Name:                       Bernice Templeman

Description: Client
Create an application that uses a socket connection 
to allow a client to specify a file name of a text file and 
have the server send the contents of the file or indicate the file does not exist.  
The server must contain a text based password file ("user name" & "password").  
The client must pass a valid username and password 
to establish a connection with the Server
 */
package project.pkg9.ctu.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener
{
    private JTextField enterField1, enterField;
    private final JPasswordField enterField2; // password field with text
    private JTextArea displayArea;
    private Scanner input;
    private Formatter output;
    private Socket connection;
    private JPanel panel;
    private JLabel label, label1, label2;
    private JScrollPane scroller;
        
    //set up GUI
    public Client()
    {
        label1 = new JLabel("UserName: "); 
        label2 = new JLabel("Password: "); 
        label = new JLabel("File Name: ");
        panel = new JPanel();
        
        panel.setLayout( new GridLayout(1,2,0,0));
        
        // add label and textfield for username
        panel.add( label1);
        enterField1 = new JTextField();
        enterField1.addActionListener(this);
        panel.add(enterField1);
        
        //add label and textfield for password
        panel.add( label2);
        enterField2 = new JPasswordField(); 
        enterField2.addActionListener(this);
        panel.add(enterField2);
        
        //add label and textfield for filename
        panel.add( label);
        enterField = new JTextField();       
        enterField.addActionListener(this);
        panel.add(enterField);
        
        //add display area for the messages and file
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        scroller = new JScrollPane( displayArea);
        setLayout( new BorderLayout());
        add( panel, BorderLayout.NORTH);
        add( scroller, BorderLayout.CENTER);
        
        setSize(700,300);
        setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent event)
    {
        // if not all fields were entered, display error
        if ((enterField2.getPassword().toString().trim().length() == 0 )
                || (enterField.getText().trim().length() == 0 )
                || (enterField1.getText().trim().length() == 0 ))
        {
            JOptionPane.showMessageDialog(null, "All fields must be complete");
        }
        else // all fields entered
        {
            try
            {
                //open connection
                connection = new Socket(InetAddress.getLocalHost(),12348);
                output = new Formatter(connection.getOutputStream());
                output.flush();
                input = new Scanner( connection.getInputStream());            
       
                //get username
                String input1 = enterField1.getText().trim();
                boolean isWhitespace = input1.contains(" ");
                String username = "";
                if(isWhitespace)
                    username = input1.substring(0,input1.indexOf(' '));
                else 
                    username = input1;
                
                //get password
                String input2 = new String(enterField2.getPassword()).trim();
                isWhitespace = input2.contains(" ");
                String password = "";
                if(isWhitespace)
                    password = input2.substring(0,input2.indexOf(' '));
                else 
                    password = input2;
                 
                //get filename
                String input3 = enterField.getText().trim();
                isWhitespace = input3.contains(" ");
                String filename = "";
                if(isWhitespace)
                    filename = input3.substring(0,input3.indexOf(' '));
                else 
                    filename = input3;
                
                // send username, password and filename to server
                String text = username + " " + password + " " + filename + "\n";
                output.format( text);
                output.flush();
                    
                String inputLine = input.nextLine();
                displayArea.setText( inputLine);
                
                //check if file was returned
                if (inputLine.equals("The file contains: "))
                {
                    //loop to display file
                    while (input.hasNextLine())
                    {
                        inputLine = "\n"+input.nextLine();
                        displayArea.append(inputLine);
                    }
                }//end if
                    
                //enterField.setEditable (true);
            }//end try
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }//end catch
            finally
            {
                try //close connections
                {
                    input.close();
                    output.close();
                    connection.close();
                }//end try
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    System.exit(1);
                }//end catch
            }//end finally
	}//end else all fields enterd
    }//end actionPerformed
    
    // main method to run application
    public static void main(String[] args) 
    {
        Client application = new Client();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main
}// end class
