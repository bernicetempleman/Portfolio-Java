
public class ConditionalBlocks {
	public static void main(String[] args) {
	  
		 boolean firstCondition = false;
		    boolean secondCondition = true;

		    if (firstCondition){
		      System.out.println("inside the if-statement");

		      if (secondCondition){
		        System.out.println("inside the nested if-statement");
		      }
		    } else if (secondCondition){
		      System.out.println(5);
		    } else {
		      System.out.println("inside the else-statement");
		    }

		    System.out.println("Outside of the if-statement");
	    
	}

	
}
