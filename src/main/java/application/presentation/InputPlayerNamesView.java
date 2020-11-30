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
		int players = controller.getNumberOfPlayers();

		GridPane gridPane = new GridPane();
		Label label3_1 = new Label("Enter the name of players");
		Label[] playertext = new Label[players];
		TextField[] input = new TextField[players];
		Button go = new Button("Start");
		Button back = new Button("<<Back");

		go.setOnAction(e -> {
			for (int i = 0; i<players; i++) {
				controller.setPlayerName(i, input[i].getText());
			}
			controller.showBoardSizeView(go);
		});
		for (int i = 0; i<players; i++) { //labeltext
			String text = "Player "+ (i+1) + ": ";
			playertext[i] = new Label(text);
			input[i] = new TextField();
		}
		back.setOnAction(e -> {

		});


		gridPane.add(label3_1, 0, 0);
		for (int i = 0; i<players; i++) {
			System.out.println(players);
			gridPane.add(playertext[i], 0, i+1);
			gridPane.add(input[i], 1, i+1);
		}
		gridPane.add(go, 0, 6);
		gridPane.add(back, 0, 7);


		return new Scene(gridPane);	
	}

}
