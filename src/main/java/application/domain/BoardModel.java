package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BoardModel extends Boardprops{

		//constructor
	public BoardModel(double width, double height) {
		super(width, height);
	}
	
	
		//I use the term tiles in some variable names, so I don't mistake them for card objects
		//but with tiles I mean cards

	private Boardprops boardprops;	//width and height property of the board (important for the card object)
	private Card[][] field;			//Card[][] array contains every card-object
	private int horizontalTiles;	//how many cards there are horizontally
	private int verticalTiles;		//how many cards there are vertically
	private int[][] positonsOfIndex;//this array[2][cardsInTotal] contains the indexes of cards but is only used to make cards random. this is not a important array for the playLogic
	private final PropertyChangeSupport changes = new PropertyChangeSupport( this );
		//gets fired if a value is changed. In this class the boardviewclass has to know whether the amount of cards has changed or not
		
		//add and remove propertychangelisteners
	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		changes.addPropertyChangeListener( listener );
	}

	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		changes.removePropertyChangeListener( listener );
	}

	
		//this method returns an array[x][y] filled with card objects. this is to initialize the field variable
		//it is called from the setBoardsize method down below to "fill" the field variable
	public Card[][] fillField(BoardModel boardModel, double width, double height) {
		Card[][] cardArray = new Card[horizontalTiles][verticalTiles];
		int hor = boardModel.getHorizontalTiles();	//having variables here instead in the for loop reduces runtime
		int ver = boardModel.getVerticalTiles();

		for(int i= 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) { //each coordinate gets a Card object
				cardArray[i][j] = new Card(width, height, false, false, i, j);
			}
		}
		return cardArray;
	}
	
	
		//method returns true if all found variables of card objects are true
	public boolean iswon() {
		int hor = getHorizontalTiles();	//having variables here instead in the for loop reduces runtime
		int ver = getVerticalTiles();
		for(int i= 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				if(!field[i][j].isFound()) { //should one card be not found, the loop can stop and returns false
					return false;
				}
			}
		}
		return true;	//program gets here if the statement above was never true
	}

		//method to set the amount of totalcards.
		//this method gets called in the boardSizeview
	public void setBoardSize(int size) {
		BoardModel oldboardModel = this;	//oldObject for the firepropertychange below
		setHorizontalTiles(size);			//sets the new value of horizontalTile
		setVerticalTiles(size);				// ""
		//almost every other variable depends on those two variables. that is why I need to "update"
		//these variables:
		this.positonsOfIndex = new int[2][horizontalTiles*verticalTiles];
		positonsOfIndex = HelperClass.randomizeMemoryBoard(horizontalTiles, verticalTiles); //HelperClass contains the static method to randomize the card placement
		this.field = new Card[horizontalTiles][verticalTiles];
		this.field = fillField(this, this.getWidth()/horizontalTiles,  this.getHeight()/verticalTiles);
		//telling boardview or controller that the size has been changed
		changes.firePropertyChange("boardModel", oldboardModel, this);
	}
	
	//rest of getters and setters
	
	public int getHorizontalTiles() {
		return horizontalTiles;
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
