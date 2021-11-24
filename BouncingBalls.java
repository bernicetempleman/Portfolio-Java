/*
23.10 (Bouncing Ball) Write a program that bounces a blue ball inside a JPanel. 
The ball should begin moving with a mousePressed event. 
When the ball hits the edge of the JPanel, it should bounce off the edge and continue in the opposite direction. 
The ball should be updated using a Runnable.

23.11 (Bouncing Balls) Modify the program in Exercise 23.10 
to add a new ball each time the user clicks the mouse.
Provide for a minimum of 20 balls. Randomly choose the color for each new ball.

High level Description
The application creates a maximum of 20 balls of a random color
and displays the balls moving within a window
The rate of movement can be controlled by modifying 
the delay time in the run() method.

main()
1. Create BouncingBallApp instance
2. Set the appropriate Window Closing features (close Window when "X" is clicked)
3. Create a "BouncingBallPanel(BBP) instance and add to container
4. Make the BBP the MouseListener" object (handle Mouse Click event)
5. Set Window size
6. Make Window Visible
*******************************************************************************
Create an application that provides a solution for problem 23.11
by modifying the solution implemented from the BouncingBall.doc file 
(located in the "Project 6/Bouncing Ball Original Solution").  
The modifications are as follows for the new solution.

Remove the "Runnable" interface from "BouncingBallPanel" class. 
Add the "Runnable" interface to "Ball" class
Modify the "mouseClicked" method in the "BouncingBallPanel"class  to start the thread after each ball is created.  
The "Ball" class must receive a reference to the "Bouncing BallPanel" (i.e., to call the "repaint" method)

Remove the "run" method from the "BouncingBallpanel" note.  
The "run" method must be implemented in the "Ball" class.  
The inner loop of the "run" method must be removed and the single "move" method call should remain. 
Also modify the method so that the delay for each ball is different 
(i.e., a way to simulate ball moving at different rates)
Make all other necessary modifications necessary to run the application.  
Zip all source code files and upload to the drop box.
 */
package bouncingballs;

public class BouncingBalls { 

    public static void main(String[] args) {

        // number of bouncing balls
        int N = Integer.parseInt(args[0]);

        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        // create an array of N random balls
        Ball[] balls = new Ball[N];
        for (int i = 0; i < N; i++)
            balls[i] = new Ball();

        // do the animation loop
        while (true) {

            // move the N balls
            for (int i = 0; i < N; i++) {
                balls[i].move();
            }

            // draw the N balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            for (int i = 0; i < N; i++) {
                balls[i].draw();
            }
            StdDraw.show(20);
        }
    
}


}