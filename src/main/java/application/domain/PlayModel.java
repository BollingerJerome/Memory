package application.domain;

public class PlayModel {

	//constructor for new playModel.
	public PlayModel() {
		this.turn = 0;
		this.round = 0;
		this.playerModel = new PlayerModel[1]; //having the default array be one element long
		this.playerTurn = 0;
	}

	private int turn;		//current step of a round (all cards down, one card open, both cards open)
	private int round;		//which round it is
	private int currentX;	//x position of the clicked card in the Card[x][y] array
	private int currentY; 	//y position of the clicked card in the Card[x][y] array
	private int lastX;		//x position of the last clicked card in the Card[x][y] array
	private int lastY;		//y position of the last clicked card in the Card[x][y] array
	private PlayerModel[] playerModel;	//Array of PlayerModelClass objects
	private int playerTurn;				//which player is currently playing each round
	private DomainController domainController;	//domainController object

	
	//updating the x an y coordinates of the cards
	public void setPosition(Card card) {			
		lastX = currentX;				
		lastY = currentY;
		currentX = card.getX();
		currentY = card.getY();
	}
	
	//initializing the playerModel[] array
	public void setPlayerModel(int players) {
		this.playerModel = new PlayerModel[players];	//I want an array of PlayerModels with length of players
		for (int i = 0; i<players; i++) {
			String defaultName = "Player " + (i+1) +": ";	//setting a default name for each player (those names can be overwritten in the MultiplayerPlayersview)
			playerModel[i] = new PlayerModel(defaultName);	//each player has a name
		}
	}
	
	
	
	//getters and setters
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
