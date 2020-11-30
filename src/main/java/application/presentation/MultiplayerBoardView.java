package application.presentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.domain.Card;
import application.domain.MultiplayerBoardModel;
import application.domain.PathStrings;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class MultiplayerBoardView {

	public MultiplayerBoardView(MultiplayerBoardModel multiboardModel, Controller controller) {
		this.controller = controller;
		this.multiboardModel = multiboardModel;
	}

	private MultiplayerBoardModel multiboardModel;
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
		for(int i = 0; i<multiboardModel.getHorizontalTiles(); i++) {
			for(int j = 0; j<multiboardModel.getVerticalTiles(); j++) {
				if(object.equals(rectangles[i][j])) {
					return multiboardModel.getField()[i][j];
				}
				
			}
		}
		return null;
	}
	
	public void turnCards() {
		for(int i = 0; i<multiboardModel.getHorizontalTiles(); i++) {
			for(int j = 0; j<multiboardModel.getVerticalTiles(); j++) {
				if(multiboardModel.getField()[i][j].isOpen()) {
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
		int hor = multiboardModel.getHorizontalTiles();
		int ver = multiboardModel.getVerticalTiles();
		cardsFront = new ImagePattern[hor][ver];
		cardsBack = new Color[hor][ver];
		rectangles = new Rectangle[hor][ver];
		double width = multiboardModel.getField()[0][0].getWidht();
		double height = multiboardModel.getField()[0][0].getHeight();
		for(int i = 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				Card card = multiboardModel.getField()[i][j];
				rectangles[i][j] = new Rectangle(i*width, j*height, width, height);
				rectangles[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
		int tiles = hor*ver;
		int[][] posIndex = multiboardModel.getPositonsOfIndex();
		
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
			multiboardModel.getField()[x][y].setPairId(posIndex[1][i]);
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

