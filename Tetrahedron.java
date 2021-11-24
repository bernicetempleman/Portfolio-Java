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

// Class Tetrahedron extends abstract class ThreeDimensionalShape
public class Tetrahedron extends ThreeDimensionalShape{
    
    private double edgeLength;
    
    // no arg constructor
    public Tetrahedron()
    {
        super();
        this.edgeLength =  0;
    }
    
    // 5 arg constructor
    public Tetrahedron(String color, int x, int y, int z, double edgeLength)
    {
        super(color,x,y,z);
        if (edgeLength < 0)
            throw new IllegalArgumentException("edgeLength must be >= 0.0");
        this.edgeLength =  edgeLength;
    }
    
    // set edgeLength
    public void setEdgeLength(double edgeLength)
    {
        if (edgeLength < 0)
            throw new IllegalArgumentException("edgeLength must be >= 0");
        this.edgeLength = edgeLength;
    }
    
    // get edgeLength
    public double getEdgeLength()
    {
        return edgeLength;
    }

    // return area of 3-D shape
    @Override
    public double getArea() {
        // Surface area = 4 * Face Area
        return 4 * getFaceArea();
    }
    
    // return face area
    public double getFaceArea()
    {
        // Face Area = ((square root(3))/4) * edgelength * edgelength
        return ((Math.sqrt(3)/4.0) * edgeLength * edgeLength);
    }
    
    // return height
    public double getHeight()
    {
        // height = ((square root of 6)/3) * edgelength
        return  (Math.sqrt(6.0)/ 3.0 * edgeLength );
    }

    // return volume of 3-d shape
    @Override
    public double getVolume() 
    {
        // volume = 1/3 * face area * height
        return (1/3.0) * getFaceArea() * getHeight();
    }
    
    //return string description of shape
    @Override
    public String toString()
    {
        return String.format("%s%nEdge Length: %.2f", super.toString(), getEdgeLength());
    }
}// end class Tetrahedron
