/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 7
Name:                       Bernice Templeman

Description: 11.16 (Catching Exceptions with Superclasses) 
Use inheritance to create an exception superclass (called ExceptionA) 
and exception subclasses ExceptionB and ExceptionC, 
where ExceptionB inherits from ExceptionA 
and ExceptionC inherits from ExceptionB. 

Write a program to demonstrate that the catch block for type ExceptionA 
catches exceptions of types ExceptionB and ExceptionC.
*********************************************************************************
The following provides a suggestions for completing this assignment, Problem 11.16

1.  Create the "ExceptionA", "ExceptionB", and "ExceptionC".  
    "ExceptionA" should inherit from the appropriate class that allows this exception to be thrown.  
    "ExceptionB" extends from "ExceptionA". 
    "ExceptionC" extends from "ExceptionB". 
2.  Create a class "ExceptionTester" that will contain a main method.
3.  The main() method should perform the following:

Create 1 object of each exception type (ExceptionA, ExceptionB, and ExceptionC)
Within a separate try block throw each exception type, passing a message
(refer to "main" method pg. 451 for an example of a single try catch block)
Within each associated try blocks create a catch block that catches an "ExceptionA" object
 
Because of Inheritance an "ExceptionA" handler  will catch "ExceptionA", "ExceptionB" and "ExceptionC" objects.
All this program should demonstrate is that if any of the above exception objects is thrown, 
the "ExceptionA" handler will catch. 

Catching subclass types individually is subject to error if you forget 
to test for one or more of the subclass types explicitly; 
catching the superclass guarantees that objects of all subclasses will be caught. 
Positioning a catch block for the superclass type after all other subclass catch blocks 
ensures that all subclass exceptions are eventually caught.

 */
package project.pkg7;

// Create a class "ExceptionTester" that will contain a main method.
public class ExceptionTester 
{
    public static void main(String[] args) 
    {
        //Within a separate try block throw each exception type, passing a message
        System.out.println("\nThrowing ExceptionA with an ExceptionA handler.");
        try //throw A
        {
            //create exceptionA object & throw it
            throw new ExceptionA("exceptionA");

        } // end try
        //Within each associated try blocks create a catch block that catches an "ExceptionA" object
        catch ( ExceptionA exception )
        { 
            StackTraceElement[] traceElements = exception.getStackTrace();
            
            System.out.println("\nAn ExceptionA object was caught by an ExceptionA handler.");
            
            // obtain the stack-trace information
            System.out.printf("\nexceptionA stack trace: ");

            // loop through traceElements to get exception description
            for (StackTraceElement element : traceElements)
            {
                System.out.printf("Class: %s\t", element.getClassName());
                System.out.printf("File: %s\t", element.getFileName());
                System.out.printf("Line: %s\t", element.getLineNumber());
                System.out.printf("Method: %s\n", element.getMethodName());
            }
            //exceptionA.printStackTrace();
            System.err.printf("%s%n", exception.getMessage());
            exception.printStackTrace();
        } // end catch
        System.out.println("\nThrowing ExceptionB with an ExceptionA handler.");
        try //throw B
        {
            // create exceptionB object & throw it
            throw new ExceptionB("exceptionB");
        } // end try
        //Within each associated try blocks create a catch block that catches an "ExceptionA" object
        catch ( ExceptionA exception )
        {
            StackTraceElement[] traceElements = exception.getStackTrace();
            
            System.out.println("\nAn ExceptionB object was caught by an ExceptionA handler.");
            // obtain the stack-trace information
            System.out.printf("\nexceptionB stack trace: ");
            
            // loop through traceElements to get exception description
            for (StackTraceElement element : traceElements)
            {
                System.out.printf("Class: %s\t", element.getClassName());
                System.out.printf("File: %s\t", element.getFileName());
                System.out.printf("Line: %s\t", element.getLineNumber());
                System.out.printf("Method: %s\n", element.getMethodName());
            }
            System.err.printf("%s\n", exception.getMessage());
            exception.printStackTrace();
        } // end catch
        System.out.println("\nThrowing ExceptionC with an ExceptionA handler.");
        try //throw C
        {
            //create exceptionC object
            throw new ExceptionC("exceptionC");
        } // end try
        //Within each associated try blocks create a catch block that catches an "ExceptionA" object
        catch ( ExceptionA exception )
        {
            // obtain the stack-trace information
            StackTraceElement[] traceElements = exception.getStackTrace();

            System.out.println("\nAn ExceptionC object was caught by an ExceptionA handler.");
            System.out.printf("\nexceptionC stack trace: ");
            // loop through traceElements to get exception description
            for (StackTraceElement element : traceElements)
            {
                System.out.printf("Class: %s\t", element.getClassName());
                System.out.printf("File: %s\t", element.getFileName());
                System.out.printf("Line: %s\t", element.getLineNumber());
                System.out.printf("Method: %s\n", element.getMethodName());
            }
            
            System.err.printf("%s\n", exception.getMessage());
            exception.printStackTrace();
        } // end catch end catch  
    } //end main   
}//end class
