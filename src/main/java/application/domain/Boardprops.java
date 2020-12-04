package application.domain;

public class Boardprops {

	public Boardprops(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	private double width, height;

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
}
