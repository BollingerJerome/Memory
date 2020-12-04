package application.domain;

import java.beans.PropertyChangeListener;

public class DomainController {

	public DomainController(BoardModel boardModel, PlayModel playModel, WonModel wonModel) {
		this.boardModel = boardModel;
		this.playModel = playModel;
		this.wonModel = wonModel;
	}

	private BoardModel boardModel;
	private PlayModel playModel;
	private WonModel wonModel;
	
	
	
	public boolean isTheSame(Card cardOne, Card cardTwo) {
		if(cardOne.getPairId() == cardTwo.getPairId()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void turn(Card card) {		
		switch(playModel.getTurn()) {
		case 0:
			if(!card.isOpen()) {
				if(!card.isFound()) {
					playModel.setPosition(card);
					boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setOpen(true);
					playModel.setTurn(playModel.getTurn()+1);
					return;
				}				
			}
			return;
		case 1:
			if(!card.isOpen() && !card.isFound() ) {
				playModel.setPosition(card);
				boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setOpen(true);
				if(isTheSame(card, boardModel.getField()[playModel.getLastX()][playModel.getLastY()])) {
					playModel.getPlayerModel()[playModel.getPlayerTurn()].addPoint();
					boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setFound(true);
					boardModel.getField()[playModel.getLastX()][playModel.getLastY()].setFound(true);
					if(boardModel.iswon()) {
						wonModel.setWon(true);
					}
					playModel.setRound(playModel.getRound()+1);
					playModel.setTurn(0);
				}
				else {
					playModel.setTurn(playModel.getTurn()+1);
				}
				return;
			}
			return;
		case 2:
			boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setOpen(false);
			boardModel.getField()[playModel.getLastX()][playModel.getLastY()].setOpen(false);
			playModel.setTurn(0);
			playModel.setPlayerTurn((playModel.getPlayerTurn()+1)%playModel.getPlayerModel().length);
			playModel.setRound(playModel.getRound()+1);
			return;
		}
		return;
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

	public PlayModel getPlayModel() {
		return playModel;
	}

	public void setPlayModel(PlayModel playModel) {
		this.playModel = playModel;
	}

	public WonModel getWonModel() {
		return wonModel;
	}

	public void setWonModel(WonModel wonModel) {
		this.wonModel = wonModel;
	}

}
