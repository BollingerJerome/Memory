package application.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardModelTest {

	@Test
	public void testFillField() { // This tests whether the fillField method fills the field correctly
		// First, generate a field manually
		BoardModel boardModel = new BoardModel(10, 10); 
		
		Card[][] cardArrayManual = new Card[10][10]; // Dimensions here are 10 by 10
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cardArrayManual[i][j] = new Card(10, 10, false, false, i, j);
			}
		}
		
		// Now create the same field with the function
		boardModel.setHorizontalTiles(10);
		boardModel.setVerticalTiles(10);
		Card[][] cardArrayAutomatic = boardModel.fillField(boardModel, 10, 10);
		
		// These must be the same dimension
		// Dimensions manual
		int heightManual = cardArrayManual.length;
		int widthManual = cardArrayManual[0].length;
		
		// Dimensions automatic
		int heightAutomatic = cardArrayAutomatic.length;
		int widthAutomatic = cardArrayAutomatic[0].length;
		
		assertEquals(heightManual, heightAutomatic);
		assertEquals(widthManual, widthAutomatic);	
		
		
		// Each field must be filled with the same thing (card)
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				String typeManual = cardArrayManual[i][j].getClass().getName();
				String typeAutomatic = cardArrayAutomatic[i][j].getClass().getName();
				assertEquals(typeManual, typeAutomatic);
			}
		}
		
	}
	
	@Test
	public void testIsWon() { // This tests whether the isWon function correctly identifies a won board
		// Create a board where only one card is not found
		BoardModel boardModel = new BoardModel(10, 10); 
		
		Card[][] cardArrayManual = new Card[10][10]; // Dimensions here are 10 by 10
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 9 && j == 9) {
					cardArrayManual[i][j] = new Card(10, 10, false, false, i, j);
				} else {
					cardArrayManual[i][j] = new Card(10, 10, false, true, i, j);
				}
			}
		}
		
		boardModel.setField(cardArrayManual);
		boardModel.setHorizontalTiles(10);
		boardModel.setVerticalTiles(10);
		
		// It must be that the isWon function returns falls
		assertEquals(boardModel.iswon(), false);
	}
	
	@Test
	public void testSetBoardSize() {
		// Create a board with dimensions 10 by 10
		BoardModel boardModel = new BoardModel(10, 10); 
		boardModel.setHorizontalTiles(10);
		boardModel.setVerticalTiles(10);
		
		// Use setBoardSize function to change the dimensions to 20 by 20
		boardModel.setBoardSize(20);
		
		// It should now be that the Horizontal and Vertical Tiles are 20
		assertEquals(boardModel.getVerticalTiles(), 20);
		assertEquals(boardModel.getHorizontalTiles(), 20);
		
	}

}
