package application.presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Home extends WindowProps {

	public Home(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor); //Windowprops as superclass
		this.controller = controller;
		
	}
	
	private Controller controller;		
	
	
	//method which returns the shown Scene
	public Scene getScene() {
		
		//overall layout
		GridPane grid = new GridPane();
		
		//title 
		Label label1 = new Label("Memory");
		label1.setTranslateX(70);
		label1.setTranslateY(20);	
		
		//Solo button
		Button buttonSolo = new Button("Solo");
		buttonSolo.setMaxWidth(110);
		buttonSolo.setTranslateX(90);	//translate functions are for the button placement but 
		buttonSolo.setTranslateY(50);	//it is not really nice to do it like this
		buttonSolo.setOnAction(e ->{		//lambda function "what happens when it is pressed?"
			controller.setNumberOfPlayers(1);	//sets the number of players to one
			controller.showBoardSizeView();		//makes the controller to show next window
		});
		
		//multiplayer button
		Button buttonMulti = new Button("Multiplayer");
		buttonMulti.setMaxWidth(110);
		buttonMulti.setTranslateX(90);	
		buttonMulti.setTranslateY(100);
		buttonMulti.setOnAction(e -> {
			controller.setMultiplayerPlayersView(); //makes the controller to show the next window
		});
		
		//our names
		Label label2 = new Label("      Jerôme Bollinger    /     Mischa Kissling\n      Jennifer Wyser       /      Alexis Burtschy\n                        Jonas Pröbsting");
		label2.setTranslateY(150);		

		//adding those labels and buttons to the gridPane with the corresponding grid coordinates
		//(the gridPane is a "Tabelle")
		grid.add(label1, 0, 0);
		grid.add(buttonSolo, 0, 1);
		grid.add(buttonMulti, 0, 2);
		grid.add(label2, 0, 3);
		
		return getDefaultScene(grid); //superclass method which returns the gridpane as a scene with the colors and size
	}

	
	
}
