///// Elise Sarles July 4-6 2024
import java.util.Scanner;
class Exercise10_3 {
	private static Scanner input;
	private static Scanner textinput;

	public static void main(String[] args) {
		/// Scanners to see inputs
			input = new Scanner(System.in);
			textinput = new Scanner(System.in);
		/// start with 1 number
			System.out.println("Enter a starting integer: ");
			int n = input.nextInt();
			MyInteger a = new MyInteger(n);
			System.out.println("The value is equal to 10: " +a.equal(10));
			System.out.println(a.getMyInteger() + " is a even number: " + a.isEven() );
			System.out.println(a.getMyInteger() + " is a odd number: " + a.isOdd());
			System.out.println(a.getMyInteger() + " is a prime number: " + a.isPrime());
		///// using 2 different object to display Code again
			System.out.println("\nChose another Integer");
			int t = input.nextInt();
			MyInteger b = new MyInteger(t);
			System.out.println("Enter a possible integer value: ");
			int m = input.nextInt();
			MyInteger c = new MyInteger(m);
			System.out.println(b.getMyInteger() + " is equal to " + c.getMyInteger() + ": " + MyInteger.equals(b, c));
			System.out.println(b.getMyInteger() + " is a even number: " + MyInteger.isEven(b) );
			System.out.println(c.getMyInteger() + " is a even number: " + MyInteger.isEven(c) );
			System.out.println(b.getMyInteger() + " is a odd number: " + MyInteger.isOdd(b));
			System.out.println(c.getMyInteger() + " is a odd number: " + MyInteger.isOdd(c));
			System.out.println(b.getMyInteger() + " is a prime number: " + MyInteger.isPrime(b));
			System.out.println(c.getMyInteger() + " is a prime number: " + MyInteger.isPrime(c));
		/// Changing a string to an integer
			System.out.println("Enter a anything that has numbers");
			String k = textinput.nextLine();
			System.out.println(MyInteger.parseInt(k));
		/// changing a string to a char[] then to an integer
			System.out.println("Enter a anything that has numbers");
			String l = textinput.nextLine();
			 char[] ch = new char[l.length()];
			 for (int i = 0; i < l.length(); i++) {
		            ch[i] = l.charAt(i);
		        }
			System.out.println(MyInteger.parseInt(ch));
	
			
		
		

		
		
	}
}