package application.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelperClassTest {

	@Test
	public void testRandomizeMemoryBoard() { // This tests whether the function randomizeMemoryBoard actually randomizes the board
		int [][] boardOne = HelperClass.randomizeMemoryBoard(10, 10);
		
		int [][] boardTwo = HelperClass.randomizeMemoryBoard(10, 10);
		
		// These two board cannot be equal
		assertNotEquals(boardOne, boardTwo);
		
		
	}

}
