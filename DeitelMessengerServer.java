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



public class DeitelMessengerServer implements MessageListener 
{
   private ExecutorService serverExecutor; // executor for server
   
      // address for multicast datagrams
   public static final String MULTICAST_ADDRESS = "239.0.0.1";
   
   // port for listening for multicast datagrams
   public static final int MULTICAST_LISTENING_PORT = 5555;
   
   // port for sending multicast datagrams
   public static final int MULTICAST_SENDING_PORT = 5554;
   
   // port for Socket connections to DeitelMessengerServer
   public static final int SERVER_PORT = 12349;   
   
   // String that indicates disconnect
   public static final String DISCONNECT_STRING = "DISCONNECT";

   // String that separates the user name from the message body
   public static final String MESSAGE_SEPARATOR = ">>>";

   // message size (in bytes)
   public static final int MESSAGE_SIZE = 512;
   
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
               new MessageReceiver( this, clientSocket ) );
                        
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
   
   // when new message is received, broadcast message to clients
   public void messageReceived( String from, String message ) 
   {          
      // create String containing entire message
      String completeMessage = from + MESSAGE_SEPARATOR + message;
      
      // create and start MulticastSender to broadcast messages
      serverExecutor.execute( 
         new MulticastSender( completeMessage.getBytes() ) );
   } // end method messageReceived
} // end class DeitelMessengerServer
