package application.domain;

public class PlayerModel {

	public PlayerModel() {}
	
	public PlayerModel(int point, String name) {
		Point = point;
		this.name = name;
	}
	private int Point;
	private String name;
	
	public int getPoint() {
		return Point;
	}
	public void setPoint(int point) {
		Point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
