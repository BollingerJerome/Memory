package application.domain;

public class PlayModel {

	public PlayModel(BoardModel board) {
		this.board = board;
		this.turn = 0;
		this.round = 0;
	}

	private BoardModel board;
	private int turn;
	private int round;
	private int currentX;
	private int currentY;
	private int lastX;
	private int lastY;
	private PlayerModel[] playerModel;

	public boolean isTheSame(Card cardOne, Card cardTwo) {
		if(cardOne.getPairId() == cardTwo.getPairId()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean playFlow(Card card) {
		switch(turn) {
		case 0:
			if(!card.isOpen()) {
				if(!card.isFound()) {
					setPosition(card);
					board.getField()[currentX][currentY].setOpen(true);
					turn++;
					return true;
				}				
			}
			return false;
		case 1:
			if(!card.isOpen() && !card.isFound() ) {
				setPosition(card);
				board.getField()[currentX][currentY].setOpen(true);
				if(isTheSame(board.getField()[currentX][currentY], board.getField()[lastX][lastY])) {
					board.getField()[currentX][currentY].setFound(true);
					board.getField()[lastX][lastY].setFound(true);
					turn = 0;
				}
				else {
					turn++;
				}
				return true;
			}
			return false;
		case 2:
			board.getField()[currentX][currentY].setOpen(false);
			board.getField()[lastX][lastY].setOpen(false);
			turn = 0;
			return true;
		}
		return false;
	}

	public void turn(Card card) {
		playFlow(card);
		round++;
	}

	public void setPosition(Card card) {			
		lastX = currentX;
		lastY = currentY;
		currentX = card.getX();
		currentY = card.getY();
	}


	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}

	public PlayerModel[] getPlayerModel() {
		return playerModel;
	}

	public void setPlayerModel(PlayerModel[] playerModel) {
		this.playerModel = playerModel;
	}


}
