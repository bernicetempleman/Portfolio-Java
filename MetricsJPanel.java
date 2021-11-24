
package metrics;

// Fig. 13.15: MetricsJPanel.java
// FontMetrics and Graphics methods useful for obtaining font metrics.
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MetricsJPanel extends JPanel 
{
   // display font metrics
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 

      //Line 16 of Fig. 13.15 creates and sets the current drawing font to a SansSerif, 
      //bold, 12-point font.
      g.setFont(new Font("SansSerif", Font.BOLD, 12));
      
      //Line 17 uses Graphics method getFontMetrics to obtain the FontMetrics 
      //object for the current font. Line 
      FontMetrics metrics = g.getFontMetrics();
      
      //Line 18 outputs the String representation of the Font returned by g.getFont().
      g.drawString("Current font: " + g.getFont(), 10, 30);
      
      // Lines 19–22 use FontMetric methods to obtain the 
      //ascent, descent, height and leading for the font.
      g.drawString("Ascent: " + metrics.getAscent(), 10, 45);
      g.drawString("Descent: " + metrics.getDescent(), 10, 60);
      g.drawString("Height: " + metrics.getHeight(), 10, 75);
      g.drawString("Leading: " + metrics.getLeading(), 10, 90);

      //Line 24 creates a new Serif, italic, 14-point font. 
      Font font = new Font("Serif", Font.ITALIC, 14);
     
      // Line 25 uses a second version of Graphics method getFontMetrics, 
      //which accepts a Font argument and returns a corresponding FontMetrics object.
      metrics = g.getFontMetrics(font);
      
      g.setFont(font);
      g.drawString("Current font: " + font, 10, 120);
      
      // Lines 28–31 obtain the ascent, descent, height and leading for the font. 
      //The font metrics are slightly different for the two fonts.
      g.drawString("Ascent: " + metrics.getAscent(), 10, 135);
      g.drawString("Descent: " + metrics.getDescent(), 10, 150);
      g.drawString("Height: " + metrics.getHeight(), 10, 165);
      g.drawString("Leading: " + metrics.getLeading(), 10, 180);
   } 
} // end class MetricsJPanel
