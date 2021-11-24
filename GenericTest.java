/*
Write a generic method, "addNumber" that uses a formal parameter type 
that extends from "Number" and returns  a type that extends from "Number". 
The method adds two objects of the same type and returns an object of that type. 
The methods signature is as follows.
public static <T extends Number>  T addNumber(T num1, T num2)

Create a class, "GenericTest" that contains the "addNumber" and "main" methods. 
The "main" method performs the following.
1.  Creates two "Double" objects, adds them and displays the results
2.  Creates two "Integer" objects, adds them and displays the results
Save and upload the file as "GenericTest.java"
 */
package generictest;

/**
 *
 * @author Bernice
 */
public class GenericTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Number d1 = Double.valueOf(5.1);
        Number d2 = Double.valueOf(5.5);
        
        Number i1 = Integer.valueOf(1);
        Number i2 = Integer.valueOf(2);
      
        
        Number sum = addNumber(d1,d2);
        System.out.println("Sum: " + sum);
        
        sum = addNumber(i1,i2);
        System.out.println("Sum: " + sum);
        
    }
    
    public static <T extends Number>  T addNumber(T num1, T num2)
    {
        Number sum = num1.doubleValue()+ num2.doubleValue(); 
        return (T) sum;
    }


}
