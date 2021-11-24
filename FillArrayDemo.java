/*
static void	fill(char[] a, char val)
Assigns the specified char value to each element of the specified array of chars.
static void	fill(char[] a, int fromIndex, int toIndex, char val)
Assigns the specified char value to each element of the specified range of the specified array of chars.
 */
package fillarraydemo;

import static java.util.Arrays.fill;


public class FillArrayDemo {

    public static void main(String[] args) 
    {
        char[] array1 = {'0','1','2','3','4','5','6','7','8','9'};
        char[] array2 = new char[10];
        
        System.out.println("Array 1: " + new String(array1));
        System.out.println("Array 2: " + new String(array2));
        
        fill(array1, '1');
        fill(array2, '1');
        
        System.out.println("Array 1: " + new String(array1));
        System.out.println("Array 2: " + new String(array2));
        
        fill(array2, 1, 5,'9');
        System.out.println("Array 2: " + new String(array2));
    }
    
}
