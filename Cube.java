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

// class Cube extends abstract class ThreeDimensionalShape
public class Cube extends ThreeDimensionalShape
{
    private double side;
    
    // no arg constructor
    public Cube()
    {
        super();
        this.side = 0;
    }
    
    // 5 arg constructor
    public Cube(String color, int x, int y, int z, double side)
    {
        super(color, x,y,z);
        if (side < 0)
            throw new IllegalArgumentException("side must be >= 0.0");
        this.side = side;
    }
    
    // set side
    public void setSide(double side)
    {
        if(side < 0)
            throw new IllegalArgumentException("side must be >= 0.0");
        this.side = side;
    }
    
    // return side
    public double getSide()
    {
        return side;
    }

    // return area of 3-d shape
    @Override
    public double getArea() 
    {
        return 6 * side * side;
    }

    //return volume of 3-d shape
    @Override
    public double getVolume() 
    {
        return side * side * side;
    }
    
    //return string representation of shape
    @Override
    public String toString()
    {
        return String.format("%s%nSide: %.2f", super.toString(), getSide());
    }
}// end class Cube
