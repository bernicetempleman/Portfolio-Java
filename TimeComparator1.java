/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 4 
Name:                       Bernice Templeman

Custom Comparator class that compares two Time1 objects.

* Note: To determine the ordering when implementing the "Comparator" interface, 
convert the time into seconds 
(i.e., hours * 3600 + minutes * 60 + seconds), 
smaller values infer higher priority)
 */

package project.pkg4;

import java.util.Comparator;

// The class must be modified to implement the "Comparator" interface
public class TimeComparator1 implements Comparator<Time1> 
{
   @Override
   public int compare(Time1 time1, Time1 time2)
   {
      String universalTime1 = time1.toUniversalString();
      String [] words1 = universalTime1.split("\\:");
      int hour1 = Integer.parseInt(words1[0]);
      int minute1 = Integer.parseInt(words1[1]);
      int second1 = Integer.parseInt(words1[2]);
      
      String universalTime2 = time2.toUniversalString();
      String [] words2 = universalTime2.split("\\:");
      int hour2 = Integer.parseInt(words2[0]);
      int minute2 = Integer.parseInt(words2[1]);
      int second2 = Integer.parseInt(words2[2]);
      
    // Note: To determine the ordering when implementing the "Comparator" interface, 
    // convert the time into seconds (i.e., hours * 3600 + minutes * 60 + seconds), 
    // smaller values infer higher priority)
      
      int intTime1 = hour1 * 3600 + minute1 * 60 + second1;
      int intTime2 = hour2 * 3600 + minute2 * 60 + second2;
      
      if ( (intTime1 - intTime2) < 0)
          return -1;
      if ((intTime1 - intTime2) > 0)
          return 1;
      return 0;
   } 
} // end class TimeComparator
