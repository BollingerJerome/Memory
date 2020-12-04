package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerModel {

	public PlayerModel() {}
	
	public PlayerModel(int point, String name) {
		point = point;
		this.name = name;
	}
	private int point;
	private String name;
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this );

	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		changes.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		changes.removePropertyChangeListener( listener );
	}
	
	public int getPoint() {
		return point;
	}
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
