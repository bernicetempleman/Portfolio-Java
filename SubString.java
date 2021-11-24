import java.io.*;
import java.util.*;

public class SubString {
	   public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	   
		   Scanner scan = new Scanner(System.in);
		   String word = scan.next();
		   int start = scan.nextInt();
		   int end = scan.nextInt();
		   String sub = (word.substring(start, end));
		   System.out.println(sub);
		   
	   }

}
