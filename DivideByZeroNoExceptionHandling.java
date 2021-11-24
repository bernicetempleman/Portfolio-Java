/*
 11.2

Uncaught Exceptions
An uncaught exception is one for which there are no matching catch blocks. 
You saw uncaught exceptions in the second and third outputs of Fig. 11.2. 
Recall that when exceptions occurred in that example, 
the application terminated early (after displaying the exception’s stack trace). 
This does not always occur as a result of uncaught exceptions. 
Java uses a “multithreaded” model of program execution—each thread is a concurrent activity. 
One program can have many threads. If a program has only one thread, an uncaught exception will cause the program to terminate. 
If a program has multiple threads, an uncaught exception will terminate only the thread in which the exception occurred.
In such programs, however, certain threads may rely on others, and if one thread terminates due to an uncaught exception, 
there may be adverse effects on the rest of the program. 
Chapter 23, Concurrency, discusses these issues in depth.

 */
package dividebyzeronoexceptionhandling;

// Fig. 11.2: DivideByZeroNoExceptionHandling.java
// Integer division without exception handling.
import java.util.Scanner;

public class DivideByZeroNoExceptionHandling
{
   // demonstrates throwing an exception when a divide-by-zero occurs
   public static int quotient(int numerator, int denominator)
   {
      return numerator / denominator; // possible division by zero
   }

   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in); 

      System.out.print("Please enter an integer numerator: ");
      int numerator = scanner.nextInt();
      System.out.print("Please enter an integer denominator: ");
      int denominator = scanner.nextInt();

      int result = quotient(numerator, denominator);
      System.out.printf(
         "%nResult: %d / %d = %d%n", numerator, denominator, result);
   }
} // end class DivideByZeroNoExceptionHandling
