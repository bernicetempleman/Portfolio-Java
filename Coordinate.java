/*
 * Bernice Templeman

(26 points) 
Write a class, 
"Coordinate" that implements the "Comparable" interface.
The class contains "x", "y" and "z" attributes (type "double"), 
a constructor, 
and accessor and mutator methods for each of the attributes. 



The "compareTo" method will be based on the "Coordinate" object distance 
from the origin of 0, 0, 0. The formula for distance from the origin is below.  
distance = sqrt( (x - 0)2 + (y - 0)2 + (z - 02 ), 
where x,y & z are the components of the coordinate object

 

For example,

Coordinate coordinate1(1,1,1);

Coordinate coordinate2(5,6,7);

The following expression will return a negative value ( i.e., distancecoordinate1 - distancecoordinate2 )

coordinate1.compareTo(coordinate2)

 

Zip both "Coordinate.java" and "CoordinateApp.java" , upload the zip file.
 */
package coordinateapp;

/**
 *
 * @author Bernice
 */
public class Coordinate implements Comparable<Coordinate>
{

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    private double x,y,z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Coordinate o) 
    {
        //distance = sqrt( (x - 0)2 + (y - 0)2 + (z - 02 )
        
        
        //this object
        double x1 = this.getX();
        double y1 = this.getY();
        double z1 = this.getZ();
        
        double x2 = o.getX();
        double y2 = o.getY();
        double z2 = o.getZ();
        
        
        double d =  Math.sqrt( ( x1- x2)*(x1- x2) + (y1-y2)*(y1-y2)+(z1-z2)*(z1-z2));

    if (d < 0) {
      return -1;
    }

    if (d >0) {
      return 1;
    }

    else {
      return 0;
    }

        
    }
    
}
