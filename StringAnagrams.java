import java.io.*;
import java.util.*;

public class StringAnagrams {
	  public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	                Scanner scan =  new Scanner(System.in);
	        String a = scan.next();
	        String b = scan.next();
	        scan.close();
	        boolean anagram= true;
	        if (a.length() != b.length()) {
	            anagram = false;
	        }
	        else{
	        a = a.toLowerCase();
	        b = b.toLowerCase();
	        
	        int sum = 0;
	        for (char c = 'a'; c <= 'z'; c++) {
	            for (int i=0; i<a.length(); i++) {
	                if (a.charAt(i) == c) {
	                    sum++;
	                }
	                if (b.charAt(i) == c) {
	                    sum--;
	                }
	            }
	            if (sum != 0) {
	                
	                anagram = false;
	                break;
	            }
	        }
	        }
	        if(anagram)
	            System.out.println("Anagrams");
	        else
	            System.out.println("Not Anagrams");
	        
	        
	        
	    }
    
}
  
