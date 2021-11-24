import java.util.Scanner;
import java.util.regex.*;

public class StringPatternRegExSyntaxChecker {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		boolean valid = true;
		while(testCases>0){
			String pattern = in.nextLine();
			try {
	            Pattern.compile(pattern);
	        } catch (PatternSyntaxException exception) {
	            //System.err.println(exception.getDescription());
	            try {
	                Pattern.compile(pattern);
	            } catch (PatternSyntaxException e1) {
	                //System.err.println(e1.getDescription());
	                System.out.println("Invalid");
	                valid = false;
	                //System.exit(1);
	            }
	            if(valid)
	            System.out.println("Valid");
	        }
			 if(valid)
	        System.out.println("Valid");
			//Write your code
			
			testCases--;
	}
}
}
