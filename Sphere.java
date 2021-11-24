/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 2 – 10.13 pg. 439
Name:                       Bernice Templeman

10.13 (Project: Shape Hierarchy) 
Implement the Shape hierarchy shown in Fig. 9.3. 

Each ThreeDimensionalShape should have methods getArea and getVolume 
to calculate the surface area and volume, respectively, of the three-dimensional shape.
 */
package shapehierarchy;

// class Sphere extends abstract class ThreeDimensionalShape
public class Sphere extends ThreeDimensionalShape{
    
    private double radius;
    
    // no arg constructor
    public Sphere()
    {
        super();
        this.radius = 0;
    }
    
    // 5 arg constructor
    public Sphere(String color, int x, int y, int z, double radius)
    {
        super(color, x, y, z);
        if (radius < 0.0)
            throw new IllegalArgumentException("radius must be >= 0.0");
        this.radius = radius;
    }
    
    // set radius
    public void setRadius( double radius)
    {
        if(radius < 0.0)
            throw new IllegalArgumentException("radius must be >= 0.0");
        this.radius =  radius;
    }
    
    //get radius
    public double getRadius()
    {
        return radius;
    }

    //return area of 3-d shape
    @Override
    public double getArea() 
    {
        return 4 * Math.PI * radius * radius;
    }

    // return volume of 3-d shape
    @Override
    public double getVolume() 
    {
        return  (4/3.0) * Math.PI * radius * radius * radius;
    }
    
    //return string description of shape
    @Override
    public String toString()
    {
        return String.format("%s%nRadius: %.2f", super.toString(),getRadius());
    }
}//end class Sphere
