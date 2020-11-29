package application.domain;

public class MultiplayerBoardModel extends BoardModel {

	
	public MultiplayerBoardModel(int horizontalTiles, int verticalTiles, Boardprops boardprops, int players) {
		super(horizontalTiles, verticalTiles, boardprops);
		this.players = players;
	}

	private int players;
	private String[] playerNames;

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	public void setPlayerName(int a, String name) {
		playerNames[a] = name; 
	}
	public String getPlayerName(int a) {
		return playerNames[a];
	}
	
	public String[] getPlayerNames() {
		return playerNames;
	}

	public void setPlayerNames(String[] playerNames) {
		this.playerNames = playerNames;
	}
	
}
