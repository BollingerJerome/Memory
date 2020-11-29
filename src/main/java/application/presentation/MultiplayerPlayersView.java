package application.presentation;

import application.domain.MultiplayerBoardModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MultiplayerPlayersView extends WindowProps{

	public MultiplayerPlayersView(double width, double height, Color backgroundColor, MultiplayerBoardModel multi, InputPlayerNamesView input) {
		super(width, height, backgroundColor);
		this.multiModel = multi;
		this.input = input;
	}
	private MultiplayerBoardModel multiModel;
	private InputPlayerNamesView input;
	
	public Scene getMultiplayersViewScene() {
		GridPane gridPane = new GridPane();
		Label text = new Label("Select players");
		Button button2 = new Button("2 Players");
		Button button3 = new Button("3 Players");
		Button button4 = new Button("4 Players");
		
		button2.setOnAction(e ->{
			multiModel.setPlayers(2);
			Stage primaryStage = (Stage) button2.getScene().getWindow();
			primaryStage.setScene(input.getInputPlayerNamesViewScene());
		});
		
		button3.setOnAction(e ->{
			multiModel.setPlayers(3);
			Stage primaryStage = (Stage) button3.getScene().getWindow();
			primaryStage.setScene(input.getInputPlayerNamesViewScene());
		});
		button4.setOnAction(e ->{
			multiModel.setPlayers(4);
			Stage primaryStage = (Stage) button4.getScene().getWindow();
			primaryStage.setScene(input.getInputPlayerNamesViewScene());
		});
		gridPane.add(text, 0, 0);
		gridPane.add(button2, 0, 1);
		gridPane.add(button3, 0, 2);
		gridPane.add(button4, 0, 3);
		Scene scene = new Scene(gridPane);
		return scene;
	}

}
