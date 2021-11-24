/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 1
Name:                       Bernice Templeman

Project 10 Description-2
Create an application that satisfies the requirements of problem 25.9 on page 1139. 
Compress and upload the entire project folder.

25.9 (Body Mass Index Calculator App) The formulas for calculating the BMI are

  BMI = (weightInPounds * 703)/(heightInInches * heightInInches)
or
  BMI = weightInKilograms/(heightInMeters * heightInMeters)

Create a BMI calculator app that allows users to enter their 
1.	weight and 
2.	height and whether they are entering these values in
3.	English or metric units, 
4.	then calculates and displays the user’s body mass index. 
5.	The app should also display the following information from the 
Department of Health and Human Services/National Institutes of Health 
so that users can evaluate their BMIs:

BMI VALUES
Underweight:   less than 18.5
Normal:        between 18.5 and 24.9
Overweight:    between 25 and 29.9
Obese:         30 or greater

 */
package bmicalculator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class BMICalculatorController implements Initializable 
{   
      
   // GUI controls defined in FXML and used by the controller's code
   @FXML 
   private TextField engWeightTextField; 

   @FXML
   private TextField engHeightTextField; 
  
   @FXML
   private TextField engBMITextField;
 
   // calculates and displays the bmi for English values
   @FXML
   private void calculateEngButtonPressed(ActionEvent event) 
   {
       //get the input from the text field and trim it
        String weight = engWeightTextField.getText().trim();
        String height = engHeightTextField.getText().trim();

        String numericPattern = "-?\\d+(\\.\\d+)?"; //pattern to check if numeric
        
        //check if weight and heigt are numeric
        boolean match1 = Pattern.matches(numericPattern, weight);
        boolean match2 = Pattern.matches(numericPattern, height);
        
        //if weight & height are numeric calculate and display BMI
        if(match1 && match2)
        { 
            //calculate BMI
            double weightInPounds = Double.valueOf(weight);
            double heightInInches = Double.valueOf(height);
            double total =  Math.round(((weightInPounds * 703)/(heightInInches * heightInInches))*10.0)/10.0;
            
            //display BMI
            engBMITextField.setText(String.valueOf(total));
        } 
        else //display error message if input is not numeric
        {
            engBMITextField.setText("Error: Input numbers only.");
        }
   }//calculateEngButtonPressed
   
   // calculates and displays the BMI for Metric Values
   @FXML
   private void calculateMetricButtonPressed(ActionEvent event) 
   {
       //get the input from the text field and trim it
        String weight = engWeightTextField.getText().trim();   
        String height = engHeightTextField.getText().trim();
        
        String numericPattern = "-?\\d+(\\.\\d+)?";  //pattern to check if numeric
        
        //check if weight and heigt are numeric
        boolean match1 = Pattern.matches(numericPattern, weight);
        boolean match2 = Pattern.matches(numericPattern, height);
        
        //if weight & height are numeric calculate and display BMI
        if(match1 && match2)
        {  
            //calculate BMI in metric
            double weightInKilograms = Double.valueOf(weight);
            double heightInMeters = Double.valueOf(height);        
            double total =  Math.round((weightInKilograms)/(heightInMeters * heightInMeters)*10.0)/10.0;
            
            //Display BMI
            engBMITextField.setText(String.valueOf(total));  
        }
        else  //display error message if input is not numeric
        {
            engBMITextField.setText("Error: Input numbers only.");
        }
   }//end calculateMetricButtonPressed
   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    } 
}//end class

