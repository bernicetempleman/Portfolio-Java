/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter.pkg13.grapics.examples;
import javax.swing.JFrame;
/**
 *
 * @author Bernice
 */
public class Chapter13GrapicsExamples {
// Fig. 13.6: ShowColors.java
// Demonstrating Colors.


   // execute application
   public static void main(String[] args)
   {
       /*
      // create frame for ColorJPanel
      JFrame frame = new JFrame("Using colors");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ColorJPanel colorJPanel = new ColorJPanel();
      frame.add(colorJPanel); 
      frame.setSize(400, 180);
      frame.setVisible(true);
      */
      // create frame for FontJPanel
      JFrame frame = new JFrame("Using fonts");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      FontJPanel fontJPanel = new FontJPanel();
      frame.add(fontJPanel); 
      frame.setSize(420, 150);
      frame.setVisible(true);
   } 
} // end class ShowColors
    

