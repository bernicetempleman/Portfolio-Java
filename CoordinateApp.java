/* Bernice Templeman

26 points) 
Write a second class, CoordinateApp.java that contains a "main" method that performs the following.
Add 3 objects of the "Coordinate" type to a PriorityQueue object . 
Use an iterative structure to display the elements from the queue in priority order 
(i.e., based on distance from the 0,0,0 coordinate; refer to compareTo method below)

The "compareTo" method will be based on the "Coordinate" object distance from the 
origin of 0, 0, 0. The formula for distance from the origin is below.  
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

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Bernice
 */
public class CoordinateApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Coordinate c1 = new Coordinate(2,2,2);
        Coordinate c2 = new Coordinate(1,1,1);
        Coordinate c3 = new Coordinate(0,0,0);
        
        Queue<Coordinate> queue = new PriorityQueue<>();
        
        System.out.println( "c1 compared to c3 = " +c1.compareTo(c3));

        // insert elements to queue 
        queue.add(c1);          
        queue.add(c2);          
        queue.add(c3);   
      

         System.out.print("Polling from queue: \n");

        // display elements in queue
         while (queue.size() > 0)
         {
           // System.out.printf("%s\n ", queue.peek().toString()); // view top element
           Coordinate x = queue.poll(); // remove top element
           
           System.out.println(x.getX() +" "+ x.getY()+ " " + x.getZ());
         }
      }
   } // end class PriorityQu
                
    

