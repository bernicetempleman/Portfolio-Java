/*
There are several kinds of variables:

Member variables in a class—these are called fields.
Variables in a method or block of code—these are called local variables.
Variables in method declarations—these are called parameters.

Field declarations are composed of three components, in order:

Zero or more modifiers, such as public or private.
The field's type.
The field's name.

Example:

private int x
private int y

The fields TwoDimensionalShape of  are named x, y and are all of data type integer (int). 
The private keyword identifies these fields as private members, 


 */
package shapetester1;

public class TwoDimensionalShape extends Shape
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
    
    /*
    The only required elements of a method declaration are the method's return type, name, a pair of parentheses, (), and a body between braces, {}.

More generally, method declarations have six components, in order:

Modifiers—such as public, private, and others you will learn about later.
The return type—the data type of the value returned by the method, 
    or void if the method does not return a value.
The method name—the rules for field names apply to method names as well, 
    but the convention is a little different.
The parameter list in parenthesis—a comma-delimited list of input parameters, 
    preceded by their data types, enclosed by parentheses, (). If there are no parameters, you must use empty parentheses.
An exception list—to be discussed later.
The method body, enclosed between braces—the method's code, 
    including the declaration of local variables, goes here.
    
Definition: Two of the components of a method declaration comprise the method signature—
    the method's name and the parameter types.
The signature of the method from example  is:
calculateAnswer(double, int, double, double)
The signature of the method from getX  is:   
getX()
    
    */
    
    // retrun x
    public int getX()
    {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    //return y
    public int getY()
    {
        return y;
    }
    
    // method requires getArea in concrete subclasses
    public double getArea()
    {
        double area = x * y;
        return area;
    }
    
    // return String repesentation of 2-D Shape
    public String toString()
    {
        return String.format("%s%nx: %d%ny: %d", super.toString(), getX(), getY());
    }
}
