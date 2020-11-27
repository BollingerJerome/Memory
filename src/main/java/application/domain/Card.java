package application.domain;

public class Card {
	
	
	
	public Card(double widht, double height, boolean open, boolean found) {
		super();
		this.widht = widht;
		this.height = height;
		this.open = open;
		this.found = found;
	}
	
	
	private double widht, height;
	private boolean open;
	private boolean found;
	
	
	public double getWidht() {
		return widht;
	}
	public void setWidht(double widht) {
		this.widht = widht;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	

}
