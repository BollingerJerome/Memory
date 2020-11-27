package application;

import application.domain.Board;
import application.domain.BoardModel;
import application.domain.Boardprops;
import application.presentation.BoardView;
import application.presentation.Home;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MemoryApp extends Application{
	
	private BoardModel boardModel;
	private BoardView boardView;
	private Boardprops props;
	private Home home;
	
	@Override
	public void start(Stage primaryStage) {
		props = new Boardprops(600,600);
		boardModel = new BoardModel(8, 8, props);
		boardView = new BoardView(boardModel);
		Group group = boardView.setupCards();
		home = new Home(300,300, Color.WHITE);
		
		try {
			
			Scene scene = new Scene(group);

			primaryStage.setScene(home.getScene());
			primaryStage.setTitle("Welcome to Memory!");
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
