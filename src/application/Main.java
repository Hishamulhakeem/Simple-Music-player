package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		
			Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Spotify");
		
			stage.setResizable(false);
			
			
			stage.setScene(scene);
			stage.show();
			
			stage.setOnCloseRequest(new EventHandler <WindowEvent>() {

				@Override
				public void handle(WindowEvent arg0) {
					// TODO Auto-generated method stub
					Platform.exit();
					System.exit(0);
				}
				
			});
			
//			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
