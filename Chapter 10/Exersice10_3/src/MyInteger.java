
public class MyInteger {
	
	private int myInteger = 0;
	/// Object constructor
	MyInteger(){
		
	}
	/// Object constructor with value
	MyInteger(int integer){
		myInteger = integer;
	}
	/// calling the value
	int getMyInteger(){
		
		return myInteger;
	}
	/// setting the value of the integer
	void setMyInteger(int integer) {
		myInteger = integer;
	}
	/// true of false is it even.
	boolean isEven(){
		if(myInteger % 2 == 0){
			return true;
		}
		else{
			return false;
		}
	}
	/// True of False is it odd
	boolean isOdd(){
		if(myInteger % 2 == 0){
			return false;
		}
		else{
			return true;
		}
		
	}
	/// true of false is it prime. First is is greater then of equal to 0 then is is divisible by anything less then it. 
	boolean isPrime(){
		if (myInteger <= 1){
			return false;
		}
		for (int i = 2; i < myInteger; i++){
			if (myInteger % i == 0){
				return false;
			}
		}
		return true;
	}
	/// same as isEven only but for numbers not the object. Also static so it can be used staticly
	static boolean isEven(int integer){
		if(integer % 2 == 0){
			return true;
		}
		else{
			return false;
		}
	}
	/// same as isOdd only but for numbers not the object. Also static so it can be used staticly
	static boolean isOdd(int integer){
		if(integer % 2 == 0){
			return false;
		}
		else{
			return true;
		}
	}
	/// same as isPrime only but for numbers not the object. Also static so it can be used staticly
	static boolean isPrime(int integer){
		if (integer <= 1){
			return false;
		}
		for (int i = 2; i < integer; i++){
			if (integer % i == 0){
				return false;
			}
		}
		return true;
	}
	/// same as isEven but static so it can be used staticly for objects
	static boolean isEven(MyInteger in){
		return isEven(in.getMyInteger());
	}
	/// same as isOdd but static so it can be used staticly for objects
	static boolean isOdd(MyInteger in){
		return isOdd(in.getMyInteger());
	}
	/// same as isPrime but static so it can be used staticly for objects
	static boolean isPrime(MyInteger in){
			return isPrime(in.getMyInteger());
	}
	////See is int and object are equal
	boolean equal(int n){
		if (myInteger == n){
			return true;
		}
		else{
			return false;
		}
	}
	////see is two int are equals
	static boolean equal(int v, int n){
		if (v == n){
			return true;
		}
		else{
			return false;
		}
	}
	////See is int and object  are equal a different way
	static  boolean equals(MyInteger o, int n){
		return equal(o.getMyInteger(), n);
	}
	//// see if two object  are equals
	static boolean equals(MyInteger o, MyInteger l){
		return equal(o.getMyInteger(), l.getMyInteger());
	}
	///change string to int taking out all things that aren't numbers
	static int parseInt(String s) {
		s = s.replaceAll("\\D+", "");
		int i = Integer.parseInt(s);
		return i;
	}
	///change char[] to int taking out all things that aren't numbers
	static int parseInt(char [] ch) {
		String s = String.valueOf(ch);
		s = s.replaceAll("\\D+", "");
		int i = Integer.parseInt(s);
		return i;
	}
	

}
