package application.presentation;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
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
	
	
	public Scene getDefaultScene(GridPane root) {
		root.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(root, 300, 300, backgroundColor );
	}
	
	public Scene getDefaultScene(BorderPane root) {
		root.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(root, 300, 300, backgroundColor );	
	}
	
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
