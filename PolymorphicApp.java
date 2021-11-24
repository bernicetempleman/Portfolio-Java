/*
Write an application that demonstrates polymorphic features. 
The application must contain 4 classes ("Vehicle", "Car", "Truck", "PolymorphicApp").  
 

"Car" and  "Truck" inherit from "Vehicle"
The "Vehicle" class must contain a method called "drive( )"
The derived classes must override the "drive( )" method
The "Vehicle" class must contain a constructor and a default implementation or the "drive( )" method. 
The subclasses must contain contructors and 
an implementation for the "drive( )"  methods that override the "Vehicle" class version.

The application class, "PolymorphicApp" must perform the following.

Declare an array of three "Vehicle" references
Create an instance of each subclass (i.e., object of "Car" and "Truck").  There will be a total of 2 objects
Assign each array reference element to one of the objects
Create a loop that iterates through the array and invokes the "drive()" method
Note: The idea is that each call to "drive( )" 
will display a different message based on the type of object that is referenced.
 */
package polymorphicapp;

/**
 *
 * @author Bernice
 */
public class PolymorphicApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declare an array of 3 "Vehicle" references
        Vehicle[] vehicles = new Vehicle[3];
        
        
        // Create an instance of each subclass (i.e., object of "Car" and "Truck").  There will be a total of 2 objects
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Truck();
        // Assign each array reference element to one of the objects
        vehicles[0] = vehicle1;
        vehicles[1] = vehicle2;
        int vehiclecount = 2;
        // Create a loop that iterates through the array and invokes the "drive()" method
        for(int i = 0; i < vehiclecount; i++)
        {
            vehicles[i].drive();
        }
    }
    
}
