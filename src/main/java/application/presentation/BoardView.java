package application.presentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import application.domain.BoardModel;
import application.domain.Card;
import application.domain.PathStrings;
import application.domain.StatisticModel;
import application.domain.WonModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class BoardView extends WindowProps{

	public BoardView(Controller controller, double width, double height, Color backgroundColor) {
		super(width, height, backgroundColor);
		this.controller = controller;
		this.borderPane = new BorderPane();
		this.eventHandler = getEventHandler();
		this.time = new Label("Time: ");
		time.setMinWidth(150);
	}

	//private BoardModel boardModel;
	private Rectangle[][] rectangles;					//javafx rectangles acting as cards with eventhandler etc.
	private Controller controller;
	private ImagePattern[][] cardsFront;				//array of the images 
	private Color[][] cardsBack;					//array of the colors 
	private Label[] playerPoints;					//labels on the left with the points
	private Label[] playernames;					//labels on the left with the playername
	private Label time;								//label showing the time
	private BorderPane borderPane;					//layout
	private Timeline timeline;						//timer object from javautils
	private EventHandler<MouseEvent> eventHandler;


	
	//whole Board view logic with randomizing etc. this is the "boardview controller"
		public Scene setupCards() {

			//resetting the second counter and the rounds
			controller.getTimeModel().reset();
			controller.getDomainController().getPlayModel().reset();

			//initializing:
			Group board = new Group();	//javafx things

			this.borderPane = new BorderPane();
			BoardModel boardModel = controller.getBoardModel(); 				//getting boardModel object.
			int numberOfHorizontalTiles = boardModel.getHorizontalTiles();		//BoardModel informations are saved to local 
			int numberOfVerticalTiles = boardModel.getVerticalTiles();			//variables to save cpu. 
			cardsFront = new ImagePattern[numberOfHorizontalTiles][numberOfVerticalTiles];
			cardsBack = new Color[numberOfHorizontalTiles][numberOfVerticalTiles];
			rectangles = new Rectangle[numberOfHorizontalTiles][numberOfVerticalTiles];
			
			fillRectangles(); 	//filling the private rectangles with Rectangle object
			setCardsImage();	//filling the private CardsFront and CardsBack array
			drawCards(); 		//drawing of the cards or updating the field

			//adding Rectangles to the Group view
			for(int i = 0; i<numberOfHorizontalTiles; i++) {
				for(int j = 0; j<numberOfVerticalTiles; j++) {
					board.getChildren().add(rectangles[i][j]);
				}
			}
			
			controller.getDomainController().setWonModel(new WonModel());
			controller.getWonModel().addPropertyChangeListener(e ->{
				timeline.stop();			//stop the timer
				createEntry();				//write score when singleplayer
				controller.showStats();		//switch to next window
			});
		
			Button backButton= new Button("Back");
			backButton.setOnAction(e -> {
				controller.showHome();
				timeline.stop();
			});
			
			startTimer();
			updatePlayerPoints();
			addTopBar();
			borderPane.setCenter(board);
			borderPane.setBottom(backButton);

			//showing the gamefield
			return getDefaultScene(borderPane);
		}

		
		
	private EventHandler<MouseEvent> getEventHandler (){ 	//adding Eventhandler
		return new EventHandler<MouseEvent>() {				
			@Override
			public void handle(MouseEvent event) {
				controller.turn(isWhichCardObject(event.getSource()));	//turn(Card card) handles the logic in domainController
				drawCards();											//updating the field 
			}
		};
	};
	
	

	public Card isWhichCardObject(Object object) {				//helper for the eventHandler. he returns the
		BoardModel boardModel = controller.getBoardModel();		//card Object so the turn(Card card) method can
		for(int i = 0; i<boardModel.getHorizontalTiles(); i++) {//work.
			for(int j = 0; j<boardModel.getVerticalTiles(); j++) {
				if(object.equals(rectangles[i][j])) {			//javafx rectangles are not the cardmodel object but they are linked with coordinates
					return boardModel.getField()[i][j];   		//when the clicked rectangles has coordinate (3|4) search the card object with the same coordinates
				}
			}
		}
		return null;
	}

	

	public void fillRectangles() {
		int hortiles = controller.getBoardModel().getHorizontalTiles();
		int vertiles = controller.getBoardModel().getVerticalTiles();
		int cardWidth = (int) controller.getBoardModel().getField()[0][0].getWidht();
		int cardHeigth = (int) controller.getBoardModel().getField()[0][0].getHeight();
		//create all Rectangle objects
		for(int i = 0; i < hortiles; i++) {
			for(int j = 0; j<vertiles; j++) {
				rectangles[i][j] = new Rectangle(i*cardWidth, j*cardHeigth, cardWidth, cardHeigth);
				rectangles[i][j].setArcHeight(cardHeigth/2);
				rectangles[i][j].setArcWidth(cardWidth/2);
				rectangles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
	}
	
	
	
	//this method does not draw anything. this method assigns just the pictures and color to the cardback and front variables
	public void setCardsImage() {
		//initializing variables
		BoardModel boardModel = controller.getBoardModel();
		int numberOfHorizontalTiles = boardModel.getHorizontalTiles();		//BoardModel informations are saved to local 
		int numberOfVerticalTiles = boardModel.getVerticalTiles();			//variables to save cpu. 
		int tiles = numberOfHorizontalTiles*numberOfVerticalTiles;
		String path, which;													//Color and Picture variables
		String[] ofWhich;													//paths leading to profs or Sehenswürdigkeiten
		Color[] backColors = TileColors.getBack();
		int[][] posIndex = boardModel.getPositonsOfIndex();
		FileInputStream fileInputStream;
		
		//decide which image (Profs or "Sehenswürdigkeiten")
		if((tiles/2) <= PathStrings.getProfsFotos().length) {
			path = "src/main/resources/Fotos Memory/Profs Fotos/";
			ofWhich = PathStrings.getProfsFotos();		//PathStrings class contains all paths of the pictures as static array
		}
		else {
			path = "src/main/resources/Fotos Memory/Sehenswuerdigkeiten Fotos/";
			ofWhich = PathStrings.getSehenswuerdigkeitenFotos();
		}
		//assigning pictures to cardsBack and cardsFront variables of this class
		for(int i = 0; i<tiles; i++) {

			which = ofWhich[posIndex[1][i]];
			String finalPath = path+which;
			int x = posIndex[0][i]%numberOfHorizontalTiles; // "%" and "/" operations gives me coordinates in a field from an int. 7 in a 3x3 field would be x = 1 and y = 2.
			int y = posIndex[0][i]/numberOfHorizontalTiles;
			cardsBack[i%numberOfHorizontalTiles][i/numberOfHorizontalTiles] = backColors[((i%numberOfHorizontalTiles)+(i/numberOfHorizontalTiles))%2];
			boardModel.getField()[x][y].setPairId(posIndex[1][i]); //same cards have same int value

			try {	//getting pictures from path and assigning them
				fileInputStream = new FileInputStream(finalPath);
				cardsFront[x][y] = (new ImagePattern(new Image(fileInputStream)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
	}

	
	
	//drawing cards picture or back (it's the updating methode from above)
	public void drawCards() {
		BoardModel boardModel = controller.getBoardModel();
		for(int i = 0; i<boardModel.getHorizontalTiles(); i++) {
			for(int j = 0; j<boardModel.getVerticalTiles(); j++) {
				if(boardModel.getField()[i][j].isOpen()) {
					rectangles[i][j].setFill(cardsFront[i][j]);
				}
				else {
					rectangles[i][j].setFill(cardsBack[i][j]);
				}
			}
		}
	}

	

	//game timer method which starts the timer and adds one second to the timemodel and updates the string each second
	public void startTimer() {
		this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
			//timemodel gets added one every second
			controller.getTimeModel().setCurrentTime(controller.getTimeModel().getCurrentTime() +1);
			time.setText(controller.getTimeModel().getTimeString()); //updating the label 
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play(); //start timer
	}
	
	//button method which decides whether game should be paused or continued based on which state the timemodel has
	public Button pauseContinue(Button pauseButton) {
		if(!controller.getDomainController().getTimeModel().isPause()) { //TimeModel has boolean for pause
			timeline.stop();						//stopping the timer
			pauseButton.setText("continue");				//setting the button text to continue
			lockGame(controller.getBoardModel(), eventHandler);		//calling function to remove eventhandler
			controller.getDomainController().getTimeModel().setPause(true);
		}	
		
		else {										//when button text is not pause -> when its continue
			timeline.play();						//continue counting
			pauseButton.setText("pause");					//setting button text to pause
			continueGame(controller.getBoardModel(), eventHandler);	//adding eventhandlers again
			controller.getDomainController().getTimeModel().setPause(false);
		}
		return pauseButton;
	}
	
	
	
	//Sub-button method when continuing
	public void lockGame(BoardModel boardModel, EventHandler eventHandler) { 	//It takes eventHandeler away of
		int numberOfHorizontalTiles = boardModel.getHorizontalTiles();			//the board, to lock it in
		int numberOfVerticalTiles = boardModel.getVerticalTiles();				//this state
		for(int i = 0; i<numberOfHorizontalTiles; i++) {
			for(int j = 0; j<numberOfVerticalTiles; j++) {
				rectangles[i][j].removeEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
	}
	
	
	
	//Sub-Button method when pausing
	public void continueGame(BoardModel boardModel, EventHandler eventHandler) {
		int numberOfHorizontalTiles = boardModel.getHorizontalTiles();			//add eventhandlers again
		int numberOfVerticalTiles = boardModel.getVerticalTiles();
		for(int i = 0; i<numberOfHorizontalTiles; i++) {
			for(int j = 0; j<numberOfVerticalTiles; j++) {
				rectangles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
	}
	
	

	//button method when winning
	public void createEntry() {
		if(controller.getNumberOfPlayers() == 1) {
			controller.getDomainController().setStatisticModel(
					new StatisticModel(controller.getDomainController().getPlayModel().getPlayerModel()[0].getName(), //updating the statistic object
							controller.getDomainController().getTimeModel().getCurrentTime(), 
							controller.getDomainController().getPlayModel().getRound()));
			//creating the entry
			controller.getDomainController().getFileController().makeEntry(
					controller.getBoardModel().getHorizontalTiles(), controller.getDomainController().getStatisticModel().write());
		}
	}

	
	
	//adding borderpanes element methods
	
	//top borderpane labels
	public void addTopBar() {
		//top of the window
		HBox top = new HBox(); //layout in the top field of this Borderpane 
		
		Button pause = new Button("pause");
		pause.setOnAction(e -> {
			pauseContinue(pause);
		});
		
		Label round = new Label("round: ");
		round.setMinWidth(150);
		controller.getDomainController().getPlayModel().addPropertyChangeListener(e -> {
			round.setText("round: " + controller.getDomainController().getPlayModel().getRound());
		});
		
		top.getChildren().add(pause);
		top.getChildren().add(round);
		top.getChildren().add(time);
		top.setSpacing(10);
		borderPane.setTop(top);
	}
	
	
	//left borderpane labels
	public void updatePlayerPoints() {
		if(controller.getNumberOfPlayers()>1) {

			GridPane gridPane = new GridPane();
			int numberOfPlayers = controller.getNumberOfPlayers();
			playerPoints = new Label[numberOfPlayers];
			playernames = new Label[numberOfPlayers];

			for (int i = 0; i<numberOfPlayers; i++) {
				playernames[i] = new Label(controller.getPlayerName(i)+": ");
				playerPoints[i] = new Label(Integer.toString(controller.getPlayerPoint(i)));
				gridPane.add(playernames[i], 0, i);
				gridPane.add(playerPoints[i], 1, i);
			}
			borderPane.setLeft(gridPane);
		}
	}

}
