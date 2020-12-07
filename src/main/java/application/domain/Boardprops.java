package application.domain;

public abstract class Boardprops {
		
		//constructor of this abstract class
		//this is here to separate width and height variables from the boardModel
		//might better be in presentation, because it depends on the screen
	public Boardprops(double width, double height) {
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
