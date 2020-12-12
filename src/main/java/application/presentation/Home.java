package application.presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
		
		VBox vbox = new VBox();
		//overall layout
		GridPane grid = new GridPane();
		BorderPane borderPane = new BorderPane();
		//title 
		Label label1 = new Label("Memory");
	
		
		//Solo button
		Button buttonSolo = new Button("Solo");
		
		buttonSolo.setOnAction(e ->{		//lambda function "what happens when it is pressed?"
			controller.setNumberOfPlayers(1);	//sets the number of players to one
			controller.showInputPlayerNamesView();		//makes the controller to show next window
		});
		
		//multiplayer button
		Button buttonMulti = new Button("Multiplayer");

		buttonMulti.setOnAction(e -> {
			controller.setMultiplayerPlayersView(); //makes the controller to show the next window
		});
		
		//our names
		Label label2 = new Label("Bollinger, Burtschy, Kissling, Pröbsting, Wyser");
		

		//adding those labels and buttons to the gridPane with the corresponding grid coordinates
		//(the gridPane is a "Tabelle")
		
		buttonMulti.setMaxWidth(100);
		buttonSolo.setMaxWidth(100);
		
		vbox.getChildren().add(label1);
		vbox.getChildren().add(buttonSolo);
		vbox.getChildren().add(buttonMulti);
		vbox.getChildren().add(label2);
		vbox.setAlignment(Pos.CENTER);
		
		
		
		borderPane.setCenter(vbox);
		
		label2.setAlignment(Pos.CENTER);
		borderPane.setBottom(label2);
		vbox.setSpacing(20);
		
		
		return getDefaultScene(borderPane); //superclass method which returns the gridpane as a scene with the colors and size
	}

	
	
}
