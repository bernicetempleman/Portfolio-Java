/*
Course Number & Section:    CIS5200-W01
Assignment Designation:     Project 3 : 20.8
Name:                       Bernice Templeman
*******************************************************************************
Create an application that provides a solution for problem 20.8

20.8 (Generic Class Pair) 
* Write a generic class Pair which has two type parameters—F and S—
* each representing the type of the first and second element of the pair, respectively. 
  [Hint: The class header should be public class Pair<F, S>.]

In addition to requirements specified in the description.  
The class must satisfy the following
* Default Constructor 
* Two argument constructor for data used to initialize "first" and "second"
* Add get and set methods for the first and second elements of the pair.
* "toString" method for displaying the "first" and "second" data elements
* Creates a  "Comparator" object (to be used by the sort method; 
* i.e. create an instance of a  class that implements the interface 
* [must override "compare" and "equals" methods])
* The application must create an ArrayList of 5 Pair objects and 
* display the contents in sorted order largest to smallest, 
  based on the method used to compare "Pair" objects. 
* The class only supports types that extend Number. 
* Assume the "Pair" objects contain x, y coordinates.  
* Therefore calculate the distance from a 0,0 coordinate to determine the sorting order 
 (i.e., ascending, smallest distance to largest distance).
 */
package project.pkg3;

import java.util.ArrayList;
import java.util.Collections;

public class Project3 {

    /*  The application must create an ArrayList of 5 Pair objects and 
        then display the contents in sorted order largest to smallest, 
        based on the method used to compare "Pair" objects.
    */
    public static void main(String[] args) 
    {

        //create an ArrayList of 5 Pair objects     
        Pair<Number, Number> p1 = new Pair<Number, Number>( 10, 3.0 );
        Pair<Number, Number> p2 = new Pair<Number, Number>( 0.5, -9 );
        Pair<Number, Number> p3 = new Pair<Number, Number>( -9, 0.49);
        Pair<Number, Number> p4 = new Pair<Number, Number>( 0, 0);
        Pair<Number, Number> p5 = new Pair<Number, Number>( -2, -4);
        
        //create an ArrayList of 5 Pair objects
        ArrayList<Pair<Number, Number>> list = new ArrayList<Pair<Number, Number>>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        
        // display the contents in sorted order largest to smallest
        Collections.sort(list, new PairCompare().reversed());
        System.out.println("Sorted list entries from largest to smallest: ");
        System.out.println(list);
    }
}

