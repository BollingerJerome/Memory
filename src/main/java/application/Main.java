package application;

import application.domain.Board;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {

	BorderPane root;
	Group bord;
	static Board board;
	Scene playerNames;
	static int players = 1;
	String playerString[];
	private static Stage primaryStage;
	static VBox layout1 = new VBox(50);
	static Scene menu= new Scene(layout1, 300, 300, Color.CORNFLOWERBLUE);
	VBox layout4 = new VBox(20);
	Scene boardSize = new Scene(layout4,300,300,Color.CORNFLOWERBLUE);
	static Scene end;

	Label[] pointLabels;

	public static void createEnd() {
		GridPane gridPane = new GridPane();
		Button back = new Button("Back");
		back.setOnAction(e -> {
			Stage primaryStage = (Stage) back.getScene().getWindow();
			primaryStage.setScene(menu);
		});
		gridPane.add(back, 1,6);
		Label[] namesOfPlayers = new Label[players];
		Label[] playerPoints = new Label[players];
		Label player = new Label("Player");
		Label punkte = new Label("Points");
		gridPane.add(player, 0, 0);
		gridPane.add(punkte, 1, 0);
		for (int i = 0; i<players; i++) {
			playerPoints[i] = new Label("   "+Integer.toString(board.getPlayerPoints()[i]));

			if (players == 1) {
				String[] me = {"You"};
				board.setPlayerNames(me);
			}
			namesOfPlayers[i] = new Label(board.getPlayerNames()[i]);
			gridPane.add(namesOfPlayers[i], 0, i+1);
			gridPane.add(playerPoints[i], 1, i+1);
		}
		end = new Scene(gridPane, 300, 300, Color.CORNFLOWERBLUE);
		primaryStage.setScene(end);
	}


	public void createGameBoard(Board board) {
		root = new BorderPane();
		this.board = board; // Main.board gets a board

		Button back = new Button("Back"); //back button
		back.setOnAction(e -> {
			Stage primaryStage = (Stage) back.getScene().getWindow();
			primaryStage.setScene(menu);
		});

		Group bord = new Group(); //group containing all cards
		for (int i = 0; i< board.getHorizontalTiles(); i++) {
			for (int j = 0; j<board.getVerticalTiles(); j++) {
				bord.getChildren().add(board.getRectangleField()[i][j]);
			}
		}

		if(players>1) { //creates pointlabels on the left side

			GridPane gridPaneLeft = new GridPane();
			Label[] playernames = new Label[players];
			pointLabels = new Label[players];

			board.addPropertyChangeListener(e -> System.out.println("Points changed"));

			for (int i = 0; i<board.getPlayers(); i++) {
				playernames[i] = new Label(playerString[i] + ": ");
				this.pointLabels[i] = new Label();
				gridPaneLeft.add(playernames[i], 0, i);
				gridPaneLeft.add(this.pointLabels[i], 1, i);
			}

			root.setLeft(gridPaneLeft);
		}
		root.setCenter(bord);
		root.setBottom(back);
	}


	public void createNameBoard(int players) {
		this.playerString = new String[players];
		GridPane layout1 = new GridPane();
		this.players = players;
		Label label3_1 = new Label("Enter the name of players");
		Label[] playertext = new Label[4];
		TextField[] input = new TextField[4];
		Button go = new Button("Start");
		Button back = new Button("<<Back");
		go.setOnAction(e -> {
			for(int i = 0; i<players; i++) {
				if(input[i].getText().isEmpty()) {
					this.playerString[i] = "Player "+(i+1);
				}
				else {
					this.playerString[i] = input[i].getText();
				}
			}
			Stage primaryStage = (Stage) go.getScene().getWindow();
			primaryStage.setScene(boardSize);
			});
		for (int i = 0; i<4; i++) {
			String text = "Player "+ i + ": ";
			playertext[i] = new Label(text);
			input[i] = new TextField();
		}
		back.setOnAction(e -> {
			Stage primaryStage = (Stage) go.getScene().getWindow();
			primaryStage.setScene(menu);
		});


		layout1.add(label3_1, 0, 0);
		for (int i = 0; i<players; i++) {
			layout1.add(playertext[i], 0, i+1);
			layout1.add(input[i], 1, i+1);
		}
		layout1.add(go, 0, 6);
		layout1.add(back, 0, 7);
		playerNames = new Scene(layout1, 300, 300, Color.CORNFLOWERBLUE);
	}



	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			Group group = new Group();



			VBox layout2 = new VBox(20);
			Scene numberPlayers = new Scene(layout2, 300, 300, Color.CORNFLOWERBLUE);


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
			twoPlayers.setOnAction(e -> {createNameBoard(2);
				players = 2;
				primaryStage.setScene(playerNames);});
			Button threePlayers = new Button("3");
			threePlayers.setOnAction(e -> {createNameBoard(3);
				players = 3;
				primaryStage.setScene(playerNames);});
			Button fourPlayers = new Button("4");
			fourPlayers.setOnAction(e -> {createNameBoard(4);
				players = 4;
				primaryStage.setScene(playerNames);});
			Button backButton1 = new Button("<< Back");
			backButton1.setOnAction(e -> primaryStage.setScene(menu));
			layout2.getChildren().addAll(label2, twoPlayers, threePlayers, fourPlayers, backButton1);


			//Scene 4 : Boardsize
			Label label4= new Label("Please select the size of the board:");
			Button vier= new Button("4x4");
			Button sechs= new Button("6x6");
			Button acht= new Button("8x8");
			Button zehn= new Button("10x10");
			Button backButton3= new Button("<< Back");
			backButton3.setOnAction(e -> primaryStage.setScene(menu));
			layout4.getChildren().addAll(label4, vier, sechs, acht, zehn, backButton3);





			//Scene 5 : Board
			vier.setOnAction(e -> { createGameBoard(new Board(4, 4, 400, 400, players, playerString));
									primaryStage.setScene(new Scene(root));});

			sechs.setOnAction(e -> {createGameBoard(new Board(6, 6, 400, 400, players, playerString));
									primaryStage.setScene(new Scene(root));});

			acht.setOnAction(e -> {createGameBoard(new Board(8, 8, 400, 400, players, playerString));
									primaryStage.setScene(new Scene(root));});

			zehn.setOnAction(e -> {	createGameBoard(new Board(10, 10, 400, 400, players, playerString));
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

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
