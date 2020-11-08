package application;
	
//Test JEROME
//hat es geklappt?
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			
			BorderPane root = new BorderPane();
			Canvas canvas = new Canvas(500, 500);
			GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
			
			Color[][] field = {{Color.RED, Color.BLUE, Color.RED},
					{Color.BLUE,Color.RED, Color.BLUE},
					{Color.RED, Color.BLUE, Color.RED}
					};
			
			Board board = new Board(field, 3, 3, canvas.getWidth()/3, canvas.getHeight()/3, graphicsContext);
			board.drawBoard();
			root.setCenter(canvas);
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
