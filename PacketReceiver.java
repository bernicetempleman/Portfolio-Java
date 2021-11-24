/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deitelmessenger;

// Fig. 24.27: PacketReceiver.java
// PacketReceiver listens for DatagramPackets containing
// messages from a DeitelMessengerServer.

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.SocketTimeoutException;
import java.util.StringTokenizer;



public class PacketReceiver implements Runnable 
{
   private MessageListener messageListener; // receives messages
   private MulticastSocket multicastSocket; // receive broadcast messages
   private InetAddress multicastGroup; // InetAddress of multicast group
   private boolean keepListening = true; // terminates PacketReceiver
   
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
   
   public PacketReceiver( MessageListener listener ) 
   {
      messageListener = listener; // set MessageListener
      
      try // connect MulticastSocket to multicast address and port 
      {
         // create new MulticastSocket
         multicastSocket = new MulticastSocket(
            MULTICAST_LISTENING_PORT );
         
         // use InetAddress to get multicast group
         multicastGroup = InetAddress.getByName( MULTICAST_ADDRESS );
         
         // join multicast group to receive messages
         multicastSocket.joinGroup( multicastGroup ); 
         
         // set 5 second timeout when waiting for new packets
         multicastSocket.setSoTimeout( 5000 );
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } // end PacketReceiver constructor
   
   // listen for messages from multicast group 
   public void run() 
   {          
      // listen for messages until stopped
      while ( keepListening ) 
      {
         // create buffer for incoming message
         byte[] buffer = new byte[ MESSAGE_SIZE ];

         // create DatagramPacket for incoming message
         DatagramPacket packet = new DatagramPacket( buffer, 
            MESSAGE_SIZE );

         try // receive new DatagramPacket (blocking call)
         {            
            multicastSocket.receive( packet ); 
         } // end try
         catch ( SocketTimeoutException socketTimeoutException ) 
         {
            continue; // continue to next iteration to keep listening
         } // end catch
         catch ( IOException ioException ) 
         {
            ioException.printStackTrace();
            break;
         } // end catch

         // put message data in a String
         String message = new String( packet.getData() );

         message = message.trim(); // trim whitespace from message

         // tokenize message to retrieve user name and message body
         StringTokenizer tokenizer = new StringTokenizer( 
            message, MESSAGE_SEPARATOR );

         // ignore messages that do not contain a user 
         // name and message body
         if ( tokenizer.countTokens() == 2 ) 
         {
            // send message to MessageListener
            messageListener.messageReceived( 
               tokenizer.nextToken(), // user name
               tokenizer.nextToken() ); // message body
         } // end if
      } // end while

      try 
      {
         multicastSocket.leaveGroup( multicastGroup ); // leave group
         multicastSocket.close(); // close MulticastSocket
      } // end try
      catch ( IOException ioException )
      { 
         ioException.printStackTrace();
      } // end catch
   } // end method run
   
   // stop listening for new messages
   public void stopListening() 
   {
      keepListening = false;
   } // end method stopListening
} // end class PacketReceiver
