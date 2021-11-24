/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingarraysdemo;

import java.util.Arrays;
import static java.util.Arrays.*;

public class ComparingArraysDemo {

    public static void main(String[] args) {
        // static boolean	equals(char[] a, char[] a2)
        // Returns true if the two specified arrays of chars are equal to one another.
        
        char[] array1 = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
        //we do not need to create array2
            
        char[] array2 = copyOfRange(array1, 2, 9);
        
        System.out.println("Array 1: " + new String(array1));
        System.out.println("Array 2: " + new String(array2));
        
        boolean same = Arrays.equals(array1, array2);
        
        System.out.println("Array1 equals Array2: " + same);
        
        System.out.println("Is array 1 equal to array 1?? "
            +Arrays.equals(array1, array1));  
    } 
}
