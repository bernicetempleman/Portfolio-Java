/*
 * ShapeTester1
 */
package shapetester1;

/*
  class declarations can include these components, in order:

Modifiers such as public, private, and a number of others that you will encounter later.
The class name, with the initial letter capitalized by convention.
The name of the class's parent (superclass), if any, preceded by the keyword extends. A class can only extend (subclass) one parent.
A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword implements. A class can implement more than one interface.
The class body, surrounded by braces, {}.
 */
public class ShapeTester1 {

    // main method 
    public static void main(String[] args) 
    {
        //create an array of references to shape objects
         Shape [] shapeArray = new Shape[6];
         
         //create objects and point array elements to them
         shapeArray[0] = new Square("blue",0,0,2);
         shapeArray[1] = new Square("green",1,1,2);
         shapeArray[2] = new Square("red",2,2,2);
         shapeArray[3] = new Square("yellow", 3,3,3);
         shapeArray[4] = new Square("purple",4,4,4);
         shapeArray[5] = new Square("orange",5,5,5);
           
         //loop through array of Shape pointers to print text description
         for( Shape shape : shapeArray)
         {
            System.out.println(shape);
            if (shape instanceof TwoDimensionalShape)
                System.out.printf("Area = %.2f\n", ((TwoDimensionalShape)shape).getArea());
            else 
            {
               //
            }             
            System.out.println();
         }
         
         int x = 3;
           
        // invoke passMethod() with 
        // x as argument
        passMethod(x);
           
        // print x to see if its 
        // value has changed
        System.out.println("After invoking passMethod, x = " + x);
        
        Square mySquare = new Square("main", 1,1,1);
        moveSquare(mySquare, 23, 56);
    }
    public static void moveSquare(Square square, int deltaX, int deltaY) {
    // code to move origin of circle to x+deltaX, y+deltaY
    square.setX(square.getX() + deltaX);
    square.setY(square.getY() + deltaY);
         
    // code to assign a new reference to circle
    square = new Square( "inMoveSquare",0, 0,0);
    }
        
    // change parameter in passMethod()
    public static void passMethod(int p) {
        p = 10;
    }  
}
