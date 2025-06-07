package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller1 {
	
	 @FXML
	    private Button ac;

	    @FXML
	    private PasswordField pas;

	    @FXML
	    private TextField tx;
	    
	   private Parent root;
	    private Stage stage;
	   private  Scene scene;

	    @FXML
	    void acc(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader loader =new FXMLLoader (getClass().getResource("Scene3.fxml"));
			root=loader.load();
			
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show(); 
			

	    }

}
