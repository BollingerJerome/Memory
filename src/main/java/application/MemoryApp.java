package application;

import application.domain.Board;
import application.domain.BoardModel;
import application.domain.Boardprops;
import application.domain.DomainController;
import application.domain.PlayModel;
import application.presentation.BoardSizeView;
import application.presentation.BoardView;
import application.presentation.Controller;
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
	private BoardSizeView boardSizeView;
	private Controller controller;
	private DomainController domainController;
	private PlayModel playModel;
	Stage primaryStage;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		props = new Boardprops(600,600);
		boardModel = new BoardModel(6, 6, props);
		playModel = new PlayModel(boardModel);
		domainController = new DomainController(boardModel, playModel);
		controller = new Controller(domainController);
		boardSizeView = new BoardSizeView(300,300, Color.WHITE, controller, boardView, boardModel);
		home = new Home(300,300, Color.WHITE, boardSizeView);
		boardModel.addPropertyChangeListener(e -> addCardListener());
				
		
		try {
			
			primaryStage.setScene(home.getScene());
			primaryStage.setTitle("Welcome to Memory!");
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void addCardListener() {
		for(int i = 0; i<boardModel.getHorizontalTiles(); i++) {
			for(int j = 0; j<boardModel.getVerticalTiles(); j++) {
				System.out.println("cards get property");
				boardModel.getField()[i][j].addPropertyChangeListener(e -> System.out.println("nothing"));
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
