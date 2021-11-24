/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballisticballs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This applet shows an animation of red balls moving on a black
 * background.  The balls "bounce" off the sides of the applet.
 * The number of balls can be set as the value of an applet
 * param with name "ballCount".  The default number is 50.
 * The number of milliseconds per frame can be set as the value of an
 * applet parameter with name "frameTime".  The default is 
 * 50 milliseconds. 
 * 
 * If the user clicks on the applet, or drags the mouse on
 * the applet, all the balls head towards the mouse location.
 * 
 * The "balls" are represented by objects of type MovingBall, which
 * is defined in the file MovingBall.java.
 * 
 * This class also contains a main() routine that allows the class
 * to be run as a stand-alone application.
 */
public class BallisticBalls extends JApplet {
   
   
   /**
    * main() routine simply opens a window that uses an object of
    * type Display as its content pane, where Display is a static
    * nested class inside this class.
    */
   public static void main(String[] args) {
      JFrame window = new JFrame("Ballistic Balls");
      Display content = new Display(50,50);
      window.setContentPane(content);
      window.pack();
      window.setLocation(100,100);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setResizable(false);  
      window.setVisible(true);
   }
   

   /**
    * The init() method of the applet uses an object of type Display
    * as the content pane of the applet. It also process the
    * applet params named "ballCount" and "frameTime", if present,
    * and uses their values to configure the Display.
    */
   public  void init() {
      
      int millisecondsPerFrame;  // Time between frames in animation.
      int ballCount;             // Number of MovingBalls that are used.
      
      try {
            // Try to read the value of millisecondsPerFrame from
            // an applet parameter named "frameTime".  If it is not
            // present or is not a legal value, an error will occur,
            // and the default value of 50 will be used.
         String str = getParameter("frameTime");
         millisecondsPerFrame = Integer.parseInt(str);
         if (millisecondsPerFrame <= 0)
            millisecondsPerFrame = 50;
      }
      catch (NumberFormatException e) {
         millisecondsPerFrame = 50;  // Use default value.
      }
      
      try {
            // Try to read the value of ballCount from
            // an applet parameter named "ballCount".  If it is not
            // present or is not a legal value, an error will occur,
            // and the default value of 50 will be used.
         String str = getParameter("ballCount");
         ballCount = Integer.parseInt(str);
         if (ballCount <= 0)
            ballCount = 50;
      }
      catch (NumberFormatException e) {
         ballCount = 50;  // Use default value.
      }
      
      setContentPane( new Display(ballCount, millisecondsPerFrame) );
      
   } // end init();
   
   
   
   /**
    * The nested class Display does all the work of the program.
    * It represents the drawing area in which the balls move.
    */
   private static class Display extends JPanel {

      MovingBall[] balls;  // An array to hold the balls.  This will be
                           //    null until the first time paintComponent()
                           //    is called.
      
      int ballCount;       // Number of balls requested in the constructor.
      
      
      /**
       * Constructor sets the background color (black) and preferred size (400-by-400)
       * of the panel.  It sets up mouse listeners and creates and starts a timer
       * that will drive the motion of the balls.
       * @param ballCount  the number of balls that should be used
       * @param millisecondsPerFrame  the time between frames; this becomes
       *    the delay time of the timer that drives the animation.
       */
      Display(int ballCount, int millisecondsPerFrame) {
         
         setBackground(Color.BLACK);
         setPreferredSize( new Dimension(400,400) );
         
         this.ballCount = ballCount;
         
         addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) { 
                  // The user has clicked on the panel.  Tell all the
                  // balls to head towards the location of the mouse.
               for (int i = 0; i < balls.length; i++)
                  balls[i].headTowards(evt.getX(), evt.getY());
            }
         });
         
         addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) { 
                  // The user has dragged the mouse on the panel.  Tell all
                  // the balls to head towards the location of the mouse.
               for (int i = 0; i < balls.length; i++)
                  balls[i].headTowards(evt.getX(), evt.getY());
            }
            
         });
         
         Timer timer = new Timer(millisecondsPerFrame, new ActionListener() {
                // This timer will drive the animation by calling repaint()
                // at periodic intervals.
            public void actionPerformed(ActionEvent evt) {
               repaint();
            }
         });
         timer.start();

      } // end constructor
      
      
      /**
       * The paint component method moves all the balls along their trajectories
       * (by calling ball.travel() for each ball) and draws all the balls  (by
       * calling ball.draw(g) for each ball).  Thus, the balls move each time
       * paintComponent() is called, and to drive the animation, it is only necessary
       * to call repaint() over-and-over.
       */
      public void paintComponent(Graphics g) {
         
         super.paintComponent(g);
         
         if (balls == null) {
            balls = new MovingBall[ ballCount ];  // Create the array
            for (int i = 0; i < balls.length; i++) {
                  // Create each of the ball objects.  The parameters specify
                  // that the balls are restricted to moving within the bounds
                  // of the panel.  NOTE: This is done in paintComponent() 
                  // because the size of the panel has not yet been set when the
                  // constructor is called.
               balls[i] = new MovingBall(0, getWidth(), 0, getHeight());
            }
         }
         
         /* Tell each ball to move.  It moves an amount depending on
          its current direction and speed, and it will "bounce" off the
          side of the applet if necessary.  Then the ball is told
          to draw itself in the graphics context g.
          */
         
         for (int i = 0; i < balls.length; i++) {
            balls[i].travel();
            balls[i].draw(g);
         }
         
      } // end paintComponent()
      
      
   } // end nested class Display
   
}  // end class BallisticBalls 
