/*
 */
package throwsclauseexample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ThrowsClauseExample {

    public static void main(String[] args) throws IOException, NullPointerException{
        Scanner keyboard = new Scanner(System.in);
        boolean result = false;
        
        //createNewFile without try/catch - ioexception
        System.out.println("createNewFile Test 1: Creating a new file with an invalid path");
        System.out.printf("The next test throws an exception & causes the program to halt. "
                + "Do you want to continue? y n : ");
        String runTest = keyboard.nextLine();
        if(runTest.equals("y"))
        {
            System.out.println("Test creating a file with an invalid path: "); 
            String filename2 = "ThisisanInvalidPath\\x\\xxx\\x.file";
            File f2 = new File(filename2);
                   
            //this can throw an exception
            result = f2.createNewFile();
            
            if(result)
                System.out.println("createNewFile Test 1: Failed " + filename2 + " created" );
            else
                System.out.println("createNewFile Test 1: Success " + filename2 + " not created");
        }   
        else
            System.out.println("createNewFile Test 1: did not run");
        System.out.println();
    } 
}
