package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BoardModel {

	public BoardModel(Boardprops boardprops) {
		this.boardprops = boardprops;
		
	}

	private Boardprops boardprops;
	private Card[][] field;
	private int horizontalTiles;
	private int verticalTiles;
	private int[][] positonsOfIndex;
	private WonModel wonModel;
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this );

	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		changes.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		changes.removePropertyChangeListener( listener );
	}

	public Card[][] fillBoard(BoardModel boardModel, double width, double height) {
		Card[][] field = new Card[horizontalTiles][verticalTiles];
		int hor = boardModel.getHorizontalTiles();
		int ver = boardModel.getVerticalTiles();

		for(int i= 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				field[i][j] = new Card(width, height, false, false, i, j);
			}
		}
		return field;
	}
	
	public boolean iswon() {
		int hor = getHorizontalTiles();
		int ver = getVerticalTiles();
		for(int i= 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				if(!field[i][j].isFound()) {
					return false;
				}
			}
		}
		return true;
	}



	public int getHorizontalTiles() {
		return horizontalTiles;
	}

	public void setBoardSize(int a) {
		BoardModel oldboardModel = this;
		setHorizontalTiles(a);
		setVerticalTiles(a);
		this.positonsOfIndex = new int[2][horizontalTiles*verticalTiles];
		positonsOfIndex = HelperClass.randomizeMemoryBoard(horizontalTiles, verticalTiles);
		this.field = new Card[horizontalTiles][verticalTiles];
		this.field = fillBoard(this, boardprops.getWidth()/horizontalTiles, boardprops.getHeight()/verticalTiles);
		
		changes.firePropertyChange("boardModel", oldboardModel, this);
	}
	
	public void setHorizontalTiles(int horizontalTiles) {
		this.horizontalTiles = horizontalTiles;

	}

	public int getVerticalTiles() {
		return verticalTiles;
	}

	public void setVerticalTiles(int verticalTiles) {
		this.verticalTiles = verticalTiles;
		
	}

	public Boardprops getBoardprops() {
		return boardprops;
	}

	public void setBoardprops(Boardprops boardprops) {
		this.boardprops = boardprops;
	}

	public Card[][] getField() {
		return field;
	}

	public void setField(Card[][] field) {
		this.field = field;
	}

	public int[][] getPositonsOfIndex() {
		return positonsOfIndex;
	}

	public void setPositonsOfIndex(int[][] positonsOfIndex) {
		this.positonsOfIndex = positonsOfIndex;
	}

}
