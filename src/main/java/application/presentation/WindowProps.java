package application.presentation;

import javafx.scene.paint.Color;

public abstract class WindowProps {
	
	public WindowProps(double width, double height, Color backgroundColor) {
		super();
		this.width = width;
		this.height = height;
		this.backgroundColor = backgroundColor;
	}
	private double width, height;
	private Color backgroundColor;
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

}
