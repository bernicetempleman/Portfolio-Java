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

//Triangle class extends abstract TwoDimensionalShape class
public class Triangle extends TwoDimensionalShape{
    
    private double base;
    private double height;
    
    // no arg constructor
    public Triangle()
    {
        super();
        this.base = 0;
        this.height = 0; 
    }
    
    // 5 arg constructor
    public Triangle(String color, int x, int y, double base, double height)
    {
        super(color,x,y);
        if ( base < 0)
            throw new IllegalArgumentException("base must be >= 0.0");
        this.base = base;
        
        if( height < 0)
            throw new IllegalArgumentException("height must be >= 0.0");
        this.height = height; 
    }
    
    //sets height
    public void setHeight(double height)
    {      
        if( height < 0)
            throw new IllegalArgumentException("height must be >= 0.0");
        this.height = height;
    }
    
    //sets base
    public void setBase(double base)
    {
        if ( base < 0)
            throw new IllegalArgumentException("base must be >= 0.0");
        this.base = base;      
    }
    
    //return height
    public double getHeight()
    {
        return height;
    }
    
    // return base
    public double getBase()
    {
        return base;
    }

    // get area of 2-d shape
    @Override
    public double getArea() {
        return 1/2.0 * base * height;
    }
    
    //return string representation of shape
    @Override
    public String toString()
    {
        return String.format("%s%nBase: %.2f%nHeight: %.2f", super.toString(), getBase(), getHeight());
    }
}// end class Triangle
