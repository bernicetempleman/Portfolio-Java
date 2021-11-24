
public class StringMethods {
	public static void main(String[] args) {
		   //String str = "Hello";
		   String s = new String("Hello");
		   
		   String str = "This is a new String"; 
		   
		   System.out.println(str.equals("Hello"));
		   System.out.println(str==s);
		   System.out.println(str.equals(s));
		   
		   //using the length() method
		   System.out.println(str.length());
		   
		   //use the indexO() method
		   System.out.println(str.indexOf("H"));
		   
		 //toUpperCase() - used to convert each letter to uppercase 
		// the value must be saved in order to use it
		 str = str.toUpperCase();
		 System.out.println(str);
		 //toLowerCase() - used to convert each letter to lowercase 
		str = str.toLowerCase(); System.out.println(str.toLowerCase()); 
		//charAt(int index) - used to find the letter at the specified index 
		System.out.println(str.charAt(5)); 
		//equalsIgnoreCase - used to test if another String is equivalent regard less of capitalization 
		System.out.println(str.equalsIgnoreCase("THiS Is A nEW STRinG")); System.out.println(str.equalsIgnoreCase("this is a new string"));
		 //substring - returns a smaller section of the original String starting at the specified index 
		System.out.println(str.substring(4)); 

		   }
}
