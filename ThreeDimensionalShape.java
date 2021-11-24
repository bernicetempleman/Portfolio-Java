/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 2 – 10.13 pg. 439
Name:                       Bernice Templeman

10.13 (Project: Shape Hierarchy) 
Implement the Shape hierarchy shown in Fig. 9.3. 

Each ThreeDimensionalShape should have 
methods getArea and getVolume 
to calculate the surface area and volume, respectively, of the three-dimensional shape.
 */
package shapehierarchy;

// abstract abstract class ThreeDimensionalShape extends abstract Shape
public abstract class ThreeDimensionalShape extends Shape
{
    private int x;
    private int y;
    private int z;
    
    //no arg constructor
    public ThreeDimensionalShape()
    {
        super();
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
    // 4 arg constructor
    public ThreeDimensionalShape( String color, int x, int y, int z)
    {
        super(color);
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    //return x
    public int getX()
    {
        return x;
    }
    
    //return y
    public int getY()
    {
        return y;
    }
    
    //return z
    public int getZ()
    {
        return z;
    }
    
    // abstract method requires getArea in concrete subclasses
    public abstract double getArea();

    // abstract method requires getVolume  in concrete subclasses
    public abstract double getVolume(); 
    
    // return String representation of 3-D object
    @Override
    public String toString()
    {
        return String.format("%s%nx: %d%ny: %d%nz: %d",  super.toString(), getX(), getY(), getZ());
    }
}// end ThreeDimensionalShape class
