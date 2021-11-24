/*
Sometimes a method responds to an exception by throwing a different exception type that’s specific to the current application. 
If a catch block throws a new exception, the original exception’s information and stack trace are lost. 
Earlier Java versions provided no mechanism to wrap the original exception information with the new exception’s information to provide a complete stack trace showing where the original problem occurred. 
This made debugging such problems particularly difficult. 
Chained exceptions enable an exception object to maintain the complete stack-trace information from the original exception. 

Program Flow of Control
The program consists of four methods—main (lines 6–16), method1 (lines 19–29), method2 (lines 32–42) and method3 (lines 45–48).
Line 10 in method main’s try block calls method1. Line 23 in method1’s try block calls method2. Line 36 in method2’s try block calls method3.
In method3, line 47 throws a new Exception. Because this statement is not in a try block, method3 terminates, 
and the exception is returned to the calling method (method2) at line 36. 
This statement is in a try block; therefore, the try block terminates and the exception is caught at lines 38–41. 
Line 40 in the catch block throws a new exception. In this case, the Exception constructor with two arguments is called. 
The second argument represents the exception that was the original cause of the problem. In this program, that exception occurred at line 47.
Because an exception is thrown from the catch block, method2 terminates and returns the new exception to the calling method (method1) at line 23. 
Once again, this statement is in a try block, so the try block terminates and the exception is caught at lines 25–28. 
Line 27 in the catch block throws a new exception and uses the exception that was caught as the second argument to the Exception constructor. 
Because an exception is thrown from the catch block, method1 terminates and returns the new exception to the calling method (main) at line 10.
The try block in main terminates, and the exception is caught at lines 12–15. Line 14 prints a stack trace.

Program Output
Notice in the program output that the first three lines show the most recent exception that was thrown 
(i.e., the one from method1 at line 27). The next four lines indicate the exception that was thrown from method2 at line 40. 
Finally, the last four lines represent the exception that was thrown from method3 at line 47. 
Also notice that, as you read the output in reverse, it shows how many more chained exceptions remain.


Figure 11.7 demonstrates chained exceptions.
 */
package usingchainedexceptions;

// Fig. 11.7: UsingChainedExceptions.java
// Chained exceptions.

public class UsingChainedExceptions
{
   public static void main(String[] args)
   {
      try 
      { 
         method1(); 
      } 
      catch (Exception exception) // exceptions thrown from method1
      { 
         exception.printStackTrace();
      } 
   } 

   // call method2; throw exceptions back to main
   public static void method1() throws Exception
   {
      try 
      { 
         method2(); 
      }
      catch (Exception exception) // exception thrown from method2
      {
         throw new Exception("Exception thrown in method1", exception);
      }
   } // end method method1

   // call method3; throw exceptions back to method1
   public static void method2() throws Exception
   {
      try 
      { 
         method3(); 
      } 
      catch (Exception exception) // exception thrown from method3
      {
         throw new Exception("Exception thrown in method2", exception);
      } 
   } // end method method2

   // throw Exception back to method2
   public static void method3() throws Exception
   {
      throw new Exception("Exception thrown in method3");
   } 
} // end class UsingChainedExceptions