/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 2 – 10.13 pg. 439
Name:                       Bernice Templeman

10.13 (Project: Shape Hierarchy) 
Implement the Shape hierarchy shown in Fig. 9.3. 

 */
package shapehierarchy;

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
