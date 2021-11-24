/*
Florida Institute of Technology
CIS 5230 Operating Systems – Program 3
Bernice Templeman

Requirements: 
sources: http://docs.oracle.com/javase/6/docs/api/java/lang/Thread.html
http://www.cs.columbia.edu/~lok/3101/lectures/08-threads.pdf
A thread is a thread of execution in a program. 
The Java Virtual Machine allows an application to have multiple threads of execution running concurrently. 
Every thread has a priority. 
Threads with higher priority are executed in preference to threads with lower priority. 
Each thread may or may not also be marked as a daemon. 
When code running in some thread creates a new Thread object, 
the new thread has its priority initially set equal to the priority of the creating thread, 
and is a daemon thread if and only if the creating thread is a daemon. 

Use the Java Thread class to demonstrate the following functionalities:
(1) Create five threads; 
show the id for each thread – getId()
(2) Show the use of the following methods (be creative in your code):
start(), 
sleep(), 
yield(), 
getState(),  
setName(), 
getName(), 
setPriority(), 
getPriority()  
-- Make sure to show threads are processed with different priority (be creative).

Exceptions:

start:
Throws: IllegalThreadStateException - if the thread was already started.

setPriority 
Throws: 
IllegalArgumentException - If the priority is not in the range MIN_PRIORITY to MAX_PRIORITY.
SecurityException - if the current thread cannot modify this thread.

setName:
Throws: 
SecurityException - if the current thread cannot modify this thread.

sleep:
Throws: InterruptedException - if any thread has interrupted the current thread.
The interrupted status of the current thread is cleared when this exception is thrown.

 */
package threadsos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadsOS extends Thread 
{
    
    public ThreadsOS() 
    {
           //default constructor  
    }
 
    @Override
    public void run() 
    {
        //loop 20 times 
        for (int i = 1; i < 21; i++) 
        {
            // display run number, thread name, priority, & state
            System.out.println("\nRun "+ i 
                    + " : " + Thread.currentThread().getName()
                    + " Priority: " + Thread.currentThread().getPriority()
                    + " State: "+ Thread.currentThread().getState());
   
            // yields  
            if (i == 2 || i == 15) 
            {
                System.out.println("Run: " + Thread.currentThread().getName() + " yielding...");
                
                //yield so another thread can run
                Thread.yield();
            }
            
            // sleeps: put thread to sleep if i = 10          
            if (i == 10)
            {
                //put thread to sleep
                try 
                {
                    System.out.println("Run: " + Thread.currentThread().getName() + " Going to sleep...");
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(ThreadsOS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                    
        }

        System.out.println("\nEnd Run: Current thread: " + Thread.currentThread().getName()
                    + " Priority: " + Thread.currentThread().getPriority()
                    + " State: "+ Thread.currentThread().getState());
    }
         
    // main
    public static void main(String[] args) 
    {
        //(1a.) Create five threads; 
        System.out.println("Creating 5 Threads");
        ThreadsOS thread1 = new ThreadsOS();
        ThreadsOS thread2 = new ThreadsOS();
        ThreadsOS thread3 = new ThreadsOS();
        ThreadsOS thread4 = new ThreadsOS();
        ThreadsOS thread5 = new ThreadsOS();
        System.out.println();
        
        // (1b) show the id for each thread – getId()
        System.out.println("Showing the id for each thread with getId():");
        System.out.println("Main: Thread 1 id: " + thread1.getId());
        System.out.println("Main: Thread 2 id: " + thread2.getId()); 
        System.out.println("Main: Thread 3 id: " + thread3.getId());        
        System.out.println("Main: Thread 4 id: " + thread4.getId()); 
        System.out.println("Main: Thread 5 id: " + thread5.getId());
        System.out.println();
        
        //2. getName()
        System.out.println("Displaying the name of each thread with getName():");
        System.out.println( "Main: Thread 1 name before it is set: " + thread1.getName());
        System.out.println( "Main: Thread 2 name before it is set: " + thread2.getName());
        System.out.println( "Main: Thread 3 name before it is set: " + thread3.getName());
        System.out.println( "Main: Thread 4 name before it is set: " + thread4.getName());
        System.out.println( "Main: Thread 5 name before it is set: " + thread5.getName());       
        System.out.println();
        
        
        try
        {
            //2. setName()
            System.out.println("Setting the name of each thread with setName()");
            thread1.setName("Thread-1");
            thread2.setName("Thread-2");
            thread3.setName("Thread-3");
            thread4.setName("Thread-4");
            thread5.setName("Thread-5");
            System.out.println();
        }
        catch(SecurityException e)
        {
            System.out.println("SecurityException");
        }
        
        //2. getName()
        System.out.println("Displaying the name of each thread with getName():");
        System.out.println( "Main: Thread 1 name after it is set: " + thread1.getName());
        System.out.println( "Main: Thread 2 name after it is set: " + thread2.getName());
        System.out.println( "Main: Thread 3 name after it is set: " + thread3.getName());
        System.out.println( "Main: Thread 4 name after it is set: " + thread4.getName());
        System.out.println( "Main: Thread 5 name after it is set: " + thread5.getName());        
        System.out.println();
        
        //2. getPriority()
        System.out.println("Displaying the priority of each thread with getPriority():");
        System.out.println("Main: Thread 1 priority: " + thread1.getPriority());
        System.out.println("Main: Thread 2 priority: " + thread2.getPriority());
        System.out.println("Main: Thread 3 priority: " + thread3.getPriority());
        System.out.println("Main: Thread 4 priority: " + thread4.getPriority());
        System.out.println("Main: Thread 5 priority: " + thread5.getPriority());       
        System.out.println();
              
        try
        {
            //2. setPriority()
            System.out.println("Setting the priority of each thread with setPriority()");
            thread1.setPriority(1);
            thread2.setPriority(8);
            thread3.setPriority(10);
            thread4.setPriority(8);
            thread5.setPriority(10);
            System.out.println();
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("IllegalArgumentException");
        }
        catch(SecurityException s)
        {
            System.out.println("SecurityException");
        }
        
        //2. getPriority()
        System.out.println("Displaying the priority of each thread with getPriority():");
        System.out.println("Main: Thread 1 priority: " + thread1.getPriority());
        System.out.println("Main: Thread 2 priority: " + thread2.getPriority());
        System.out.println("Main: Thread 3 priority: " + thread3.getPriority());
        System.out.println("Main: Thread 4 priority: " + thread4.getPriority());
        System.out.println("Main: Thread 5 priority: " + thread5.getPriority());       
        System.out.println();
        
        //2. getState()
        System.out.println("Displaying the state of each thread with getState():");
        System.out.println("Main: Thread 1 state before it is started: " + thread1.getState());
        System.out.println("Main: Thread 2 state before it is started: " + thread2.getState());
        System.out.println("Main: Thread 3 state before it is started: " + thread3.getState());
        System.out.println("Main: Thread 4 state before it is started: " + thread4.getState());
        System.out.println("Main: Thread 5 state before it is started: " + thread5.getState());        
        System.out.println();
           
        try
        {
            //start threads
            System.out.println("Starting threads with start()");
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            System.out.println();
        }
        catch(IllegalThreadStateException e)
        {
            System.out.println("IllegalThreadStateException");
        }

        //getState()
        System.out.println("Displaying the state of each thread with getState():");
        System.out.println("Main: Thread 1 state after it is started: " + thread1.getState());
        System.out.println("Main: Thread 2 state after it is started: " + thread2.getState());
        System.out.println("Main: Thread 3 state after it is started: " + thread3.getState());
        System.out.println("Main: Thread 4 state after it is started: " + thread4.getState());
        System.out.println("Main: Thread 5 state after it is started: " + thread5.getState());        
        System.out.println();
        
        //getState()
        System.out.println("Displaying the state of each thread with getState():");
        System.out.println("Main: Thread 1 state: " + thread1.getState());
        System.out.println("Main: Thread 2 state: " + thread2.getState());
        System.out.println("Main: Thread 3 state: " + thread3.getState());
        System.out.println("Main: Thread 4 state: " + thread4.getState());
        System.out.println("Main: Thread 5 state: " + thread5.getState());
        System.out.println();
        
        // sleep to give processing time before displaying state again
        System.out.println("Main: calling sleep to allow processing time:");
        System.out.println();
        try 
        {
            Thread.sleep(4000);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(ThreadsOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //getState()
        System.out.println("Displaying the state of each thread with getState():");
        System.out.println("Main: Thread 1 state: " + thread1.getState());
        System.out.println("Main: Thread 2 state: " + thread2.getState());
        System.out.println("Main: Thread 3 state: " + thread3.getState());
        System.out.println("Main: Thread 4 state: " + thread4.getState());
        System.out.println("Main: Thread 5 state: " + thread5.getState());
        System.out.println();
    }   
}
