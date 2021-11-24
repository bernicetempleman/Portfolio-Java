/*
 * Shape.java
 */
package shapetester1;

public class Shape 
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
}
