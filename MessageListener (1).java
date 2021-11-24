/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deitelmessengerservertest;

// Fig. 24.21: MessageListener.java
// MessageListener is an interface for classes that wish to
// receive new chat messages.


public interface MessageListener 
{
   // receive new chat message
   public void messageReceived( String from, String message );
} // end interface MessageListener
