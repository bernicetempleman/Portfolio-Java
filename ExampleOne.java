
public class ExampleOne {
	
	public static void main(String[] args) {
		//create some dummy data for our method

		int input = 5;

		ExampleOne eo = new ExampleOne();

		 

		//call the method here

		System.out.println(eo.factorial(input));
		
		char letter = 'z';
		eo.printChar(letter);
		
	}
	
	public int factorial(int num) {
		if (num<=0)
			return 0;
		if (num==1)
			return 1;
		return num * factorial(num-1);
		
	}
	
	public void printChar(char input) {
		 if (input < 'a' || input > 'z') return;

		 System.out.print(input);
		 input -= 1;
		 printChar(input);
		}
	
	//recursive binary search
	
	public int binarySearch(int[] data, int target) {
		 //return -1 if the given array is empty
		 if (data == null || data.length == 0) return -1;

		 //define the range of indexes
		 int minRange = 0;
		 int maxRange = data.length;

		 //find the midpoint value
		 int midpoint = data[maxRange/2];

		 if (midpoint == target) {
		 return maxRange/2; //return the position
		 }else if (data.length == 1 ) {
		 return -1; //this is to stop additional recursive calls
		 }else if (midpoint < target) {
		 minRange = (maxRange/2);

		 //create new data to search upon
		 int[] temp = copyArray(data, minRange, maxRange);

		 //need to add the range if it is in the upper half
		 //to keep track of the index otherwise the index is based
		 //on the smaller range
		 int indexAdder = (maxRange/2);

		 //find the index in the smaller array
		 int search = binarySearch(temp, target);

		 //check if the search found the value
		 if (search == -1) {
		 return -1; //return -1, if the search didn't find it
		 }else {
		 return indexAdder + search;
		//return the value plus the adder if found
		 }
		 }else if (midpoint > target) {
		 maxRange = (maxRange/2);

		 //create new data to search upon
		 int[] temp = copyArray(data, minRange, maxRange);
		 
		 //because we're searching the lower half, we don't need to keep track of the index
		 return binarySearch(temp, target);
		 }

		 return -1;
		}
	
	
		//A method used to copy the values of one array into the next
		public int[] copyArray(int[] original, int min, int max) {
		 int[] target = new int[max-min];
		 for (int i = 0; i < target.length; i++) {
		 target[i] = original[min+i];
		 }
		 return target;
		} 


}
