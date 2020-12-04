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
		super(width, height, backgroundColor);
		this.controller = controller;
		
	}
	
	private Button buttonMulti;
	private Button buttonSolo;
	private Controller controller;
	
	
	public Scene getScene() {
		
		GridPane grid = new GridPane();
		Label label1 = new Label("Memory");
		label1.setTranslateX(70);
		label1.setTranslateY(20);	

		Button buttonSolo = new Button("Solo");
		buttonSolo.setMaxWidth(110);
		buttonSolo.setTranslateX(90);	
		buttonSolo.setTranslateY(50);
		buttonSolo.setOnAction(e ->{
			controller.setNumberOfPlayers(1);
			controller.showBoardSizeView(buttonSolo);
		});
		
		Button buttonMulti = new Button("Multiplayer");
		buttonMulti.setMaxWidth(110);
		buttonMulti.setTranslateX(90);	
		buttonMulti.setTranslateY(100);
		buttonMulti.setOnAction(e -> {
			controller.setMultiplayerPlayersView(buttonMulti);
		});
		
		Label label2 = new Label("      Jérôme Bollinger    /     Mischa Kissling\n      Jennifer Wyser       /      Alexis Burtschy\n                        Jonas Pröbsting");
		label2.setTranslateY(150);		

		grid.add(label1,0,0);
		grid.add(buttonSolo,0,1);
		grid.add(buttonMulti,0,2);
		grid.add(label2,0,3);

		//Scene home = new Scene(grid);
		
		return getDefaultScene(grid);
	}

	
	
}
