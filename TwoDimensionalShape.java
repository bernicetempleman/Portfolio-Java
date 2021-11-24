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

// abstract class TwoDimensionalShape extends  abstract class Shape
public abstract class TwoDimensionalShape extends Shape 
{
    private int x;
    private int y;
    
    // no arg constructor
    public TwoDimensionalShape()
    {
        super();   
        this.x = 0;
        this.y = 0;
    }
    
    // 3 arg constructor
    public TwoDimensionalShape(String color, int x, int y)
    {
        super(color);   
        this.x = x;
        this.y = y;
    }
    
    // retrun x
    public int getX()
    {
        return x;
    }
    
    //return y
    public int getY()
    {
        return y;
    }
    
    // abstract method requires getArea in concrete subclasses
    public abstract double getArea(); 
    
    // return String repesentation of 2-D Shape
    public String toString()
    {
        return String.format("%s%nx: %d%ny: %d", super.toString(), getX(), getY());
    }
}// end TwoDimensionalShape class
