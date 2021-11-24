import java.io.*;
import java.util.*;
import java.util.regex.*;

class MyRegex {
	 //public String pattern = "((([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5]))\\b";
	 String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
	 public String REGEX = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
	 Pattern pattern = Pattern.compile(REGEX);
	 public boolean match(String ip){
	      return Pattern.matches(REGEX,ip);
	 }

}

public class StringRegexIPaddress {
	
	  public static void main(String[] args) {
	        /* Enter your code here.
			Read input from STDIN. 
			Print output to STDOUT. 
			Your class should be named Solution. */
		  
		  Scanner scan = new Scanner(System.in);
		  
		 MyRegex reg = new MyRegex();
		 while(scan.hasNext()) {
		  String ipAddress = scan.nextLine();
		  System.out.println(reg.match(ipAddress));
		 }	  
	    }
}
