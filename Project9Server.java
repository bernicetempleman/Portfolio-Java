/*
Project 9 Description
Create an application that uses a socket connection
to allow a client to specify a file name of a text file and 
have the server send the contents of the file or indicate the file does not exist. 
The server must contain a text based password file ("user name" & "password").  
The client must pass a valid username and password to establish a connection with the Server 
(see Note 1).

Notes:
1.  A much better approach would be to encrypt the password file.  
The Java Cryptographic Extension (available since JDK 1.4) provides an API.

Java Cryptography Architecture Reference Guide (JCA Guide) - 
http://docs.oracle.com/javase/6/docs/technotes/guides/security/crypto/CryptoSpec.html#Introduction 
(Links to an external site.)
  Introduction, Code Examples - Computing a Message Digest Object  (i.e. one-way hash; using SHA-1)


 */
package project.pkg9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project9Server 
{
    private int currentTot;
    ServerSocket serversocket;
    Socket client;
    int bytesRead;
    Connect c = new Connect();
    BufferedReader input;
    PrintWriter output;

    public void start() throws IOException{
        System.out.println("Connection Starting on port:" + c.getPort());
        //make connection to client on port specified
        serversocket = new ServerSocket(c.getPort());

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

    public void logInfo() throws Exception{
        //open buffered reader for reading data from client
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String username = input.readLine();
        System.out.println("SERVER SIDE" + username);
        String password = input.readLine();
        System.out.println("SERVER SIDE" + password);

        //open printwriter for writing data to client
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

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
                 output.println("Welcome, " + username);  
                        }
            } // removed the else statement
        }//end while

        if(!found) 
        { 
            output.println("Login Failed");
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
        
        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }      
}

