package application.presentation;

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
		GridPane gridPane = new GridPane(); //overall Layout
		
		//title
		Label label4= new Label("Please select the size of the board:");
		
		Button vier= new Button("4x4"); //button 4x4
		vier.setMaxWidth(75);			//size
		vier.setTranslateX(110);		//translate -> placement
		vier.setTranslateY(20);
		vier.setOnAction(e -> {
			controller.setBoardSize(4);	//setting the size variable in  boardModel to 4 x 4
			controller.showBoard();		//showing the game field
			controller.setWon(false);	//when starting the game it is necessary to tell that the game hasnt been won yet
		});
		
		Button sechs= new Button("6x6"); //same here
		sechs.setMaxWidth(75);
		sechs.setTranslateX(110);
		sechs.setTranslateY(40);
		sechs.setOnAction(e -> {
			controller.setBoardSize(6);
			controller.showBoard();
			controller.setWon(false);
		});
		
		
		Button acht= new Button("8x8");
		acht.setMaxWidth(75);
		acht.setTranslateX(110);
		acht.setTranslateY(60);
		acht.setOnAction(e -> {
			controller.setBoardSize(8);
			controller.showBoard();
			controller.setWon(false);
		});
		
		Button zehn= new Button("10x10");
		zehn.setMaxWidth(75);
		zehn.setTranslateX(110);
		zehn.setTranslateY(80);
		zehn.setOnAction(e -> {
			controller.setBoardSize(10);
			controller.showBoard();
			controller.setWon(false);
		});
		
		//back button
		Button backButton= new Button("<< Back");
		backButton.setTranslateY(100);
		backButton.setOnAction(e -> controller.showHome()); //set the home Scene 
	
		//adding all labels and buttons to the gridPane
		gridPane.add(label4, 0, 0);
		gridPane.add(vier, 0, 1);
		gridPane.add(sechs, 0, 2);
		gridPane.add(acht, 0, 3);
		gridPane.add(zehn, 0, 4);
		gridPane.add(backButton, 0, 5);
		
		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(gridPane);
	}

	
}
