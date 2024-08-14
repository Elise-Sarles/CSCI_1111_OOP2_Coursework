package application;
//// Elise Sarles August 12 2024
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_1 extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene scene = new Scene(getPane(), 600, 200);
		Image icon = new Image("icon.png"); // add image for icon
		primaryStage.getIcons().add(icon); // change icon
		primaryStage.setTitle("Exercise15_3"); // Title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	protected BorderPane getPane() {
		////Created pane all of this will go in
		BorderPane pane = new BorderPane();
		/// text and button for move
		Text text = new Text(50, 50,"Programming is Fun");
		text.setFont(new Font(20));
		text.setFill(Color.BLACK);
		Pane panefortext = new Pane();
		HBox paneforbutton = new HBox();
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");
		paneforbutton.getChildren().addAll(btLeft, btRight);
		paneforbutton.setAlignment(Pos.CENTER);
		paneforbutton.setPadding(new Insets(5,5,5,5));
		paneforbutton.setStyle("-fx_border-width: 2px; -fx-border-color: black");
		
		/// Actions for moment buttons if statements stopping them for leaving the view of the screen.
		btLeft.setOnAction(e -> { 
			if(text.getX() -10 >= 0) {
				text.setX(text.getX() - 10);
			}});
		
		btRight.setOnAction(e -> { 
			if(text.getX() + 10 <= panefortext.getWidth() -180) {
				text.setX(text.getX() + 10);
			}});
		
		
		panefortext.getChildren().add(text);
		
		///// Radio buttons 
		HBox paneforradiobutton = new HBox();
		paneforradiobutton.setPadding(new Insets(5,5,5,5));
		paneforradiobutton.setStyle("-fx_border-width: 2px; -fx-border-color: black");
		RadioButton rdRed = new RadioButton("Red ");
		RadioButton rdGreen = new RadioButton("Green ");
		RadioButton rdBlue = new RadioButton("Blue ");
		RadioButton rdOrange = new RadioButton("Orange ");
		RadioButton rdBlack = new RadioButton("Black ");
		paneforradiobutton.getChildren().addAll(rdRed, rdGreen, rdBlue, rdOrange, rdBlack);	
		paneforradiobutton.setAlignment(Pos.CENTER);
		ToggleGroup group = new ToggleGroup();
		rdRed.setToggleGroup(group);
		rdGreen.setToggleGroup(group);
		rdBlue.setToggleGroup(group);
		rdOrange.setToggleGroup(group);
		rdBlack.setToggleGroup(group);
		
		
		rdRed.setOnAction(e -> {
			if(rdRed.isSelected()) {
				text.setStroke(Color.RED);
			}
		});
		
		rdGreen.setOnAction(e -> {
			if(rdGreen.isSelected()) {
				text.setStroke(Color.GREEN);
			}
		});
		
		rdBlue.setOnAction(e -> {
			if(rdBlue.isSelected()) {
				text.setStroke(Color.BLUE);
			}
		});
		
		rdOrange.setOnAction(e -> {
			if(rdOrange.isSelected()) {
				text.setStroke(Color.ORANGE);
			}
		});
		
		rdBlack.setOnAction(e -> {
			if(rdBlack.isSelected()) {
				text.setStroke(Color.BLACK);
			}
		});
		
		pane.setTop(paneforradiobutton);
		pane.setBottom(paneforbutton);
		pane.setCenter(panefortext);
		
		return pane;
	}

}