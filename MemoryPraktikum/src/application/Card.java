package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Card {

	
	public Card(GraphicsContext gc, double x, double y, double w, double h, Color color) {
		this.gc = gc;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
	}

	private GraphicsContext gc;
	private double x, y, w, h;
	private Color color;
	
	public void draw() {
		gc.setFill(color);
		gc.fillRect(x, y, w, h);
	}

	public GraphicsContext getGc() {
		return gc;
	}

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
