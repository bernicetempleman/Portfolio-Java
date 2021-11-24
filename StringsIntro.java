import java.io.*;
import java.util.*;

public class StringsIntro {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
         *Print output to STDOUT. Your class should be named Solution. */
		
		Scanner scan = new Scanner(System.in);
		String first = scan.next();
		String second = scan.next();
		int sum = first.length() + second.length();
		System.out.println(sum);
		System.out.println(first.compareTo(second)>0?"Yes":"No");
		System.out.println(first.substring(0, 1).toUpperCase()
				+first.substring(1, first.length())+" "
		+second.substring(0, 1).toUpperCase()+second.substring(1, second.length()));
		
    }

}
