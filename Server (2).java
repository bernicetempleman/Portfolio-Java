/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project9.server.password;


import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Server {
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

/*
        if(username.equals(c.getUsername()) &&password.equals(c.getPassword()))
        {
            output.println("Welcome, " + username);   
        }        
        else
        {
            output.println("Login Failed");
        }
        */
        
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
