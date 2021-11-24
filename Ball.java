/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

public class Ball {

    // instance variables
    private double rx, ry;        // position
    private double vx, vy;        // velocity
    private final double radius;  // radius

    // constructor
    public Ball() {
        rx = 0.0;
        ry = 0.0;
        vx     = 0.015 - Math.random() * 0.03;
        vy     = 0.015 - Math.random() * 0.03;
        radius = 0.025 + Math.random() * 0.05;
    }

    // bounce of vertical wall by reflecting x-velocity
    private void bounceOffVerticalWall() {
        vx = -vx;
    }

    // bounce of horizontal wall by reflecting y-velocity
    private void bounceOffHorizontalWall() {
        vy = -vy;
    }

    // move the ball one step
    public void move() {
        if (Math.abs(rx + vx) + radius > 1.0) bounceOffVerticalWall();
        if (Math.abs(ry + vy) + radius > 1.0) bounceOffHorizontalWall();
        rx = rx + vx;
        ry = ry + vy;
    }

    // draw the ball
    public void draw() {
        StdDraw.filledCircle(rx, ry, radius);
    }



    // test client
    public static void main(String[] args) {

        // create and initialize two balls
        Ball b1 = new Ball();
        Ball b2 = new Ball();

        // animate them
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);
        while (true) {
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            b1.move();
            b2.move();
            b1.draw();
            b2.draw();
            StdDraw.show(20);
        }
    }
}
