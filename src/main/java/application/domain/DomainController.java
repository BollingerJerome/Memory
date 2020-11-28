package application.domain;

public class DomainController {
	
	
	
	public DomainController(BoardModel boardModel, PlayModel playModel) {
		this.boardModel = boardModel;
		this.playModel = playModel;
	}



	private BoardModel boardModel;
	private PlayModel playModel;
	
	public void turn(Card card) {
		playModel.turn(card);
	}
	
	public void setBoardSize (int a) {
		boardModel.setHorizontalTiles(a);
		boardModel.setVerticalTiles(a);
	}
	
}
