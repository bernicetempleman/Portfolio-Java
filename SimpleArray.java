/*
Class SimpleArray with Synchronization

Figure 23.8 displays class SimpleArray with the proper synchronization. 
Notice that it’s identical to the SimpleArray class of Fig. 23.5, 
except that add is now a synchronized method (line 20). 
So, only one thread at a time can execute this method. 
We reuse classes ArrayWriter (Fig. 23.6) and SharedArrayTest (Fig. 23.7) from the previous example.
 
Line 20 declares method add as synchronized, making all of the operations 
in this method behave as a single, atomic operation. Line 22 performs 
the first suboperation—storing the value of writeIndex. 
Line 35 defines the second suboperation, writing an element to the element at 
the index position. Line 39 increments writeIndex. 
When the method finishes executing at line 41, the executing thread implicitly 
releases the SimpleArray lock, making it possible for another thread to begin executing the add method.
In the synchronized add method, we print messages to the console indicating 
the progress of threads as they execute this method, in addition to performing 
the actual operations required to insert a value in the array. We do this so that 
the messages will be printed in the correct order, allowing us to see whether 
the method is properly synchronized by comparing these outputs with those of the previous,
unsynchronized example. We continue to output messages from synchronized blocks 
in later examples for demonstration purposes only; typically, however, I/O should 
not be performed in synchronized blocks, because it’s important to minimize 
the amount of time that an object is “locked.” [Note: Line 27 in this example 
calls Thread method sleep (for demo purposes only) to emphasize the unpredictability of thread scheduling. 
You should never call sleep while holding a lock in a real application.]

*/
package sharedarraytestsafe;
// Fig. 23.8: SimpleArray.java
// Class that manages an integer array to be shared by multiple 
// threads with synchronization.
import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray 
{ 
    private static final SecureRandom generator = new SecureRandom();
    private final int[] array; //the shared integer array
    private int writeIndex = 0; // index of the next element to be written
    
    //construct a SimplyArray of a given size
    public SimpleArray(int size)
    {
        array = new int[size];
    }
    
    //add a value to the shared array
    public synchronized void add(int value)
    {
        int position = writeIndex; //store the write index
        
           try 
            {
                //in real applicatins, you shouldn't sleep while holding a lock
                Thread.sleep(generator.nextInt(500)); //for demo only
                
            }
            catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
           
            // put value in the appropriate element
           array[position] = value;
           System.out.printf("%s wrote %2d to element %d.%n", 
                   Thread.currentThread().getName(), value, position);
           
           ++writeIndex; //increment index of element to be written next 
           System.out.printf("Next write index: %d%n", writeIndex);

        }
    
    //used for outputting the contents of the shared integer array
    public synchronized String toString()
    {
        return Arrays.toString(array);
    }
    }

