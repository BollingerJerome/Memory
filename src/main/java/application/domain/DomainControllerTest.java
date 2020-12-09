package application.domain;

import static org.junit.Assert.*;
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
		BoardModel boardModel = new BoardModel(200,200);
	    Card[][] fielde = new Card[2][2];
	    fielde[0][0] = new Card(10, 10, false, false, 0, 0);
	    fielde[0][1] = new Card(10, 10, false, false, 0, 1);
	    fielde[1][0] = new Card(10, 10, false, false, 1, 0);
	    fielde[1][1] = new Card(10, 10, false, false, 1, 1);
	    boardModel.setField(fielde);
	    PlayModel playModel = new PlayModel();
	    
	    WonModel wonModel = new WonModel();
	    TimeModel timeModel = new TimeModel();
	    StatisticModel statisticModel = new StatisticModel();
	    FileController fileController = new FileController();
	    
	    DomainController domainController = new DomainController(boardModel, playModel, 
			wonModel, timeModel, statisticModel, fileController);
	    
				
		// Now we turn a card
		domainController.turn(fielde[0][0]);
		
		// turn is 0, card is not open and not found. It should be the case that the turn then goes to 1	
		assertEquals(playModel.getTurn(), 1);
		
		// FROM HERE DOESNT WORK BECAUSE HAVE NOT DEFINED PLAYERS
		// Now we turn a second card
		domainController.turn(fielde[0][1]);
		
		// turn is 1, card is not open and not found. IT should be the case that the turn then goes to 2
		assertEquals(playModel.getTurn(), 2);
	}
}
