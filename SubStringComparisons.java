import java.io.*;
import java.util.*;

public class SubStringComparisons {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
    	Scanner scan = new Scanner(System.in);
    	
    	String s = scan.next();
    	
    	int k = scan.nextInt();
    	scan.close();
    	
    	String [] subStrArray = new String[s.length()-k +1];
    	String largest = s.substring(0, k );
    	String smallest = s.substring(0, k );
    	for (int i = 0; i < s.length() - k +1;i++) {
    		subStrArray[i] = s.substring(i, i+k );
    		if (subStrArray[i].compareTo(largest) >0)
    			largest = subStrArray[i];
    		if (subStrArray[i].compareTo(smallest) <0)
    			smallest = subStrArray[i];
    		
    	}
    	System.out.println(smallest);
    	System.out.println(largest);
    }
}
