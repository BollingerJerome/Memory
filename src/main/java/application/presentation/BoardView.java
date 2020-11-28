package application.presentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.domain.BoardModel;
import application.domain.Card;
import application.domain.PathStrings;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class BoardView {


	public BoardView(BoardModel boardModel, Controller controller) {
		this.controller = controller;
		this.boardModel = boardModel;
	}

	private BoardModel boardModel;
	private Rectangle[][] rectangles;
	private Controller controller;
	private ImagePattern[][] cardsFront;
	private Color[][] cardsBack;
	
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
		for(int i = 0; i<boardModel.getHorizontalTiles(); i++) {
			for(int j = 0; j<boardModel.getVerticalTiles(); j++) {
				if(object.equals(rectangles[i][j])) {
					return boardModel.getField()[i][j];
				}
				
			}
		}
		return null;
	}
	
	public void turnCards() {
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
	
	
	public Group setupCards() {
		EventHandler<MouseEvent> eventHandler = getEventHandler();
		Group board = new Group();
		int hor = boardModel.getHorizontalTiles();
		int ver = boardModel.getVerticalTiles();
		cardsFront = new ImagePattern[hor][ver];
		cardsBack = new Color[hor][ver];
		rectangles = new Rectangle[hor][ver];
		double width = boardModel.getField()[0][0].getWidht();
		double height = boardModel.getField()[0][0].getHeight();
		for(int i = 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				Card card = boardModel.getField()[i][j];
				rectangles[i][j] = new Rectangle(i*width, j*height, width, height);
				rectangles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
		int tiles = hor*ver;
		int[][] posIndex = boardModel.getPositonsOfIndex();
		
		String path, which;
		String[] ofWhich;
		Color[] backColors = TileColors.getBack();
		if((tiles/2) <= PathStrings.getProfsFotos().length) {
			path = "src/main/resources/Fotos Memory/Profs Fotos/";
			ofWhich = PathStrings.getProfsFotos();
		}
		else {
			path = "src/main/resources/Fotos Memory/Sehenswuerdigkeiten Fotos/";
			ofWhich = PathStrings.getSehenswuerdigkeitenFotos();
		}
		
		FileInputStream fileInputStream;
		for(int i = 0; i<tiles; i++) {
			
			which = ofWhich[posIndex[1][i]];
			String finalPath = path+which;
			int x = posIndex[0][i]%hor;
			int y = posIndex[0][i]/hor;
			cardsBack[i%hor][i/hor] = backColors[((i%hor)+(i/hor))%2];
			
			try {
				fileInputStream = new FileInputStream(finalPath);
				cardsFront[x][y] = (new ImagePattern(new Image(fileInputStream)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
		turnCards();
		for(int i = 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				board.getChildren().add(rectangles[i][j]);
			}
		}
		return board;
	}
}
