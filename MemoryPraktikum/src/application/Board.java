package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board {
	
	public Board(Color[][] setup, int verticalCards, int horizontalCards, double scalarX, double scalarY, GraphicsContext gc) {
		this.gc = gc;
		this.setup = setup;
		this.verticalCards = verticalCards;
		this.horizontalCards = horizontalCards;
		this.scalarX = scalarX;
		this.scalarY = scalarY;
		this.card = new Card[horizontalCards][verticalCards];
		
		for (int i = 0; i<horizontalCards; i++) {
			for (int j = 0; j<verticalCards; j++) {
				this.card[i][j] = new Card(gc, i*scalarX, j*scalarY, scalarX, scalarY, setup[i][j]);
			}
		}
	}
	
	private Color[][] setup;
	private int verticalCards, horizontalCards;
	private double scalarX, scalarY;
	private Card[][] card;
	private GraphicsContext gc;
	
	public void drawBoard() {
		for (int i = 0; i<horizontalCards; i++) {
			for (int j = 0; j<verticalCards; j++) {
				this.card[i][j].draw();
			}
		}
	}
	
	public Color[][] getSetup() {
		return setup;
	}
	public void setSetup(Color[][] setup) {
		this.setup = setup;
	}
	public int getVerticalCards() {
		return verticalCards;
	}
	public void setVerticalCards(int verticalCards) {
		this.verticalCards = verticalCards;
	}
	public int getHorizontalCards() {
		return horizontalCards;
	}
	public void setHorizontalCards(int horizontalCards) {
		this.horizontalCards = horizontalCards;
	}
	public double getScalarX() {
		return scalarX;
	}
	public void setScalarX(double scalarX) {
		this.scalarX = scalarX;
	}
	public double getScalarY() {
		return scalarY;
	}
	public void setScalarY(double scalarY) {
		this.scalarY = scalarY;
	}
	
	
	
	

}
