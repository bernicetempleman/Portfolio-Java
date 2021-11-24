/*
 // Fig 28.6 ClientTest.java
Class Tests Client portion of a stream-socket connection between client and server
 */
package ch28.example2client;

import javax.swing.JFrame;


public class ClientTest 
{

    public static void main(String[] args) 
    {
        Client application;// declare client application
        
        //if no command line args
        if(args.length == 0)
        {
            application = new Client("127.0.0.1"); //connect to localost
            
        }
        else
            application = new Client(args[0]); //use args to connect
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application)
    }
    
}
