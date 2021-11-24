/*
 *take a number and count up 10 times separate by then
       int b;
        System.out.println("Enter int: ");
        b = in.nextInt();
System.out.print(a*b);
 */
package hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void yourMethod(int a) {
        
        for(int i=a+1 ; i < a+10; i++)
        {
        System.out.print(i + " then ");
        
        }
        System.out.print(a+10);
        
                   digit = num % 10;
            
            if (digit == 8)
                holes+=2;
            else if ((digit == 0)||(digit ==4)|| (digit ==6) || (digit == 9))
                holes +=1;  
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter int: ");
        int a;
        a = in.nextInt();
        if (a < (Math.pow(10,7)));
 
        yourMethod(a);
    }
}
