
public class Rectangle {

	double Width = 1;
	double Height = 1;
	
	Rectangle(){
	}
	
	Rectangle(double newWidth, double newHeight){
		Width = newWidth;
		Height = newHeight;
	}
	
	double getArea() {
		return Width * Height;
	}
	
	double getPerimeter() {
		
		return 2 *(Width + Height);
	}
	
	double getHeight() {
		return Height;
		
	}
	
	double getWidth() {
		return Width;
		
	}
	
	void setWidth(double newWidth) {
		Width = newWidth;
	}
	void setHeight(double newHeight) {
		Height = newHeight;
	}
		
}
