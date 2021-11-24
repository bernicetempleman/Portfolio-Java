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
*
* The class only supports types that extend Number. 
* Assume the "Pair" objects contain x, y coordinates.  
* Therefore calculate the distance from a 0,0 coordinate to determine the sorting order 
 (i.e., ascending, smallest distance to largest distance).
 */
package project.pkg3;

// generic class Pair which has two type parameters—F and S—
// each representing the type of the first and second element of the pair, respectively.
// class pair only supports types that extend Number
public class Pair<F extends Number, S extends Number> 
//implements Comparable<Pair<F,S>>
{  
    // Pair objects contain x, y coordinates
    private F first;
    private S second;
    
    // Default Constructor 
    public Pair()
    {
        this.first = null;
        this.second = null;
    }
    
    // Two argument constructor for data used to initialize "first" and "second"    
    public Pair(F first, S second)
    {
        this.first= first;
        this.second = second;
    }
    
    // Add get and set methods for the first and second elements of the pair.
    
    // getFirst returns first
    public F getFirst()
    {
        return first;
    }
    
    // sets first 
    public void setFirst(F first)
    {
        this.first = first;
    }
    
    // returns second
    public S getSecond(){
        return second;
    }

    // set second
    public void setSecond(S second){
        this.second = second;
    }
    
    // "toString" method for displaying the "first" and "second" data elements
    @Override
    public String toString(){
        return String.format("First: %s  Second: %s", (getFirst()).toString(), (getSecond()).toString());
    }

    // get distance:
    // calculate the distance from a 0,0 coordinate to determine sorting order
    // (i.e., ascending, smallest distance to largest distance).
    public double getDistance()
    {
        //convert pair first second to ints
        double x = Double.parseDouble((getFirst()).toString());
        double y = Double.parseDouble((getSecond()).toString());
        
        // distance between point and (0,0) = sqrt((x1-x2)*(x1-x2) + (y1-y2*(y1-y2))
        double distance = (double) Math.sqrt((x-0)*(x-0) + (y-0)*(y-0));      
        
        return distance;
    }
    
    // overide equals
    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (getClass() != o.getClass()) return false;
      Pair<F, S> oPair = (Pair<F, S>) o;
      return (first.equals(oPair.first) && second.equals(oPair.second));
    }
}
