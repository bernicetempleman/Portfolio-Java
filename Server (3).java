/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project9.ctu.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Server extends JFrame
{
    private Formatter output;
    private Scanner input;
    private ServerSocket server;
    private Socket connection;
    
     private int currentTot;
    ServerSocket serversocket;
    Socket client;
    int bytesRead;

    BufferedReader input2;
    PrintWriter output2;
    
    public Server()
    {
        try
        {
            server = new ServerSocket( 12348,10);
            
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
            System.exit(0);
        }
        
        setSize(400,200);
        setVisible(true);
    }
    
    public void runServer()
    {
        try
        {
            connection = server.accept();
            output = new Formatter(connection.getOutputStream());
            output.flush();
            input = new Scanner(connection.getInputStream());
            File inputFile = new File(input.nextLine());
            String result;
            
            if(inputFile.exists())
            {
                Scanner fileInput = new Scanner(inputFile);
                output.format("The file contains: ");
                output.flush();
                
                while(fileInput.hasNextLine())
                {
                    result = "\n"+fileInput.nextLine();
                    output.format(result);
                    output.flush();
                }
            }//end if
            else
            {
                result = inputFile.getName() + " does not exist.\n";
                output.format(result);
                output.flush();
            }
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

    /*
    public void start() throws IOException{
        System.out.println("Connection Starting on port:" + c.getPort());
        //make connection to client on port specified
        serversocket = new ServerSocket();

        //accept connection from client
        client = serversocket.accept();

        System.out.println("Waiting for connection from client");

        try {
            logInfo();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    */

    public void logInfo() throws Exception
    {
        //open buffered reader for reading data from client
        input2 = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String username = input2.readLine();
        System.out.println("SERVER SIDE" + username);
        String password = input2.readLine();
        System.out.println("SERVER SIDE" + password);

        //open printwriter for writing data to client
        output2 = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        
        Scanner fileScan = new Scanner (new File("1.txt"));
        boolean found = false; // added this variable
        while (fileScan.hasNextLine()&& !found) 
        {
            String input = fileScan.nextLine();
            String Username = input.substring(0,input.indexOf(':'));
            String Password = input.substring(input.indexOf(':')+1,input.length());
            System.out.println(Username+ Password +username + password);

            if (Username.equals(username)  )
            {
                if(Password.equals(password))
                        {
                found = true; // added this to set found
                 output2.println("Welcome, " + username);  
                        }
            } // removed the else statement
        }//end while

        if(!found) 
        { 
            output2.println("Login Failed");
        }
        
        output.flush();
        output.close();

    }
    
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        PrintWriter writer;
        try {
            writer = new PrintWriter("1.txt", "UTF-8");
        
            writer.println("java1:java1");
            writer.println("java2:java2");
            writer.close();
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        Server application = new Server();        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

        application.runServer();
    }      


}
