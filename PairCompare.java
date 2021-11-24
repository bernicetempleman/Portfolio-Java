/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 3 : 20.8
Name:                       Bernice Templeman
*******************************************************************************
Create an application that provides a solution for problem 20.8
20.8 (Generic Class Pair) 

In addition to requirements specified in the description.  
The class must satisfy the following

* Creates a  "Comparator" object (to be used by the sort method; 
* i.e. create an instance of a  class that implements the interface 
* [must override "compare" and "equals" methods])
 */
package project.pkg3;

import java.util.Comparator;

//public class PairCompare implements Comparator<Pair<F, S>>
public class PairCompare<F extends Number & Comparable<F>,S extends Number & Comparable<S>> implements Comparator<Pair<F,S>>
{
    // override compare
    // Compares its two arguments for order. 
    // Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
    @Override   
    public int compare(Pair<F, S> o1, Pair<F, S> o2) 
    {
        if (o1.equals(o2))
        {
            //System.out.println("These are equal");
            return 0;       
        }
               
        //else check their distance
        Double distance1 = o1.getDistance();
        Double distance2 = o2.getDistance();
      
        if ( (distance1 - distance2) < 0)
            return -1;
        if ((distance1 - distance2) > 0)
            return 1;
        return 0;
    }    
}
