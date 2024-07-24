///// Elise Sarles July 20 2024 

///// Elise Sarles July 20 2024
import java.util.Scanner;

public class Exerise12_3 {

	static Scanner input = new Scanner(System.in);
	public static void main (String[] arg) {
		int[] array = new int[100];
		for(int i = 0; i <= 99; i ++) {
			array[i] = (int)(Math.random()* 10);
		}
		/// with a try and catch
		System.out.println("Using a try and Catch. \n");
		boolean enter = true;
		do {
			System.out.println("Please enter a whole number between 0 and 99! \n");
			int in = input.nextInt();
			try {
				System.out.println(" The number held at slot " + in + " is " + array[in] + "\n");
				enter = false;
			}catch(Exception ex) {
				System.out.println( "Out of Bounds, please try again.");
			}
			
		}while(enter);
		
		///// with an If statment 
		System.out.println("Using an if and else. \n");
		boolean play = true;
		do {
			System.out.println("Please enter a whole number between 0 and 99! \n");
			int in = input.nextInt();
			if (in < 0){
				System.out.println( "Out of Bounds please try again.");
			}
			else if(in <= 99){
				System.out.println(" The number held at slot " + in + " is " + array[in] + "\n");
				play = false;
			}
			else{
				System.out.println( "Out of Bounds please try again.");
			}
			
		}while(play);
	}
}
