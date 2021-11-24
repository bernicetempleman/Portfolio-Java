/* CAUTION: NOT THREAD SAFE!
 
23.4.3 Unsynchronized Mutable Data Sharing

First, we illustrate the dangers of sharing an object across threads without 
proper synchronization. In this example (Figs. 23.5–23.7), 
two Runnables maintain references to a single integer array.
Each Runnable writes three values to the array, then terminates.
This may seem harmless, but we’ll see that it can result in errors if the array 
is manipulated without synchronization.

Class SimpleArray

A SimpleArray object (Fig. 23.5) will be shared across multiple threads. 
SimpleArray will enable those threads to place int values into array 
(declared at line 9). Line 10 initializes variable writeIndex, 
which will be used to determine the array element that should be written 
to next. 
The constructor (lines 13–16) creates an integer array of the desired size.

// Fig. 23.5: SimpleArray.java
// Class that manages an integer array to be shared by multiple threads.
 */
package sharedarraytest;
import java.security.SecureRandom;
import java.util.Arrays;


public class SimpleArray //CAUTION: NOT THREAD SAFE!
{
    private static final SecureRandom generator = new SecureRandom();
    private final int[] array; //the shared integer array
    private int writeIndex = 0;// shared index of next element to write
    
    //construct a SimpleArray of a given size
    public SimpleArray(int size)
    {
        array = new int[size];
    }
    
    /*
    Method add (lines 19–40) allows new values to be inserted at the end of the array. 
    Line 21 stores the current writeIndex value. Line 26 puts the thread 
    that invokes add to sleep for a random interval from 0 to 499 milliseconds. 
    This is done to make the problems associated with unsynchronized access 
    to shared mutable data more obvious. 
    After the thread is done sleeping, line 34 inserts the value passed 
    to add into the array at the element specified by position. 
    Lines 35–36 output a message indicating the executing thread’s name, 
    the value that was inserted in the array and where it was inserted. 
    The expression Thread.currentThread().getName()
    (line 36) first obtains a reference to the currently executing Thread, 
    then uses that Thread’s getName method to obtain its name.
    Line 38 increments writeIndex so that the next call to add will insert a
    value in the array’s next element. Lines 43–46 override method toString
    to create a String representation of the array’s contents.
    */
    
    //add a value to the shared array
    public void add(int value)
    {
        int position = writeIndex; //store the write index
        
        try
        {
            //put thread to sleep for 0-499 milliseconds
            Thread.sleep(generator.nextInt(500));
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt(); //re-interrupt the thread
        }
        
        // put value in the appropriate element
        array[position] = value;
        System.out.printf("%s wrote %2d to element %d.%n",
                Thread.currentThread().getName(), value, position);
        
        ++writeIndex;//increment index of element to be written next
        System.out.printf("Next write index %d%n", writeIndex);
    }//end add
    
    //used for outputting the contents of the shared integer array 
    @Override
    public String toString()
    {
        return Arrays.toString(array);
    }
/*
    23.4.4 Synchronized Mutable Data Sharing—Making Operations Atomic

The output errors of Fig. 23.7 can be attributed to the fact that the shared object, 
    SimpleArray, is not thread safe—SimpleArray is susceptible to errors 
    if it’s accessed concurrently by multiple threads. The problem lies in method add, 
    which stores the value of writeIndex, places a new value in that element, 
    then increments writeIndex. Such a method would present no problem in a 
    single-threaded program. However, if one thread obtains the value of writeIndex,
    there’s no guarantee that another thread cannot come along and increment
    writeIndex before the first thread has had a chance to place a value in the array.
    If this happens, the first thread will be writing to the array based on a 
    stale value of writeIndex—a value that’s no longer valid. 
    Another possibility is that one thread might obtain the value of writeIndex 
    after another thread adds an element to the array but before writeIndex is incremented.
    In this case, too, the first thread would write to the array based on an invalid value for writeIndex.
SimpleArray is not thread safe because it allows any number of threads to read and modify shared mutable data concurrently, which can cause errors. To make SimpleArray thread safe, we must ensure that no two threads can access its shared mutable data at the same time. While one thread is in the process of storing writeIndex, adding a value to the array, and incrementing writeIndex, no other thread may read or change the value of writeIndex or modify the contents of the array at any point during these three operations. In other words, we want these three operations—storing writeIndex, writing to the array, incrementing writeIndex—to be an atomic operation, which cannot be divided into smaller suboperations. (As you’ll see in later examples, read operations on shared mutable data should also be atomic.) We can simulate atomicity by ensuring that only one thread carries out the three operations at a time. Any other threads that need to perform the operation must wait until the first thread has finished the add operation in its entirety.
Atomicity can be achieved using the synchronized keyword. By placing our three suboperations in a synchronized statement or synchronized method, we allow only one thread at a time to acquire the lock and perform the operations. When that thread has completed all of the operations in the synchronized block and releases the lock, another thread may acquire the lock and begin executing the operations. This ensures that a thread executing the operations will see the actual values of the shared mutable data and that these values will not change unexpectedly in the middle of the operations as a result of another thread’s modifying them.
    */   
}
