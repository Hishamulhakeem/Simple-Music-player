package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable {
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	 @FXML
	    private Button bn,ba;

	    @FXML
	    private Button bpa;

	    @FXML
	    private Button bpl;

	    @FXML
	    private Button bpr;

	    @FXML
	    private Button bres;

	    @FXML
	    private ComboBox<String> bs;

	    @FXML
	    private Button bt1;

	    @FXML
	    private Button bt2;

	    @FXML
	    private ImageView img,imag,imag1,imag2,imag3,imag4,im;

	    @FXML
	    private Slider vs;
	    @FXML
	    private ProgressBar bar;
	    
	    @FXML
	    private Label label;
	    
	    private Media media;
		private MediaPlayer mediaPlayer;
		
		
		private File directory;
		private File[] files;
		
		private ArrayList<File> songs;
		
		private int songNumber;
		private int[] speed= {25,50,75,100,125,150,175,200};
		private Timer timer;
		private TimerTask task;
		private boolean running;
		
		Image i1 = new Image(getClass().getResourceAsStream("1.jpeg"));
		Image i2 = new Image(getClass().getResourceAsStream("2.jpeg"));
		Image i3 = new Image(getClass().getResourceAsStream("3.jpeg"));
		Image i4 = new Image(getClass().getResourceAsStream("4.jpeg"));
		Image i5 = new Image(getClass().getResourceAsStream("5.jpeg"));
		Image i6 = new Image(getClass().getResourceAsStream("6.jpeg"));
		Image i7 = new Image(getClass().getResourceAsStream("7.jpeg"));
		Image i8 = new Image(getClass().getResourceAsStream("8.jpeg"));
		Image i9 = new Image(getClass().getResourceAsStream("9.jpeg"));
		
		
		String s1="Adada (2).mp3";
		String s2="Duniyaa.m4a";
		String s3="Jailer.m4a";
		String s4="Maan Meri Jaan .m4a";
		String s5=" Maate vinadhuga .m4a";
		
		private String getCurrentSongFileName() {
			String so=label.getText();
			return so;
		}
		
	    @FXML
	    void next(ActionEvent event) {
	    	
	    	if(songNumber <songs.size() - 1) {
	    		songNumber ++;
	    		mediaPlayer.stop();
	    		if(running) {
	    			cancelTimer();
	    		}
	    		
	    		
	    		media = new Media(songs.get(songNumber).toURI().toString());
	    		mediaPlayer = new MediaPlayer(media);
	    		label.setText(songs.get(songNumber).getName());
	    		
	    		play(event);
	    		
	    		
	    		
	    		
	    		
	    	}else {
	    		songNumber =0;
	    		mediaPlayer.stop();
	    		if(running) {
	    			cancelTimer();
	    		}
	    		
	    		
	    		media = new Media(songs.get(songNumber).toURI().toString());
	    		mediaPlayer = new MediaPlayer(media);
	    		label.setText(songs.get(songNumber).getName());
	    		play(event);
	    		
	    	}
	    	
	    	
	    	

	    }

	    @FXML
	    void pause(ActionEvent event) {
	    	cancelTimer();
	    	mediaPlayer.pause();

	    }

	    private void cancelTimer() {
	    	
	    	running = false;
	    	timer.cancel();
			
			
		}

		@FXML
	    void play(ActionEvent event) {
			
			String currentSongFileName = getCurrentSongFileName();
			
	    	beginTimer();
			
			changeSpeed(null);
			mediaPlayer.setVolume(vs.getValue() * 0.01);
			mediaPlayer.play();

			if(currentSongFileName.equals("Adada")) {
	    		img.setImage(i1);
	    	}
			else if(currentSongFileName.equals("Duniyaa")) {
	    		img.setImage(i2);
	    	}
			else if(currentSongFileName.equals("Jailer")) {
	    		img.setImage(i3);
	    	}
			else if(currentSongFileName.equals("Maan Meri Jaan")) {
	    		img.setImage(i4);
	    	}
			else if(currentSongFileName.equals(" Maate vinadhuga")) {
	    		img.setImage(i5);
	    	}else {
	    		img.setImage(i1);
	    	}
			
			
	    }

	    private void beginTimer() {
	    	
	    	timer = new Timer();
	    	task = new TimerTask() {

				@Override
				public void run() {
					running = true;
					double current = mediaPlayer.getCurrentTime().toSeconds();
					double end = media.getDuration().toSeconds();
					
					bar.setProgress(current/end);
					if(current/end == 1) {
						cancelTimer();
					}
				}
	    		
	    	};
	    	timer.scheduleAtFixedRate(task, 0, 1000);
	    	
			// TODO Auto-generated method stub
			
		}

		@FXML
	    void pre(ActionEvent event) {
			if(songNumber >0) {
	    		songNumber --;
	    		mediaPlayer.stop();
	    		
	    		if(running) {
	    			cancelTimer();
	    		}
	    		
	    		media = new Media(songs.get(songNumber).toURI().toString());
	    		mediaPlayer = new MediaPlayer(media);
	    		label.setText(songs.get(songNumber).getName());
	    		
	    		play(event);
	    		
	    	}else {
	    		songNumber = songs.size()-1;
	    		mediaPlayer.stop();
	    		
	    		if(running) {
	    			cancelTimer();
	    		}
	    		
	    		
	    		media = new Media(songs.get(songNumber).toURI().toString());
	    		mediaPlayer = new MediaPlayer(media);
	    		label.setText(songs.get(songNumber).getName());
	    		play(event);
	    		
	    	}
	    	
		

	    }

	    @FXML
	    void reset(ActionEvent event) {
	    	bar.setProgress(0);;
	    	mediaPlayer.seek(Duration.seconds(0.0));

	    }

	    

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			songs=new ArrayList<File>();
			directory = new File("Music");
			files = directory.listFiles();
			
			if(files != null) {
				for(File file: files) {
					songs.add(file);
				//	System.out.println(file);
				}
			}
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
					
			label.setText(songs.get(songNumber).getName());
			label.setStyle("-fx-font-size: 17pt; -fx-text-fill: #eeff00");
			
			
			
			
			for(int i =0;i< speed.length;i++) {
				bs.getItems().add(Integer.toString(speed[i]));
			}
			
			bs.setOnAction(this::changeSpeed);
			
			vs.valueProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				mediaPlayer.setVolume(vs.getValue() * 0.01);
					
				}
				
			});
			bar.setStyle("-fx-accent: #00FF00;");
			
			
			// setting image for each button
			
			Image b=new Image(getClass().getResourceAsStream("backward.jpeg"));
			imag.setImage(b);
			imag.setMouseTransparent(true);
			
            Image b1=new Image(getClass().getResourceAsStream("pause (2).jpeg"));
			imag1.setImage(b1);
			imag1.setMouseTransparent(true);
			
            Image b2=new Image(getClass().getResourceAsStream("replay.jpeg"));
			imag2.setImage(b2);
			imag2.setMouseTransparent(true);
			
            Image b3=new Image(getClass().getResourceAsStream("pause.jpeg"));
			imag3.setImage(b3);
			imag3.setMouseTransparent(true);
			
            Image b4=new Image(getClass().getResourceAsStream("forward.jpeg"));
			imag4.setImage(b4);
			imag4.setMouseTransparent(true);
			
			Image b5=new Image(getClass().getResourceAsStream("lo.jpeg"));
			im.setImage(b5);
			im.setMouseTransparent(true);
						
			img.setImage(i5);
			
		}
		@FXML
		void ba(ActionEvent event) throws IOException {
			
			pause(event);
			FXMLLoader loader =new FXMLLoader (getClass().getResource("Scene3.fxml"));
			root=loader.load();
			
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show(); 
			
		}
		

		public void changeSpeed(ActionEvent event) {
		    	
		    	if(bs.getValue()==null) {
		    		mediaPlayer.setRate(1);
		    	}else {
		    		mediaPlayer.setRate(Integer.parseInt(bs.getValue())*0.01);
		    	}		
			}
	    }

	

