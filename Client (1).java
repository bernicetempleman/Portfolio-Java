/*
 // Fig 28.5 Client.java
Client portion of a stream-socket connection between client and server

 */
package ch28.example2client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Client extends JFrame
{
    private JTextField enterField; // enters information from user
    private JTextArea displayArea; // display information to user
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private String message = "";
    private String chatServer;
    private Socket client;

    // initialize chatServer and set up GUI
    public Client(String host)
    {
       super("Cient");
       
       chatServer = host; // set server to which this client connects
       
       enterField = new JTextField(); //createField
       enterField.setEditable(false);
       enterField.addActionListener(
               new ActionListener()
               {
                   //send message to server
                   public void actionPerformed(ActionEvent event)
                   {
                       sendData(event.getActionCommand());
                       enterField.setText("");
                   }
               }
       );
       
       add(enterField, BorderLayout.NORTH);
       
       displayArea = new JTextArea();
       add(new JScrollPane(displayArea), BorderLayout.CENTER );
       
       setSize(300, 150);
       setVisible(true);
       
    }
    
    // connect to server and process messages from server
    public void runClient()
    {
        try //connect to server, get streams, process connection
        {
            connectToServer();
            getStreams();
            processConnection();
            
        }
        catch(EOFException eofException)
        {
            displayMessage("\nClient terminaed connection");
            
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            closeConnection();
        }
    }
    
    //connect to server
    private void connectToServer() throws IOException
    {
        displayMessage("Attempting connection\n");
        
        //create Socket to make connectin to server
        client = new Socket(InetAddress.getByName(chatServer),12345);
        
        //display connection information
        displayMessage("Connected to: " + client.getInetAddress().getHostName());
        
        
    }
    
    // get streams to send and receive data
    private void getStreams() throws IOException
    {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        
        input = new ObjectInputStream(client.getInputStream());
        displayMessage("\nGot I/O streams\n");
        
        
    }
    
    // process connection with server
    private void processConnection() throws IOException
    {
        //enable enterField so client user can send messages
        setTextFieldEditable(true);
        
        do
        {
            try
            {
                message = (String) input.readObject();
                displayMessage("\n" + message);
                
            }
            catch (ClassNotFoundException classNotFoundException)
            {
                displayMessage("\nUnknown object type received");
                
            }
        } while (!message.equals("SERVER>>> TERMINATE"));
    }
    
    //close streams & socket
    private void closeConnection()
    {
        displayMessage("\nClosing connection");
         setTextFieldEditable(false);
        
        try
        {
            output.close();
            input.close();
            client.close();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
    
    //send message to server
    private void sendData (String message)
    {
        try // send object to server
        {
            output.writeObject("CLIENT>>> " + message);
            output.flush();
            displayMessage("\nCLIENT>>> " + message);
            
        }
        catch(IOException ioException)
        {
            displayArea.append("\nError writing object");
        }
    }
    
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run()
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }
    // manipulates enterField in the event-dispatch thread
     private void setTextFieldEditable(final boolean editable)
     {
        SwingUtilities.invokeLater(
           new Runnable()
           {
              public void run() // sets enterField's editability
              {
                 enterField.setEditable(editable);
              }
           }
        );
      }

    
}
