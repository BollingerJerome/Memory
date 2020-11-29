package application.presentation;

import application.domain.MultiplayerBoardModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class InputPlayerNamesView extends WindowProps {

	public InputPlayerNamesView(double width, double height, Color backgroundColor, MultiplayerBoardModel multi) {
		super(width, height, backgroundColor);
		this.multi = multi;
	}

	private MultiplayerBoardModel multi;
	
	
	public Scene getInputPlayerNamesViewScene() {
		
		GridPane gridPane = new GridPane();
		Label label3_1 = new Label("Enter the name of players");
		Label[] playertext = new Label[multi.getPlayers()];
		TextField[] input = new TextField[multi.getPlayers()];
		Button go = new Button("Start");
		Button back = new Button("<<Back");
		
		go.setOnAction(e -> {
			for (int i = 0; i<multi.getPlayers(); i++) {
				if(input[i].getText().isEmpty()) {
					String defaultName = "Player "+i; 
					multi.setPlayerName(i, defaultName);
				}
				else {
					multi.setPlayerName(i, input[i].getText());
				}
			}
			
			
			});
		for (int i = 0; i<multi.getPlayers(); i++) { //labeltext
			String text = "Player "+ i + ": ";
			playertext[i] = new Label(text);
			input[i] = new TextField();
		}
		back.setOnAction(e -> {
			
		});


		gridPane.add(label3_1, 0, 0);
		for (int i = 0; i<multi.getPlayers(); i++) {
			System.out.println(multi.getPlayers());
			gridPane.add(playertext[i], 0, i+1);
			gridPane.add(input[i], 1, i+1);
		}
		gridPane.add(go, 0, 6);
		gridPane.add(back, 0, 7);
		
		
		return new Scene(gridPane);	
	}
	
}
