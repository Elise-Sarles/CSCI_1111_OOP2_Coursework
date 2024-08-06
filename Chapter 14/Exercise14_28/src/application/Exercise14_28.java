package application;
////Elise Sarles August 6 2024
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;


public class Exercise14_28 extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		ClockPane clock = new ClockPane(((int)(Math.random()* 12)),((int)(Math.random()* 31)),((int)(Math.random()* 60)));
		clock.setHHVisiblity(true);
		clock.setMHVisiblity(true);
		System.out.println(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
		Scene scene = new Scene(clock, 400, 400);
		Image icon = new Image("icon.png");
		Stage stage = new Stage();
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.setTitle("Clock Pane Exercise14_28");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
