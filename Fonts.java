/*
Figure 13.12 contains the main method, 
which creates a JFrame to display a FontJPanel.
We add a FontJPanel object to this JFrame (line 15), 
which displays the graphics created in Fig. 13.11.
*/
package fonts;

// Fig. 13.12: Fonts.java
// Using fonts.
import javax.swing.JFrame;

public class Fonts 
{
   // execute application
   public static void main(String[] args)
   {
      // create frame for FontJPanel
      JFrame frame = new JFrame("Using fonts");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      FontJPanel fontJPanel = new FontJPanel();
      frame.add(fontJPanel); 
      frame.setSize(420, 150);
      frame.setVisible(true);
   } 
} // end class Fonts
