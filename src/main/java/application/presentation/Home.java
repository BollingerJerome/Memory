package application.presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Home extends WindowProps {

	public Home(double width, double height, Color backgroundColor, BoardSizeView boardSize) {
		super(width, height, backgroundColor);
		this.boardSize = boardSize;
	}
	private BoardSizeView boardSize;
	
	public Scene getScene() {
		GridPane grid = new GridPane();
		Label label1 = new Label("Welcome to Memory!");
		Button buttonSolo = new Button("Solo");
		buttonSolo.setOnAction(e ->{
			Stage primaryStage = (Stage) buttonSolo.getScene().getWindow();
			primaryStage.setScene(boardSize.getScene());
		});
		Button buttonMulti = new Button("Multiplayer");
		grid.add(label1,0,0);
		grid.add(buttonSolo,0,1);
		grid.add(buttonMulti,0,2);
		Scene home = new Scene(grid);
		
		return home;
	}
	
	
}