package application.presentation;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class InputPlayerNamesView extends WindowProps {

	public InputPlayerNamesView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}

	private Controller controller;


	public Scene getInputPlayerNamesViewScene() {
		
		VBox vbox = new VBox();
		
		int players = controller.getNumberOfPlayers(); //getting the number of players from the playModel playersarray
		
		//most elements are arrays because this window adapts to the number of players
		Label titleLabel = new Label("Enter your name:"); //title
		
		TextField[] input = new TextField[players];		//input textfields
		
		
		for (int i = 0; i<players; i++) { 				//sets the number of labels and textfields and giving the label a name
			String text = "Player "+ (i+1);
			input[i] = new TextField(text);
		}
		
		Button backButton= new Button("Back");			//back bbutton
		backButton.setOnAction(e -> controller.showHome());	//setting the scene to home
		
		Button go = new Button("Start");					//starting the game button
	
		go.setOnAction(e -> {
			for (int i = 0; i<players; i++) { 				//this for loop saves the names of the inputs to the playerModel
				if(!input[i].getText().isEmpty()) {			 //each player has already a default name this means that those default name are only overwritten when player chooses to set a name
					String[] test = input[i].getText().split("\\."); //I cannot allow a point in the name, so I delete the rest
					controller.setPlayerName(i, test[0]);
				}
			}
			controller.showBoardSizeView(); 				//showing the boardsize window
		});
		

		//adding all elements to the gridPane
		vbox.getChildren().add(titleLabel);
		for (int i = 0; i<players; i++) {
			input[i].setMaxWidth(80);;
			vbox.getChildren().add(input[i]);
		}
		
		
		HBox hbox = new HBox();
		hbox.getChildren().add(backButton);
		hbox.getChildren().add(go);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(hbox);

		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);
		
		
		
		
		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(vbox);	
	}

}
