package application;

import application.domain.BoardModel;
import application.domain.Boardprops;
import application.domain.DomainController;
import application.domain.PlayModel;
import application.domain.WonModel;
import application.presentation.BoardSizeView;
import application.presentation.BoardView;
import application.presentation.Controller;
import application.presentation.Home;
import application.presentation.InputPlayerNamesView;
import application.presentation.MultiplayerPlayersView;
import application.presentation.StatsView;
import application.services.FileController;
import javafx.application.Application;
import javafx.scene.paint.Color;
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
	private MultiplayerPlayersView multiplayerPlayersView;
	private InputPlayerNamesView inputPlayerNamesView;
	private StatsView statsView;
	private WonModel wonModel;
	private FileController fileController;
	
	@Override
	public void start(Stage primaryStage) {
		
		fileController = new FileController();
		
		wonModel = new WonModel();
		props = new Boardprops(600,600);
		boardModel = new BoardModel(props);
		playModel = new PlayModel(boardModel, wonModel);
		domainController = new DomainController(boardModel, playModel, wonModel, fileController);
	
		
		controller = new Controller(primaryStage, domainController, boardSizeView, multiplayerPlayersView, boardView, inputPlayerNamesView, statsView, home);
		boardSizeView = new BoardSizeView(300,300, Color.CORNFLOWERBLUE, controller);
		boardView = new BoardView(controller);
		home = new Home(300, 300, Color.CORNFLOWERBLUE, controller);
		multiplayerPlayersView = new MultiplayerPlayersView(300,300, Color.CORNFLOWERBLUE, controller);
		inputPlayerNamesView = new InputPlayerNamesView(300,300, Color.CORNFLOWERBLUE, controller);
		statsView = new StatsView(300,300, Color.CORNFLOWERBLUE, controller);
		
		controller.setHome(home);
		controller.setBoardSizeView(boardSizeView);
		controller.setBoardView(boardView);
		controller.setMultiplayerPlayersView(multiplayerPlayersView);
		controller.setInputPlayerNamesView(inputPlayerNamesView);
		controller.setStatsView(statsView);
		
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
