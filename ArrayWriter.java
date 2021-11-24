// Fig. 23.6: ArrayWriter.java
// Adds integers to an array shared with other Runnables

package sharedarraytest;
import java.lang.Runnable;

/*
Class ArrayWriter

Class ArrayWriter (Fig. 23.6) implements the interface Runnable to define a 
task for inserting values in a SimpleArray object. 
The constructor (lines 10–14) takes two arguments—an integer value, 
which is the first value this task will insert in the SimpleArray object, 
and a reference to the SimpleArray object. Line 20 invokes method add on the SimpleArray object. 
The task completes after three consecutive integers beginning with startValue are 
inserted in the SimpleArray object.
*/
public class ArrayWriter implements Runnable
{
    private final SimpleArray sharedSimpleArray;
    private final int startValue;
    
    public ArrayWriter(int value, SimpleArray array)
    {
        startValue = value;
        sharedSimpleArray = array;
    }
    
    public void run()
    {
        for (int i = startValue; i < startValue + 3; i++)
        {
            sharedSimpleArray.add(i); //add an element to the shared array
        }
    }
}
