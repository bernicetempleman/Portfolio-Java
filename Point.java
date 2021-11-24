/*
Create a public class "Point" that 
contains attributes "x", "y", and "z"  (all of type "double"), 
a 3 argument constructor (i.e., to initialize the coordinates), 
mutator and accessor methods, 
and an static method "distBetweenPoints" that receives two Point references and 
returns the distance between the two points represented by the references to the "Point" instances. 

Distance between two points can be determined by the following formula,

dist = SQRT ( (x2 - x1)2 + (y2 - y1)2 + (z2 - z1)2 )
 */
package pointtester;

public class Point 
{

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    private double x,y,z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public double getZ() {
        return z;
    }
    
    public static double distBetweenPoints( Point p1, Point p2)
    {
    
        //dist = SQRT ( (x2 - x1)2 + (y2 - y1)2 + (z2 - z1)2 )
        double distance = Math.sqrt( (p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y)+(p2.z - p1.z)*(p2.z - p1.z));
        return distance;
    }
}
