package application.presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class BoardSizeView extends WindowProps{

	public BoardSizeView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}
	
	
	private Controller controller;
	
	//method which returns the shown Scene
	public Scene getScene() {
		VBox vbox = new VBox(); //overall Layout
		
		//title
		Label label4= new Label("Please select the size of the board:");
		
		Button vier= new Button("4x4"); //button 4x4
		vier.setMaxWidth(60);
		vier.setOnAction(e -> {
			controller.setBoardSize(4);	//setting the size variable in  boardModel to 4 x 4
			controller.showBoard();		//showing the game field
			controller.setWon(false);	//when starting the game it is necessary to tell that the game hasnt been won yet
		});
		
		Button sechs= new Button("6x6"); //same here
		sechs.setMaxWidth(60);
		sechs.setOnAction(e -> {
			controller.setBoardSize(6);
			controller.showBoard();
			controller.setWon(false);
		});
		
		
		Button acht= new Button("8x8");
		acht.setMaxWidth(60);
		acht.setOnAction(e -> {
			controller.setBoardSize(8);
			controller.showBoard();
			controller.setWon(false);
		});
		
		Button zehn= new Button("10x10");
		zehn.setMaxWidth(60);
		zehn.setOnAction(e -> {
			controller.setBoardSize(10);
			controller.showBoard();
			controller.setWon(false);
		});
		
		//back button
		Button backButton= new Button("Back");
		backButton.setOnAction(e -> controller.showHome()); //set the home Scene 
	
		//adding all labels and buttons to the gridPane
		vbox.getChildren().add(label4);
		vbox.getChildren().add(vier);
		vbox.getChildren().add(sechs);
		vbox.getChildren().add(acht);
		vbox.getChildren().add(zehn);
		vbox.getChildren().add(backButton);
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		
		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(vbox);
	}

	
}
