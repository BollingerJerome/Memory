package application;

import application.domain.BoardModel;	//importing all classes
import application.domain.DomainController;
import application.domain.PlayModel;
import application.domain.TimeModel;
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
	
		//having objects of almost every class is necessary
	private BoardModel boardModel;
	private BoardView boardView;
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
	private TimeModel timeModel;

	
	@Override	//starts when program is started
	public void start(Stage primaryStage) {
		
		//adding the services controller 
		fileController = new FileController();

		//initializing all models and the domainController
		wonModel = new WonModel();
		boardModel = new BoardModel(600,600);
		playModel = new PlayModel();
		timeModel = new TimeModel();
		domainController = new DomainController(boardModel, playModel, wonModel, timeModel, fileController);
		playModel.setDomainController(domainController);

		
	
		

		//assigning all Views and the controller
		//every view needs an controller object
		controller = new Controller(primaryStage, domainController, boardSizeView, multiplayerPlayersView, boardView, inputPlayerNamesView, statsView, home);
		boardSizeView = new BoardSizeView(300,300, Color.CORNFLOWERBLUE, controller);
		boardView = new BoardView(controller);
		home = new Home(300, 300, Color.CORNFLOWERBLUE, controller);
		multiplayerPlayersView = new MultiplayerPlayersView(300,300, Color.CORNFLOWERBLUE, controller);
		inputPlayerNamesView = new InputPlayerNamesView(300,300, Color.CORNFLOWERBLUE, controller);
		statsView = new StatsView(300,300, Color.CORNFLOWERBLUE, controller);
		
		//but every controller needs also the view objects for proper information exchange
		controller.setHome(home);
		controller.setBoardSizeView(boardSizeView);
		controller.setBoardView(boardView);
		controller.setMultiplayerPlayersView(multiplayerPlayersView);
		controller.setInputPlayerNamesView(inputPlayerNamesView);
		controller.setStatsView(statsView);
		
		try {
			//what is shown at the programm start
			//from here on the rest views are controlled by the controller
			primaryStage.setScene(home.getScene());
			primaryStage.setTitle("MEMORY");
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//main method
	public static void main(String[] args) {
		launch(args);
	}

}
