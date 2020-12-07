package application.domain;

import java.beans.PropertyChangeListener;

import application.services.FileController;

public class DomainController {

	public DomainController(BoardModel boardModel, PlayModel playModel, 
			WonModel wonModel, FileController fileController) {
		this.boardModel = boardModel;
		this.playModel = playModel;
		this.wonModel = wonModel;
		this.fileController = fileController;
	}

	private BoardModel boardModel;
	private PlayModel playModel;
	private WonModel wonModel;
	private FileController fileController;
	
	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		wonModel.addPropertyChangeListener(listener);
	}
	
	public void setWon(boolean won) {
		wonModel.setWon(won);
	}
	
	public boolean iswon() {
		return boardModel.iswon();
	}
	
	public void setPlayerName(int i, String name) {
		playModel.getPlayerModel()[i].setName(name);
	}
	
	public void turn(Card card) {
		playModel.turn(card);
	}

	public void setBoardSize (int a) {
		boardModel.setBoardSize(a);
	}

	public BoardModel getBoardModel() {
		return boardModel;
	}

	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}

	public void setNumberOfPlayers(int a) {
		playModel.setPlayerModel(a);
	}
	
	public int getNumberOfPlayers() {
		return playModel.getPlayerModel().length;
	}
	
	public int getPlayerPoint(int i) {
		return playModel.getPlayerPoint(i);
	}
	
	public String getPlayerName(int i) {
		return playModel.getPlayerModel()[i].getName();
	}
	
	public PlayerModel[] getPlayersModel() {
		return playModel.getPlayerModel();
	}

	public FileController getFileController() {
		return fileController;
	}

	public void setFileController(FileController fileController) {
		this.fileController = fileController;
	}

}
