/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deitelmessengerservertest;

// Fig. 24.23: MulticastSender.java
// MulticastSender broadcasts a chat message using a multicast datagram.


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class MulticastSender implements Runnable
{   
   private byte[] messageBytes; // message data
   
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
   
   public MulticastSender( byte[] bytes ) 
   { 
      messageBytes = bytes; // create the message
   } // end MulticastSender constructor

   // deliver message to MULTICAST_ADDRESS over DatagramSocket
   public void run() 
   {
      try // deliver message
      {         
         // create DatagramSocket for sending message
         DatagramSocket socket = 
            new DatagramSocket( MULTICAST_SENDING_PORT );
         
         // use InetAddress reserved for multicast group
         InetAddress group = InetAddress.getByName( MULTICAST_ADDRESS );
         
         // create DatagramPacket containing message
         DatagramPacket packet = new DatagramPacket( messageBytes, 
            messageBytes.length, group, MULTICAST_LISTENING_PORT );
         
         socket.send( packet ); // send packet to multicast group
         socket.close(); // close socket
      } // end try
      catch ( IOException ioException ) 
      { 
         ioException.printStackTrace();
      } // end catch
   } // end method run
} // end class MulticastSender
