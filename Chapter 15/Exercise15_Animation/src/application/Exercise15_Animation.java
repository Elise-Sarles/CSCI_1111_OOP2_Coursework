package application;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_Animation  extends Application {

	
	public void start(Stage primaryStage) throws Exception{

		Pane pane = new Pane();
	
		// Create a rectangle
		Rectangle rectangle = new Rectangle (0, 0, 25, 50);
		rectangle.setFill(Color.BLACK);
		rectangle.setOpacity(0.5);
		
		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		double width = 400;
		double height = 400;
		double centerX = 200;
		double centerY = 200 ;
		double radius = Math.min(width, height) * 0.4;
		
		// s represents the number of sides of the shape
		int s = 5;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		} 
		
		// Add circle and rectangle to the pane
		pane.getChildren().add(polygon);
		pane.getChildren().add(rectangle);
		
		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(polygon);
		pt.setNode(rectangle);
		pt.setOrientation(
		PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play(); // Start animation
		
		polygon.setOnMousePressed(e -> pt.pause());
		polygon.setOnMouseReleased(e -> pt.play());
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 400);
		Image icon = new Image("icon.png"); // add image for icon
		primaryStage.getIcons().add(icon); // change icon
		primaryStage.setTitle("PathTransitionDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the 
		primaryStage.show(); // Display the stage

		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
