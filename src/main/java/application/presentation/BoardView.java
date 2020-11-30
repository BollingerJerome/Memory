package application.presentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.domain.BoardModel;
import application.domain.Card;
import application.domain.PathStrings;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class BoardView {


	public BoardView(Controller controller) {
		this.controller = controller;
		borderPane = new BorderPane();
	}

	//private BoardModel boardModel;
	private Rectangle[][] rectangles;
	private Controller controller;
	private ImagePattern[][] cardsFront;
	private Color[][] cardsBack;
	Label[] playerPoints;
	Label[] playernames;
	private BorderPane borderPane;
	
	private EventHandler<MouseEvent> getEventHandler (){
		return new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				controller.turn(isWhichCardObject(event.getSource()));
				turnCards();
			}
		};
	};
	
	public Card isWhichCardObject(Object object) {
		BoardModel boardModel = controller.getBoardModel();
		for(int i = 0; i<boardModel.getHorizontalTiles(); i++) {
			for(int j = 0; j<boardModel.getVerticalTiles(); j++) {
				if(object.equals(rectangles[i][j])) {
					return boardModel.getField()[i][j];
				}
				
			}
		}
		return null;
	}
	
	//drawing cards picture or back
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
		
		//initializing
		
		BoardModel boardModel = controller.getBoardModel();
		EventHandler<MouseEvent> eventHandler = getEventHandler();
		Group board = new Group();
		int hor = boardModel.getHorizontalTiles();
		int ver = boardModel.getVerticalTiles();
		int tiles = hor*ver;
		int[][] posIndex = boardModel.getPositonsOfIndex();
		String path, which;
		String[] ofWhich;
		Color[] backColors = TileColors.getBack();
		cardsFront = new ImagePattern[hor][ver];
		cardsBack = new Color[hor][ver];
		rectangles = new Rectangle[hor][ver];
		double width = boardModel.getField()[0][0].getWidht();
		double height = boardModel.getField()[0][0].getHeight();
		FileInputStream fileInputStream;
		
		//create all Rectangle objects
		for(int i = 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				Card card = boardModel.getField()[i][j];
				rectangles[i][j] = new Rectangle(i*width, j*height, width, height);
				rectangles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
		
		//decide which image
		if((tiles/2) <= PathStrings.getProfsFotos().length) {
			path = "src/main/resources/Fotos Memory/Profs Fotos/";
			ofWhich = PathStrings.getProfsFotos();
		}
		else {
			path = "src/main/resources/Fotos Memory/Sehenswuerdigkeiten Fotos/";
			ofWhich = PathStrings.getSehenswuerdigkeitenFotos();
		}
		
		
		//assigning pictures to cards
		for(int i = 0; i<tiles; i++) {
			
			which = ofWhich[posIndex[1][i]];
			String finalPath = path+which;
			int x = posIndex[0][i]%hor;
			int y = posIndex[0][i]/hor;
			cardsBack[i%hor][i/hor] = backColors[((i%hor)+(i/hor))%2];
			boardModel.getField()[x][y].setPairId(posIndex[1][i]);
			
			try {
				fileInputStream = new FileInputStream(finalPath);
				cardsFront[x][y] = (new ImagePattern(new Image(fileInputStream)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
		
		turnCards();
		//adding cards to Group
		for(int i = 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				board.getChildren().add(rectangles[i][j]);
			}
		}
		
		//if multiple players are selcted, a gridpane will be added to the scen which shows the points
		
		updatePlayerPoints();
		borderPane.setCenter(board);
		return new Scene(borderPane);
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
