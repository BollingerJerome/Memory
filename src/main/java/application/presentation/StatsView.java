package application.presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class StatsView extends WindowProps {

	public StatsView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}

	private Controller controller;
	
	public Scene showStatsView() {

		int players = controller.getNumberOfPlayers();
		GridPane gridPane = new GridPane();
		Button back = new Button("Back");
		back.setOnAction(e -> {
			controller.showHome();
		});
		gridPane.add(back, 1,6);
		Label[] namesOfPlayers = new Label[players];
		Label[] playerPoints = new Label[players];
		Label player = new Label("Player");
		Label punkte = new Label("Points");
		gridPane.add(player, 0, 0);
		gridPane.add(punkte, 1, 0);
		
		for (int i = 0; i<players; i++) {
			playerPoints[i] = new Label("   "+Integer.toString(controller.getPlayerPoint(i)));

			if (players == 1) {
				controller.setPlayerName(0, "You");;
			}
			namesOfPlayers[i] = new Label(controller.getPlayerName(i));
			gridPane.add(namesOfPlayers[i], 0, i+1);
			gridPane.add(playerPoints[i], 1, i+1);
		}
		Scene stats = new Scene(gridPane);
		return stats;
	}
}
