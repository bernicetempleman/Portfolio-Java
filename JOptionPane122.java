/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joptionpane12.pkg2;
import javax.swing.JOptionPane; 
/**
 *
 * @author Bernice
 */
public class JOptionPane122 {
// Fig. 12.2: Addition.java
// Addition program that uses JOptionPane for input and output.


   public static void main(String[] args)
   {
      // obtain user input from JOptionPane input dialogs
      String firstNumber = 
         JOptionPane.showInputDialog("Enter first integer");
      String secondNumber =
          JOptionPane.showInputDialog("Enter second integer");

      // convert String inputs to int values for use in a calculation
      int number1 = Integer.parseInt(firstNumber); 
      int number2 = Integer.parseInt(secondNumber);

      int sum = number1 + number2; // add numbers

      // display result in a JOptionPane message dialog
      JOptionPane.showMessageDialog(null, "The sum is " + sum, 
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   } 
} // end class Addition
