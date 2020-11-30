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
	
	
	public Scene getMultiplayersViewScene() {
		GridPane gridPane = new GridPane();
		Label text = new Label("Select players");
		Button button2 = new Button("2 Players");
		Button button3 = new Button("3 Players");
		Button button4 = new Button("4 Players");
		
		button2.setOnAction(e ->{
			controller.setNumberOfPlayers(2);
			controller.showInputPlayerNamesView(button2);
		});
		
		button3.setOnAction(e ->{
			controller.setNumberOfPlayers(3);
			controller.showInputPlayerNamesView(button3);
		});
		button4.setOnAction(e ->{
			controller.setNumberOfPlayers(4);
			controller.showInputPlayerNamesView(button4);
		});
		gridPane.add(text, 0, 0);
		gridPane.add(button2, 0, 1);
		gridPane.add(button3, 0, 2);
		gridPane.add(button4, 0, 3);
		Scene scene = new Scene(gridPane);
		return scene;
	}

}
