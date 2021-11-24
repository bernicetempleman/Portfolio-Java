/*
Figure 13.8(b) shows the default JColorChooser dialog that allows the user 
to select a color from a variety of color swatches. 
There are three tabs across the top of the dialog—Swatches, HSB and RGB. 
These represent three different ways to select a color. 
The HSB tab allows you to select a color based on hue, saturation and brightness
—values that are used to define the amount of light in a color. 
Visit http://en.wikipedia.org/wiki/HSL_and_HSV for more information on HSB. 
The RGB tab allows you to select a color by using sliders to select the 
red, green and blue components. 
The HSB and RGB tabs are shown in Fig. 13.9.
 */
package showcolors2;

// Fig. 13.8: ShowColors2.java
// Choosing colors with JColorChooser.
import javax.swing.JFrame;

public class ShowColors2
{
   // execute application
   public static void main(String[] args)
   {
      ShowColors2JFrame application = new ShowColors2JFrame();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
} // end class ShowColors2
