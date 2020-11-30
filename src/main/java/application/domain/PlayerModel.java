package application.domain;

public class PlayerModel {

	public PlayerModel() {}
	
	public PlayerModel(int point, int id, String name) {
		super();
		Point = point;
		this.id = id;
		this.name = name;
	}
	private int Point;
	private int id;
	private String name;
	public int getPoint() {
		return Point;
	}
	public void setPoint(int point) {
		Point = point;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
