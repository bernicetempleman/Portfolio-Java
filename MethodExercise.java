
public class MethodExercise {
	public static void main(String[] args) {

		   //create a class instance

		   MethodExercise me = new MethodExercise();

		 

		   //call your first method here

		   int num = me.randomNumber();
		   
		   System.out.println(num); 

	}
	
	public int randomNumber () {
		//Math.random() * (max - min + 1) + min  
		
		int result = (int) (Math.random() * 50) + 1;

		 return result; 
	}

}
