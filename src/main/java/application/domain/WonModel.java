package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WonModel {

	public WonModel() {
		this.won = false;
	}

	private boolean won;
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this );

	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		changes.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		changes.removePropertyChangeListener( listener );
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		boolean oldWon = this.won;
		this.won = won;
		if(won) {
			changes.firePropertyChange("Won", oldWon, won);
		}
	}

}
