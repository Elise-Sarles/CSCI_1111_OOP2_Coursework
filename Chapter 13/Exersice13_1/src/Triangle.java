
public class Triangle extends geometricObject {  /// sets parents object as geometricObject
	double side1 = 1.0; //// one side of side1
	double side2 = 1.0; //// one side of side2
	double side3 = 1.0; //// one side of side3

	/// Creates  triangle object
	Triangle(){
	}
	/////Creates triangle obect with arguments
	Triangle(double newside1, double newside2, double newside3){
		side1 = newside1;
		side2 = newside2;
		side3 = newside3;
	}
	//// Creates triangle with arguments from parent object
	Triangle(double newside1, double newside2, double newside3, String newColor, boolean updatefilled){
		side1 = newside1;
		side2 = newside2;
		side3 = newside3;
		setColor(newColor);
		setfilled(updatefilled);
	
	}
	///fectchs side 1
	public double getside1(){
		return side1;
	}
	///fetchs side 2
	public double getside2(){
		return side2;
	}
	///fetchs side 3
	public double getside3(){
		return side3;
	}
	//sets side 1
	public void setside1(double newside1) {
		side1 = newside1;
	}
	//sets side 2
	public void setside2(double newside2) {
		side2 = newside2;
	}
	//set side 3
	public void setside3(double newside3) {
		side3 = newside3;
	}
	/// fetchs a string with all the sides
	public String getsides() {
		return side1 + " " + side2 + " " + side3;
	}
	///sets all three sides
	public void setsides(double newside1, double newside2, double newside3){
		side1 = newside1;
		side2 = newside2;
		side3 = newside3;
	}
	/// returns the area of the triangle
	public double getArea() {
		double s = (side1 + side2 + side3)/2;
		double Area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return Area;
	}
	/// returns the perimeter of the triangle
	public double getPerimeter() {
		double Perimeter = side1 + side2 + side3;
		return Perimeter;
	}
	/// returns a string about the objects
	public String toString() {
	return "Triangle: side 1 = " + side1 + " side 2 = " + side2 + " side 3 = " + side3 + super.toString();
	}
}
