package application.domain;

public class DomainController {

	public DomainController(BoardModel boardModel, PlayModel playModel) {
		this.boardModel = boardModel;
		this.playModel = playModel;
	}

	private BoardModel boardModel;
	private PlayModel playModel;
	

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

}
