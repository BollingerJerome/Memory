package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board {
	
	
	//random color constructor
	public Board(double horizontalTiles, double verticalTiles, double width, double heigth, int players, String[] playersString) {
		EventHandler<MouseEvent> eventHandler = getEventHandler();
		this.horizontalTiles = horizontalTiles;
		this.verticalTiles = verticalTiles;
		this.width = width;
		this.heigth = heigth;
		this.rectangleField = new Rectangle[(int) horizontalTiles][(int) verticalTiles];
		this.front = new boolean[(int) horizontalTiles][(int) verticalTiles];
		this.fotos = new int[(int) horizontalTiles][(int) verticalTiles];
		this.images = randomizeImage();
		this.backColors = backOfCards();
		this.lastFlippedX = new int[2];
		this.lastFlippedY = new int[2];
		this.flip = 0;
		this.players = players;
		this.playerPoints = new int[players];
		this.PlayerNames = playersString;
		double rectWidth = width/horizontalTiles;
		double rectHeigth = heigth/verticalTiles;
		for (int i = 0; i< horizontalTiles; i++) {
			for (int j = 0; j<verticalTiles; j++) {
				this.front[i][j] = false;
				rectangleField[i][j] = new Rectangle(i*rectWidth, j*rectHeigth, rectWidth, rectHeigth);
				rectangleField[i][j].setFill(backColors[i][j]); //why isn't there a constructor for five variables?
				rectangleField[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
	}
	


	private Image[][] images;
	private double horizontalTiles, verticalTiles, width, heigth; //how many tiles and info of canvas
	private Rectangle rectangleField[][];	//array of all rectangle objects
	private boolean[][] front;				// card is turned up or down maybe I could put this info in rectangle object
	private Color[][] backColors;			//Color of cards back
	private int[] lastFlippedX;				//array of the two last position on x
	private int[] lastFlippedY; 			//array of the two last position on y
	private int flip;						//stages of a turn
	private int turn;
	private String[] PlayerNames;
	private int players;
	private int[] playerPoints;
	private int[][] fotos;
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this );
	
	public void addPropertyChangeListener( PropertyChangeListener listener ) {
        changes.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener( PropertyChangeListener listener ) {
        changes.removePropertyChangeListener( listener );
    }
	
	// turns the card if front table is true and turns them back if front is false
	public void turnCards () {
		for (int i = 0; i< horizontalTiles; i++) {
			for (int j = 0; j<verticalTiles; j++) {
				if(front[i][j]) {
					rectangleField[i][j].setFill(new ImagePattern(images[i][j]));
				}
				else {
					rectangleField[i][j].setFill(backColors[i][j]);
				}
			}
		}
	}

	//assigns the colors of the back of the colors
	public Color[][] backOfCards (){
		Color[][] back = new Color[(int) horizontalTiles][(int) verticalTiles];
		for (int i = 0; i < horizontalTiles; i++) {
			for (int j = 0; j < verticalTiles; j++) {
				if((j+i)%2 == 1) {
					back[i][j] = TileColors.getBack()[1];
				}
				else {
					back[i][j] = TileColors.getBack()[0];
				}
			}
		}

		return back;
	}

	

	
	public Image[][] randomizeImage () {

		/*creates the card fronts in a random fashion
		 *each tile gets a random float. then they get sorted and assigned the indexes
		 *
		 * tiles[color(in TileColorsArray][random] = {1,	2,	 	3,	 	4, 		5,		 6,		 7,		 8, 	9, 		10...}
		 * 							 {0.41, 0.25, 0.9999, 0.1111, 0.7523, 0.6541, 0.251,   0.548,  0.335    0.875...}
		 * 
		 * sorted:					{	4,		2,  	7,		9,		1,	  8,	6,  	  5,     10,    3...	}
		 * 							{0.1111,  0.25,   0.251,  0.335, 0.41, 0.548, 0.6541, 0.7523,  0.875, 0.9999...	}
		 * 
		 * 	numbered:			{4, 2, 7, 9, 1, 8, 6, 5, 10, 3...	}
		 * 						{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,...}
		 * 
		 * index:		[random] x=random/GameFieldWidth | y = random%GameFieldWidth
		 * 				
		 * 
		 */
		
		
		int tiles = (int) horizontalTiles * (int) verticalTiles;
		Image[][] randomColors = new Image[(int) horizontalTiles][(int) verticalTiles];
		double[][] tile = new double[2][tiles];
		//each tile gets two random floats
		for (int i = 0; i < tiles; i++) {
			tile[0][i] = i; 
			tile[1][i] = Math.random()*10*Math.random();
		}
		//Bubble sort
		for (int i = 0; i < tiles; i++) {
			for(int j = 0; j < tiles-1; j++) {
				if(tile[1][j] > tile[1][j+1]) {
					double helperZero = tile[0][j+1];
					double helperOne = tile[1][j+1];
					tile[0][j+1] = tile[0][j];
					tile[1][j+1] = tile[1][j];
					tile[0][j] = helperZero;
					tile[1][j] = helperOne;
				}
			}
		}
		//nummerieren
		for(int j = 0; j < tiles; j++) {
			tile[1][j] = j;
		}
		for (int i = 0; i < tiles; i++) {
			int hor = (int) (i%horizontalTiles);
			int ver = (int) (i/horizontalTiles);
			int col = (int) tile[0][i];
			
			if(col%2 == 1) {
				col--;
			}
			col /= 2;
			String path; 
			String which;
			//if((tiles/2) <= PathStrings.getProfsFotos().length) {
		//		path = "src\\main\\resources\\Fotos Memory\\Profs Fotos\\";
		//		which = PathStrings.getProfsFotos()[col];
		//	}
		//	else {
				path = "src\\main\\resources\\Fotos Memory\\Sehenswuerdigkeiten Fotos\\";
				which = PathStrings.getSehenswuerdigkeitenFotos()[col];
		//	}
			path += which;
			FileInputStream fileInputStream;
	
			try {
				fotos[hor][ver] = col; 
				fileInputStream = new FileInputStream(path);
				randomColors[hor][ver] = new Image(fileInputStream);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			 
		}

		return randomColors;	
	}
	
	public void turnCardsBack(Object source, EventHandler<MouseEvent> eventHandler) {
		if (source instanceof Rectangle) {
			
			//checks the position of the pressed rectangle
			Rectangle rectangle = (Rectangle) source;
			for (int i = 0; i< horizontalTiles; i++) {
				for (int j = 0; j<verticalTiles; j++) {

					if(rectangleField[i][j].equals(rectangle)) {
						//there are four stages of a turn:
						//0: all cards are turned upsidedown -> first card is opened
						//1: first card is opened -> second card ist opend
						//2: first and second card is open -> check if they are the same 
									//if yes cards stay open and turn to 0 
									//if not goto 3
						//3: cards will be flipped back
						
						switch (flip) {
						case 0: //open the first card
							if(!front[i][j]) {
								front[i][j] = true;
								rectangleField[i][j].removeEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
								flip++;
								lastFlippedX[0] = i;
								lastFlippedY[0] = j;
								turnCards();
							}
							break;
						case 1:
							if(!front[i][j]) {
								front[i][j] = true;
								flip++;
								lastFlippedX[1] = i;
								lastFlippedY[1] = j;
								rectangleField[lastFlippedX[0]][lastFlippedY[0]].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
								equalImage(lastFlippedX[0], lastFlippedY[0], lastFlippedX[1], lastFlippedY[1]);
								turnCards();
								won();
							}
							break;

						case 2:
							front[lastFlippedX[0]][lastFlippedY[0]] = false;
							front[lastFlippedX[1]][lastFlippedY[1]] = false;
							flip = 0;
							turnCards();
							turn++;
							break;
						}
						return;
					}
				}	
			}	
		}
	}
	
	
	//Eventhandler
	private EventHandler<MouseEvent> getEventHandler (){
		return new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				turnCardsBack(event.getSource(), this);
			}
		};
	};
	
	//checking if the colors are matching
	
	public boolean equalColors(int cx, int cy, int lx, int ly) {
		if(lastFlippedX[0] >= 0) {
			
			if(fotos[cx][cy] == fotos[lx][ly] && !((cx == lx) && (cy == ly))) {
				int[] point = playerPoints;
				point[turn%players] = playerPoints[turn%players]+1;
				setPlayerPoints(point);
			
				
				turn++;
				flip = 0;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean equalImage(int cx, int cy, int lx, int ly) {
		if(lastFlippedX[0] >= 0) {
			if(fotos[cx][cy] == fotos[lx][ly] && !((cx == lx) && (cy == ly))) {
				
				int[] etwas = playerPoints;
				etwas[turn%players] = playerPoints[turn%players]+1;
				setPlayerPoints(etwas); //add point to player
				
				flip = 0;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			turn++;
			return false;
		}
	}
	
	//checks if the whole board is opened
	public boolean won() {
		for (int i = 0; i< horizontalTiles; i++) {
			for (int j = 0; j<verticalTiles; j++) {
				if(front[i][j]) {
					
				}
				else{
					return false;
				}
			}
		}
		Main.createEnd();
		return true;
	}



	public double getHorizontalTiles() {
		return horizontalTiles;
	}
	public void setHorizontalTiles(double horizontalTiles) {
		this.horizontalTiles = horizontalTiles;
	}
	public double getVerticalTiles() {
		return verticalTiles;
	}
	public void setVerticalTiles(double verticalTiles) {
		this.verticalTiles = verticalTiles;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeigth() {
		return heigth;
	}
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
	public Rectangle[][] getRectangleField() {
		return rectangleField;
	}
	public void setRectangleField(Rectangle[][] rectangleField) {
		this.rectangleField = rectangleField;
	}
	public boolean[][] getFront() {
		return front;
	}
	public void setFront(boolean[][] front) {
		this.front = front;
	}
	public Color[][] getBackColors() {
		return backColors;
	}
	public void setBackColors(Color[][] backColors) {
		this.backColors = backColors;
	}
	public int getFlip() {
		return flip;
	}
	public void setFlip(int flip) {
		this.flip = flip;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String[] getPlayerNames() {
		return PlayerNames;
	}
	public void setPlayerNames(String[] playerNames) {
		PlayerNames = playerNames;	
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}
	public int[] getPlayerPoints() {
		return playerPoints;
	}
	public void setPlayerPoints(int[] playerPoints) {
		int[] oldpoints = this.playerPoints;
		this.playerPoints = playerPoints;
		System.out.println("setPlayerPoints method executed");
		changes.firePropertyChange( "playerPoints", oldpoints, playerPoints );
	}



}