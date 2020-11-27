package application.domain;

public class BoardModel {
	
	public BoardModel(int horizontalTiles, int verticalTiles, Boardprops boardprops) {
		this.boardprops = boardprops;
		this.horizontalTiles = horizontalTiles;
		this.verticalTiles = verticalTiles;
		this.positonsOfIndex = new int[2][horizontalTiles*verticalTiles];
		positonsOfIndex = HelperClass.randomizeMemoryBoard(horizontalTiles, verticalTiles);
		this.field = new Card[horizontalTiles][verticalTiles];
		this.field = fillBoard(this, boardprops.getWidth()/horizontalTiles, boardprops.getHeight()/verticalTiles);
	}
	
	private Boardprops boardprops;
	private Card[][] field;
	private int horizontalTiles, verticalTiles;
	private int[][] positonsOfIndex;
	
	public Card[][] fillBoard(BoardModel boardModel, double width, double height) {
		Card[][] field = new Card[horizontalTiles][verticalTiles];
		int hor = boardModel.getHorizontalTiles();
		int ver = boardModel.getVerticalTiles();
		
		for(int i= 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				field[i][j] = new Card(width, height, false, false);
			}
		}
		return field;
	}
	

	
	

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
