
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author berni
 */
public class Ch2ex1 {

 // {

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
      // TODO code application logic here
  // }
    
    // Programmer	: Bernice Templeman
// Date			: 08/28/2015
// Course		: CIS 5100
// Homework  	: 2
// Exercise		: 2.15
// Description	: Arihmetic
//		Use techniques shown in Fig 2.7
//		Write an Application that asks the user to enter 2 integers
//		Obtain them from the user
//		Print their sum, product, difference, quotient.
//


//public class Ch2_Exercise15 {

	//main method begins execution of java application
	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		int number1;		// first number for Arithmetic operations	
		int number2;		// second number for Arithmetic operations
		int sum;			// sum of number1 and number2
		int difference;		// difference of number1 and number2
		int product;		// product of number1 and number2
		int quotient;		// quotient of numbe1 and number2

		System.out.println("Enter the first integer: "); //prompt
		number1 = input.nextInt(); // read first number from the user

		System.out.println("Enter the second integer: "); //prompt
		number2 = input.nextInt(); // read second number from the user

		sum = number1 + number2; //add numbers, then store total in sum

		difference = number1 - number2; // subtract numbers, then store total in difference

		product = number1 * number2; // multiply numbers, then store total in product

		// check for Divide by 0 error
		if (number2 != 0) // number2 is not 0
			quotient = number1 / number2; // divide numbers, then store total in quotient
		else //number2 is 0
			quotient = 0; // set quotient to 0

		System.out.printf("Sum is \t\t%d%n", sum); // display sum

		System.out.printf("Difference is \t%d%n", difference); // display difference

		System.out.printf("Product is \t%d%n", product); // display product

		if (number2 != 0)
			System.out.printf("Quotient is \t%d%n", quotient); // display quotient
		else
			System.out.println("Quotient error \tCan not Divide by 0\n");
	}//end method main
}// end class
//}
