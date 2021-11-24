/*
Demonstrating the finally Block
Figure 11.5 demonstrates that the finally block executes even if an exception is not thrown in the corresponding try block. 
The program contains static methods main (lines 6–18), throwException (lines 21–44) and doesNotThrowException (lines 47–64). 
Methods throwException and doesNotThrowException are declared static, 
so main can call them directly without instantiating a UsingExceptions object.

System.out and System.err are streams—sequences of bytes. 
While System.out (known as the standard output stream) displays a program’s output, System.err 
(known as the standard error stream) displays a program’s errors. Output from these streams can be redirected (
i.e., sent to somewhere other than the command prompt, such as to a file). 
Using two different streams enables you to easily separate error messages from other output. 
For instance, data output from System.err could be sent to a log file, 
while data output from System.out can be displayed on the screen. For simplicity, 
this chapter will not redirect output from System.err, but will display such messages to the command prompt. 
You’ll learn more about streams in Chapter 15.

Throwing Exceptions Using the throw Statement
Method main (Fig. 11.5) begins executing, enters its try block and immediately calls method throwException (line 10). 
Method throwException throws an Exception. The statement at line 26 is known as a throw statement
—it’s executed to indicate that an exception has occurred. So far, 
you’ve caught only exceptions thrown by called methods. You can throw exceptions yourself by using the throw statement. 
Just as with exceptions thrown by the Java API’s methods, this indicates to client applications that an error has occurred.
A throw statement specifies an object to be thrown. The operand of a throw can be of any class derived from class Throwable.
 */
package usingexceptions;

// Fig. 11.5: UsingExceptions.java
// try...catch...finally exception handling mechanism.

public class UsingExceptions 
{
   public static void main(String[] args)
   {
      try 
      { 
         throwException(); 
      }
      catch (Exception exception) // exception thrown by throwException
      {
         System.err.println("Exception handled in main");
      } 

      doesNotThrowException();
   } 

   // demonstrate try...catch...finally
   public static void throwException() throws Exception
   {
      try // throw an exception and immediately catch it
      { 
         System.out.println("Method throwException");
         throw new Exception(); // generate exception
      }
      catch (Exception exception) // catch exception thrown in try
      {
         System.err.println(
            "Exception handled in method throwException");
         throw exception; // rethrow for further processing

         // code here would not be reached; would cause compilation errors

      } 
      finally // executes regardless of what occurs in try...catch
      {
         System.err.println("Finally executed in throwException");
      }

      // code here would not be reached; would cause compilation errors

   }
   // demonstrate finally when no exception occurs
   public static void doesNotThrowException()
   {
      try // try block does not throw an exception
      { 
         System.out.println("Method doesNotThrowException");
      }
      catch (Exception exception) // does not execute
      {
         System.err.println(exception);
      }
      finally // executes regardless of what occurs in try...catch
      {
         System.err.println(
            "Finally executed in doesNotThrowException");
      } 

      System.out.println("End of method doesNotThrowException");
   } 
} // end class UsingExceptions
