package application.domain;

public class PlayModel {

	public PlayModel() {
		this.turn = 0;
		this.round = 0;
		this.playerModel = new PlayerModel[1];
		this.playerTurn = 0;
	}

	private int turn;
	private int round;
	private int currentX;
	private int currentY;
	private int lastX;
	private int lastY;
	private PlayerModel[] playerModel;
	private int playerTurn;
	private DomainController domainController;

	

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
	public int getPlayerPoint(int i) {
		return playerModel[i].getPoint();
	}

	public void setPlayerModel(int a) {
		this.playerModel = new PlayerModel[a];
		for (int i = 0; i<a; i++) {
			String defaultName = "Player " + (i+1) +": ";
			playerModel[i] = new PlayerModel(0, defaultName);
		}
	}

	public DomainController getDomainController() {
		return domainController;
	}

	public void setDomainController(DomainController domainController) {
		this.domainController = domainController;
	}


	public int getCurrentX() {
		return currentX;
	}


	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}


	public int getCurrentY() {
		return currentY;
	}


	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}


	public int getLastX() {
		return lastX;
	}


	public void setLastX(int lastX) {
		this.lastX = lastX;
	}


	public int getLastY() {
		return lastY;
	}


	public void setLastY(int lastY) {
		this.lastY = lastY;
	}


	public int getPlayerTurn() {
		return playerTurn;
	}


	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}


	public void setPlayerModel(PlayerModel[] playerModel) {
		this.playerModel = playerModel;
	}


}
