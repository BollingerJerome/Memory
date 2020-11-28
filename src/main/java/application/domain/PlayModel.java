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

	public void playFlow(Card card) {
		switch(turn) {
		case 0:
			if(setPosition(card)) {
				board.getField()[currentX][currentY].setOpen(true);
			}
			break;
		case 1:
			if(setPosition(card)) {
				board.getField()[currentX][currentY].setOpen(true);
				System.out.println("second open");
			}
			break;
		case 2:
			if(true) {
				board.getField()[currentX][currentY].setOpen(false);
				board.getField()[lastX][lastY].setOpen(false);
			}
		}
	}

	public void turn(Card card) {
		playFlow(card);
		if(round%3 == 0) {
			turn = 0;
		}
		else {
			turn++;
		}
		round++;
	}

	public boolean setPosition(Card card) {			
		System.out.println("is this card:" + card.getX() + card.getY());
		if(!card.isOpen()) {
			lastX = currentX;
			lastY = currentY;
			currentX = card.getX();
			currentY = card.getY();
			return true;
		}
		else {
			return false;
		}
		
		
		
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


}
