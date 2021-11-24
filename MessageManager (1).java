/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project9.textreader;
// Fig. 24.24: MessageManager.java
// MessageManger is an interface for objects capable of managing
// communications with a message server.

public interface MessageManager 
{      
   // connect to message server and route incoming messages
   // to given MessageListener
   public void connect( MessageListener listener );
   
   // disconnect from message server and stop routing
   // incoming messages to given MessageListener
   public void disconnect( MessageListener listener );
   
   // send message to message server
   public void sendMessage( String from, String message );  
} // end interface MessageManager