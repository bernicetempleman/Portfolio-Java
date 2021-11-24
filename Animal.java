/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java30min;

/**
 *
 * @author berni
 */

// single line comment
/* multi line
comment
*/
// import libraties
import java.util.Scanner;
import java.util.*;

// a class degines the attributes (fields) and capabilities (methods) of a real workd object


public class Animal 

   {

    /**
     * @param args the command line arguments
     */
   
   //static means this number is shared by all objects of type Animal
   
   // final means this value can't be changed
   public static final double FAVNUMVER = 1.61814;
   
   // variables (fields) start with a letter, underscore or $
   // private fields can oly be accessed by other methods in the class
   
   //Strings are objects that hold a series of characters
           private String name;
           
   //Booleans have a value of true or fald=se
        private boolean hasOwner = false;
        
    //Bytes can hold a value of -128 to 127
        private byte age;
        
        //longs can hold the values between -2 ^63 to (2^63)-1
        private long uniqueId;
        
        //char are unsigned ints that represent UTF-16 codes from 0 to 65535
        private char favoriteChar;
        
     //doubles ate 64 bit IEEE 754  floating pts with decimal values
        private double speed;
        
        //floats are 32 bit  IEEE
        private float height;
        
        //static variables have the same value for every object
        //any variable or function that doesn't make sense for object to have should be static
        
       // protected means package or subclasses in other packages
        
        protected static int numberOfAnimals =0;
        
        //A scanner object allows you to except user input from keyboard
        static Scanner userInput = new Scanner(System.in);
        
        
   
    public static void main(String args[]) {
      // TODO code application logic here
   }
}
