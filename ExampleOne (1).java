import java.util.Scanner;

public class ExampleOne {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please type in a line and hit Enter.");

		 

		String line = scanner.nextLine();

		System.out.println("You have typed: " + line);

		 

		scanner.close();
		
		String numbers = "1 2 3 5 7 9";

		scanner = new Scanner(numbers);

		while (scanner.hasNextInt()) {

		System.out.print(scanner.nextInt());

		}

		scanner.close();
		

		}
	
	//Create a method that uses a Scanner to parse any input from the console 
	//(System.in) and prints out the number of vowels in the line.

	public static void printVowels() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Please type in a line and hit Enter.");

		 String line = scanner.nextLine();
		 int count = 0;

		 for (int i = 0; i < line.length(); i++) {
		 char letter = line.charAt(i);
		 if (isVowel(letter)) {
		 count++;
		 }
		 }
		 System.out.println("The number of vowels: " + count);
		 scanner.close();
		}
		
	public static boolean isVowel(char letter) {
	if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
		 return true;
		 }
		 return false;
		} 
	
	public static void mover() {
		 Scanner scanner = new Scanner(System.in);
		 boolean exit = false;
		 System.out.println("Please type in one of the following:");
		 System.out.println("* 1 - Move Right");
		 System.out.println("* 2 - Move Left");
		 System.out.println("* 3 - Move Up");
		 System.out.println("* 4 - Move Down");
		 System.out.println("* q - exit program");
		 while (scanner.hasNext()) {

		 String input = scanner.next();

		 switch(input) {
		 case "1": {
		 System.out.println("Moving Right"); break;
		 }
		 case "2": {
		 System.out.println("Moving Left"); break;
		 }
		 case "3": {
		 System.out.println("Moving Up"); break;
		 }
		 case "4": {
		 System.out.println("Moving Down"); break;
		 }
		 case "q": {
		 System.out.println("Moving Left"); exit = true; break;
		 }
		 default: {
		 System.out.println("Try again. Accepatable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]");
		 }
		 }

		 if (exit) {
		 System.out.println("Exiting program...");
		 break;
		 }
		 }
		 scanner.close();
		}
}
