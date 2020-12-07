package application.domain;

public class StatisticModel {

	
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
	
	
	public void write() {
		String entry = "E" + "." + boardSize +"." + name + "." + time + "." + points + "." + rounds;
		System.out.println(entry);
	}
	
	
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
