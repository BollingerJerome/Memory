package application.presentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import application.domain.BoardModel;
import application.domain.Card;
import application.domain.PathStrings;
import application.domain.StatisticModel;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class BoardView {

	

	public BoardView(Controller controller) {
		this.controller = controller;
		this.borderPane = new BorderPane();
	}

	//private BoardModel boardModel;
	private Rectangle[][] rectangles;		//javafx rectangles acting as cards with eventhandler etc.
	private Controller controller;
	private ImagePattern[][] cardsFront;	//array of the images 
	private Color[][] cardsBack;			//array of the colors 
	Label[] playerPoints;					//labels on the left with the points
	Label[] playernames;					//labels on the left with the playername
	Label time;								//label showing the time
	private BorderPane borderPane;			//layout
	Timeline timeline;						//timer object from javautils
	
	private EventHandler<MouseEvent> getEventHandler (){ 	//adding Eventhandler
		return new EventHandler<MouseEvent>() {				
			@Override
			public void handle(MouseEvent event) {
				controller.turn(isWhichCardObject(event.getSource()));	//turn(Card card) handles the logic
				turnCards();											//updating the field 
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
	
	//drawing cards picture or back (it's the updating methode from above)
	public void turnCards() {
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
	
	
	//whole Board view logic with randomizing etc.
	public Scene setupCards() {
		
		//initializing:
		controller.getTimeModel().reset();
		Group board = new Group();	//javafx things
		EventHandler<MouseEvent> eventHandler = getEventHandler(); //get Eventhandler from above
		this.borderPane = new BorderPane();
		BoardModel boardModel = controller.getBoardModel(); 				//getting boardModel object.
		int numberOfHorizontalTiles = boardModel.getHorizontalTiles();		//BoardModel informations are saved to local 
		int numberOfVerticalTiles = boardModel.getVerticalTiles();			//variables to save cpu. 
		int tiles = numberOfHorizontalTiles*numberOfVerticalTiles;
		int[][] posIndex = boardModel.getPositonsOfIndex();
		double width = boardModel.getField()[0][0].getWidht();
		double height = boardModel.getField()[0][0].getHeight();
		
		String path, which;			//Color and Picture variables
		String[] ofWhich;	//paths leading to profs or Sehenswürdigkeiten
		Color[] backColors = TileColors.getBack();
		cardsFront = new ImagePattern[numberOfHorizontalTiles][numberOfVerticalTiles];
		cardsBack = new Color[numberOfHorizontalTiles][numberOfVerticalTiles];
		rectangles = new Rectangle[numberOfHorizontalTiles][numberOfVerticalTiles];
		FileInputStream fileInputStream;
		
		time = new Label("Time: ");
		
		//create all Rectangle objects
		for(int i = 0; i<numberOfHorizontalTiles; i++) {
			for(int j = 0; j<numberOfVerticalTiles; j++) {
				rectangles[i][j] = new Rectangle(i*width, j*height, width, height);
				rectangles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
		
		//decide which image (Profs or "Sehenswürdigkeiten")
		if((tiles/2) <= PathStrings.getProfsFotos().length) {
			path = "src/main/resources/Fotos Memory/Profs Fotos/";
			ofWhich = PathStrings.getProfsFotos();		//PathStrings class contains all paths of the pictures as static array
		}
		else {
			path = "src/main/resources/Fotos Memory/Sehenswuerdigkeiten Fotos/";
			ofWhich = PathStrings.getSehenswuerdigkeitenFotos();
		}
		
		
		//assigning pictures to cards
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
		
		turnCards(); //drawing of the cards resp. updating the field
		
		//adding Rectangles to the Group view
		for(int i = 0; i<numberOfHorizontalTiles; i++) {
			for(int j = 0; j<numberOfVerticalTiles; j++) {
				board.getChildren().add(rectangles[i][j]);
			}
		}
		//adding back button
		Button backButton= new Button("<< Back");
		backButton.setOnAction(e -> {
			controller.showHome();
			timeline.stop();
		});
		

		//if won, show stats
		controller.getWonModel().addPropertyChangeListener(e ->{
			
			controller.getDomainController().setStatisticModel(new StatisticModel(controller.getDomainController().getPlayModel().getPlayerModel()[0].getName(), //updating the statistic object
					controller.getDomainController().getTimeModel().getCurrentTime(), 
					controller.getDomainController().getPlayModel().getRound()));
			timeline.stop();
			controller.getDomainController().getFileController().makeEntry(boardModel.getHorizontalTiles(), controller.getDomainController().getStatisticModel().write());
			controller.showStats();
		
		});

		
		updatePlayerPoints();
		
		//TODO Pause button should not move when time changes
		Button pause = new Button("pause");
		pause.setOnAction(e -> {
			if(pause.getText().contentEquals("pause")) { //not pretty but the button makes two different things dependant on the button name
				timeline.stop();						//stopping the timer
				pause.setText("continue");				//setting the button text to continue
				lockGame(boardModel, eventHandler);		//calling function to remove eventhandler
			}	
			else {										//when button text is not pause -> when its continue
				timeline.play();						//continue counting
				pause.setText("pause");					//setting button text to pause
				continueGame(boardModel, eventHandler);	//adding eventhandlers again
			}
		});
		
		//initializing the timer
		this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
			//timemodel gets added one every second
			controller.getTimeModel().setCurrentTime(controller.getTimeModel().getCurrentTime() +1);
	        time.setText(controller.getTimeModel().getTimeString()); //updating the label 
	    }));
	    timeline.setCycleCount(Animation.INDEFINITE);
	    timeline.play(); //start timer
	    
	    
		GridPane top = new GridPane(); //layout on top of the Borderpane (I have two labels next to each other)
		top.add(time, 0, 0);
		top.add(pause, 1, 0);
		borderPane.setTop(top);
		borderPane.setCenter(board);
		borderPane.setBottom(backButton);
		
		Button win = new Button("win");
		win.setOnAction(e ->{
			controller.getWonModel().setWon(true);
		});
		borderPane.setRight(win);
		
		//showing the gamefield
		return new Scene(borderPane);
	}
	
	public void lockGame(BoardModel boardModel, EventHandler eventHandler) { 	//It takes eventHandeler away of
		int numberOfHorizontalTiles = boardModel.getHorizontalTiles();			//the board, to lock it in
		int numberOfVerticalTiles = boardModel.getVerticalTiles();				//this state
		for(int i = 0; i<numberOfHorizontalTiles; i++) {
			for(int j = 0; j<numberOfVerticalTiles; j++) {
				rectangles[i][j].removeEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
	}
	
	public void continueGame(BoardModel boardModel, EventHandler eventHandler) {
		int numberOfHorizontalTiles = boardModel.getHorizontalTiles();			//add eventhandlers again
		int numberOfVerticalTiles = boardModel.getVerticalTiles();
		for(int i = 0; i<numberOfHorizontalTiles; i++) {
			for(int j = 0; j<numberOfVerticalTiles; j++) {
				rectangles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
	}
	
	public void updatePlayerPoints() {
		if(controller.getNumberOfPlayers()>1) {
			
			GridPane gridPane = new GridPane();
			int numberOfPlayers = controller.getNumberOfPlayers();
			playerPoints = new Label[numberOfPlayers];
			playernames = new Label[numberOfPlayers];

			for (int i = 0; i<numberOfPlayers; i++) {
				playernames[i] = new Label(controller.getPlayerName(i));
				playerPoints[i] = new Label(Integer.toString(controller.getPlayerPoint(i)));
				gridPane.add(playernames[i], 0, i);
				gridPane.add(playerPoints[i], 1, i);
			}
			borderPane.setLeft(gridPane);
		}
	}

	
	
}
