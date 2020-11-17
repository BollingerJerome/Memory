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
import javafx.scene.text.Text;


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
			Group group = new Group();
			
			VBox layout1 = new VBox(50);     
			Scene menu= new Scene(layout1, 300, 300, Color.CORNFLOWERBLUE);
			VBox layout2 = new VBox(20);     
			Scene numberPlayers = new Scene(layout2, 300, 300, Color.CORNFLOWERBLUE);
			VBox layout3_1 = new VBox(20);     
			Scene nameTwoPlayers = new Scene(layout3_1, 300, 300, Color.CORNFLOWERBLUE);
			VBox layout3_2 = new VBox(20);     
			Scene nameThreePlayers = new Scene(layout3_2, 300, 300, Color.CORNFLOWERBLUE);
			VBox layout3_3 = new VBox(20);     
			Scene nameFourPlayers = new Scene(layout3_3, 300, 300, Color.CORNFLOWERBLUE);
			VBox layout4 = new VBox(20);
			Scene boardSize = new Scene(layout4,300,300,Color.CORNFLOWERBLUE);
			
			
			//Scene 1 : Welcome to Memory
			Label label1 = new Label("Welcome to Memory!");
			Button buttonSolo = new Button("Solo");
			buttonSolo.setOnAction(e -> primaryStage.setScene(boardSize));  
			Button buttonMulti = new Button("Multiplayer");
			buttonMulti.setOnAction(e -> primaryStage.setScene(numberPlayers));
			layout1.getChildren().addAll(label1, buttonSolo, buttonMulti);
			
			
			//Scene 2 : if Multi --> Number of players
			Label label2= new Label("Enter the number of players");
			Button twoPlayers = new Button("2");
			twoPlayers.setOnAction(e -> primaryStage.setScene(nameTwoPlayers));  
			Button threePlayers = new Button("3");
			threePlayers.setOnAction(e -> primaryStage.setScene(nameThreePlayers));  
			Button fourPlayers = new Button("4");
			fourPlayers.setOnAction(e -> primaryStage.setScene(nameFourPlayers));  
			Button backButton1 = new Button("<< Back");
			backButton1.setOnAction(e -> primaryStage.setScene(menu));  
			layout2.getChildren().addAll(label2, twoPlayers, threePlayers, fourPlayers, backButton1);
			
			
			//Scene 3.1 : if Multi --> Name of 2 players
			Label label3_1 = new Label("Enter the name of players");
			Text textNames1_1 = new Text();
			textNames1_1.setText("Player 1: ");
			Text textNames1_2 = new Text();
			textNames1_2.setText("Player 2: ");
			Button backButton2_1= new Button("<< Back");
			backButton2_1.setOnAction(e -> primaryStage.setScene(numberPlayers));  
			Button nextButton1_1= new Button("Next >>");
			nextButton1_1.setOnAction(e -> primaryStage.setScene(boardSize));  
			layout3_1.getChildren().addAll(label3_1,textNames1_1, textNames1_2, backButton2_1,nextButton1_1);
			
			//Scene 3.2 : if Multi --> Name of 3 players
			Label label3_2 = new Label("Enter the name of players");
			Text textNames2_1 = new Text();
			textNames2_1.setText("Player 1: ");
			Text textNames2_2 = new Text();
			textNames2_2.setText("Player 2: ");
			Text textNames2_3 = new Text();
			textNames2_3.setText("Player 3: ");
			Button backButton2_2= new Button("<< Back");
			backButton2_2.setOnAction(e -> primaryStage.setScene(numberPlayers));  
			Button nextButton1_2= new Button("Next >>");
			nextButton1_2.setOnAction(e -> primaryStage.setScene(boardSize));  
			layout3_2.getChildren().addAll(label3_2,textNames2_1, textNames2_2, textNames2_3, backButton2_2,nextButton1_2);
			
			//Scene 3.3 : if Multi --> Name of 4 players
			Label label3_3 = new Label("Enter the name of players");
			Text textNames3_1 = new Text();
			textNames3_1.setText("Player 1: ");
			Text textNames3_2 = new Text();
			textNames3_2.setText("Player 2: ");
			Text textNames3_3 = new Text();
			textNames3_3.setText("Player 3: ");
			Text textNames3_4 = new Text();
			textNames3_4.setText("Player 4: ");
			Button backButton2_3= new Button("<< Back");
			backButton2_3.setOnAction(e -> primaryStage.setScene(numberPlayers));  
			Button nextButton1_3= new Button("Next >>");
			nextButton1_3.setOnAction(e -> primaryStage.setScene(boardSize));  
			layout3_3.getChildren().addAll(label3_1,textNames3_1, textNames3_2, textNames3_3, textNames3_4, backButton2_3,nextButton1_3);
			

			//Scene 4 : Boardsize
			Label label4= new Label("Please select the size of the board:");
			Button vier= new Button("4x4");
			//vier.setAlignment(Pos.CENTER);
			Button sechs= new Button("6x6");
			//sechs.setAlignment(Pos.CENTER);
			Button acht= new Button("8x8");
			//acht.setAlignment(Pos.CENTER);
			Button zehn= new Button("10x10");
			//zehn.setAlignment(Pos.CENTER);
			Button backButton3= new Button("<< Back");
			backButton3.setOnAction(e -> primaryStage.setScene(menu));  
			layout4.getChildren().addAll(label4, vier, sechs, acht, zehn, backButton3);
			
			

			
                             
			//Scene 5 : Board
			vier.setOnAction(e -> { createGameBoard(new Board(2, 2, 400, 400));
      vier.setOnAction(e -> { createGameBoard(new MultiplayerBoard(4, 4, 400, 400,2));
									primaryStage.setScene(new Scene(root));});
			
			sechs.setOnAction(e -> {createGameBoard(new MultiplayerBoard(6, 6, 400, 400, 2));
									primaryStage.setScene(new Scene(root));});
			
			acht.setOnAction(e -> {createGameBoard(new MultiplayerBoard(8, 8, 400, 400,4));
									primaryStage.setScene(new Scene(root));});
			
			zehn.setOnAction(e -> {	createGameBoard(new MultiplayerBoard(10, 10, 400, 400,4));
									primaryStage.setScene(new Scene(root));});
			
			
			//Scene 6 : GAME OVER (Solo)
			Label label5= new Label("GAME OVER");
			Text textSolo = new Text();
			textSolo.setText("Game Time: ");
			textSolo.setText("Tries: ");
			Button menuButtonSolo= new Button("Menu >>");
			menuButtonSolo.setOnAction(e -> primaryStage.setScene(menu));  
			VBox layout5= new VBox(20);
			layout5.getChildren().addAll(label5, menuButtonSolo);
			Scene scene4 = new Scene(layout5, 300, 300);
			
			
			//Scene 7 : GAME OVER (Multiplayer)
			Label label6= new Label("GAME OVER");
			Text textMulti = new Text();
			textMulti.setText("Winner: ");
			textMulti.setText("Game Time: ");
			textMulti.setText("Pairs found: ");
			textMulti.setText("Tries: ");
			Button menuButtonMulti= new Button("Menu >>");
			menuButtonMulti.setOnAction(e -> primaryStage.setScene(menu));  
			VBox layout6= new VBox(20);
			layout6.getChildren().addAll(label6, menuButtonMulti);
			Scene scene5 = new Scene(layout6, 300, 300);
			
			
			primaryStage.setScene(menu);
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