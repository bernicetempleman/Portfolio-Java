
package javaapplication7;

/**
 *
 * @author Bernice Templeman
 */
/*Java programs are made up of classes that are used to create classes. There has to be at least one class in a java program.  There can be more than one class in a program and the classes can be grouped into packages.  One of  the java classes in the program has a main method that begins the program. The main method is static so it belongs to the class and not to the instances (objects) of the class. There can only be one public class in a file. Java classes are the blueprint used to create objects

There is also a class called Class. Class extends the Object class.

The Object class is the top class. The Object class does not have a superclass. Every class is a direct or indirect descendant of the Object class and inherits the instance methods of Object. Each class besides the Object class has one superclass. 

An object is also an  instance of a class. The class can be reused to create more than one instance (object) of the class. Objects are created with the "new" operator which allocates memory for an object. 

Objects have the characteristics of "state" and "behavior" that is determined by the class.

The Non-static variables in the class become instance variables in each object that belongs to that class. The data is inside the individual object, not the class. Each object has its own set of data. It has its own "state".

Java conserves storage by maintaining only one copy of each method per class—this method is invoked by every object of the class.(Performance tip 8.1 from book)

An example is:
*/

// class declaration

class Lunch

{

    // state (member variables)

    private String  veggie;

 

   //behavior (method declarations)

   public void getVeggie()

   {

       System.out.println("Get Veggies");

   } //end method getVeggie

}// end class Lunch


//public class App

public class App

{

    //static main method

    public static void main(String[] args)

    {

         // create new Lunch object (instantiating Lunch class) 

         Lunch fridayLunch = new Lunch();

        //call the object's method 

         fridayLunch.getVeggie();

    }// end main

}// end class App