/*
//Fig 28.4 ServerTest.java
Test the Server application
 */
package ch28.example2;

import javax.swing.JFrame;

public class ServerTest 
{

    public static void main(String[] args) 
    {
        Server application = new Server(); //  create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer();
    }
    
}
