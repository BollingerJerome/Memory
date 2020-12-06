package application.presentation;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MultiplayerPlayersView extends WindowProps{

	public MultiplayerPlayersView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}
	private Controller controller;
	
	
	//this window allows the player to select the number of players
	public Scene getMultiplayersViewScene() {
		
		GridPane gridPane = new GridPane(); //overall layout
		
		Label text = new Label("Select players");
		
		Button button2 = new Button("2 Players"); 	//button to select 2 players
		button2.setTranslateX(110);
		button2.setTranslateY(20);	
		button2.setOnAction(e ->{
			controller.setNumberOfPlayers(2);  		//set the number of the playerModelarray in playmodel to two
			controller.showInputPlayerNamesView();	//next window
		});
		
		Button button3 = new Button("3 Players"); 	//same for the next few
		button3.setTranslateX(110);
		button3.setTranslateY(40);
		button3.setOnAction(e ->{
			controller.setNumberOfPlayers(3);
			controller.showInputPlayerNamesView();
		});
		
		Button button4 = new Button("4 Players");
		button4.setTranslateX(110);
		button4.setTranslateY(60);
		button4.setOnAction(e ->{
			controller.setNumberOfPlayers(4);
			controller.showInputPlayerNamesView();
		});
		
		//back button
		Button backButton= new Button("<< Back");
		backButton.setTranslateY(80);
		backButton.setOnAction(e -> controller.showHome());
		
		
		
		
		
		
		//adding all elements to the gridPane
		gridPane.add(text, 0, 0);
		gridPane.add(button2, 0, 1);
		gridPane.add(button3, 0, 2);
		gridPane.add(button4, 0, 3);
		gridPane.add(backButton, 0, 4);
		
		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(gridPane);
	}

}
