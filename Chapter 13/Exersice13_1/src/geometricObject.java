import java.util.Date;

public abstract class geometricObject {
	
	private String color = "white"; /////Shapes color
	private boolean filled = false; ///// If shape is filled or note
	private Date dateCreated; ////// The date it is created
	
	////Creates a new object
	protected geometricObject(){
		dateCreated = new Date();
	}
	/////Creates object but with arguments
	protected geometricObject(String newColor, boolean updatefilled){
		dateCreated = new Date();
		color = newColor;
		filled = updatefilled;
		
	}
	/// Fetches the color of object
	public String getColor() {
		return color;
	}
	////Sets color of object
	public void setColor(String newColor) {
		color = newColor;
	}
	///// fetches if the color is filled
	public boolean isfilled() {
		return filled;
	}
	/// Sets if the object is filled
	public void setfilled(boolean updatefilled) {
		filled =updatefilled;
		
	}
	//fetches the date object was created
	public Date getDateCreated() {
		return dateCreated;
	}
	@Override
	/// returns a string about the objects
	public String toString() {
		return "\nColor is " + color + ". \nIs it Filled: " + filled + " \nThe date Created " + dateCreated;
	}

	public abstract double getArea();
	
	public abstract double getPerimeter();
	

}

