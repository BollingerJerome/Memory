package application.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.services.FileController;

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
		// Initialise the game - this is the same thing as is done in the MemoryApp
		
		// THIS DOES NOT WORK
		FileController fileController = new FileController();
		StatisticModel statisticModel = new StatisticModel();
		WonModel wonModel = new WonModel();
		BoardModel boardModel = new BoardModel(600,600);
		PlayModel playModel = new PlayModel();
		TimeModel timeModel = new TimeModel();
		DomainController domainController = new DomainController(boardModel, playModel, wonModel, timeModel, statisticModel, fileController);
				
		// Now we turn a card
		Card card = new Card(10, 10, false, false, 10, 10);
		domainController.turn(card);
		
		// turn is 0, card is not open and not found. It should be the case that the turn then goes to 1	
		assertEquals(playModel.getTurn(), 1);
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
