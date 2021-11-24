/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapetester;



// abstract class Shape
public abstract class Shape 
{
    private String color;  
    
    // no arg constructor
    public Shape()
    {
        this.color = null;
    }
    
    // one arg constructor
    public Shape(String color)
    {
        this.color = color;
    }
    
    // set color
    public void setColor(String color)
    {
        this.color = color;
    }
    
    //return color
    public String getColor()
    {
        return color;
    }
    
    //return String representation of Shape object
    @Override
    public String toString()
    {
        return String.format("%s : %s %nColor: %s", getClass().getSuperclass().getSimpleName(),getClass().getSimpleName() , getColor());
    }   
}// end Shape class
