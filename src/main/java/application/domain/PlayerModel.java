package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerModel {
	
	//Constructor 
	public PlayerModel(String name) {
		this.name = name;
		this.point = 0;
	}
	
	private int point;	//every player has points
	private String name;
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this ); 
	//changes will be fired when a new point is set 

	//addPropertyChangelistener is probably called in Boardviewclass.
	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		changes.addPropertyChangeListener( listener );
	}
	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		changes.removePropertyChangeListener( listener );
	}
	
	//calls setpoint method to add a point
	public void addPoint() {
		setPoint(getPoint()+1);
	}
	
	public int getPoint() {
		return point;
	}
	
	//firePropertychange when new point is set.
	//in controller class is defined what will happen, when point value is changed
	public void setPoint(int point) {
		int oldpoint = this.point;
		this.point = point;
		changes.firePropertyChange("point", oldpoint, point);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
