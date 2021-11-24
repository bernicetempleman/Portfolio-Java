/*


In addition, create a second public class "PointTester" that contains the "main" method that performs the following
1.  Prompts the user for the x, y, and z coordinates.
2.  Creates a "Point" instance named "Point1"
3.  Prompts the user for the x, y, and z coordinates.
4.  Creates a "Point" instance named "Point2"
5.  Displays the distance between the two points.


 */
package pointtester;

import java.util.Scanner;


public class PointTester 
{

    /**
1.  Prompts the user for the x, y, and z coordinates.
2.  Creates a "Point" instance named "Point1"
3.  Prompts the user for the x, y, and z coordinates.
4.  Creates a "Point" instance named "Point2"
5.  Displays the distance between the two points.
     */
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        
        //Prompts the user for the x, y, and z coordinates.
        System.out.println("enter x: ");       
        double x = keyboard.nextDouble();
        System.out.println("enter y: ");
        double y = keyboard.nextDouble();
        System.out.println("enter z: ");
        double z = keyboard.nextDouble();
        
        //Creates a "Point" instance named "Point1"
        Point Point1 = new Point(x,y,z);
        
                //Prompts the user for the x, y, and z coordinates.
        System.out.println("enter x: ");       
        x = keyboard.nextDouble();
        System.out.println("enter y: ");
        y = keyboard.nextDouble();
        System.out.println("enter z: ");
        z = keyboard.nextDouble();
        
        //Creates a "Point" instance named "Point1"
        Point Point2 = new Point(x,y,z);
        
        System.out.println("Distance is: " + Point.distBetweenPoints(Point1, Point2));
        
        
    }
    
}
