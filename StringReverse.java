import java.io.*;
import java.util.*;

public class StringReverse {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
    	Scanner scan = new Scanner(System.in);
    	String word = scan.next();
    	int length = word.length();
    	scan.close();
    	boolean pal = true;
    	
    	for (int i = 0; i < length / 2; i++) {
    		int j = length-1-i;
    		
    	    if (word.charAt(i) != word.charAt(j)) {
    	      
    	        pal = false;
    	        break;
    	    }
    	}
    	if (!pal) System.out.println("No");
    	else
    	System.out.println("Yes");
    
    }

}
