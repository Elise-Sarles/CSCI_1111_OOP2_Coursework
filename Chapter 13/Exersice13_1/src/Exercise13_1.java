////Elise Sarles July 27 2024. Used from Exersice11_1
import java.util.Scanner;

public class Exercise13_1 {
	
	static Scanner input = new Scanner(System.in);
	static Scanner words = new Scanner(System.in);
	 
	 public static void main(String[] args) {
		 
		 System.out.println("Enter a side to a triangle");
		 double a = input.nextDouble();
		 System.out.println(" Enter the another side the triangle");
		 double b = input.nextDouble();
		 System.out.println("Enter the last side of the triangle");
		 double c = input.nextDouble();
		 System.out.println("What color is the triangle?");
		 String color = words.nextLine();
		 System.out.println("Is the shapes color filled? (Enter 1 for yes or 2 for no)");
		 int fill = input.nextInt();
		 boolean filled = false;
		 if (fill == 1){
			 filled = true;
		 }
		 else if(fill == 2) {
			 filled = false;
		 }
		 else {
			 System.out.println("Not a vaild entry automaticly set triangle as not filled.");
		 filled = false;
		 }
		 
		 Triangle Tri = new Triangle(a,b,c,color,filled);
			
			System.out.println( Tri.toString() + "\nThe Area is " + Tri.getArea() + "\nThe Perimeter is " + Tri.getPerimeter());
	 }
}
