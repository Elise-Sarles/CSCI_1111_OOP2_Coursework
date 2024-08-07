package application;
/////Elise Sarles August 6 2024
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Exercise15_3 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Circle circle = new Circle(50, 50, 25);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Pane pane = new Pane(circle);

		 // Hold four buttons in an HBox 
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		                            
		HBox hBox = new HBox(btUp, btDown, btLeft, btRight);
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		                        
		BorderPane borderPane = new BorderPane(pane);
		borderPane.setBottom(hBox);
		        
		// Create and register the handler
		        
		btUp.setOnAction(new EventHandler<ActionEvent>() {

		@Override // Override the handle method

		public void handle(ActionEvent e) {
		circle.setCenterY(circle.getCenterY() > 25 ? circle.getCenterY() - 5 : 25);
		}
		});

		btDown.setOnAction(new EventHandler<ActionEvent>() {
		@Override 
		// Override the handle method
		public void handle(ActionEvent e) {
		circle.setCenterY(circle.getCenterY() < pane.getHeight() ? circle.getCenterY() + 5 : pane.getHeight());
		}
		});

		btLeft.setOnAction(new EventHandler<ActionEvent>() {
		@Override // Override the handle method 
		public void handle(ActionEvent e) {
		circle.setCenterX(circle.getCenterX() > 25 ? circle.getCenterX() - 5 : 25);
		}
		});

		btRight.setOnAction(new EventHandler<ActionEvent>() {
		@Override // Override the handle method
		public void handle(ActionEvent e) {
		circle.setCenterX(circle.getCenterX() < pane.getWidth() - 25 ? circle.getCenterX() + 5 : pane.getWidth() - 25);
		}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 400, 350);
		Image icon = new Image("icon.png"); // add image for icon
		primaryStage.getIcons().add(icon); // change icon
		primaryStage.setTitle("Exercise15_3"); // Title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
