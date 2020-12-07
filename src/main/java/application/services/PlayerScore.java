package application.services;

public class PlayerScore {
	
	public PlayerScore(String name, String time, String rounds) {
		this.name = name;
		this.time = time;
		this.rounds = rounds;
	}
	
	private String name;
	private String time;
	private String rounds;
	
	public String getScoreString() {
		String score = "Name: " + name +" Time: " + time + " rounds: " + rounds;
		return score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRounds() {
		return rounds;
	}
	public void setRounds(String rounds) {
		this.rounds = rounds;
	}

}
