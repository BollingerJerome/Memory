package application.presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class BoardSizeView extends WindowProps{

	public BoardSizeView(double width, double height, Color backgroundColor, Controller controller) {
		super(width, height, backgroundColor);
		this.controller = controller;
	}
	
	
	private Controller controller;
	
	public Scene getScene() {
		VBox vbox = new VBox();
		Label label4= new Label("Please select the size of the board:");
		Button vier= new Button("4x4");
		vier.setOnAction(e -> {
			controller.setBoardSize(4);
			controller.showBoard(vier);
		});
		Button sechs= new Button("6x6");
		sechs.setOnAction(e -> {
			controller.setBoardSize(6);
			controller.showBoard(sechs);
		});
		Button acht= new Button("8x8");
		acht.setOnAction(e -> {
			controller.setBoardSize(8);
			controller.showBoard(acht);
		});
		Button zehn= new Button("10x10");
		zehn.setOnAction(e -> {
			controller.setBoardSize(10);
			controller.showBoard(zehn);
		});
		Button backButton= new Button("<< Back");
		backButton.setOnAction(e -> controller.showHome());
		vbox.getChildren().add(label4);
		vbox.getChildren().add(vier);
		vbox.getChildren().add(sechs);
		vbox.getChildren().add(acht);
		vbox.getChildren().add(zehn);
		vbox.getChildren().add(backButton);
		Scene scene = new Scene(vbox);
		return scene;
	}

	
}
