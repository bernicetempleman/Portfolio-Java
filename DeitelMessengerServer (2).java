/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deitelmessengerservertest;

// Fig. 24.18: DeitelMessengerServer.java
// DeitelMessengerServer is a multithreaded, socket- and 
// packet-based chat server.


import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class DeitelMessengerServer  
{
   private ExecutorService serverExecutor; // executor for server
   
   
   // port for Socket connections to DeitelMessengerServer
   public static final int SERVER_PORT = 12349;   
   
   // String that indicates disconnect
   public static final String DISCONNECT_STRING = "DISCONNECT";
 
   // start chat server
   public void startServer() 
   {
      // create executor for server runnables
      serverExecutor = Executors.newCachedThreadPool();

      try // create server and manage new clients
      {
         // create ServerSocket for incoming connections
         ServerSocket serverSocket = 
            new ServerSocket( SERVER_PORT, 100 );
         
         System.out.printf( "%s%d%s", "Server listening on port ", 
            SERVER_PORT, " ..." );
         
         // listen for clients constantly
         while ( true ) 
         {
            // accept new client connection
            Socket clientSocket = serverSocket.accept();
            
            // create MessageReceiver for receiving messages from client
            serverExecutor.execute( 
            new MessageReceiver( (MessageListener) this, clientSocket ) );
                        
            // print connection information
            System.out.println( "Connection received from: " +
               clientSocket.getInetAddress() );
         } // end while     
      } // end try
      catch ( IOException ioException )
      {
         ioException.printStackTrace();
      } // end catch
   } // end method startServer
   
  
} // end class DeitelMessengerServer
