
public class Exercise9_1 {
 //// Elise Sarles July 3 2024 Rectangle test
	public static void main(String[] args) {
		
		///Creating first Rectangle
		Rectangle r1 = new Rectangle(4, 40);
		///Creating Second Rectangle
		Rectangle r2 = new Rectangle(3.5,35.9);
		
		//// Displaying width of r1
		System.out.println("Width of Retangle one: " + r1.getWidth());
	//// Displaying Height of r1
		System.out.println("Height of Retangle one: " + r1.getHeight());
	//// Displaying Area of r1
		System.out.println("Area of Retangle one: " + r1.getArea());
	//// Displaying Perimeter of r1
		System.out.println("Perimeter of Retangle one: " + r1.getPerimeter());
	///// Display separation line
		System.out.println("-----------------------------");
	//// Displaying width of r2
			System.out.println("Width of Retangle two: " + r2.getWidth());
		//// Displaying Height of r2
			System.out.println("Height of Retangle two: " + r2.getHeight());
		//// Displaying Area of r2
			System.out.println("Area of Retangle two: " + r2.getArea());
		//// Displaying Perimeter of r2
			System.out.println("Perimeter of Retangle two: " + r2.getPerimeter());
			

	}

}
