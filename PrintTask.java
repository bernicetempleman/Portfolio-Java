/*
ch 23 figure 23_03_04

Class PrintTask implemetns Runnable so that multiple PrintTasks can execute concurrently. 
Variable sleepTime stores a random integer value from 0 to  5 seconds created i the PrintTask constructor
Each thread running PrintTask sleeps for the amount of time specified by sleepTime, 
then outputs its task's name and a message indicating that its done sleeping

A PrintTask executes when a thread calls the PrintTask's run method.


 */
package taskexecutor;

import java.security.SecureRandom;

public class PrintTask implements Runnable
{
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime; //random sleep time for thread
    private final String taskName;
    
    // constructor 
    public PrintTask(String taskName)
    {
        this.taskName = taskName;
        
        //pick random sleep time between 0 and 5 seconds
        sleepTime = generator.nextInt(5000); //milliseconds
    }

    // method run contains the code that a thread will execute
    @Override
    public void run() 
    {
        try //put thread to sleep for sleepTime amount of time
        {
            System.out.printf("%s going to sleep for %d milliseconds. %n", 
                    taskName, sleepTime);
            //invoke static method sleep of class Thread to place the thread in
            // the timed-waiting state for the specified  amount of time.
            // at this point the thread loses the processor, 
            //and the system allows another thread to execute
            // when the thread awakens, it reneters the runnable stat.
 
            Thread.sleep(sleepTime);
        }
        /*
        It’s considered good practice to let the executing thread handle InterruptedExceptions. 
        Normally, you’d do this by declaring that method run throws the exception, 
        rather than catching the exception. 
        However, recall from Chapter 11 that when you override a method, 
        the throws may contain only the same exception types or a subset 
        of the exception types declared in the original method’s throws clause. 
        Runnable method run does not have a throws clause in its original declaration, 
        so we cannot provide one in line 21. To ensure that the executing thread receives the InterruptedException, 
        line 32 first obtains a reference to the currently executing
        Thread by calling static method currentThread, 
        then uses that Thread’s interrupt method to deliver the 
        InterruptedException to the current thread.
        */
        catch(InterruptedException exception ) //required because checked exception
        { //if a sleeping threads interrupt method is called
            exception.printStackTrace();
            Thread.currentThread().interrupt(); // re-interrupt the thread
        }
            //When the Print Task is assigned to a processor again,
            // a message is printed that it is done sleeping
            // then method run terminates
        
        //print task name
        System.out.printf("%s done sleeping%n", taskName);
    }
    
}
