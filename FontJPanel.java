
package fonts;

// Fig. 13.11: FontJPanel.java
// Display strings in different fonts and colors.
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FontJPanel extends JPanel
{
   // display Strings in different fonts and colors
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      
      /*
      uses the Font constructor to initialize Font objects 
(in lines 17, 21, 25 and 30) that are each passed to Graphics method setFont 
to change the drawing font. Each call to the Font constructor passes a font name 
(Serif, Monospaced or SansSerif) as a string, a font style 
(Font.PLAIN, Font.ITALIC or Font.BOLD) and a font size. 
Once Graphics method setFont is invoked, all text displayed following the call 
will appear in the new font until the font is changed. 
      */

      // 17 set font to Serif (Times), bold, 12pt and draw a string 
      g.setFont(new Font("Serif", Font.BOLD, 12));
      
      /*
       Each font’s information 
is displayed in lines 18, 22, 26 and 31–32 using method drawString. 
The coordinates passed to drawString correspond to the lower-left corner of 
the baseline of the font.
      */
      g.drawString("Serif 12 point bold.", 20, 30);

      // 21 set font to Monospaced (Courier), italic, 24pt and draw a string 
      g.setFont(new Font("Monospaced", Font.ITALIC, 24));
      g.drawString("Monospaced 24 point italic.", 20, 50);

      // 25 set font to SansSerif (Helvetica), plain, 14pt and draw a string 
      g.setFont(new Font("SansSerif", Font.PLAIN, 14));
      g.drawString("SansSerif 14 point plain.", 20, 70);
      
     /* Line 29 changes the drawing color to red, 
      so the next string displayed appears in red.
     */
   
      g.setColor(Color.RED);
      
      // 30 set font to Serif (Times), bold/italic, 18pt and draw a string
      g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
      
      /*
      Lines 31–32 display information about the final Font object.
      Method getFont of class Graphics returns a Font object representing
      the current font. Method getName returns the current font name as a string. 
      Method getSize returns the font size in points.
      */
      g.drawString(g.getFont().getName() + " " + g.getFont().getSize() +
         " point bold italic.", 20, 90);
   } 
} // end class FontJPanel
