package application.presentation;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class WindowProps {
	//abstract class which contains a method to return a default Scene for all windows except the boardview
	
		//constructor
	public WindowProps(double width, double height, Color backgroundColor) {
		super();
		this.width = width;
		this.height = height;
		this.backgroundColor = backgroundColor;
	}
	
	
	private double width, height;	//window height and width
	private Color backgroundColor;	//the Scenes background color
	
		//this method returns a Scene which contains the Pane of the View and adds colors and size to it
	public Scene getDefaultScene(GridPane root) {
		root.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(root, width, height, backgroundColor );
	}
	
		//does the same but it is necessary to have different methods for differen parameter types
	public Scene getDefaultScene(BorderPane root) {
		root.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(root, width, height, backgroundColor );	
	}
	
	public Scene getDefaultScene(VBox root) {
		root.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
		return new Scene(root, width, height, backgroundColor );	
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
