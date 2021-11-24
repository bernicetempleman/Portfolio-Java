/*
Create an object of your favorite class (make sure your object has an Id field).
 */
package program.pkg4.os;

import java.sql.Time;

public class Employee 
{
    public static int employeeCount = 0;
    public static int waitingCount = 0;
    
    private final int id;
    private Time waitStartTime; // time entered queue
    private Time waitEndTime;   // time left the queue
    private long totalWaitTime; // total time in the queue
    private boolean waiting;    // true=waiting in the queue or false=not in the queue
    
    public Employee()
    {
        waiting = false; // not in the queue
        employeeCount++;
        id = employeeCount;
    }

    public Time getWaitStartTime() 
    {
        return waitStartTime;
    }

    public void setWaitStartTime(Time waitStartTime) 
    {
        this.waitStartTime = waitStartTime;
    }

    public Time getWaitEndTime() 
    {
        return waitEndTime;
    }

    public void setWaitEndTime(Time waitEndTime) 
    {
        this.waitEndTime = waitEndTime;
    }

    public String getTotalWaitTime() 
    {
        long diff = waitEndTime.getTime() - waitStartTime.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        //long diffDays = diff / (24 * 60 * 60 * 1000);

        String totalTime = String.format("%02d:%02d:%02d", diffHours,diffMinutes,diffSeconds);
        return totalTime;
    }

    public boolean isWaiting() 
    {
        return waiting;
    }

    public void setWaiting(boolean waiting) 
    {
        this.waiting = waiting;
    }
   
    public static int getWaitingCount() 
    {
        return waitingCount;
    }
    
    public static int getEmployeeCount() 
    {
        return employeeCount;
    }

    public int getId() 
    {
        return id;
    }
}
