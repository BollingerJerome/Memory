package application.presentation;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
		
		VBox vbox = new VBox();			 //overall layout
		
		Label text = new Label("Select players");
		
		Button button2 = new Button("2 Players"); 	//button to select 2 players
		button2.setOnAction(e ->{
			controller.setNumberOfPlayers(2);  		//set the number of the playerModelarray in playmodel to two
			controller.showInputPlayerNamesView();	//next window
		});
		
		Button button3 = new Button("3 Players"); 	//same for the next few
		button3.setOnAction(e ->{
			controller.setNumberOfPlayers(3);
			controller.showInputPlayerNamesView();
		});
		
		Button button4 = new Button("4 Players");
		button4.setOnAction(e ->{
			controller.setNumberOfPlayers(4);
			controller.showInputPlayerNamesView();
		});
		
		//back button
		Button backButton= new Button("Back");
		backButton.setOnAction(e -> controller.showHome());
		
		
		
		
		
		
		//adding all elements to the gridPane
		vbox.getChildren().add(text);
		vbox.getChildren().add(button2);
		vbox.getChildren().add(button3);
		vbox.getChildren().add(button4);
		vbox.getChildren().add(backButton);
		
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		
		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(vbox);
	}

}
