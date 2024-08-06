package application;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.*;

public class ClockPane extends Pane{
	private int hour;
	private int minute;
	private int second;
	private boolean hourHandVisible;
	private boolean minuteHandVisible;
	private boolean secondHandVisible;
	
	/// basic constructor
	ClockPane(){
		setCurrentTime();
	}
	/// constructor w/ number properties
	ClockPane(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	ClockPane(boolean hhv, boolean mhv, boolean shv){
		setCurrentTime();
		this.hourHandVisible = hhv;
		this.minuteHandVisible = mhv;
		this.secondHandVisible = shv;
	}
	/// constructor w/ all properties
	ClockPane(int hour, int minute, int second, boolean hhv, boolean mhv, boolean shv){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.hourHandVisible = hhv;
		this.minuteHandVisible = mhv;
		this.secondHandVisible = shv;
	}
	///All the getter method for the properties
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public boolean getHourHandVisiblity() {
		return hourHandVisible;
	}
	public boolean getMinuteHandVisiblity() {
		return minuteHandVisible;
	}
	public boolean getSecounHandVisiblity() {
		return secondHandVisible;
	}
	///All the setter methods for the properties
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}
	public void setHHVisiblity(boolean hhv) {
		this.hourHandVisible = hhv;
		paintClock();
	}
	public void setMHVisiblity(boolean mhv) {
		this.minuteHandVisible = mhv;
		paintClock();
	}
	public void setSHVisiblity(boolean shv) {
		this.secondHandVisible = shv;
		paintClock();
	}
	
	public void setCurrentTime(){
		Calendar calender = new GregorianCalendar();
		this.hour = calender.get(Calendar.HOUR_OF_DAY);
		this.minute = calender.get(Calendar.MINUTE);
		this.second = calender.get(Calendar.SECOND);
		
		paintClock();
		
	}
	
	private void paintClock(){
		double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
		double centerX = getWidth() /2;
		double centerY = getHeight() /2;
		
		//Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12,"12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius -3, "6");
		
		 // Draw second hand
	    double sLength = clockRadius * 0.8;
	    double secondX = centerX + sLength * 
	      Math.sin(second * (2 * Math.PI / 60));
	    double secondY = centerY - sLength * 
	      Math.cos(second * (2 * Math.PI / 60));
	    Line sLine = new Line(centerX, centerY, secondX, secondY);
	    sLine.setStroke(Color.RED);

	    // Draw minute hand
	    double mLength = clockRadius * 0.65;
	    double xMinute = centerX + mLength * 
	      Math.sin(minute * (2 * Math.PI / 60));
	    double minuteY = centerY - mLength * 
	      Math.cos(minute * (2 * Math.PI / 60));
	    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
	    mLine.setStroke(Color.BLACK);
	    
	    // Draw hour hand
	    double hLength = clockRadius * 0.5;
	    double hourX = centerX + hLength * 
	      Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
	    double hourY = centerY - hLength *
	      Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
	    Line hLine = new Line(centerX, centerY, hourX, hourY);
	    hLine.setStroke(Color.BLACK);
	    
	    getChildren().clear();  
	    getChildren().addAll(circle, t1, t2, t3, t4);
	    if (getHourHandVisiblity()) {
	    	 getChildren().add(hLine);
	    }
	    if (getMinuteHandVisiblity()) {
	    	 getChildren().add(mLine);
	    }
	    if (getSecounHandVisiblity()) {
	   	 getChildren().add(sLine);
	   }
		
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paintClock();
	}
	
	public void setHeight(double height) {
		super.setHeight(height);
		paintClock();
	}
	
	
	
}
