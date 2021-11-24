import java.util.*;
import java.io.*;

public class JavaLoops {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t= in.nextInt();
		
		int sum = 0;
		
		for(int i = 0; i<t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			
			sum = a; 
			
			for (int j = 0; j < n; j++) {
				
				sum+=Math.pow(2, j)*b;
				System.out.print(sum + " ");
			}
			System.out.println();
		}
		
	}

}
