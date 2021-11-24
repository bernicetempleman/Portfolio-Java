/*
 * This is the HelloWorldMessage Class
 */
package helloworldapp;

public class HelloWorldMessage
{
    // Class variable
    static int numberOfMessages = 0;
    
    // instance variables
    int instanceNumberOfMessages = 0;
    String message = "Hello World";
    
    public void displayMessage()
    {
        // local variable
        int localNumberOfMessages = 0;
        
        // increment Class variable
        numberOfMessages++;
        
        //increment instance variable
        instanceNumberOfMessages++;
        
        // increment local variable
        localNumberOfMessages++;
        
        System.out.println("HelloWorldMessage: displayMessage");
        System.out.println("numberOfMessages: " + numberOfMessages);
        System.out.println("instanceNumberOfMessages: " + instanceNumberOfMessages);
        System.out.println("localNumberOfMessages: " + localNumberOfMessages);
        System.out.println(message); 
        System.out.println();
        
    }
    
    public void displayMessage2( String message)
    {
        System.out.println(message); 
    }
    
    public boolean displayNumbers()
    {       
        // declares an array of integers
        long[] numberArray;
        
        byte number0 = 127;
        short number1 = -32768;
        int number2 = 32768;
        
        //this is an error
        //long number3 = -100000000000000;
        
        //this works
        long number3 = -100000000000000L;
        long number4 = 1234_5678_9012_3456L;
      
        boolean success = false;
        
        // create an array of integers
        numberArray = new long[10];  
        
        numberArray[0] = number0;
        numberArray[1] = number1;
        numberArray[2] = number2;
        numberArray[3] = number3;
        numberArray[4] = number4;
        numberArray[5] = 0xCAFE_BABE;
        numberArray[6] = 0x7fff_ffff_ffff_ffffL;
        numberArray[7] = 0b0010_0101;
        numberArray [8] = 0b11010010_01101001_10010100_10010010;
        numberArray[9] = 0xFF_EC_DE_5E;
        
        for(int i = 0; i < numberArray.length; i++)
        {         
            try
            {
                long x = numberArray[i];
                System.out.println( x + " fits in:");
                if(x>=-128 && x<=127)
                    System.out.println("* byte");
                if(x>=  -32768 && x<= 32767)
                    System.out.println("* short");
                if(x== (int) x)
                    System.out.println("* int");
                if(x == (long)x)
                    System.out.println("* long");
                success = true;
            }
            catch(Exception e)
            {
                System.out.println(numberArray[i] + " can't be fitted anywhere.");
               
            }

        }
        System.out.println("HelloWorldMessage: Result= " + success);
        return success;
    }
    
    public void displayArrays()
    {
        //First Array
        //declares an array of integers
        int [] intArray;

        //create an array of integers
        intArray = new int[2];

        //assign values to the array
        intArray[0] = 5;
        intArray[1] = 10;
        
        //display array
        System.out.println("Array 1: Element 1 at index 0: " + intArray[0]);
        System.out.println("Array 1: Element 2 at index 1: " + intArray[1]);       
        System.out.println();
        
        //Array 2
        int[] intArray2 = new int[2];
        //assign values to the array
        intArray2[0] = 50;
        intArray2[1] = 100;
        
        //display array
        System.out.println("Array 2: Element 1 at index 0: " + intArray2[0]);
        System.out.println("Array 2: Element 2 at index 1: " + intArray2[1]); 
        System.out.println();
        
        //Array 3
        //array initializer list
        int[] intArray3 = { 
            100, 200
        };
        System.out.println("Length of Array 3: " + intArray3.length);
        
        //display array
        System.out.println("Array 3: Element 1 at index 0: " + intArray3[0]);
        System.out.println("Array 3: Element 2 at index 1: " + intArray3[1]); 
        System.out.println();
        
        //Array 4
        //Multidimensional array
        //example of array initialized with valuse grouped in rows
        int[][] intArray4 = {
            { 1,2},
            {3,4,5}             
        };
        System.out.println("Length of Multidimensional Array 4: " + intArray4.length);
        System.out.println("Length of Multidimensional Array 4 Row 0: " + intArray4[0].length);
        System.out.println("Length of Multidimensional Array 4 Row 1: " + intArray4[1].length);
        
        System.out.println("Array 4: Element 1 at index 0: " + intArray4[0][0]);
        System.out.println("Array 4: Element 2 at index 1: " + intArray4[0][1]);
        System.out.println("Array 4: Element 3 at index 0: " + intArray4[1][0]);
        System.out.println("Array 4: Element 4 at index 1: " + intArray4[1][1]);
        System.out.println("Array 4: Element 5 at index 1: " + intArray4[1][2]);    
        
        System.out.println();
        //example of multidimensional array with 2 rows and 3 columns
        int[][] intArray5 = new int[2][3];
        System.out.println("Length of Multidimensional Array 5: " + intArray5.length);
        System.out.println("Length of Multidimensional Array 5 Row 0: " + intArray5[0].length);
        System.out.println("Length of Multidimensional Array 5: Row 1: " + intArray5[1].length);
        System.out.println();
        
        //example of multidimensional array with different number of columns
        int[][] intArray6 = new int[2][];   // create 2 rows
        intArray6[0] = new int[4]; // create 4 columns for row 0
        intArray6[1] = new int[2]; // create 2 columns for row 1
        System.out.println("Length of Multidimensional Array 6: " + intArray6.length);
        System.out.println("Length of Multidimensional Array 6 Row 0: " + intArray6[0].length);
        System.out.println("Length of Multidimensional Array 6 Row 1: " + intArray6[1].length);
    }
    
    
}
