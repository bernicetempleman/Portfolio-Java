/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 4 
Name:                       Bernice Templeman

"Time1" class shown in Fig. 8.1 on page 317.  
*/

package project.pkg4;

// Fig. 8.1: Time1.java
// Time1 class declaration maintains the time in 24-hour format.
public class Time1 
{
    private int hour; // 0 - 23  
    private int minute; // 0 - 59 
    private int second; // 0 - 59 
  
    // set a new time value using universal time; throw an
    // exception if the hour, minute or second is invalid
    public void setTime(int hour, int minute, int second)
    {
        // validate hour, minute and second
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60)
        {
            throw new IllegalArgumentException(               
               "hour, minute and/or second was out of range");
        }
 
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
 
    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString()
    {
        return String.format("%d:%d:%d", hour, minute, second);
    }
 
    // convert to String in standard-time format (H:MM:SS AM or PM)
    @Override
    public String toString()
    {
        return String.format("%d:%d:%d %s",         
            ((hour == 0 || hour == 12) ? 12 : hour % 12),
            minute, second, (hour < 12 ? "AM" : "PM"));  
    }
} // end class Time1
