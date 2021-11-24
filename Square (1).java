/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapetester;

// class Square extends abstract class TwoDimensionalShape
public class Square extends TwoDimensionalShape
{   
    private double side;
    
    //no arg constructor
    public Square() 
    {
        super();
        this.side = 0;
    }
    
    // 4 arg constructor
    public Square(String color, int x, int y, double side) 
    {
        super(color,x,y);
        if (side < 0)
            throw new IllegalArgumentException("side must be >= 0.0");
        this.side = side;
    }
    
    // set side
    public void setSide(double side)
    {
        if ( side < 0.0)
            throw new IllegalArgumentException("side must be >= 0.0");
        this.side = side;
    }
    
    //get side
    public double getSide()
    {
        return side;
    }

    //return area of a 2-d shape
    @Override
    public double getArea() 
    {
        return side * side;
    }
    
    //return string representation of shape
    @Override
    public String toString()
    {
        return String.format("%s%nSide: %.2f", super.toString(), getSide());
    }
}//end class Square
