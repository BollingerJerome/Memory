package application;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {
	
	private EventHandler<MouseEvent> getEventHandler (){
		return new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				if (event.getSource() instanceof Rectangle) {
					Rectangle rectangle = (Rectangle) event.getSource();
					for (int i = 0; i< horizontalTiles; i++) {
						for (int j = 0; j<verticalTiles; j++) {
							if(rectangleField[i][j].equals(rectangle) && !front[i][j]) {
								front[i][j] = true;
								turnCards();
							}
							else {
								if(rectangleField[i][j].equals(rectangle)) {
									front[i][j] = false;
									turnCards();
									
								}
							}
						}
					}	
				}
			}
		};
	};
	
	public void turn() {
		
	}
	

	public Board(Color[][] colors, double horizontalTiles, double verticalTiles, double width, double heigth) {
		EventHandler<MouseEvent> eventHandler = getEventHandler();
		this.frontColors = colors;
		this.horizontalTiles = horizontalTiles;
		this.verticalTiles = verticalTiles;
		this.width = width;
		this.heigth = heigth;
		this.rectangleField = new Rectangle[(int) horizontalTiles][(int) verticalTiles];
		
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
	
	
	private Color[][] frontColors;
	private double horizontalTiles, verticalTiles, width, heigth;
	private Rectangle rectangleField[][];	
	private boolean[][] front;
	private Color[][] backColors;
	
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
	
}
