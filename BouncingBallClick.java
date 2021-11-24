/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballclick;

/**
 *
 * @author Bernice
 */
/***********************************************************
 * Bouncing Ball
 * Author:  Eric Eaton, Benedict Brown
 * 
 * Description:
 * Simulates a ball bouncing off the walls
 * and floor with acceleration due to gravity
 * 
 * Compilation:  javac BouncingBallClick.java
 * Execution:    java BouncingBallClick maxBalls
 *               Animates up to maxBalls bouncing balls,
 *               Balls are created when the user clicks
 *                  the mouse.
 * 
 * Program Arguments:  maxBalls - the maximum number
 *                                 of balls to draw
 * 
 ***********************************************************/

public class BouncingBallClick {
    public static void main(String[] args) {
        // read in the maximum number of balls
        int maxBalls = Integer.parseInt(args[0]);

        // so far we haven't created any balls
        int nBalls = 0;

        // setup the window
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
      
        // set up the parallel arrays to store ball info
        double[] x  = new double[maxBalls];
        double[] y  = new double[maxBalls];
        double[] dx = new double[maxBalls];
        double[] dy = new double[maxBalls];
        double[] accel = new double[maxBalls];

        boolean justCreatedBall = false;

        String BALL_FILE  = "soccer_ball.png";
        String SOUND_FILE = "pop.wav";

        while (true) {
            // check if the user is just pressed the mouse
            if (StdDraw.mousePressed()) {
                // check that we haven't reached the maximum number of balls
                // and also that we haven't already created a ball for this
                // mouse click
                if (!justCreatedBall && nBalls < maxBalls) {
                    // create another ball at the current mouse position
                    // set a randome velocity and acceleration
                    x[nBalls] = StdDraw.mouseX(); // current mouse position
                    y[nBalls] = StdDraw.mouseY();      
                    dx[nBalls] = Math.random();
                    dy[nBalls] = .5 + .5 * Math.random();
                    accel[nBalls] = .05 + .3 * Math.random();

                    StdAudio.play(SOUND_FILE); // play a sound

                    nBalls++; // now we have one more ball!

                    // make sure we don't create another ball
                    // until we click again
                    justCreatedBall = true;
                }
            } else {
                // the mouse is up, so we didn't create a ball
                justCreatedBall = false;
            }

            // draw the balls
            StdDraw.clear(StdDraw.WHITE);
            StdDraw.setPenColor(StdDraw.RED);
            for (int i = 0; i < nBalls; i++) {
              // draw ball image centered at (x[i], y[i])
              StdDraw.picture(x[i], y[i], BALL_FILE);
            }
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.square(50,50,50);
          
            // simulate motion
            for (int i = 0; i < nBalls; i++) {
                x[i]  = x[i]  + dx[i];
                y[i]  = y[i]  - dy[i];
                dy[i] = dy[i] + accel[i];

                // bounce off floor
                if (y[i] <= 0) {
                    dy[i] = -0.9 * dy[i];
                }

                // bounce off walls
                if (x[i] <= 0 || x[i] >= 100 ) {
                    dx[i] = -dx[i];
                }
            }

            // animate
            StdDraw.show(5);
        }
    }
}