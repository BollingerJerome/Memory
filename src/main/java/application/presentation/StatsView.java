package application.presentation;

import application.services.FileController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StatsView extends WindowProps {

	public StatsView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}

	private Controller controller;
	
	public Scene showStatsView() {
		
		VBox vbox = new VBox();
		GridPane gridPane = new GridPane(); //overall layout
		
		//how many players are there
		int players = controller.getNumberOfPlayers();
		
		//back button
		Button back = new Button("Back");
		back.setTranslateY(180);
		back.setOnAction(e -> {
			controller.showHome();
		});
		
		
		Label[] namesOfPlayers = new Label[players]; //playername display thingy
		Label[] playerPoints = new Label[players];
		
		Label player = new Label("Player:");
		player.setTranslateX(10);
		player.setTranslateY(10);
		
		Label time = new Label(controller.getTimeModel().getTimeString()); //how long this game was
		
		//how many rounds were needed to complete the game
		Label turnsInTotal = new Label("total turns: " + controller.getDomainController().getPlayModel().getRound());
		
		Label punkte = new Label("Points:");
		punkte.setTranslateX(30);
		punkte.setTranslateY(10);
		
		
		
		for (int i = 0; i<players; i++) {
			playerPoints[i] = new Label("   "+Integer.toString(controller.getPlayerPoint(i))); 	//text for label is points of players
			playerPoints[i].setTranslateX(30);
			playerPoints[i].setTranslateY(20);
			
			
			namesOfPlayers[i] = new Label(controller.getPlayerName(i));
			namesOfPlayers[i].setTranslateX(10);
			namesOfPlayers[i].setTranslateY(20);
			
			gridPane.add(namesOfPlayers[i], 0, i+1);
			gridPane.add(playerPoints[i], 1, i+1);
			
		}
		
		
		
		
		//adding all elements
		gridPane.add(back, 0,6);
		gridPane.add(player, 0, 0);
		gridPane.add(punkte, 1, 0);
		gridPane.add(time, 0, 8);
		gridPane.add(turnsInTotal, 4, 1);
		
		vbox.getChildren().add(gridPane);
		
		
		//adding the highscore list
		if(players == 1) {
			
			vbox.getChildren().add(getScoreBox());
		}
		
		
		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(vbox);
	}
	
	
	//creating the score box 
	public VBox getScoreBox() {
		VBox scoreBox = new VBox();
		Label[] scoreLabels = new Label[10];
		String[][] it = new String[10][3]; //will contain the txt information
		it = controller.getDomainController().getFileController().	//will return the string with readfunctions
				read(controller.getDomainController().getBoardModel().getHorizontalTiles());
		for (int i = 0; i<10; i++) {
			if(it[i][1] == null) {	//stop adding text if there is no content
				break;
			}
			else {
				String score = "Rang: " + (i+1) + "  name: " +it[i][0]+ " time: " + it[i][1] + " rounds: " + it[i][2];
				scoreLabels[i] = new Label(score);
				scoreBox.getChildren().add(scoreLabels[i]);
			}
		}
		return scoreBox;
	}
	
	
}
