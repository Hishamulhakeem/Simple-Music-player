package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller2 {
	
	  @FXML
	    private Button bu;
	  
	  private Parent root;
	  private Stage stage;
	  private Scene scene;

	    @FXML
	    void bu1(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader loader =new FXMLLoader (getClass().getResource("Scene.fxml"));
			root=loader.load();
			
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show(); 
			

	    }
	    @FXML
	    void lo(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader loader =new FXMLLoader (getClass().getResource("Scene4.fxml"));
			root=loader.load();
			
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show(); 
			

	    }
	    @FXML
         void mo(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader loader =new FXMLLoader (getClass().getResource("Scene5.fxml"));
			root=loader.load();
			
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show(); 
			

	    }
	    

}
