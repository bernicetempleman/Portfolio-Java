/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg9.fileclient;

   import java.net.*;
   import java.io.*;
   
   public class FileClient {
   
      static final int LISTENING_PORT = 3210;
   
   
      public static void main(String[] args) {
      
         String computer;      // Name or IP address of server.
         Socket connection;    // A socket for communicating with
                               //                that computer.
         PrintWriter outgoing; // Stream for sending a command
                               //                to the server.
         TextReader incoming;  // Stream for reading data from
                               //                the connection.
         String command;       // Command to send to the server.
         
   
         /* Check that the number of command-line arguments is legal.
            If not, print a usage message and end. */
         
         if (args.length == 0 || args.length > 3) 
         {
             /*
            System.out.println("Usage:  java FileClient <server>");
            System.out.println("    or  java FileClient <server> <file>");
            System.out.println(
                  "    or  java FileClient <server> <file> <local-file>");
            return;
             */
             computer = "127.0.0.1";
             command = "get testfile.txt";
         }
         
         else
         {
         /* Get the server name and the message to send to the server. */
         
         computer = args[0];
         
         if (args.length == 1)
            command = "index";
         else
            command = "get " + args[1];
         
         }
         
         /* Make the connection and open streams for communication.
            Send the command to the server.  If something fails
            during this process, print an error message and end. */
         
         try {
            connection = new Socket( computer, LISTENING_PORT );
            incoming = new TextReader( connection.getInputStream() );
            outgoing = new PrintWriter( connection.getOutputStream() );
            outgoing.println(command);
            outgoing.flush();
         }
         catch (Exception e) {
            System.out.println(
                 "Can't make connection to server at \"" + args[0] + "\".");
            System.out.println("Error:  " + e);
            return;
         }
         
         /* Read and process the server's response to the command. */
         
         try {
            if (args.length == 1) {
                  // The command was "index".  Read and display lines
                  // from the server until the end-of-stream is reached.
               System.out.println("File list from server:");
               while (incoming.eof() == false) {
                  String line = incoming.getln();
                  System.out.println("   " + line);
               }
            }
            else {
                  // The command was "get <file-name>".  Read the server's
                  // response message.  If the message is "ok", get the file.
               String message = incoming.getln();
               if (! message.equals("ok")) {
                  System.out.println("File not found on server.");
                  return;
               }
               PrintWriter fileOut;  // For writing the received data to a file.
               if (args.length == 3) {
                     // Use the third parameter as a file name.
                   fileOut = new PrintWriter( new FileWriter(args[2]) );
               }
               else {
                     // Use the second parameter as a file name,
                     // but don't replace an existing file.
                   File file = new File(args[1]);
                   if (file.exists()) {
                      System.out.println("A file with that name already exists.");
                      System.out.println("To replace it, use the three-argument");
                      System.out.println("version of the command.");
                      return;
                   }
                   fileOut = new PrintWriter( new FileWriter(args[1]) );
               }
               while (incoming.peek() != '\0') {
                      // Copy lines from incoming to the file until
                      // the end of the incoming stream is encountered.
                   String line = incoming.getln();
                   fileOut.println(line);
               }
               if (fileOut.checkError()) {
                  System.out.println("Some error occurred while writing the file.");
                  System.out.println("Output file might be empty or incomplete.");
               }
            }
         }
         catch (Exception e) {
            System.out.println("Sorry, an error occurred while reading data from the server.");
            System.out.println("Error: " + e);
         }
         
      }  // end main()
      
   
   } //end class FileClient

