package application;

public class MultiplayerBoard extends Board {

	
	
	public MultiplayerBoard(double horizontalTiles, double verticalTiles, double width, double heigth,
			 int players) {
		super(horizontalTiles, verticalTiles, width, heigth);
		PlayerNames = new String[players];
		this.players = players;
		PlayerPoints = new int[players];
	}
	
	private String[] PlayerNames;
	private int players;
	private int[] PlayerPoints;
	
	
	
	
	public void playersTurn() {
		
	}
	
	
	
	
	
	
	public String[] getPlayerNames() {
		return PlayerNames;
	}
	public void setPlayerNames(String[] playerNames) {
		PlayerNames = playerNames;
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}
	public int[] getPlayerPoints() {
		return PlayerPoints;
	}
	public void setPlayerPoints(int[] playerPoints) {
		PlayerPoints = playerPoints;
	}
}
