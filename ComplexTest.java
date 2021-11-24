/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexnumbers;

/**
 *
 * @author Bernice
 
3.	A (11 points)  (Complex Numbers) Create a class called Complex for performing arithmetic with complex numbers.  Complex numbers have the form 

realPart + imaginaryPart * i

where i is 

 

Write a program to test your class.  Use floating-point variables to represent the private data of the class.  Provide a constructor that enables an object of this class to be initialized when it is declared.  Provide a no-argument constructor with default values in case no initializers are provided.  Provide public methods that perform the following operations:
a)	Add two Complex numbers: the real parts are added together and the imaginary parts are added together.
Hint: 
For this exercise, please consider the use of this reference (see from subchapter 8.4).  
A template looks like:

// Add two Complex numbers
public Complex add( Complex Right )
{
   /*  Write code here 
}
b)	Subtract two Complex numbers: the real part of the right operand is subtracted from the real part of the left operand, and the imaginary part of the right operand is subtracted from the imaginary part of the left operand.
c)	Print Complex numbers in the form (a, b), where a is the real part and b is the imaginary part.
*/
class ComplexNumbers 
{
	private double realPart;
	private double imaginaryPart;
	
	public ComplexNumbers()
	{
		this(0.0,0.0);
	}
	
	public ComplexNumbers(double realPart, double imaginaryPart)
	{
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	// Add two Complex numbers
	public ComplexNumbers Add( ComplexNumbers Right )
	{
		ComplexNumbers Left = this;
		double real = Left.realPart + Right.realPart;
		double imaginary = Left.imaginaryPart + Right.imaginaryPart;
		return new ComplexNumbers(real, imaginary);
	}
	
	//subtract two Complex Numbers
	public ComplexNumbers Subtract( ComplexNumbers Right )
	{
		ComplexNumbers Left = this;
		double real = Left.realPart - Right.realPart;
		double imaginary = Left.imaginaryPart - Right.imaginaryPart;
		return new ComplexNumbers(real, imaginary);
	}
	
	//print complex numbers in form (a, b)
	public void Print()
	{
		System.out.printf("(%f, %f)", realPart, imaginaryPart);
	}
}
public class ComplexTest {

	public static void main(String[] args) {
		
		ComplexNumbers number1 = new ComplexNumbers(5,4);
		ComplexNumbers number2 = new ComplexNumbers(-2,2);
		ComplexNumbers result = new ComplexNumbers();
		
		System.out.printf("result = ");
		result.Print();
		System.out.println();
		
		System.out.printf("number1 = ");
		number1.Print();
		System.out.println();
		
		System.out.printf("number2 = ");
		number2.Print();
		System.out.println();
		
		System.out.printf("number1 + number2 = ");
		result = number1.Add(number2);
		result.Print();
		System.out.println();
		
		System.out.printf("number1 - number2 = ");
		result = number1.Subtract(number2);
		result.Print();
	}
}

