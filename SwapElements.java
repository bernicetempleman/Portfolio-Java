
public class SwapElements {

	public static void main(String[] args){
	 int[] elements = {1, 2, 3, 4, 5};
	 int last = elements.length-1;
	 int temp = elements[0];
	 elements[0] = elements[last];
	 elements[last] = temp;
	 
	 for(int i =0; i <=last; i++) {
		 System.out.println(elements[i]);
	 }
			 
			 
	 
	}
	    
	 /*Put your code here to swap the first element with the last*/
	 
}
