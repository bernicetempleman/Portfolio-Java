/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchdemo;

import static java.util.Arrays.binarySearch;

public class BinarySearchDemo {

    public static void main(String[] args) {
        char[] array1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k','l','m','n','o','p','q',
            'r','s','t','u','v','w','x','y','z'};
        
        int location = binarySearch(array1, 'a');
        
        System.out.println("Array 1: " + new String(array1));
        System.out.println("a is at location: " + location);
        
        //remember array location begins with 0
        
        //we can reuse location
        //we don't need to declare it again
        location = binarySearch(array1, 'v');
        
        System.out.println("Array 1: " + new String(array1));
        System.out.println("v is at location: " + location);
    }
    
}
