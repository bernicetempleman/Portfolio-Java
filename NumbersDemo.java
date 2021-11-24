/*
 * primitive types and Numbers
 */
package numbersdemo;

public class NumbersDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //primitive types
        // primitive types are not objects
        // they do not have methods
        boolean boolean1;
        byte byte1;
        char char1;
        double double1;
        float float1;
        int int1;
        long long1;
        short short1;
        
        // type-wrapper class 
        // extends class Number
        // type-wrapper classes are final (they cannot be extended
        // enable you to manipulate primitive-type values as objects
        // some data structures manipulate & share objects, 
        // they cannot manipulate primitive type variables
        // type-wrapper classes have mehtods
        Boolean boolean2;
        Character char2;
        Double double2;
        Float float2;
        Integer int2;
        Long long2;
        Short short2;
        
        int2 = 5; // boxes int to an Integer object
        int2 =  int2 + 10;   // unboxes the Integer to a int, adds, then boxes to Integer
        System.out.println("int2: " + int2); 
        
        Integer[] intArray = new Integer[10];   // create intArray
        intArray[0] = 10;                       // assign Integer 10 to intArray[0]
        int1 = intArray[0];                     // get int value of Integer
        int2 = intArray[0];                     // get int value of Integer
        
        System.out.println("int1: " + int1 + " int2: " + int2);
        
        // Autoboxing : converts a value of primitive type to an object 
        // of the corresponding type-wrapper class (conversion is automatic)
        
        // Auto-Unboxing : converts an object of a type-wrapper class to a 
        // valuue of the corresponding primitive type (conversion is automatic)
         
        /*
         autoboxing occurs when assigning an int value (10) to intArray[0], 
        because intArray stores references to Integer objects, not int values. 
        Auto-unboxing occurs when assigning intArray[0] to int variable value,
        because variable value stores an int value, 
        not a reference to an Integer object. 
        Boxing conversions also occur in conditions, 
        which can evaluate to primitive boolean values or Boolean objects
        */      
        
        int x = 5;
        int y = 5;
         x = y = 0;
        System.out.println(x +" " + y);
    }  
}
