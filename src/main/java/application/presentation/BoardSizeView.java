package application.presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class BoardSizeView extends WindowProps{

	public BoardSizeView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}
	
	
	private Controller controller;
	
	public Scene getScene() {
		GridPane gridPane = new GridPane();
		Label label4= new Label("Please select the size of the board:");
		Button vier= new Button("4x4");
		vier.setMaxWidth(75);
		vier.setTranslateX(110);
		vier.setTranslateY(20);
		vier.setOnAction(e -> {
			controller.setBoardSize(4);
			controller.showBoard(vier);
			controller.setWon(false);
		});
		Button sechs= new Button("6x6");
		sechs.setMaxWidth(75);
		sechs.setTranslateX(110);
		sechs.setTranslateY(40);
		sechs.setOnAction(e -> {
			controller.setBoardSize(6);
			controller.showBoard(sechs);
			controller.setWon(false);
		});
		Button acht= new Button("8x8");
		acht.setMaxWidth(75);
		acht.setTranslateX(110);
		acht.setTranslateY(60);
		acht.setOnAction(e -> {
			controller.setBoardSize(8);
			controller.showBoard(acht);
			controller.setWon(false);
		});
		Button zehn= new Button("10x10");
		zehn.setMaxWidth(75);
		zehn.setTranslateX(110);
		zehn.setTranslateY(80);
		zehn.setOnAction(e -> {
			controller.setBoardSize(10);
			controller.showBoard(zehn);
			controller.setWon(false);
		});
		Button backButton= new Button("<< Back");
		backButton.setTranslateY(100);
		backButton.setOnAction(e -> controller.showHome());
	
		gridPane.add(label4, 0, 0);
		gridPane.add(vier, 0, 1);
		gridPane.add(sechs, 0, 2);
		gridPane.add(acht, 0, 3);
		gridPane.add(zehn, 0, 4);
		gridPane.add(backButton, 0, 5);
		//Scene scene = new Scene(gridPane);
		return getDefaultScene(gridPane);
	}

	
}
