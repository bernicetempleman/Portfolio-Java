/*
// Fig 28.10 ClientTest.java
Tests the Client class
 */
package ch28.example3.client;

import javax.swing.JFrame;

public class ClientTest 
{

    public static void main(String[] args) 
    {
        Client application = new Client();// create client
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.waitForPackets(); // run client application
    }
    
}
