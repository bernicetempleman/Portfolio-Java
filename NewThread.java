/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtendThread;

class NewThread extends Thread {

NewThread(){

super("Demo Thread");

System.out.println("Child Thread:" + this);

start();

}

 	public void run () {

try {

for(int i = 5; i > 0;i--) {

System.out.println("Child Thread:" + i);

Thread.sleep(500);

}

}catch (InterruptedException e) {

System.out.println("Child Interrupted");

}

System.out.println("Exiting Child Thread.");

}

}



 
