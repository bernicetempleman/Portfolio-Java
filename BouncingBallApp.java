/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 8
Name:                       Bernice Templeman

Create an application that provides a solution for problem 23.11 
by modifying the solution implemented from the BouncingBall.doc file 
(located in the "Project 6/Bouncing Ball Original Solution").  
The modifications are as follows for the new solution.

* Remove the "Runnable" interface from "BouncingBallPanel" class. 
* Add the "Runnable" interface to "Ball" class
* Modify the "mouseClicked" method in the "BouncingBallPanel"class  
  to start the thread after each ball is created.  
  The "Ball" class must receive a reference to the "Bouncing BallPanel" 
  (i.e., to call the "repaint" method)
* Remove the "run" method from the "BouncingBallpanel" note.  
  The "run" method must be implemented in the "Ball" class.  
  The inner loop of the "run" method must be removed and the single "move" method call should remain.  
  Also modify the method so that the delay for each ball is different 
  (i.e., a way to simulate ball moving at different rates)
* Make all other necessary modifications necessary to run the application.

23.11 (Bouncing Balls) 
Modify the program in Exercise 23.10 
to add a new ball each time the user clicks the mouse.
Provide for a minimum of 20 balls. 
Randomly choose the color for each new ball.

23.10 (Bouncing Ball) 
Write a program that bounces a blue ball inside a JPanel. 
The ball should begin moving with a mousePressed event. 
When the ball hits the edge of the JPanel,
it should bounce off the edge and continue in the opposite direction. 
The ball should be updated using a Runnable.

High level Description
The application creates a maximum of 20 balls of a random color
and displays the balls moving within a window
The rate of movement can be controlled by modifying 
the delay time in the run() method.

*******************************************************************************
 */
package project.pkg8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BouncingBallApp extends JFrame
{
    private BouncingBallPanel BBP;
   
    //create an empty array for 20 Ball objects. The Ball Array
    private Ball[] balls;
    
    // set ball count to 0
    int ballCount = 0;

    // App constructor
    public BouncingBallApp()  
    {
        super("Bouncing Balls");
        BBP = new BouncingBallPanel(500, 500);
    
        balls = new Ball[20];
        add(BBP);
  
        setSize(500, 500);
        setVisible(true);
    } // end constructor

    // Main method:
    //1. Create BouncingBallApp instance
    //2. Set the appropriate Window Closing features (close Window when "X" is clicked)
    //3. Create a "BouncingBallPanel(BBP) instance and add to container
    //4. Make the BBP the MouseListener" object (handle Mouse Click event)
    //5. Set Window size
    //6. Make Window Visible
   public static void main(String args[])  
   {
        BouncingBallApp application = new BouncingBallApp();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   }//end main

   // Class Ball creates a ball and moves its position
   // A thread overrides the run method to define how the ball behaves
   // Each ball is one instance of this class 
   private class Ball extends Thread
   {
        private Ellipse2D.Double thisBall;
        private boolean ballStarted;
        private int speed;  //the delay for each ball is different 
        
        private double x;
        private double y;
        private int deltaX;
        private int deltaY;        
        private double diameter;
        private Color color;
      
        //Ball constructor
        public Ball()
        {
            // Create new ball with random color, speed, start point and direction.  
            ballStarted = true;   
            color = Color.getHSBColor((float) Math.random(), 1f, 1f);
            //size = 10 + (int)(Math.random() * 60);    //different size balls
            diameter = 40;                              // all balls have the same size
            speed = 10 + (int)(Math.random() * 100);    //the delay for each ball is different 
            x = (int)(Math.random() * 300);             //random start point
            y = (int)(Math.random() * 300);             //random start point
            deltaX = -10 + (int)(Math.random() * 21);   //random direction
            deltaY = -10 + (int)(Math.random() * 21);   //random direction
            
            if ((deltaX == 0) && (deltaY == 0)) 
            { 
                deltaX = 1; 
            }
            thisBall = new Ellipse2D.Double(x, y, diameter, diameter);             
        }//end Ball constructor
            
        public void draw(Graphics2D g2d)
        {
            if (thisBall != null)
            {
                g2d.setColor(color);
                g2d.fill(thisBall);
            }
        }
      
        //The "run" method must be implemented in the "Ball" class.  
        //Also modify the method so that the delay for each ball is different 
        //(i.e., a way to simulate ball moving at different rates)
        public void run()
        {
            while(ballStarted)   // Keeps ball moving
            {
                try 
                {
                    // To free up processor time
                    Thread.sleep(speed);
                }
                catch (InterruptedException e)
                {   
                    System.out.println("Woke up early");
                }

                // calculate new position and move ball
                int oldX = (int) thisBall.getX();
                int oldY = (int) thisBall.getY();
                int newX = oldX + deltaX;
                if (newX + diameter > BBP.getWidth() || newX < 0) 
                    deltaX = -deltaX;
                int newY = oldY + deltaY;
                if (newY + diameter > BBP.getHeight() || newY < 0) 
                    deltaY = -deltaY;            
                thisBall.setFrame(newX, newY, diameter, diameter);
                BBP.repaint();
            }//end while
        }//end run
    } //end Ball


    // Balls drawn on Panel
    private class BouncingBallPanel extends JPanel  
    {
        private int width;
        private int height;
 
        //Bouncing Ball Panel constructor
        public BouncingBallPanel (int w, int h)
        {
            width = w;
            height = h;
            setBackground(Color.BLACK);
      
            // add ball when mouse is clicked
            addMouseListener(

		new MouseAdapter()  {
		   public void mouseClicked(MouseEvent e)
                   {
                       if (ballCount < 20)
                       {
                            balls[ballCount] = new Ball();
                            balls[ballCount].start();
                            ballCount++;
                       }                     
                   }
                }
          );
        }//end Bouncing Ball Panel constructor

        public Dimension getPreferredSize()
        {
            return new Dimension(width, height);
        }

        public void paintComponent (Graphics g)  
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < ballCount; i++) 
            { 
                balls[i].draw(g2d);
            }
        }//end paintComponent
   } // end BouncingBallPanel inner class
} // end BouncingBallApp
           