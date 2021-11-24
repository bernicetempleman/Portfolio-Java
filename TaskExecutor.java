/*
Chapter 23
Figure 23.4 uses an ExecutorService object to manage threads that execute PrintTasks 
(as defined in Fig. 23.3). Lines 11–13 create and name three PrintTasks to execute. 
Line 18 uses Executors method newCachedThreadPool to obtain an ExecutorService 
that’s capable of creating new threads as they’re needed by the application.
These threads are used by ExecutorService to execute the Runnables.

The sample outputs show each task’s name and sleep time as the thread goes to sleep. 
The thread with the shortest sleep time in most cases awakens first, 
indicates that it’s done sleeping and terminates. In Section 23.8, 
we discuss multithreading issues that could prevent the thread with the shortest sleep time from awakening first. 
In the first output, the main thread terminates before any of the PrintTasks output their names and sleep times.
This shows that the main thread runs to completion before any of the PrintTasks gets a chance to run. 
In the second output, all of the PrintTasks output their names and sleep times before the main thread terminates.
This shows that the PrintTasks started executing before the main thread terminated. 
Also, notice in the second example output, task3 goes to sleep before task2 last, 
even though we passed task2 to the ExecutorService’s execute method before task3. 
This illustrates the fact that we cannot predict the order in which the tasks will start executing, 
even if we know the order in which they were created and started.


[x]
< Return to Search Results
Email This Page (Key: e)
Print
Zoom Out (Key: -)
Zoom In (Key: +)
Toggle to Full Screen (Key: f)
Previous (Key: p)
Next (Key: n)
 URL  Show search terms
Waiting for Previously Scheduled Tasks to Terminate
Waiting for Previously Scheduled Tasks to Terminate

After scheduling tasks to execute, 
you’ll typically want to wait for the tasks to complete—for example, 
so that you can use the tasks’ results. After calling method shutdown,
you can call ExecutorService method awaitTermination to wait for scheduled tasks to complete.
We demonstrate this in Fig. 23.7.
We purposely did not call awaitTermination in Fig. 23.4 
to demonstrate that a program can continue executing after the main thread terminates.
 */

package taskexecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Bernice
 */
public class TaskExecutor 
{
/*
    Main Thread

The code in main executes in the main thread, which is created by the JVM. 
    The code in the run method of PrintTask (lines 21–37 of Fig. 23.3) 
    executes whenever the Executor starts each PrintTask—again,
    this is sometime after they’re passed to the ExecutorService’s execute method 
    (Fig. 23.4, lines 21–23). When main terminates, 
    the program itself continues running because there are still tasks that must finish executing. 
    The program will not terminate until these tasks complete.
    */
    public static void main(String[] args) 
    {
        // create and name each runnable
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");
        
        System.out.println("Starting Executor");
        
        /*
        Executors method newCachedThreadPool to obtain an ExecutorService 
        that’s capable of creating new threads as they’re needed by the application.
        These threads are used by ExecutorService to execute the Runnables.
        */
        
        // create executorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        /*
        Lines 21–23 each invoke the ExecutorService’s execute method, 
        which executes its Runnable argument (in this case a PrintTask) some time in the future. 
        The specified task may execute in one of the threads in the ExecutorService’s thread pool, 
        in a new thread created to execute it, or in the thread that called the execute method—
        the ExecutorService manages these details. Method execute returns immediately from each invocation—
        the program does not wait for each PrintTask to finish. Line 26 calls ExecutorService method shutdown,
        which notifies the ExecutorService to stop accepting new tasks, 
        but continues executing tasks that have already been submitted. 
        Once all of the previously submitted Runnables have completed, the ExecutorService terminates. 
        Line 28 outputs a message indicating that the tasks were started and the main thread is finishing its execution.
        */
        
        // start the three PrintTasks
        executorService.execute(task1); //start task1
        executorService.execute(task2);
        executorService.execute(task3);
        
        //shut down ExecutorService - it decides when to shut down threads
        executorService.shutdown();
        
        System.out.printf("Tasks started, main ends.%n%n");
    }
    
}
