package application;

//Test JEROME
//hat es geklappt?
//Ja von kisslingmischa

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {

	

	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			Canvas canvas = new Canvas(2000, 2000);
			Group bord = new Group();
			Board board = new Board( 4, 4, canvas.getWidth()/4, canvas.getHeight()/4);

			for (int i = 0; i< board.getHorizontalTiles(); i++) {
				for (int j = 0; j<board.getVerticalTiles(); j++) {
					bord.getChildren().add(board.getRectangleField()[i][j]);
				}
			}

			root.setCenter(bord);
			primaryStage.setScene(new Scene(root));
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