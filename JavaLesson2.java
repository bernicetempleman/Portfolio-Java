package SampleJava;
import java.util.Scanner;

public class JavaLesson2
{
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.print("Your favorite number: ");
		if (userInput.hasNextInt())
		{
			int numberEntered = userInput.nextInt();
			System.out.println("You entered " + numberEntered);
			int numEnteredTimes2= numberEntered + numberEntered;
			System.out.println(numEnteredTimes2);
		}
		else {
			System.out.println("Enter an integer next time");
		}
	}
}