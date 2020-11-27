package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerPoint {

    private int[] points;

    public PlayerPoint(int[] points) {
        this.points = points;
    }

    private final PropertyChangeSupport changes = new PropertyChangeSupport( this );

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public void setPointForPlayer(int playerId) {
        int oldPoints = points[playerId];
        points[playerId]++;
        changes.firePropertyChange( "points", oldPoints, points[playerId] );
    }

    public int getPointForPlayer(int playerId) {
        return points[playerId];
    }

    public void addPropertyChangeListener( PropertyChangeListener listener ) {
        changes.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener( PropertyChangeListener listener ) {
        changes.removePropertyChangeListener( listener );
    }


}
