/*
To change the color, you must create a new Color object 
(or use one of the predeclared Color constants). 
Like String objects, Color objects are immutable (not modifiable).

The JColorChooser component (package javax.swing) enables application users 
to select colors. Figures 13.7–13.8 demonstrate a JColorChooser dialog. 
When you click the Change Color button, a JColorChooser dialog appears. 
When you select a color and press the dialog’s OK button,
the background color of the application window changes.
 */
package showcolors2;

// Fig. 13.7: ShowColors2JFrame.java
// Choosing colors with JColorChooser.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ShowColors2JFrame extends JFrame 
{
   private final JButton changeColorJButton;
   private Color color = Color.LIGHT_GRAY;
   private final JPanel colorJPanel;

   // set up GUI
   public ShowColors2JFrame()
   {
      super("Using JColorChooser");

      // create JPanel for display color
      colorJPanel = new JPanel();
      colorJPanel.setBackground(color);

      // set up changeColorJButton and register its event handler
      changeColorJButton = new JButton("Change Color");
      changeColorJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {
            // display JColorChooser when user clicks button
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
                /*
                Class JColorChooser provides static method showDialog, 
                which creates a JColorChooser object,
                attaches it to a dialog box and displays the dialog. 
                Lines 36–37 of Fig. 13.7 invoke this method to display the color-chooser dialog. 
                Method showDialog returns the selected Color object, or null 
                if the user presses Cancel or closes the dialog without pressing OK. 
                The method takes three arguments—a reference to its parent Component,
                a String to display in the title bar of the dialog and the initial selected 
                Color for the dialog. The parent component is a reference to the window 
                from which the dialog is displayed (in this case the JFrame, 
                with the reference name frame). The dialog will be centered on the parent. 
                If the parent is null, the dialog is centered on the screen. 
                While the color-chooser dialog is on the screen, the user cannot interact 
                with the parent component until the dialog is dismissed. 
                This type of dialog is called a modal dialog.
                
                */
               color = JColorChooser.showDialog(
                  ShowColors2JFrame.this, "Choose a color", color);

               /*
               After the user selects a color, lines 40–41 determine whether color is null, 
               and, if so, set color to Color.LIGHT_GRAY.
               */
               // set default color, if no color is returned 
               if (color == null)
                  color = Color.LIGHT_GRAY;

               /*
               Line 44 invokes method setBackground to change the background color 
               of the JPanel. Method setBackground is one of the many Component 
               methods that can be used on most GUI components. 
               The user can continue to use the Change Color button 
               to change the background color of the application.
               */
               // change content pane's background color
               colorJPanel.setBackground(color);
            } 
         } // end anonymous inner class
      ); // end call to addActionListener
 
      add(colorJPanel, BorderLayout.CENTER); 
      add(changeColorJButton, BorderLayout.SOUTH);

      setSize(400, 130);
      setVisible(true);
   } // end ShowColor2JFrame constructor
} // end class ShowColors2JFrame
