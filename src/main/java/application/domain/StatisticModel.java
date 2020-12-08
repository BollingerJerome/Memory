package application.domain;

public class StatisticModel {

	//this class saves the info of the game stats for the services
	public StatisticModel() {
	}
	
	public StatisticModel(String name, int time, int rounds) {
		this.name = name;
		this.time = time;
		this.rounds = rounds;
	}
	
	
	
	private String name;
	private int time;
	private int rounds;
	
	
	//this method returns the entry as a string for the filewriter
	public String write() {
		String entry =name + "." + time + "." + rounds +"\n";
		System.out.println(entry);
		return entry;
	}
	
	
	//getters and setters;

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
	public int getRounds() {
		return rounds;
	}
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
}
