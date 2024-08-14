package application;
//// Elise Sarles August 13 2024
import java.io.File;

//// Elise Sarles August 13 2024
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Exercise16_21 extends Application{
	static int fin = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		/////pane made
		Pane pane = new Pane();
		////add song (you will have to find the new path to this file on you computer)
		////File mf = new File("C:\\Users\\Elise Sarles\\Documents\\Eclipse_Workspace\\Exercise16_21\\src\\Music.mp3");
		///// put this in to song instead  - mf.toURI().toURL().toString()
		Media song = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer music = new MediaPlayer(song);
		///text field made
		TextField tf = new TextField("#");
		tf.setAlignment(Pos.CENTER);
		tf.setFont(Font.font(60));
		tf.setPrefColumnCount(4);
		/// the event that will do the timer.
		EventHandler<ActionEvent> timer = e -> {
				if(Integer.parseInt(tf.getText()) > 0) {
				tf.setText(String.valueOf(Integer.parseInt(tf.getText()) - 1 ));
				  System.out.print("no ");
				} 
				else if(Integer.parseInt(tf.getText()) == 0 ) {
					if (fin ==0) {
					System.out.print("yes ");
					fin++;
					music.play();
					}
					tf.setEditable(false);
				 }
		};
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(500),timer));
		animation.setCycleCount(Timeline.INDEFINITE);
		tf.setOnAction(e-> animation.play());
		
		pane.getChildren().add(tf);
		
		Scene scene = new Scene(pane); ///setting the scene
		Image icon = new Image("icon.png"); // add image for icon
		primaryStage.getIcons().add(icon); // change icon
		primaryStage.setTitle("Exercise16_21"); // Title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		System.out.print("Starting program \n");
		launch(args);
		
	}

}
