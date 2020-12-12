package application.presentation;

import application.services.FileController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
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
		back.setOnAction(e -> {
			controller.showHome();
		});
		
		
		Label[] namesOfPlayers = new Label[players]; //playername display thingy
		Label[] playerPoints = new Label[players];
		
		Label player = new Label("Player");

		
		Label time = new Label(controller.getTimeModel().getTimeString()); //how long this game was
		
		//how many rounds were needed to complete the game
		Label turnsInTotal = new Label(Integer.toString(controller.getDomainController().getPlayModel().getRound()));
		Label punkte = new Label("Points            ");
		Label round = new Label("turns in total");
		
		
		
		for (int i = 0; i<players; i++) {
			playerPoints[i] = new Label(Integer.toString(controller.getPlayerPoint(i))); 	//text for label is points of players
			namesOfPlayers[i] = new Label(controller.getPlayerName(i));
			gridPane.add(namesOfPlayers[i], 0, i+1);
			gridPane.add(playerPoints[i], 1, i+1);
			
		}
		
		
		
	
		//adding all elements 
		gridPane.add(player, 0, 0);
		gridPane.add(punkte, 1, 0);
		gridPane.add(round, 2, 0);
		gridPane.add(time, 0, 8);
		gridPane.add(turnsInTotal, 2, 1);
		
		
		vbox.getChildren().add(gridPane);
		
		
		//adding the highscore list
		if(players == 1) {
			
			vbox.getChildren().add(getScoreBox());
		}
		vbox.getChildren().add(back);
		
		//superclass method which returns the gridpane as a scene with the colors and size
		return getDefaultScene(vbox);
	}
	

	//creating the score box 
	public GridPane getScoreBox() {
		GridPane scoreBox = new GridPane();
		
		Label title1 = new Label("Rang");
		Label title2 = new Label("name"); 
		Label title3 = new Label("time"); 
		Label title4 = new Label("rounds"); 
		
		ColumnConstraints column = new ColumnConstraints(40);
        scoreBox.getColumnConstraints().add(column);
		
		for (int i = 0; i < 3; i++) {
			column = new ColumnConstraints(80);
	        scoreBox.getColumnConstraints().add(column);
	     }
		
		
		scoreBox.add(title1, 0, 0);
		scoreBox.add(title2, 1, 0);
		scoreBox.add(title3, 2, 0);
		scoreBox.add(title4, 3, 0);
	
	
		String[][] it = new String[10][3]; //will contain the txt information
		it = controller.getDomainController().getFileController().	//will return the string with readfunctions
				read(controller.getDomainController().getBoardModel().getHorizontalTiles());
		for (int i = 0; i<10; i++) {
			if(it[i][1] == null) {	//stop adding text if there is no content
				break;
			}
			else {
				Label rang = new Label(Integer.toString(i+1));
				scoreBox.add(rang,0,i+1);
				Label name = new Label(it[i][0]);
				scoreBox.add(name,1,i+1);
				Label time = new Label(it[i][1]);
				scoreBox.add(time,2,i+1);
				Label rounds = new Label(it[i][2]);
				scoreBox.add(rounds,3,i+1);
				
			}
		}
		return scoreBox;
	}
	
	
}
