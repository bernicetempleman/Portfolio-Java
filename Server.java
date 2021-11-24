/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 9
Name:                       Bernice Templeman

Description: Server
Create an application that uses a socket connection 
to allow a client to specify a file name of a text file and 
have the server send the contents of the file or indicate the file does not exist.  
The server must contain a text based password file ("user name" & "password").  
The client must pass a valid username and password 
to establish a connection with the Server
 */
package project9.ctu.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame
{
    private Formatter output;           // output
    private Scanner input;              // input
    private ServerSocket server;        // server
    private Socket connection;          // socket connection
    private JTextField enterField;      // input message from user
    private JTextArea displayArea;      // display information to user
    private int counter = 1;            // counter of number of connections
 
    public Server()
    {
        super("Server");
        
        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        
        add(enterField, BorderLayout.NORTH);
        
        displayArea = new JTextArea(); // create displayArea
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        
        setSize(300,150); //set size of window
        setVisible(true); // show window
    }
    
    public void runServer() 
    {
        try
        {
            server = new ServerSocket( 12348,10);
            
            while (true)
            {
                try
                {
                    waitForConnection(); //wait for a connection
                    getStreams();
                    processFileRequest();             
                   
                }//end try
                catch (EOFException eofException)
                {
                    displayMessage("\nServer terminated connection");
                }//end catch
                catch(IOException e)
                {
                    displayMessage("IOexception");
                }
                finally
                {
                    closeConnection(); // close connection
                    ++counter;
                }//end finally          
            } //end while    
        }//end try
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            System.exit(0);
        }
        finally
        {
            try
            {
                output.close();
                input.close();
                connection.close();
            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
                System.exit(0);
            }
        }//end finally
    }//end runServer

    // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException
    {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());        
    }//end waitForConnection
    
    // get streams to send an receive data
    private void getStreams() 
    {
        try 
        {
            output = new Formatter(connection.getOutputStream());
            output.flush();  //flush output buffer to send header info
            
            input = new Scanner(connection.getInputStream());
            
            displayMessage("\nGot I/O streams\n");
        } //end try
        catch (IOException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end getStreams

    //process file request
    private void processFileRequest()
    {
        try {
            //read line of data from client
            String text = input.nextLine();
            
            // get username, password & filename from input
            String delims = "[ ]";
            String[] tokens = text.split(delims);
            String username = tokens[0];
            String password = tokens[1];
            String filename = tokens[2];
            
            File inputFile = new File(filename); 
            String result;
            
            //open password file to verify username and password
            Scanner fileScan = new Scanner (new File("1.txt"));
            boolean found = false; //boolean found if username & password correct
            
            // loop through password file 
            while (fileScan.hasNextLine()&& !found)
            {
                String input = fileScan.nextLine();
                String Username = input.substring(0,input.indexOf(':'));
                String Password = input.substring(input.indexOf(':')+1, input.length());
                
                if (Username.equals(username))
                {
                    if(Password.equals(password))
                    {
                        found = true; // added this to set found
                    }
                }
            }//end while
            
            if(found) // username & password correct
            {
                if(inputFile.exists())
                {
                    //open file to read from
                    Scanner fileInput = new Scanner(inputFile);
                    
                    // output message to client
                    output.format("The file contains: ");
                    output.flush();
                    
                    //loop to read file and output to client
                    while(fileInput.hasNextLine())
                    {
                        result = "\n"+fileInput.nextLine();
                        output.format(result);
                        output.flush();
                    }
                }//end if
                else // file does not exist
                {
                    //output error message to client
                    result = inputFile.getName() + " does not exist.\n";
                    output.format(result);
                    output.flush();
                }
            }//end if found
            else //not found
            {
                //output error message to client
                result = "Invalid username/password.\n";
                output.format(result);
                output.flush();
            }//end else (not found)
        } //end try
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    } //end process file request
    
    //close streams and socket
    private void closeConnection()
    {
        displayMessage("\nTerminating connection\n");
        
        try
        {
            output.close(); //close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }//end closeConnection
        
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
            new Runnable()
            {
                @Override
                public void run()
                {
                    displayArea.append(messageToDisplay); //append message
                }               
            }
        );
    }//end displayMessage
   
    // main method to run application
    public static void main(String[] args) 
    {
        try 
        {
            
            // create a password file
            PrintWriter writer;          
            writer = new PrintWriter("1.txt", "UTF-8");
            writer.println("java1:java1");
            writer.println("java2:java2");
            writer.close();
            
            // create application and run it
            Server application = new Server();
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.runServer();
        } //end try
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (UnsupportedEncodingException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end main      
}//end class
