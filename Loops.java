
public class Loops {
	public static void main(String[] args) {

	    //create a simple for-loop that prints the numbers 1 to 10     

	       for (int i = 1; i <= 10; i++){

	           System.out.println(i);

	       }
	       
	       /*
	        * Exercise 1

Create an array of ten byte values. The values can be any arbitrary numbers that you choose.
 Now use a for-loop to iterate over the elements in the array and print them to the console. 
	        */
	       byte[] values = {1,2,3,4,5,6,7,8,9,10};
	       for(int i=0; i <values.length; i++)
	       {
	    	   System.out.println(values[i]);
	       }
	       
	       byte[] b = {1, 2, 3, 4, 8, 16, 32, 64, 67, 120};

	       for (int i = 0; i < b.length; i++) {
	       System.out.println(b[i]);
	       } 

	}

}
