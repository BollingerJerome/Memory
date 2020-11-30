package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Card {
	
	public Card(double widht, double height, boolean open, boolean found, int x, int y) {
		this.widht = widht;
		this.height = height;
		this.open = open;
		this.found = found;
		this.x = x;
		this.y = y;
	}
	
	private int pairId;
	private int x,y;
	private double widht, height;
	private boolean open;
	private boolean found;
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this );

	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		changes.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		changes.removePropertyChangeListener( listener );
	}
	
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
		boolean oldOpen = this.open;
		this.open = open;
		changes.firePropertyChange( "open", oldOpen, open );
	}
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getPairId() {
		return pairId;
	}

	public void setPairId(int pairId) {
		this.pairId = pairId;
	}
	

}
