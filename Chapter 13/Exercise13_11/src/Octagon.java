

public class Octagon extends geometricObject implements Cloneable, Comparable<geometricObject>{
	double side1 = 1.0;
	double side2 = 1.0;
	double side3 = 1.0;
	double side4 = 1.0;
	double side5 = 1.0;
	double side6 = 1.0;
	double side7 = 1.0;
	double side8 = 1.0;
	
	
	Octagon(){
		
	}
	
	Octagon(double side){
		side1 = side;
		side2 = side;
		side3 = side;
		side4 = side;
		side5 = side;
		side6 = side;
		side7 = side;
		side8 = side;
	}
	
	Octagon(double newside, String newColor, boolean updatefilled){
		side1 = newside;
		side2 = newside;
		side3 = newside;
		side4 = newside;
		side5 = newside;
		side6 = newside;
		side7 = newside;
		side8 = newside;
		setColor(newColor);
		setfilled(updatefilled);
	}
	
	///fetchs side 1
	public double getside1(){
		return side1;
	}
	///fetches side 2
	public double getside2(){
		return side2;
	}
	///fetches side 3
	public double getside3(){
		return side3;
	}
	///fetches side 4
	public double getside4(){
		return side4;
	}
	///fetches side 5
	public double getside5(){
		return side5;
	}
	///fectchs side 6
	public double getside6(){
		return side6;
	}
	///fectchs side 7
	public double getside7(){
		return side7;
	}
	///fectchs side 8
	public double getside8(){
		return side8;
	}
	
	//sets side 1
	public void setsides(double newside) {
		side1 = newside;
		side2 = newside;
		side3 = newside;
		side4 = newside;
		side5 = newside;
		side6 = newside;
		side7 = newside;
		side8 = newside;
	}

	
	public double getArea() {
		double area;
		area = (2+ 4/Math.sqrt(2))*side1 * side1;
								
		return area;
	}
	public double getPerimeter() {
		double perimeter = side1 + side2 + side3 + side4 + side5 + side6 + side7 + side8;
		return perimeter;
	}
	
	@Override
	/// returns a string about the objects
	public String toString() {
		return  "Octagon: \nside 1 = " + side1 + " side 2 = " + side2 + " side 3 = " + side3 + " side 4 = " + side4 + " side 5 = " + side5+ " side 6 = " + side6+ " side 7 = " + side7+ " side 8 = " + side8 + "\nThe Permiter is: " + this.getPerimeter() + "\nThe Area is: " + this.getArea() + super.toString() ;
	}
	public int compareTo(geometricObject o) {
		if (getArea() > o.getArea())
			return 1;
		else if (getArea() < o.getArea())
			return -1;
		else
			return 0;
		
	}
	public Object clone() {
		try {
			return super.clone();
		}
		catch(CloneNotSupportedException ex) {
			return null;
		}
	}
}
