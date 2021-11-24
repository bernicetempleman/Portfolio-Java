/*
http://stackoverflow.com/questions/21421150/java-using-graphics-component-within-an-actionlistener
 */
package addsquares;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AddSquares {

    private int R = 0;
    private int G = 0;
    private int B = 0;
    private int xLoc = 0;
    private int yLoc = 0;

    List<Square> squares = new ArrayList<>();
    private JButton addSquare = new JButton("Add Square");
    private RectsPanel panel = new RectsPanel();

    public AddSquares() {

        addSquare.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = new Color(R, G, B);
                squares.add(new Square(xLoc, yLoc, color));
                panel.repaint();
                R += 10;
                G += 20;
                B += 30;
                xLoc += 20;
                yLoc += 20;

            }
        });

        JFrame frame = new JFrame("Draw Squares");
        frame.add(panel, BorderLayout.CENTER);
        frame.add(addSquare, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private class RectsPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Square square : squares) {
                square.drawSquare(g);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 250);
        }
    }

    private class Square {
        int x = 0; 
        int y = 0;
        Color color;

        public Square(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void drawSquare(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, 75 ,75);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddSquares addSquares = new AddSquares();
            }
        });
    }
}