/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12_Swing_Examples;

// Fig. 12.21: ComboBoxFrame.java
// JComboBox that displays a list of image names.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // hold icon names
   private final JLabel label; // displays selected icon

   //C:\Users\Bernice\Documents\CIS5200-AdvancedProgramming-Java\ch12\fig12_21_22
   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   String dir = "C:\\Users\\Bernice\\Documents\\CIS5200-AdvancedProgramming-Java\\ch12\\fig12_21_22\\";
   private final Icon[] icons = { 
      new ImageIcon(dir + names[0]),
      new ImageIcon(dir + names[1]), 
      new ImageIcon(dir + names[2]),
      new ImageIcon(dir + names[3])};

   // ComboBoxFrame constructor adds JComboBox to JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout()); // set frame layout     

      imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
      imagesJComboBox.setMaximumRowCount(3); // display three rows

      imagesJComboBox.addItemListener(
         new ItemListener() // anonymous inner class
         {
            // handle JComboBox event
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // determine whether item selected
               if (event.getStateChange() == ItemEvent.SELECTED)
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);
            } 
         } // end anonymous inner class
      ); // end call to addItemListener

      add(imagesJComboBox); // add combobox to JFrame
      label = new JLabel(icons[0]); // display first icon
      add(label); // add label to JFrame
   }
} // end class ComboBoxFrame
