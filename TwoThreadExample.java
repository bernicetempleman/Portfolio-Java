/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twothreadexample;

public class TwoThreadExample 
{
    public TwoThreadExample() 
    {
        (new SimpleThread("First Thread")).start();
        (new SimpleThread("Second Thread")).start();
    }
 
    private class SimpleThread extends Thread 
    {
        public SimpleThread(String str) { super(str); }
        public void run() 
        {
            for (int i = 0; i < 10; i++) 
            {
                System.out.println(getName() + " says " + i);
                try
                { 
                    sleep((long)(Math.random() * 1000)); 
                }
                catch (InterruptedException e) 
                {
                    System.out.println("InterruptedException");
                }
            }
            System.out.println(getName() + " is done.");
        }
    }
 
    public static void main (String[] args) 
    {
        new TwoThreadExample();
    }
}
