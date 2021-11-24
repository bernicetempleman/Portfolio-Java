package showcolors;

// Fig. 13.6: ShowColors.java
// Demonstrating Colors.
import javax.swing.JFrame;

public class ShowColors
{
    /*
    Method main of class ShowColors (lines 8–18 of Fig. 13.6) creates the JFrame 
    that will contain a ColorJPanel object where the colors will be displayed.   
    */
   // execute application
   public static void main(String[] args)
   {
      // create frame for ColorJPanel
      JFrame frame = new JFrame("Using colors");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ColorJPanel colorJPanel = new ColorJPanel();
      frame.add(colorJPanel); 
      frame.setSize(400, 180);
      frame.setVisible(true);
   } 
} // end class ShowColors