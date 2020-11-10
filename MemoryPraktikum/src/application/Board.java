package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {
	
	
	

	public Board(Color[][] colors, double horizontalTiles, double verticalTiles, double width, double heigth) {
		super();
		this.colors = colors;
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
			}
		}
	}
	
	//random color constructor
	public Board(double horizontalTiles, double verticalTiles, double width, double heigth) {
		this.horizontalTiles = horizontalTiles;
		this.verticalTiles = verticalTiles;
		this.width = width;
		this.heigth = heigth;
		this.rectangleField = new Rectangle[(int) horizontalTiles][(int) verticalTiles];
		this.colors = randomize();
		double rectWidth = width/horizontalTiles;
		double rectHeigth = heigth/verticalTiles;
		for (int i = 0; i< horizontalTiles; i++) {
			for (int j = 0; j<verticalTiles; j++) {
				rectangleField[i][j] = new Rectangle(i*rectWidth, j*rectHeigth, rectWidth, rectHeigth);
				rectangleField[i][j].setFill(colors[i][j]); //why isn't there a constructor for five variables?
			}
		}
	}
	
	
	private Color[][] colors;
	private double horizontalTiles, verticalTiles, width, heigth;
	private Rectangle rectangleField[][];	
	
	public Color[][] randomize () {
		int tiles = (int) horizontalTiles * (int) verticalTiles;
		
		Color[][] randomColors = new Color[(int) horizontalTiles][(int) verticalTiles];
		double[][] tile = new double[3][tiles];
		
		
		//each tile gets two random floats
		for (int i = 0; i < tiles; i++) {
			tile[0][i] = i; 
			tile[1][i] = Math.random();
			tile[2][i] = Math.random();
		}
		
		//Bubble sort
		for (int i = 0; i < tiles; i++) {
			for(int j = 0; j < tiles-1; j++) {
				if(tile[1][j] > tile[1][j+1]) {
					
					double helperZero = tile[0][j+1];
					double helperOne = tile[1][j+1];
					double helperTwo = tile[2][j+1];
					tile[0][j+1] = tile[0][j];
					tile[1][j+1] = tile[1][j];
					tile[2][j+1] = tile[2][j];
					tile[0][j] = helperZero;
					tile[1][j] = helperOne;
					tile[2][j] = helperTwo;
				}
			}
		}
		
		//nummerieren
		for(int j = 0; j < tiles; j++) {
			tile[1][j] = j%horizontalTiles;
		}
		
		//sortieren zweiten Reihe
		for (int i = 0; i < tiles; i++) {
			for(int j = 0; j < tiles-1; j++) {
				
				if(tile[2][j] > tile[2][j+1]) {
					
					double helperZero = tile[0][j+1];
					double helperOne = tile[1][j+1];
					double helperTwo = tile[2][j+1];
					tile[0][j+1] = tile[0][j];
					tile[1][j+1] = tile[1][j];
					tile[2][j+1] = tile[2][j];
					tile[0][j] = helperZero;
					tile[1][j] = helperOne;
					tile[2][j] = helperTwo;
				}
			}
		}
		//nummerieren
		for(int j = 0; j < tiles; j++) {
			tile[2][j] = j/horizontalTiles;
		}
		
		for (int i = 0; i < tiles; i++) {
			int hor = (int) tile[1][i];
			int ver = (int) tile[2][i];
			int col = (int) tile[0][i];
			Color which = TileColors.getColortiles()[col];
			System.out.println(i+".");
			System.out.println(hor +"|"+ver);
			System.out.println();
			randomColors[hor][ver] = which; 
		}
		
		return randomColors;	
	}
	
	
	public Color[][] getColors() {
		return colors;
	}
	public void setColors(Color[][] colors) {
		this.colors = colors;
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
