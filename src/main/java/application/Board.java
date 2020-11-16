package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {
	
	
	/*	//basic test constructor
	public Board(Color[][] colors, double horizontalTiles, double verticalTiles, double width, double heigth) {
		EventHandler<MouseEvent> eventHandler = getEventHandler();
		this.frontColors = colors;
		this.horizontalTiles = horizontalTiles;
		this.verticalTiles = verticalTiles;
		this.width = width;
		this.heigth = heigth;
		this.rectangleField = new Rectangle[(int) horizontalTiles][(int) verticalTiles];
		this.lastFlippedX = new int[2];
		this.lastFlippedY = new int[2];
		this.flip = 0;
		double rectWidth = width/horizontalTiles;
		double rectHeigth = heigth/verticalTiles;
		for (int i = 0; i< horizontalTiles; i++) {
			for (int j = 0; j<verticalTiles; j++) {
				rectangleField[i][j] = new Rectangle(i*rectWidth, j*rectHeigth, rectWidth, rectHeigth);
				rectangleField[i][j].setFill(colors[i][j]); //why isn't there a constructor for five variables?
				rectangleField[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
			}
		}
	}
	*/

	
	
	//random color constructor
	public Board(double horizontalTiles, double verticalTiles, double width, double heigth) {
		EventHandler<MouseEvent> eventHandler = getEventHandler();
		this.horizontalTiles = horizontalTiles;
		this.verticalTiles = verticalTiles;
		this.width = width;
		this.heigth = heigth;
		this.rectangleField = new Rectangle[(int) horizontalTiles][(int) verticalTiles];
		this.front = new boolean[(int) horizontalTiles][(int) verticalTiles];
		this.frontColors = randomize();
		this.backColors = backOfCards();
		this.lastFlippedX = new int[2];
		this.lastFlippedY = new int[2];
		this.flip = 0;
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


	private Color[][] frontColors;	//Color of cards front at position x,y
	private double horizontalTiles, verticalTiles, width, heigth; //how many tiles and info of canvas
	private Rectangle rectangleField[][];	//array of all rectangle objects
	private boolean[][] front;				// card is turned up or down maybe I could put this info in rectangle object
	private Color[][] backColors;			//Color of cards back
	private int[] lastFlippedX;				//array of the two last position on x
	private int[] lastFlippedY; 			//array of the two last position on y
	private int flip;						//stages of a turn
	
	
	// turns the card if front table is true and turns them back if front is false
	public void turnCards () {
		for (int i = 0; i< horizontalTiles; i++) {
			for (int j = 0; j<verticalTiles; j++) {
				if(front[i][j]) {
					rectangleField[i][j].setFill(frontColors[i][j]);
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

	
	public Color[][] randomize () {

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
		Color[][] randomColors = new Color[(int) horizontalTiles][(int) verticalTiles];
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
			int hor = (int) ((int) tile[1][i]%horizontalTiles);
			int ver = (int) ((int) tile[1][i]/horizontalTiles);
			int col = (int) tile[0][i];
			Color which = TileColors.getColortiles()[col];
			randomColors[hor][ver] = which; 
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
						System.out.println("rectangleMouse event");
						
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
								equalColors(lastFlippedX[0], lastFlippedY[0], lastFlippedX[1], lastFlippedY[1], eventHandler);
								turnCards();
								won();
							}
							break;

						case 2:
							front[lastFlippedX[0]][lastFlippedY[0]] = false;
							front[lastFlippedX[1]][lastFlippedY[1]] = false;
							flip = 0;
							turnCards();
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
	public boolean equalColors(int cx, int cy, int lx, int ly, EventHandler<MouseEvent> eventHandler) {
		if(lastFlippedX[0] >= 0) {
			if(frontColors[cx][cy] == frontColors[lx][ly] && !((cx == lx) && (cy == ly))) {

				System.out.println("Pair found!");
				flip = 0;
				//rectangleField[cx][cy].removeEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
				//rectangleField[lx][ly].removeEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
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
		System.out.println("SOMEONE WON!!!");
		System.exit(0);
		return true;
	}


	public Color[][] getColors() {
		return frontColors;
	}
	public void setColors(Color[][] colors) {
		this.frontColors = colors;
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

	public Color[][] getFrontColors() {
		return frontColors;
	}

	public void setFrontColors(Color[][] frontColors) {
		this.frontColors = frontColors;
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



}