/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testscheduler;

public class Scheduler extends Thread

{
    private CircularList queue;

private int timeSlice;

private static final int DEFAULT_TIME_SLICE = 1000;

public Scheduler(){

timeSlice = DEFAULT_TIME_SLICE;

queue = new Circularlist();

}

public Scheduler(int quantum){

timeSlice = quantum;

queue = new Circularlist();

}

public addThread(Thread t) 
{

t.setPriority(2);

queue.additem(t);

}

private void schedulerSleep() {

try{

Thread.sleep(timeSlice );

} catch (InterruptedException e){};

}

 

 

public void run(){

Thread current;

this.setPriority(6);

while (true) {

// get the next thread

current = (Thread)queue.getnext();

if ( (current != null) && (current.isAlive()) ){

current.setPriority(4);

schedulerSleep();

current.setPriority(2);

}

}

}



}
