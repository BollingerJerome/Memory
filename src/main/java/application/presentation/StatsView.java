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
		back.setTranslateY(180);
		back.setOnAction(e -> {
			controller.showHome();
		});
		
		gridPane.add(back, 0,6);
		Label[] namesOfPlayers = new Label[players];
		Label[] playerPoints = new Label[players];
		Label player = new Label("Player:");
		Label time = new Label(controller.getTimeModel().getTimeString());
		Label turnsInTotal = new Label("total turns: " + controller.getDomainController().getPlayModel().getRound());
		player.setTranslateX(10);
		player.setTranslateY(10);
		Label punkte = new Label("Points:");
		punkte.setTranslateX(30);
		punkte.setTranslateY(10);
		
		
		gridPane.add(player, 0, 0);
		gridPane.add(punkte, 1, 0);
		gridPane.add(time, 0, 8);
		gridPane.add(turnsInTotal, 4, 1);
		for (int i = 0; i<players; i++) {
			playerPoints[i] = new Label("   "+Integer.toString(controller.getPlayerPoint(i)));
			playerPoints[i].setTranslateX(30);
			playerPoints[i].setTranslateY(20);
			if (players == 1) {
				controller.setPlayerName(0, "You");;
			}
			namesOfPlayers[i] = new Label(controller.getPlayerName(i));
			namesOfPlayers[i].setTranslateX(10);
			namesOfPlayers[i].setTranslateY(20);
			gridPane.add(namesOfPlayers[i], 0, i+1);
			gridPane.add(playerPoints[i], 1, i+1);
			
		}
		Scene stats = getDefaultScene(gridPane);
		return stats;
	}
}
