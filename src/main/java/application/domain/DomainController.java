package application.domain;

public class DomainController {

	public DomainController(BoardModel boardModel, PlayModel playModel, PlayerModel playerModel) {
		this.boardModel = boardModel;
		this.playModel = playModel;
		this.playerModel = playerModel;
	}

	private BoardModel boardModel;
	private PlayModel playModel;
	private PlayerModel playerModel;


	public void turn(Card card) {
		playModel.turn(card);
	}

	public void setBoardSize (int a) {
		System.out.println("setSize");
		boardModel.setBoardSize(a);
	}

	public BoardModel getBoardModel() {
		return boardModel;
	}

	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}

	public void setNumberOfPlayers(int a) {
		PlayerModel[] playerModele = new PlayerModel[a];
		playModel.setPlayerModel(playerModele);
	}
	
	public int getNumberOfPlayers() {
		return playModel.getPlayerModel().length;
	}

}
