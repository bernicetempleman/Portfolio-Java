/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 4 
Name:                       Bernice Templeman

Create an application that uses a "PriorityQueue" to perform the following

* Uses the constructor that receives a "Comparator" object as an argument

* Stores 5 "Time1" objects using the "Time1" class shown in Fig. 8.1 on page 317.  
The class must be modified to implement the "Comparator" interface

* Displays the "Universal Time" in priority order

* Note: To determine the ordering when implementing the "Comparator" interface, 
convert the time into seconds 
(i.e., hours * 3600 + minutes * 60 + seconds), 
smaller values infer higher priority)
 */
package project.pkg4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Project4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // create comparator
        Comparator<Time1> comparator = new TimeComparator1(); 
        
        // create PriorityQueue to Store 5 "Time1" objects using the "Time1" class
        PriorityQueue<Time1> queue = new PriorityQueue<Time1>(5, comparator); 
      
        // create the Time1 objects
        Time1 time1 = new Time1();
        Time1 time2 = new Time1();
        Time1 time3 = new Time1();
        Time1 time4 = new Time1();
        Time1 time5 = new Time1();
      
        // set the times
        time1.setTime(6, 24, 34);
        time2.setTime(18, 14, 58);
        time3.setTime(6, 05, 34);
        time4.setTime(12, 14, 58);
        time5.setTime(6, 24, 22);

        // insert the time elements to queue
        queue.offer(time1);
        queue.offer(time2);
        queue.offer(time3);
        queue.offer(time4);
        queue.offer(time5);

        System.out.print("\nDisplaying queue Univarsal Times in priority order: \n");

        // display elements in queue 
        // Displays the "Universal Time" in priority order
        if (queue.size() !=0 )
            displayUniversalTime(queue.remove());
        while (queue.size() != 0)
        {
            System.out.printf(", ");
            displayUniversalTime(queue.remove());
        }
        System.out.println();
      
    }//end main
    
    // displays a Time1 object in 24-hour and 12-hour formats
    private static void displayTime(String header, Time1 t)
    {
        System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n",
            header, t.toUniversalString(), t.toString());
    }
      
    // Displays the "Universal Time" in priority order
    // smaller values infer higher priority
    private static void displayUniversalTime(Time1 t)
    {
        System.out.printf("%s",
             t.toUniversalString());
    }
} // end class 

