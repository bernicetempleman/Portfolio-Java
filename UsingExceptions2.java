/*
11.7 Stack Unwinding and Obtaining Information from an Exception Object
When an exception is thrown but not caught in a particular scope, 
the method-call stack is “unwound,” and an attempt is made to catch the exception in the next outer try block. 
This process is called stack unwinding. 
Unwinding the method-call stack means that the method in which the exception was not caught terminates, 
all local variables in that method go out of scope and control returns to the statement that originally invoked that method. 
If a try block encloses that statement, an attempt is made to catch the exception. 
If a try block does not enclose that statement or if the exception is not caught, stack unwinding occurs again. 
Figure 11.6 demonstrates stack unwinding, and the exception handler in main shows how to access the data in an exception object.

In main, the try block (lines 8–11) calls method1 (declared at lines 35–38), 
which in turn calls method2 (declared at lines 41–44), which in turn calls method3 (declared at lines 4750). 
Line 49 of method3 throws an Exception object—this is the throw point. 
Because the throw statement at line 49 is not enclosed in a try block, 
stack unwinding occurs—method3 terminates at line 49, 
then returns control to the statement in method2 that invoked method3 (i.e., line 43). 
Because no try block encloses line 43, 
stack unwinding occurs again—method2 terminates at line 43 and returns control to the statement in method1 that invoked method2 
(i.e., line 37). Because no try block encloses line 37, 
stack unwinding occurs one more time—method1 terminates at line 37 and 
returns control to the statement in main that invoked method1 (i.e., line 10). 
The try block at lines 8–11 encloses this statement. 
The exception has not been handled, so the try block terminates and the first matching catch block (lines 12–31)
catches and processes the exception. If there were no matching catch blocks, 
and the exception is not declared in each method that throws it, a compilation error would occur. 
Remember that this is not always the case—for unchecked exceptions, the application will compile,
but it will run with unexpected results.

The catch handler in Fig. 11.6 (lines 12–31) demonstrates getMessage, printStackTrace and getStackTrace. 
If we wanted to output the stack-trace information to streams other than the standard error stream, 
we could use the information returned from getStackTrace and output it to another stream or use one of the overloaded versions of method printStackTrace. 
Sending data to other streams is discussed in Chapter 15.
Line 14 invokes the exception’s getMessage method to get the exception description. 
Line 15 invokes the exception’s printStackTrace method to output the stack trace that indicates where the exception occurred. 
Line 18 invokes the exception’s getStackTrace method to obtain the stack-trace information as an array of StackTraceElement objects. 
Lines 24–30 get each StackTraceElement in the array and invoke its methods getClassName, getFileName, getLineNumber and getMethodName to get the class name, filename, 
line number and method name, respectively, for that StackTraceElement. Each StackTraceElement represents one method call on the method-call stack.
The program’s output shows that output of printStackTrace follows the pattern: 
className.methodName(fileName:lineNumber), where className, methodName and fileName indicate the names of the class, 
method and file in which the exception occurred, respectively, and the lineNumber indicates where in the file the exception occurred. 
You saw this in the output for Fig. 11.2. Method getStackTrace enables custom processing of the exception information. 
Compare the output of printStackTrace with the output created from the StackTraceElements to see that both contain the same stack-trace information.

 */
package usingexceptions2;

// Fig. 11.6: UsingExceptions.java
// Stack unwinding and obtaining data from an exception object.

public class UsingExceptions2 
{
   public static void main(String[] args)
   {
      try 
      { 
         method1(); 
      }
      catch (Exception exception) // catch exception thrown in method1
      { 
         System.err.printf("%s%n%n", exception.getMessage());
         exception.printStackTrace(); 

         // obtain the stack-trace information
         StackTraceElement[] traceElements = exception.getStackTrace();
         
         System.out.printf("%nStack trace from getStackTrace:%n");
         System.out.println("Class\t\tFile\t\t\tLine\tMethod");

         // loop through traceElements to get exception description
         for (StackTraceElement element : traceElements) 
         {
            System.out.printf("%s\t", element.getClassName());
            System.out.printf("%s\t", element.getFileName());
            System.out.printf("%s\t", element.getLineNumber());
            System.out.printf("%s%n", element.getMethodName());
         } 
      } 
   } // end main

   // call method2; throw exceptions back to main
   public static void method1() throws Exception
   {
      method2();
   } 

   // call method3; throw exceptions back to method1
   public static void method2() throws Exception
   {
      method3();
   }

   // throw Exception back to method2
   public static void method3() throws Exception
   {
      throw new Exception("Exception thrown in method3");
   } 
} // end class UsingExceptions
    

