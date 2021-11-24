/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12_Swing_Examples;
// Fig. 12.15: ButtonFrame.java
// Command buttons and action events.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame 
{
   private final JButton plainJButton; // button with just text
   private final JButton fancyJButton; // button with icons

   // ButtonFrame adds JButtons to JFrame
   public ButtonFrame()
   {
      super("Testing Buttons");
      setLayout(new FlowLayout()); 

      plainJButton = new JButton("Plain Button"); // button with text
      add(plainJButton); // add plainJButton to JFrame

      Icon bug1 = new ImageIcon("C:\\Users\\Bernice\\Documents\\CIS5200-AdvancedProgramming-Java\\ch12\\fig12_15_16\\bug1.gif");
      Icon bug2 = new ImageIcon("C:\\Users\\Bernice\\Documents\\CIS5200-AdvancedProgramming-Java\\ch12\\fig12_15_16\\bug2.gif");
      fancyJButton = new JButton("Fancy Button", bug1); // set image
      fancyJButton.setRolloverIcon(bug2); // set rollover image
      add(fancyJButton); // add fancyJButton to JFrame

      // create new ButtonHandler for button event handling 
      ButtonHandler handler = new ButtonHandler();
      fancyJButton.addActionListener(handler);
      plainJButton.addActionListener(handler);
   }

   // inner class for button event handling
   private class ButtonHandler implements ActionListener 
   {
      // handle button event
      @Override
      public void actionPerformed(ActionEvent event)
      {
         JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
            "You pressed: %s", event.getActionCommand()));
      }
   } 
} // end class ButtonFrame