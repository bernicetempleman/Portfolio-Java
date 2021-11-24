/*
// Fig. 24.26: MessageSender.java
// Sends a message to the chat server in a separate Runnable.
 */
package deitelmessenger;

import java.net.Socket;
import java.io.IOException;
import java.util.Formatter;
import java.net.Socket;

public class MessageSender implements Runnable 
{
   private Socket clientSocket; // Socket over which to send message
   private String messageToSend; // message to send
   
   // port for Socket connections to DeitelMessengerServer
   public static final int SERVER_PORT = 12349;   
   
   // String that indicates disconnect
   public static final String DISCONNECT_STRING = "DISCONNECT";

   // String that separates the user name from the message body
   public static final String MESSAGE_SEPARATOR = ">>>";

   // message size (in bytes)
   public static final int MESSAGE_SIZE = 512;
   
   public MessageSender( Socket socket, String userName, String message ) 
   {
      clientSocket = socket; // store Socket for client
      
      // build message to be sent
      messageToSend = userName + MESSAGE_SEPARATOR + message;
   } // end MessageSender constructor
   
   // send message and end
   public void run() 
   {
      try // send message and flush formatter
      {     
         Formatter output =
         new Formatter( clientSocket.getOutputStream() );
         output.format( "%s\n", messageToSend ); // send message
         output.flush(); // flush output
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } // end method run
} // end class MessageSender
