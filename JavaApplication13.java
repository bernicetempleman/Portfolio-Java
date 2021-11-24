/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12_Swing_Examples;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Bernice
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args)
      {
          // obtain user input from JOptionPane input dialogs    
     /*    String firstNumber =                                   
            JOptionPane.showInputDialog("Enter first integer"); 
        String secondNumber =                                  
           JOptionPane.showInputDialog("Enter second integer");
        
         // convert String inputs to int values for use in a calculation
         int number1 = Integer.parseInt(firstNumber);
         int number2 = Integer.parseInt(secondNumber);
 
         int sum = number1 + number2;
 
         // display result in a JOptionPane message dialog       
         JOptionPane.showMessageDialog(null, "The sum is " + sum,
            "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);   
         
      LabelFrame labelFrame = new LabelFrame(); 
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      labelFrame.setSize(260, 180); 
      labelFrame.setVisible(true); 
     
      TextFieldFrame textFieldFrame = new TextFieldFrame(); 
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textFieldFrame.setSize(350, 100); 
      textFieldFrame.setVisible(true); 
      
      ButtonFrame buttonFrame = new ButtonFrame(); 
      buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      buttonFrame.setSize(275, 110); 
      buttonFrame.setVisible(true); 
      
      
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); 
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      checkBoxFrame.setSize(275, 100); 
      checkBoxFrame.setVisible(true); 
      
      
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      radioButtonFrame.setSize(300, 100); 
      radioButtonFrame.setVisible(true); 
             
             
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); 
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      comboBoxFrame.setSize(350, 150); 
      comboBoxFrame.setVisible(true); 
      
      ListFrame listFrame = new ListFrame(); // create ListFrame
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      listFrame.setSize(350, 150); 
      listFrame.setVisible(true); 
      
      
        MultipleSelectionFrame multipleSelectionFrame =
         new MultipleSelectionFrame(); 
        multipleSelectionFrame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE);
        multipleSelectionFrame.setSize(350, 150); 
        multipleSelectionFrame.setVisible(true); 
        
                
      MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame(); 
      mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mouseTrackerFrame.setSize(300, 100); 
      mouseTrackerFrame.setVisible(true); 
      
      
      MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame(); 
      mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mouseDetailsFrame.setSize(400, 150); 
      mouseDetailsFrame.setVisible(true); 
      }

//Painter
// create JFrame
      JFrame application = new JFrame("A simple paint program");

      PaintPanel paintPanel = new PaintPanel(); 
      application.add(paintPanel, BorderLayout.CENTER); 
      
      // create a label and place it in SOUTH of BorderLayout
      application.add(new JLabel("Drag the mouse to draw"), 
         BorderLayout.SOUTH);

      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      application.setSize(400, 200); 
      application.setVisible(true); 
      
      KeyDemoFrame keyDemoFrame = new KeyDemoFrame(); 
      keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      keyDemoFrame.setSize(350, 100); 
      keyDemoFrame.setVisible(true); 
      
              FlowLayoutFrame flowLayoutFrame = new FlowLayoutFrame(); 
      flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      flowLayoutFrame.setSize(300, 75); 
      flowLayoutFrame.setVisible(true); 
             
          
          BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame(); 
      borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      borderLayoutFrame.setSize(300, 200); 
      borderLayoutFrame.setVisible(true); 
      
      
              GridLayoutFrame gridLayoutFrame = new GridLayoutFrame(); 
      gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gridLayoutFrame.setSize(300, 200); 
      gridLayoutFrame.setVisible(true); 
             */
          PanelFrame panelFrame = new PanelFrame(); 
      panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panelFrame.setSize(450, 200); 
      panelFrame.setVisible(true); 
             
}
}
