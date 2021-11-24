/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 2 – 10.13 pg. 439
Name:                       Bernice Templeman

10.13 (Project: Shape Hierarchy) 
Implement the Shape hierarchy shown in Fig. 9.3. 

Each TwoDimensionalShape should contain 
method getArea to calculate the area of the two-dimensional shape.  
 */
package shapehierarchy;

// class Vircle extends abstract class TwoDimensionalShape
public class Circle extends TwoDimensionalShape
{ 
    private double radius;

    // no arg constructor
    public Circle()
    {
        super();
        this.radius = 0;
    }
    
    // 4 arg constructor
    public Circle( String color, int x, int y, double radius)
    {
        super(color, x, y);
        if (radius < 0.0)
            throw new IllegalArgumentException("radius must be >= 0.0");
        this.radius = radius;
    }
    
    // set radius
    public void setRadius(double radius)
    {
        if(radius < 0)
            throw new IllegalArgumentException("radius must be >= 0.0");
        this.radius = radius;
    }
    
    // return radius
    public double getRadius()
    {
        return radius;
    }
    
    // return area of 2-d shape
    @Override
    public double getArea() 
    {
        return Math.PI * (radius * radius);
    }
    
    // return String description of Circle
    @Override
    public String toString()
    {
        return String.format("%s%nRadius: %.2f", super.toString(), getRadius());
    }
}//end class Circle
