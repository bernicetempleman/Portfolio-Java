/*
static void	sort(char[] a)
Sorts the specified array into ascending numerical order.
 */
package sortdemo;

import static java.util.Arrays.sort;

public class SortDemo {

    public static void main(String[] args) {
        char[] array1 = {'B', 'e', 'r', 'n', 'i', 'c', 'e'};
        
        System.out.println("Array 1 before sort: " + new String(array1));
        
        sort(array1);
        
        System.out.println("Array 1 after sort: " + new String(array1));

    }
    
}
