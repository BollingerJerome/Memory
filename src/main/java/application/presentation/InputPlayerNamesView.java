package application.presentation;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class InputPlayerNamesView extends WindowProps {

	public InputPlayerNamesView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}

	private Controller controller;


	public Scene getInputPlayerNamesViewScene() {
		
		GridPane gridPane = new GridPane(); //overall layout 
		
		int players = controller.getNumberOfPlayers(); //getting the number of players from the playModel playersarray
		
		//most elements are arrays because this window adapts to the number of players
		Label label3_1 = new Label("Enter the names"); //title
		
		TextField[] input = new TextField[players];		//input textfields
		Label[] playertext = new Label[players];		//player 1: , player 2: the labels on the left side
		
		for (int i = 0; i<players; i++) { 				//sets the number of labels and textfields and giving the label a name
			String text = "Player "+ (i+1) + ": ";
			playertext[i] = new Label(text);
			input[i] = new TextField();
		}
		
		Button backButton= new Button("<< Back");			//back bbutton
		backButton.setOnAction(e -> controller.showHome());	//setting the scene to home
		
		Button go = new Button("Start");					//starting the game button
		go.setTranslateX(230);
		go.setTranslateY(30);
		go.setMaxWidth(70);
		go.setOnAction(e -> {
			for (int i = 0; i<players; i++) { 				//this for loop saves the names of the inputs to the playerModel
				if(!input[i].getText().isEmpty()) {			 //each player has already a default name this means that those default name are only overwritten when player chooses to set a name
					controller.setPlayerName(i, input[i].getText());
				}
			}
			controller.showBoardSizeView(); 				//showing the boardsize window
		});
		
		


		//adding all elements to the gridPane
		gridPane.add(label3_1, 0, 0);
		for (int i = 0; i<players; i++) {
			gridPane.add(playertext[i], 0, i+1);
			gridPane.add(input[i], 1, i+1);
		}
		gridPane.add(go, 0, 6);
		gridPane.add(backButton, 0, 7);

		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(gridPane);	
	}

}
