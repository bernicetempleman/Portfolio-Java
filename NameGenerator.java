
public class NameGenerator {
	public static void main(String args[]){

		   String[] firstNames = {"Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah", "William"};

		   String[] lastNames = {"Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow", "Tran"};

		   

		   //iterate over the first set of numbers

		   for (int i = 0; i < firstNames.length; i++) {

		     

		     //iterate over the second set of numbers

		     for (int j = 0; j < lastNames.length; j++) {

		       

		       //print the product of the current elements from each set

		       System.out.println(firstNames[i] +" " + lastNames[j]);

		     }

		   }

		 }

}
