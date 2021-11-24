/*
http://homepage.cs.uiowa.edu/~slonnegr/oosd/22Threads.pdf
 */
package bounce;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static sun.invoke.util.ValueConversions.box;

public class Bounce extends JFrame
{
    private JPanel surface;
    public static void main(String [] a)
    {
        JFrame jf = new Bounce();
        jf.setSize(600, 500);
        jf.setVisible(true);
    }

    Bounce()
    {
        setTitle("Bounce");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        Container cp = getContentPane();
        cp.setBackground(new Color(255, 204, 153));
        surface = new JPanel();
        surface.setBackground(new Color(255, 204, 153));
        cp.add(surface, "Center");
        JPanel south = new JPanel();
        south.setBackground(new Color(153, 204, 153));
        JButton start = new JButton("Start");
        start.addActionListener(new ButtonHandler());
        south.add(start);

        JButton close = new JButton("Close");
        close.addActionListener(new ButtonHandler());
        south.add(close);
        cp.add(south, "South");
        
    }

    class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String arg = e.getActionCommand();
          /*  if (arg.equals("Start"))
            {
                Ball b = new Ball(surface, Color.blue);
                b.bounce();
            }
            */
            if (arg.equals("Start"))
            {
                Ball b = new Ball(surface, Color.blue);
                b.start(); // Note: calls start, not bounce
            }
            else if (arg.equals("Close"))
            {
                System.exit(0);
            }
        }
    }
} // end of class Bounce



class Ball extends Thread implements Runnable
{

    private JPanel box;
    private Color color;
    private static final int XSIZE=20, YSIZE=20;
    private int x=50, y=0, dx=2, dy=2;
    
    Ball(JPanel c, Color clr)
    {
        box = c;
        color = clr;
    }
    
    void draw()
    {
        Graphics g = box.getGraphics();
        g.setColor(color);
        g.fillOval(x, y, XSIZE, YSIZE);
    }
        
    void move()
    {
        Graphics g = box.getGraphics();
        g.setColor(box.getBackground());
        g.fillOval(x, y, XSIZE, YSIZE); // draw over old ball

        x = x + dx;
        y = y + dy;
        Dimension d = box.getSize();
        
        if (x <= 0)
        { 
            x = 0;
        } 
        dx = -dx; 
    
    
    if (x + XSIZE >= d.width)
    { 
        x = d.width-XSIZE; 
        dx = -dx; 
    }
    if (y <= 0)
    { 
        y = 0; 
        dy = -dy; 
    }
    if (y+YSIZE >= d.height)
    { 
        y = d.height-YSIZE; 
        dy = -dy; 
    }
    g.setColor(color);
    g.fillOval(x, y, XSIZE, YSIZE);
    }
    
    // Instead of method bounce()
    @Override
    public void run()
    {
        draw(); // draw ball for first time

        while (true) // run until Close button is pressed
        {
            try { Thread.sleep(20); }
            catch (InterruptedException e)
            { return; }
            move();
        }
    }

 /*   void bounce()
    {
        draw(); // draw ball for first time
        for (int k=1; k<=1000; k++)
        {
            try
            { 
                Thread.sleep(20);
            }
        
            catch (InterruptedException e)
            { 
                return; 
            }
        
            move();
        }
    }
*/
    



}//end class ball


/*
Problem
While ball is moving, no other method can be executing.
• Button presses are ignored until ball is done moving.
• Window close is ignored until ball is done moving.
• Ball is executing its code using the event handling thread.
Copyright 2004 by Ken Slonneger Threads 37
The execution of the program involves two threads:
1. A thread that executed the three lines of the main method
and then terminates.
2. A thread that listens for the occurrence of events and calls
the appropriate methods in the Listener objects. The method
bounce executes on this thread. Drawing is done on this
thread.
Solution
Make Ball a thread.
• Then other processes may execute while Ball thread is
sleeping or not scheduled to execute.
• Also, may have multiple balls.
• Every time "Start" is pressed, a new ball thread is started.

In class Bounce
if (arg.equals("Start")
{
Ball b = new Ball(surface, Color.blue):
b.start(); // Note: calls start, not bounce
}

In class Ball
class Ball extends Thread
{
// Instead of method bounce()
public void run()
{
draw(); // draw ball for first time

while (true) // run until Close button is pressed
{
try { Thread.sleep(20); }
catch (InterruptedException e)
{ return; }
move();
}
}*/
