/*
23_05-07

23.4.3 Unsynchronized Mutable data : 
 illustrate the dangers of sharing an object across threads without proper synchronization. 
In this example (Figs. 23.5–23.7), two Runnables maintain references to a single integer array. 
Each Runnable writes three values to the array, then terminates. This may seem harmless, 
but we’ll see that it can result in errors if the array is manipulated without synchronization.

Class SharedArrayTest

Class SharedArrayTest (Fig. 23.7) executes two ArrayWriter tasks that add values
to a single SimpleArray object. Line 12 constructs a six-element SimpleArray object. 
Lines 15–16 create two new ArrayWriter tasks, one that places the values 1–3 
in the SimpleArray object, and one that places the values 11–13. Lines 19–21 
create an ExecutorService and execute the two ArrayWriters. 
Line 23 invokes the ExecutorService’s shutDown method to prevent additional 
tasks from starting and to enable the application to terminate
when the currently executing tasks complete execution.


Class SimpleArray

A SimpleArray object (Fig. 23.5) will be shared across multiple threads. 
SimpleArray will enable those threads to place int values into array (declared at line 9). 
Line 10 initializes variable writeIndex, 
which will be used to determine the array element that should be written to next. 
The constructor (lines 13–16) creates an integer array of the desired size.
 */
package sharedarraytest;
// Fig 23.7: SharedArrayTest.java
// Executing two Runnables to add elements to a shared SimpleArray.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest 
{


    public static void main(String[] args) 
    {
        // construct the shared object
        SimpleArray sharedSimpleArray = new SimpleArray(6);
        
        // create two tasks to write to the shared SimpleArray
        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
        
        // execute the tasks with an ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(writer1);
        executorService.execute(writer2);
        
        executorService.shutdown();
        /*
        Recall that ExecutorService method shutdown returns immediately. 
        Thus any code that appears after the call to ExecutorService method 
        shutdown in line 23 will continue executing as long as the main thread 
        is still assigned to a processor. 
        We’d like to output the SimpleArray object to show you the results 
        after the threads complete their tasks. 
        So, we need the program to wait for the threads to complete 
        before main outputs the SimpleArray object’s contents. 
        Interface ExecutorService provides the awaitTermination method for 
        this purpose. This method returns control to its caller either 
        when all tasks executing in the ExecutorService complete or when the 
        specified timeout elapses. If all tasks are completed before 
        awaitTermination times out, this method returns true; otherwise it 
        returns false. The two arguments to awaitTermination represent a 
        timeout value and a unit of measure specified with a constant from 
        class TimeUnit (in this case, TimeUnit.MINUTES).
Method awaitTermination throws an InterruptedException if the calling thread is interrupted while waiting for other threads to terminate. Because we catch this exception in the application’s main method, there’s no need to re-interrupt the main thread as this program will terminate as soon as main terminates.
In this example, if both tasks complete before awaitTermination times out, line 34 displays the SimpleArray object’s contents. Otherwise, lines 37–38 display a message indicating that the tasks did not finish executing before awaitTermination timed out.
        */
        
        try
        {
            //wait 1 minute for both writers to finish executing
            boolean taskEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
            
            if (taskEnded)
            {
                System.out.printf("%nContents of SimpleArray:%n");
                System.out.println(sharedSimpleArray); //print contents
            }
            else
                System.out.println("Timed out while waiting for task to finish");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
 /*
   Sample Program Output

Figure 23.7’s output shows the problems (highlighted in the output) that can be 
    caused by failure to synchronize access to shared mutable data. 
    The value 1 was written to element 0, then overwritten later by the value 11.
    Also, when writeIndex was incremented to 3, nothing was written to that element, 
    as indicated by the 0 in that element of the printed array.
Recall that we added calls to Thread method sleep between operations on the shared 
    mutable data to emphasize the unpredictability of thread scheduling and increase
    the likelihood of producing erroneous output. 
    Even if these operations were allowed to proceed at their normal pace, 
    you could still see errors in the program’s output. However, modern processors 
    can handle the simple operations of the SimpleArray method add so quickly 
    that you might not see the errors caused by the two threads executing this method concurrently,
    even if you tested the program dozens of times. 
    One of the challenges of multithreaded programming is spotting the errors
    —they may occur so infrequently and unpredictably that a broken program does 
    not produce incorrect results during testing, creating the illusion that 
    the program is correct. This is all the more reason to use predefined 
    collections that handle the synchronization for you. 
    */   
}
