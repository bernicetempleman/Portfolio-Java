/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testscheduler;

/**
 *
 * @author Bernice
 */
public class TestScheduler {



public static void main(String args[]) 
{

Thread.currentThread().setpriority(Thread.Max_Priority);

Schedular CPUSchedular = new Scheduler ();

CPUSchedular.start()

 

TestThread t1 = new TestThread("Thread 1");

t1.start()

CpuSchedular.addThread(t1);

TestThread t2 = new TestThread("Thread 2");

t2.start()

CpuSchedular.addThread(t2);

TestThread t3 = new TestThread("Thread 1");

t3.start()

CpuSchedular.addThread(t3);

}

