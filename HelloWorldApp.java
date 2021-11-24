
package helloworldapp;

import java.util.Scanner;

// this is a class
public class HelloWorldApp 
{
    // this is another comment
    
    //this is the main function 
    public static void main(String[] args) 
    {
            // this creates an HelloWorldMessage objects named message1 and message2
            HelloWorldMessage message1 = new HelloWorldMessage();
            HelloWorldMessage message2 = new HelloWorldMessage();
            
            // array of HelloWorldMessage objects
            HelloWorldMessage[] messages = new HelloWorldMessage[2];
            messages[0] =  message1;
            messages[1] = message2;
            
            // message1 object displayMessage
            System.out.println("HelloWorldApp: message1");
            messages[0].displayMessage();
            System.out.println();
            
            // message object displayMessage
            System.out.println("HelloWorldApp: message2");
            messages[1].displayMessage();
            
            System.out.println();
            // message1 object displayMessage
            System.out.println("HelloWorldApp: message1");
            messages[0].displayMessage();
            
            System.out.println();
            messages[0].displayMessage2("Hello World from message1");
            
            System.out.println();
            boolean result = message1.displayNumbers();
            System.out.println("HelloWorldApp: Result= " + result);
            
            System.out.println();
            messages[0].displayArrays();

    }
}

