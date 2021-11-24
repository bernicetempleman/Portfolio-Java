/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deitelmessenger;

// Fig. 24.29: DeitelMessenger.java
// DeitelMessenger is a chat application that uses a ClientGUI
// and SocketMessageManager to communicate with DeitelMessengerServer.



public class DeitelMessenger
{   
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
   public static void main( String args[] ) 
   {
      MessageManager messageManager; // declare MessageManager
      
      if ( args.length == 0 )
         // connect to localhost
         messageManager = new SocketMessageManager( "localhost" );
      else
         // connect using command-line arg
         messageManager = new SocketMessageManager( args[ 0 ] );  
      
      // create GUI for SocketMessageManager
      ClientGUI clientGUI = new ClientGUI( messageManager );
      clientGUI.setSize( 300, 400 ); // set window size
      clientGUI.setResizable( false ); // disable resizing
      clientGUI.setVisible( true ); // show window
   } // end main
} // end class DeitelMessenger
