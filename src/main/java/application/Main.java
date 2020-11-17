package application;

//Test JEROME
//hat es geklappt?
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {

	BorderPane root = new BorderPane();
	Group bord;
	
	public void createGameBoard(MultiplayerBoard board) {
		Group bord = new Group();
		for (int i = 0; i< board.getHorizontalTiles(); i++) {
			for (int j = 0; j<board.getVerticalTiles(); j++) {
				bord.getChildren().add(board.getRectangleField()[i][j]);
			}
		}
		root.setCenter(bord);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {

			Scene scene1, boardSize;
			VBox layout2= new VBox(20);
			boardSize= new Scene(layout2,300,250);

			//Scene 1
			Label label1= new Label("Welcome to Memory!");
			Button buttonSolo= new Button("Solo");
			buttonSolo.setOnAction(e -> primaryStage.setScene(boardSize));   
			VBox layout1 = new VBox(50);     
			layout1.getChildren().addAll(label1, buttonSolo);
			scene1= new Scene(layout1, 300, 250);

			//Scene 2
			Label label2= new Label("Please select the size of the board:");
			Button vier= new Button("4x4");
			vier.setAlignment(Pos.CENTER);
			Button sechs= new Button("6x6");
			sechs.setAlignment(Pos.CENTER);
			Button acht= new Button("8x8");
			acht.setAlignment(Pos.CENTER);
			Button zehn= new Button("10x10");
			zehn.setAlignment(Pos.CENTER);
			layout2.getChildren().addAll(label2, vier, sechs, acht, zehn);
			
			
			vier.setOnAction(e -> { createGameBoard(new MultiplayerBoard(4, 4, 400, 400,2));
									primaryStage.setScene(new Scene(root));});
			
			sechs.setOnAction(e -> {createGameBoard(new MultiplayerBoard(6, 6, 400, 400, 2));
									primaryStage.setScene(new Scene(root));});
			
			acht.setOnAction(e -> {createGameBoard(new MultiplayerBoard(8, 8, 400, 400,4));
									primaryStage.setScene(new Scene(root));});
			
			zehn.setOnAction(e -> {	createGameBoard(new MultiplayerBoard(10, 10, 400, 400,4));
									primaryStage.setScene(new Scene(root));});
			
			
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Welcome to Memory!");
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}