package application.presentation;

import application.domain.BoardModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BoardSizeView extends WindowProps{

	public BoardSizeView(double width, double height, Color backgroundColor, Controller controller, BoardView bordView, BoardModel boardModel) {
		super(width, height, backgroundColor);
		this.controller = controller;
		this.boardView = bordView;
		this.boardModel = boardModel;
	}
	
	private Controller controller;
	private BoardView boardView;
	private BoardModel boardModel;
	public Scene getScene() {
		VBox vbox = new VBox();
		Label label4= new Label("Please select the size of the board:");
		Button vier= new Button("4x4");
		vier.setOnAction(e -> {
			controller.setBoardSize(4);
			boardView = new BoardView(boardModel, controller);
			Stage primaryStage = (Stage) vier.getScene().getWindow();
			primaryStage.setScene(new Scene(boardView.setupCards()));
		});
		Button sechs= new Button("6x6");
		sechs.setOnAction(e -> {
			controller.setBoardSize(6);
			boardView = new BoardView(boardModel, controller);
			Stage primaryStage = (Stage) vier.getScene().getWindow();
			primaryStage.setScene(new Scene(boardView.setupCards()));
		});
		Button acht= new Button("8x8");
		acht.setOnAction(e -> {
			controller.setBoardSize(8);
			boardView = new BoardView(boardModel, controller);
			Stage primaryStage = (Stage) vier.getScene().getWindow();
			primaryStage.setScene(new Scene(boardView.setupCards()));
		});
		Button zehn= new Button("10x10");
		zehn.setOnAction(e -> {
			controller.setBoardSize(10);
			boardView = new BoardView(boardModel, controller);
			Stage primaryStage = (Stage) vier.getScene().getWindow();
			primaryStage.setScene(new Scene(boardView.setupCards()));
		});
		Button backButton= new Button("<< Back");
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
