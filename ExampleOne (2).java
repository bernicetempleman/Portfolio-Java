
public class ExampleOne {

	public static void main(String[] args) {
		boolean on = false;
		do {
			System.out.println("Inside the dowhile loop");
		}while ( on);
		
		/*For this exercise, you need to write a do-while loop that prints the odd numbers 1 through 49,
		 *  inclusively, each on a separate line.

		Exercise 2

		For this exercise, you must write a do-while loop that prints the letters of the alphabet. 
		You must use a single char variable that you manipulate to print to the console. 
		(You shouldn’t have 26 lines of code that each print a letter...)*/
		
		int i = 1;
		
		do{
			System.out.println(i);
			i+=2;
			
		}while (i <=49);
		
		char letter = 'a';

		char end = 'z';
		
		do {
			System.out.println(letter);
			letter++;
		}while (letter <=end);
	}
}
