/*
 * ArrayCopyDemo
 */
package arraycopydemo;

public class ArrayCopyDemo 
{

    // note: 
    // src - the source array.
    // srcPos - starting position in the source array.
    // dest - the destination array.
    // destPos - starting position in the destination data.
    // length - the number of array elements to be copied.

    public static void main(String[] args) 
    {
        // create 2 arrays of char
        char[] array1 = {'0','1','2','3','4','5','6','7','8','9'};
        char[] array2 = new char[10];
        
        //copy array1 to array2
        System.out.println("Copy array");
        System.arraycopy(array1, 0, array2, 0, 10);
        System.out.println("array1: " + new String(array1));
        System.out.println("array2: " + new String(array2));
        System.out.println();
        
        //create array3 (different size)
        char[] array3 = new char[7];
        
        // copy part of array
        System.out.println("Copy part of array");
        System.arraycopy(array1, 2, array3, 0, 7);
        System.out.println("array1: " + new String(array1));
        System.out.println("array3: " + new String(array3));
        System.out.println();
        
        //source and destination are the same
        System.out.println("Source and destination are the same");
        System.arraycopy(array1, 2, array1, 0, 7);
        System.out.println("array1: " + new String(array1));
        System.out.println();
        
        //source and destination are the same
        System.out.println("Source and destination are the same");
        int[] numbers = { 0,1, 2, 3, 4, 5, 6,7,8,9};
        System.out.print("numbers before copy: ");
        for(int i :  numbers) 
            System.out.print(i);
        System.out.println();
        System.arraycopy(numbers, 2, numbers, 3, 3);
        System.out.print("numbers after copy: ");
        for(int i :  numbers) 
            System.out.print(i);
        System.out.println();
    }  
}
