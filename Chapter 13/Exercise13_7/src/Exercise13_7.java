/////Elise Sarles July 29 2024
import java.util.Scanner;

public class Exercise13_7 {
	
	static Scanner input = new Scanner(System.in);
	static Scanner words = new Scanner(System.in);
	 
	 public static void main(String[] args) {
		geometricObject[] objgroup = new geometricObject[5];
		for (int i= 0; i < objgroup.length; i++) {
			objgroup[i] = new Triangle();
		}
		
		for (int i= 0; i < objgroup.length; i++) {
			System.out.println(objgroup[i].toString());
			if (objgroup[i] instanceof Colorable) {
				((Colorable)objgroup[i]).howToColor();
				System.out.print("\n");
			}
			
		}
	 }
	 
	 
}
