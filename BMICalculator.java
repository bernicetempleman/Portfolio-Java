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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bernice
 */
public class BMICalculator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BMICalculator.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("BMI Calculator"); // displayed in window's title bar
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
