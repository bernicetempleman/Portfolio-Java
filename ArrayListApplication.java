/* Bernice Templeman
(26 points) Write an application class (ArrayListApplication)
that contains a main(...) method. The method must perform the following.

Prompt user for 10 names and store in an "ArrayList" object
Shuffle the names using "shuffle"" method of the "Collections" class
Display the smallest element in the collection use the "Collections.min" method.
Display the largest element in the collection use the "Collections.max" method.
Save and upload the file as "ArrayListApplication.java"
 */
package arraylistapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Bernice
 */
public class ArrayListApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayList<String> names = new ArrayList<>();
        Scanner a = new Scanner(System.in);
        String name = null;
        
        for (int i= 0; i < 10; i++)
        {
            System.out.println("Enter name: ");
            
            name = a.nextLine();
            names.add(name);
            
            
    }
    Collections.shuffle(names);
     for (int i = 0; i < names.size(); i++) {
	    String value = names.get(i);
	    System.out.println("Name: " + value);
	}
     
    System.out.println("Min: " + Collections.min(names));
    
    
    System.out.println("Max: " + Collections.max(names));
    
    }
    
}
