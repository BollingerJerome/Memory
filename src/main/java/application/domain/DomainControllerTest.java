package application.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DomainControllerTest {
	@Test
	public void testIsTheSame() { // Check with two set cards whether this method works
		DomainController domainController = new DomainController(null, null, null, null, null, null);
		
		// First create two cards
		Card cardOne = new Card(10, 10, true, true, 10, 10); // Syntax is Card(height, width, isOpen, isFound, x, y). None of these are 
		// relevant for the testing, as it will be the pairID which determines if the card match
		Card cardTwo = new Card(10, 10, true, true, 10, 10);
		
		// Then give the two cards the same ID
		cardOne.setPairId(1);
		cardTwo.setPairId(1);
				
		// Assert that isTheSame must equal true
		assertEquals(domainController.isTheSame(cardOne, cardTwo), true);
		
		// Now change one of the IDs
		cardOne.setPairId(2);
		
		// Assert that isTheSame must equal false
		assertEquals(domainController.isTheSame(cardOne, cardTwo), false);
	}
	
	@Test
	public void testTurnCorrectCase() { // This tests whether the correct turn is identified by the turn method		
		// Create a card which is open and found
		Card cardOne = new Card(10, 10, false, false, 10, 10);
		
		// Create a PlayModel and set turn to 0 (i.e. no card is open)
		PlayModel playModel = new PlayModel(); 
		playModel.setTurn(0);
		
		// Add the card to the PlayModel
		playModel.setPosition(cardOne);
		
		// Create BoardModel
		BoardModel boardModel = new BoardModel(10, 10);
		
		// Now create a DomainController class with this PlayModel and BoardModel
		DomainController domainController = new DomainController(boardModel, playModel, null, null, null, null);
		
		// Execute method turn on the card. The playModel should increase turns because the condition is  met
		domainController.turn(cardOne);
		
		// Check to make sure the turn is still at 0
		assertEquals(playModel.getTurn(),1);
		
		// Change the card characteristics to not open and found
		
		
	}
	
	/*
	@Test
	public void testSetWon() {
		fail("Not yet implemented");
	}

	@Test
	public void testIswon() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlayerName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBoardSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoardModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBoardModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumberOfPlayers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberOfPlayers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerPoint() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayersModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFileController() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFileController() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlayModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWonModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWonModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTimeModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTimeModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatisticModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStatisticModel() {
		fail("Not yet implemented");
	}
	*/

}
