 /// Elise Sarles July 30 2024
public class Exercise13_11 {
	
	public static void main(String[] arg) {
		Octagon o1 = new Octagon(5);
		Octagon o2 = o1;
		Octagon o3 = (Octagon)o1.clone();
		
		System.out.println(o1.equals(o2));
		System.out.println(o1.equals(o3));
		
		System.out.println(o1.compareTo(o2));
		System.out.println(o1.compareTo(o3));
		
	}
}
