package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WonModel {
		//constructor sets won variable to false
	public WonModel() {
		this.won = false;
	}
	
	//variable which saves whether current game has been won or not
	private boolean won;
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this );
	//changes has method firepropertychangesomething to allarm the game to go to the stats
	
	//add, remove propertychangelistener
	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		changes.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		changes.removePropertyChangeListener( listener );
	}

	//getter
	public boolean isWon() {
		return won;
	}
	//setter
	public void setWon(boolean won) {
		boolean oldWon = this.won;
		this.won = won;
		if(won) { //when won, firepropertychange -> show stats (should be in boardView class)
			changes.firePropertyChange("Won", oldWon, won);
		}
	}

}
