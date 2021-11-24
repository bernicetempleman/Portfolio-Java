/*

 */
package shapetester;

//public abstract class TwoDimensionalShape extends Shape 
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

