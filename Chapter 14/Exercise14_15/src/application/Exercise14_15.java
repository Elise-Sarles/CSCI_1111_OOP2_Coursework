package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.*;

public class Exercise14_15 extends Application{
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		StackPane sign = new StackPane();
		Scene scene = new Scene(sign, 400, 400);
		Polygon polygon = new Polygon();
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.RED);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = sign.getWidth() / 2, centerY = sign.getHeight() / 2;
		double radius = Math.min(sign.getWidth(), sign.getHeight()) * 0.4;

		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 8;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}    
		//// rotating object to have flat side facing up
		polygon.setRotate(22.5);
		///Adding in the text
		Text text = new Text("Stop");
		text.setFont(Font.font("Times new Roman", FontWeight.BOLD, (sign.getWidth() / 4)));
		text.setFill(Color.WHITE);
		
		sign.getChildren().clear();
		sign.getChildren().addAll(polygon,text);
	
		
		primaryStage.setTitle("Stop Sign"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}

