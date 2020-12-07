package application.domain;

public class StatisticModel {

	//this class saves the info of the game stats for the services
	public StatisticModel() {
	}
	
	public StatisticModel(int boardSize, String name, int time, int points, int rounds) {
		this.boardSize = boardSize;
		this.name = name;
		this.time = time;
		this.points = points;
		this.rounds = rounds;
	}
	
	
	
	private int boardSize;
	private String name;
	private int time;
	private int points;
	private int rounds;
	
	
	//this method returns the entry as a string for the filewriter
	public String write() {
		String entry = boardSize +"." + name + "." + time + "." + points + "." + rounds +"\n";
		System.out.println(entry);
		return entry;
	}
	
	
	//getters and setters;
	public int getBoardSize() {
		return boardSize;
	}
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getRounds() {
		return rounds;
	}
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
}
