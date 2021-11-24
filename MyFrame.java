/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframe;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bernice
 */

public class MyFrame extends JPanel {
public int xPos, yPos, xDir = 3, yDir = 4;
public int diameter = 50;

public MyFrame(){
    final JFrame thisFrame = new JFrame();
    thisFrame.add(this);
    thisFrame.setTitle("Bouncing Ball");
    thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    thisFrame.setLocationRelativeTo(null);
    thisFrame.setSize(500, 500);

    this.addMouseListener(new MouseListener() {
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {
            xPos = e.getX();
            yPos = e.getY();
            Thread t = new Thread() {
                @Override
                public void run() {
                    while(true){
                        try{
                            Thread.sleep(10);
                        }catch(Exception e){};
                        xPos += xDir;
                        yPos += yDir;

                        if(xPos + diameter >= thisFrame.getWidth() - 25 || xPos <= 0) xDir = -xDir;
                        if(yPos + diameter >= thisFrame.getHeight() - diameter || yPos <= 0) yDir = -yDir;
                        repaint();
                    }
                } 
            };
            t.start();
        }
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {}
        });

    thisFrame.setVisible(true);

    }
    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        g.fillOval(xPos, yPos, diameter, diameter); 
    }
    
        public static void main(String[] args) {
         new MyFrame();
    }
}
