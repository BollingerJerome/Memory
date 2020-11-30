package application.presentation;

import java.beans.PropertyChangeListener;

import application.domain.BoardModel;
import application.domain.Card;
import application.domain.DomainController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

	public Controller(DomainController domainController, BoardSizeView boardSizeView,
			MultiplayerPlayersView multiplayerPlayersView, BoardView boardView, InputPlayerNamesView inputPlayerNamesView,
			StatsView statsView, Home home) {
		this.domainController = domainController;
		this.boardSizeView = boardSizeView;
		this.multiplayerPlayersView = multiplayerPlayersView;
		this.boardView = boardView;
		this.inputPlayerNamesView = inputPlayerNamesView;
		this.statsView = statsView;
		this.home = home;
	}
	
	private Home home;
	private BoardSizeView boardSizeView;
	private DomainController domainController;
	private BoardView bordView;
	private MultiplayerPlayersView multiplayerPlayersView;
	private BoardView boardView;
	private InputPlayerNamesView inputPlayerNamesView;
	private StatsView statsView;
	private Stage primaryStage;
	
	
	//Home Buttons
	public void showBoardSizeView(Button button) {
		this.primaryStage = (Stage) button.getScene().getWindow();
		Stage primaryStage = (Stage) button.getScene().getWindow();
		primaryStage.setScene(boardSizeView.getScene());
	}
	public void setMultiplayerPlayersView(Button button) {
		Stage primaryStage = (Stage) button.getScene().getWindow();
		primaryStage.setScene(multiplayerPlayersView.getMultiplayersViewScene());
	}
	
	public void showHome() {
		primaryStage.setScene(home.getScene());
	}
	
	//BoardSizeButtons
	public void showBoard(Button button) {
		Stage primaryStage = (Stage) button.getScene().getWindow();
		primaryStage.setScene(boardView.setupCards());
	}
	public void setBoardSize(int size) {
		domainController.setBoardSize(size);
	}
	public void turn(Card card) {
		domainController.turn(card);
	}
	public void resetBoard() {
		
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
		for(int i = 0; i<a; i++) {
			domainController.getPlayersModel()[i].addPropertyChangeListener(e -> boardView.updatePlayerPoints());
		}
	}
	
	public int getNumberOfPlayers() {
		return domainController.getNumberOfPlayers();
	}

	//inputplayerNames
	public void setPlayerName(int i, String name) {
		domainController.setPlayerName(i, name);
	}
	public String getPlayerName(int i) {
		return domainController.getPlayerName(i);
	}
	public int getPlayerPoint(int i) {
		return domainController.getPlayerPoint(i);
	}
	
	
	//stats
	
	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		domainController.addPropertyChangeListener(listener);
	}
	
	public void showStats() {
		primaryStage.setScene(statsView.showStatsView());
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
	public StatsView getStatsView() {
		return statsView;
	}
	public void setStatsView(StatsView statsView) {
		this.statsView = statsView;
	}
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
	
}
