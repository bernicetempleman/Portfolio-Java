/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 4 
Name:                       Bernice Templeman
 */
package comparatortest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Bernice
 */
public class ComparatorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                // create and initialize a Time1 object
        Time1 time = new Time1(); // invokes Time1 constructor 
 
        // output string representations of the time
        displayTime("After time object is created", time);
        System.out.println();
 
        // change time and output updated time
        time.setTime(13, 27, 6);  
        displayTime("After calling setTime", time);
        System.out.println();
 
        // attempt to set time with invalid values
        try
        {
            time.setTime(99, 99, 99); // all values out of range 
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }
 
        // display time after attempt to set invalid values
        displayTime("After calling setTime with invalid values", time);
         
        //***************************************      
        List<Time2> list = new ArrayList<>(); // create List

        list.add(new Time2(6, 24, 34));
        list.add(new Time2(18, 14, 58));
        list.add(new Time2(6, 05, 34));
        list.add(new Time2(12, 14, 58));
        list.add(new Time2(6, 24, 22));
      
        // output List elements
        System.out.printf("Unsorted array elements:%n%s%n", list);

        // sort in order using a comparator
        Collections.sort(list, new TimeComparator()); 

        // output List elements
        System.out.printf("Sorted list elements:%n%s%n", list);
    }
    
}


