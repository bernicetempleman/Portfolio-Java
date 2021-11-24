/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Bernice
 */
public class ColorChooserController //implements Initializable 
{
    
    @FXML private Slider blueSlider;
    @FXML private TextField blueTextField;
    @FXML private Rectangle colorRectangle;
    
    private int blue = 0;


    
    public void initialize()
    {
        blueTextField.textProperty().bind(blueSlider.valueProperty().asString("%.0f"));
        
        blueSlider.valueProperty().addListener(
    (observableValue, oldValue, newValue) ->
            {
                blue = newValue.intValue();
                colorRectangle.setFill(Color.rgb(blue, 0, 0));
            });
        
    }    
    
}
