public class MethodParams{

 

 public static void main(String[] args) {

   //create a class instance

   MethodParams mp = new MethodParams();

 

   //call your method here

   double d = mp.convertIntToDouble(44);

 

   //print the value to the console

   System.out.println(d);

 

   //call the 2nd method here

   System.out.println(mp.sum(1.0, 2, 3));
   
   float[] squared = mp.square(1,2,3,4);
   for (int i =0; i< squared.length; i++) {
	   System.out.println (squared[i]);
   }
   
   String first = "aab";
   String second = "aac";
   
   System.out.println("first word"+ mp.findFirstWord(first, second));

 }

 

 //create your first method here

 public double convertIntToDouble(int num){

   return (double)num;

 }

 

 //new sum method here

 public double sum(double num1, int num2, int num3){

   return num1 + num2 + num3;  

 }
 
 /*
  * Create a method that declares four int parameters, 
  * squares each, and places the results in a float array.
  *  The method should return the float array result. 
  *  Name the method square.
  */
 public float[] square(int num1, int num2, int num3, int num4) {
	 float[] squares = {num1*num1, num2*num2, num3*num3, num4* num4};
			 return squares;
 }
 
 /*
  * Create a method that declares two String parameters. 
  * This method should search through each parameter 
  * and determine the word that should come first 
  * if they were sorted alphabetically.
  *  Whichever word is first from both parameters should be returned. 
  *  Name the method findFirstWord.

You can assume that both inputs are the same length and are actual words (not numbers).
 You can also assume that the length of each word will be at least 3 letters.
  */
 
 public String findFirstWord(String a, String b) {
	 
	 //convert Strings to char arrays
	 char[] aArray = a.toCharArray();
	 char[] bArray = b.toCharArray();
	 for (int i=0; i< aArray.length; i++) {
		 if(aArray[i] < bArray[i])
			 return a;
		 if(bArray[i] < aArray[i])
			 return b;
	 }
	 
	 
	 return a;
 }

}
