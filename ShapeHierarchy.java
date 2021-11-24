/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 2 – 10.13 pg. 439
Name:                       Bernice Templeman

10.13 (Project: Shape Hierarchy) 
Implement the Shape hierarchy shown in Fig. 9.3. 

Create a program that uses an array of Shape references 
to objects of each concrete class in the hierarchy. 

The program should print a text description of the object to which each array element refers.

Also, in the loop that processes all the shapes in the array,
determine whether each shape is a TwoDimensionalShape or a ThreeDimensionalShape. 
If it’s a TwoDimensionalShape, display its area. 
If it’s a ThreeDimensionalShape, display its area and volume.
 */
package shapehierarchy;

public class ShapeHierarchy 
{
    public static void main(String[] args)
    {
        
        //create an array of references to shape objects
         Shape [] shapeArray = new Shape[6];
         
         //create objects and point array elements to them
         shapeArray[0] = new Circle("blue",0,0,2);
         shapeArray[1] = new Square("green",1,1,2);
         shapeArray[2] = new Triangle("red",2,2,2,2);
         shapeArray[3] = new Sphere("yellow", 3,3,3,2);
         shapeArray[4] = new Cube("purple",4,4,4,2);
         shapeArray[5] = new Tetrahedron("orange",5,5,5,2);
           
         //loop through array of Shape pointers to print text description
         for( Shape shape : shapeArray)
         {
            System.out.println(shape);
            if (shape instanceof TwoDimensionalShape)
                System.out.printf("Area = %.2f\n", ((TwoDimensionalShape)shape).getArea());
            else if (shape instanceof ThreeDimensionalShape)
            {
                System.out.printf("Area: %.2f",((ThreeDimensionalShape)shape).getArea());
                System.out.printf("\nVolume: %.2f\n", ((ThreeDimensionalShape)shape).getVolume());
            }             
            System.out.println();
         }
    } // end main   
}//end class ShapeHierarchy
