/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraycopyofdemo;

/**
 *
 * @author Bernice
 */
public class ArrayCopyOfDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] array1 = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
        //we do not need to create array2
            
        char[] array2 = java.util.Arrays.copyOfRange(array1, 2, 9);
        
        System.out.println("Array 1: " + new String(array1));
        System.out.println("Array 2: " + new String(array2));
    }
    
}
