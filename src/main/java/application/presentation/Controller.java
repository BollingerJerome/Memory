package application.presentation;

import application.domain.BoardModel;
import application.domain.Card;
import application.domain.DomainController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

	public Controller(DomainController domainController, BoardSizeView boardSizeView,
			MultiplayerPlayersView multiplayerPlayersView, BoardView boardView, InputPlayerNamesView inputPlayerNamesView) {
		this.domainController = domainController;
		this.boardSizeView = boardSizeView;
		this.multiplayerPlayersView = multiplayerPlayersView;
		this.boardView = boardView;
		this.inputPlayerNamesView = inputPlayerNamesView;
	}
	
	
	private BoardSizeView boardSizeView;
	private DomainController domainController;
	private BoardView bordView;
	private MultiplayerPlayersView multiplayerPlayersView;
	private BoardView boardView;
	private InputPlayerNamesView inputPlayerNamesView;
	
	
	
	
	//Home Buttons
	public void showBoardSizeView(Button button) {
		Stage primaryStage = (Stage) button.getScene().getWindow();
		primaryStage.setScene(boardSizeView.getScene());
	}
	public void setMultiplayerPlayersView(Button button) {
		Stage primaryStage = (Stage) button.getScene().getWindow();
		primaryStage.setScene(multiplayerPlayersView.getMultiplayersViewScene());
	}
	
	//BoardSizeButtons
	public void showBoard(Button button) {
		Stage primaryStage = (Stage) button.getScene().getWindow();
		primaryStage.setScene(new Scene(boardView.setupCards()));
	}
	public void setBoardSize(int size) {
		System.out.println("controller executed");
		domainController.setBoardSize(size);
	}
	public void turn(Card card) {
		domainController.turn(card);
	}
	
	
	//BoardView
	public BoardModel getBoardModel() {
		return domainController.getBoardModel();
	}
	
	public void showInputPlayerNamesView(Button button) {
		Stage primaryStage = (Stage) button.getScene().getWindow();
		primaryStage.setScene(inputPlayerNamesView.getInputPlayerNamesViewScene());
	}
	
	//Playerplayers
	public void setNumberOfPlayers(int a) {
		domainController.setNumberOfPlayers(a);
	}
	
	public int getNumberOfPlayers() {
		return domainController.getNumberOfPlayers();
	}

	public void setPlayerName(int i, String name) {
		domainController.setPlayerName(i, name);
	}
	
	
	//else
	public BoardSizeView getBoardSizeView() {
		return boardSizeView;
	}
	public void setBoardSizeView(BoardSizeView boardSizeView) {
		this.boardSizeView = boardSizeView;
	}
	public DomainController getDomainController() {
		return domainController;
	}
	public void setDomainController(DomainController domainController) {
		this.domainController = domainController;
	}
	public BoardView getBordView() {
		return bordView;
	}
	public void setBordView(BoardView bordView) {
		this.bordView = bordView;
	}
	public MultiplayerPlayersView getMultiplayerPlayersView() {
		return multiplayerPlayersView;
	}
	public void setMultiplayerPlayersView(MultiplayerPlayersView multiplayerPlayersView) {
		this.multiplayerPlayersView = multiplayerPlayersView;
	}
	public BoardView getBoardView() {
		return boardView;
	}
	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}
	public InputPlayerNamesView getInputPlayerNamesView() {
		return inputPlayerNamesView;
	}
	public void setInputPlayerNamesView(InputPlayerNamesView inputPlayerNamesView) {
		this.inputPlayerNamesView = inputPlayerNamesView;
	}
	
}
