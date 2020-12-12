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
	public void testTurnCorrectCaseDifferentCards() { // This tests whether the correct turn is identified by the turn method 
		// when two different cards are chosen	
		// Initialise the game
		// Set up a board model
		BoardModel boardModel = new BoardModel(200,200);
		
		// Create a field and fill it with cards, we have a 2x2 field
	    Card[][] field = new Card[2][2];
	    field[0][0] = new Card(10, 10, false, false, 0, 0);
	    field[0][1] = new Card(10, 10, false, false, 0, 1);
	    field[1][0] = new Card(10, 10, false, false, 1, 0);
	    field[1][1] = new Card(10, 10, false, false, 1, 1);
	    
	    // Give these cards IDs
	    field[0][0].setPairId(1);
	    field[0][1].setPairId(1);
	    field[1][0].setPairId(2);
	    field[1][1].setPairId(2);
	    
	    // Add this field to the board model
	    boardModel.setField(field);
	    
	    // Create a playModel
	    PlayModel playModel = new PlayModel();
	    
	    // Add players to the play model
	    playModel.setPlayerModel(2);
	    
	    // Create wonModel, timeModel, statisticModel and fileController
	    WonModel wonModel = new WonModel();
	    TimeModel timeModel = new TimeModel();
	    StatisticModel statisticModel = new StatisticModel();
	    FileController fileController = new FileController();
	    
	    // Add all of these to the domainController
	    DomainController domainController = new DomainController(boardModel, playModel, 
			wonModel, timeModel, statisticModel, fileController);
	    
	    // Check to make sure it goes 0 -> 1 -> 2 in turns when two cards which are NOT THE SAME are chosen
		// Now we turn a card
		domainController.turn(field[0][0]);
		
		// turn is 0, card is not open and not found. It should be the case that the turn then goes to 1	
		assertEquals(playModel.getTurn(), 1);
		
		// Now we turn a second card, which is NOT the same as the card already turned
		domainController.turn(field[1][1]);
		
		// turn is 1, card is not open and not found, and is not the same as the card already chosen. 
		// It should be the case that the turn then goes to 2
		assertEquals(playModel.getTurn(), 2);
	}
	
	@Test
	public void testTurnCorrectCaseSameCards() { // This tests whether the correct turn is identified by the turn method 
		// when two same cards are chosen	
		// Initialise the game
		// Set up a board model
		BoardModel boardModel = new BoardModel(200,200);
		
		// Create a field and fill it with cards, we have a 2x2 field
	    Card[][] field = new Card[2][2];
	    field[0][0] = new Card(10, 10, false, false, 0, 0);
	    field[0][1] = new Card(10, 10, false, false, 0, 1);
	    field[1][0] = new Card(10, 10, false, false, 1, 0);
	    field[1][1] = new Card(10, 10, false, false, 1, 1);
	    
	    // Give these cards IDs
	    field[0][0].setPairId(1);
	    field[0][1].setPairId(1);
	    field[1][0].setPairId(2);
	    field[1][1].setPairId(2);
	    
	    // Add this field to the board model
	    boardModel.setField(field);
	    
	    // Create a playModel
	    PlayModel playModel = new PlayModel();
	    
	    // Add players to the play model
	    playModel.setPlayerModel(2);
	    
	    // Create wonModel, timeModel, statisticModel and fileController
	    WonModel wonModel = new WonModel();
	    TimeModel timeModel = new TimeModel();
	    StatisticModel statisticModel = new StatisticModel();
	    FileController fileController = new FileController();
	    
	    // Add all of these to the domainController
	    DomainController domainController = new DomainController(boardModel, playModel, 
			wonModel, timeModel, statisticModel, fileController);
	    
		// Check to make sure it goes 0 -> 1 -> 0 in turns when two cards which are the SAME are chosen
		// Turn a card
		domainController.turn(field[0][0]);
				
		// turn is 0, card is not open and not found. It should be the case that the turn then goes to 1	
		assertEquals(playModel.getTurn(), 1);
				
		// Turn a second card, which IS the same as the card already turned
		domainController.turn(field[0][1]);
				
		// turn is 1, card is not open and not found, and is the same as the card already chosen. 
		// It should be the case that the turn goes to 0
		assertEquals(playModel.getTurn(), 0);
	}
	
	@Test
	public void testTurnOpenCard() { // This tests whether the method correctly identifies an open card and does not increase turns 
		// if a card is chosen which has already been turned
		// Initialise the game
		// Set up a board model
		BoardModel boardModel = new BoardModel(200,200);
		
		// Create a field and fill it with cards, we have a 2x2 field
	    Card[][] field = new Card[2][2];
	    field[0][0] = new Card(10, 10, false, false, 0, 0);
	    field[0][1] = new Card(10, 10, false, false, 0, 1);
	    field[1][0] = new Card(10, 10, false, false, 1, 0);
	    field[1][1] = new Card(10, 10, false, false, 1, 1);
	    
	    // Give these cards IDs
	    field[0][0].setPairId(1);
	    field[0][1].setPairId(1);
	    field[1][0].setPairId(2);
	    field[1][1].setPairId(2);
	    
	    // Add this field to the board model
	    boardModel.setField(field);
	    
	    // Create a playModel
	    PlayModel playModel = new PlayModel();
	    
	    // Add players to the play model
	    playModel.setPlayerModel(2);
	    
	    // Create wonModel, timeModel, statisticModel and fileController
	    WonModel wonModel = new WonModel();
	    TimeModel timeModel = new TimeModel();
	    StatisticModel statisticModel = new StatisticModel();
	    FileController fileController = new FileController();
	    
	    // Add all of these to the domainController
	    DomainController domainController = new DomainController(boardModel, playModel, 
			wonModel, timeModel, statisticModel, fileController);
	    
		// Check to make sure it goes 0 -> 1 -> 1 in turns when the exact same card is turned twice
		// Turn a card
		domainController.turn(field[0][0]);
				
		// turn is 0, card is not open and not found. It should be the case that the turn then goes to 1	
		assertEquals(playModel.getTurn(), 1);
				
		// Turn the same card. It should be the case that the turn stays at 1 because nothing happens as the same card has been 
		// clicked
		domainController.turn(field[0][0]);
				
		// turn is 1, card is not open and not found, and is the same as the card already chosen. 
		// It should be the case that the turn goes to 0
		assertEquals(playModel.getTurn(), 1);
	}
	
	@Test
	public void testCorrectPointsAdded() { // This makes sure the points are correctly counted - points added when they should be
		// Initialise the game
		// Set up a board model
		BoardModel boardModel = new BoardModel(200,200);
		
		// Create a field and fill it with cards, we have a 2x2 field
	    Card[][] field = new Card[2][2];
	    field[0][0] = new Card(10, 10, false, false, 0, 0);
	    field[0][1] = new Card(10, 10, false, false, 0, 1);
	    field[1][0] = new Card(10, 10, false, false, 1, 0);
	    field[1][1] = new Card(10, 10, false, false, 1, 1);
	    
	    // Give these cards IDs
	    field[0][0].setPairId(1);
	    field[0][1].setPairId(1);
	    field[1][0].setPairId(2);
	    field[1][1].setPairId(2);
	    
	    // Add this field to the board model
	    boardModel.setField(field);
	    
	    // Create a playModel
	    PlayModel playModel = new PlayModel();
	    
	    // Add players to the play model - player 1 and player 2. These are the default names
	     playModel.setPlayerModel(2);
	    
	    // Create wonModel, timeModel, statisticModel and fileController
	    WonModel wonModel = new WonModel();
	    TimeModel timeModel = new TimeModel();
	    StatisticModel statisticModel = new StatisticModel();
	    FileController fileController = new FileController();
	    
	    // Add all of these to the domainController
	    DomainController domainController = new DomainController(boardModel, playModel, 
			wonModel, timeModel, statisticModel, fileController);
	    
	    // Score for player 1
	    int scorePlayerOne = playModel.getPlayerModel()[playModel.getPlayerTurn()].getPoint();
	    
		// Player 1 begins and turns a card
		domainController.turn(field[0][0]);
				
		// Turn a second card, which is the same
		domainController.turn(field[0][1]);
				
		// Make sure points have increased by 1
		assertEquals(playModel.getPlayerModel()[playModel.getPlayerTurn()].getPoint(), scorePlayerOne + 1);
	}
	
	@Test
	public void testPointsStaySame() { // This makes sure the points are correctly counted - no points added when they should not be
		// Initialise the game
		// Set up a board model
		BoardModel boardModel = new BoardModel(200,200);
		
		// Create a field and fill it with cards, we have a 2x2 field
	    Card[][] field = new Card[2][2];
	    field[0][0] = new Card(10, 10, false, false, 0, 0);
	    field[0][1] = new Card(10, 10, false, false, 0, 1);
	    field[1][0] = new Card(10, 10, false, false, 1, 0);
	    field[1][1] = new Card(10, 10, false, false, 1, 1);
	    
	    // Give these cards IDs
	    field[0][0].setPairId(1);
	    field[0][1].setPairId(1);
	    field[1][0].setPairId(2);
	    field[1][1].setPairId(2);
	    
	    // Add this field to the board model
	    boardModel.setField(field);
	    
	    // Create a playModel
	    PlayModel playModel = new PlayModel();
	    
	    // Add players to the play model - player 1 and player 2. These are the default names
	     playModel.setPlayerModel(2);
	    
	    // Create wonModel, timeModel, statisticModel and fileController
	    WonModel wonModel = new WonModel();
	    TimeModel timeModel = new TimeModel();
	    StatisticModel statisticModel = new StatisticModel();
	    FileController fileController = new FileController();
	    
	    // Add all of these to the domainController
	    DomainController domainController = new DomainController(boardModel, playModel, 
			wonModel, timeModel, statisticModel, fileController);
	    
	    // Score for player 1
	    int scorePlayerOne = playModel.getPlayerModel()[playModel.getPlayerTurn()].getPoint();
	    
		// Player 1 begins and turns a card
		domainController.turn(field[0][0]);
				
		// Turn a second card, which is not the same
		domainController.turn(field[1][1]);
				
		// Make sure points have not changed
		assertEquals(playModel.getPlayerModel()[playModel.getPlayerTurn()].getPoint(), scorePlayerOne);
	}
	
	@Test
	public void testWinCorrectlyIdentified() { // This makes sure a won board is correctly identified
		// Initialise the game
		// Set up a board model
		BoardModel boardModel = new BoardModel(200,200);
		
		// Create a field and fill it with cards, we have a 2x2 field
	    Card[][] field = new Card[2][2];
	    field[0][0] = new Card(10, 10, false, false, 0, 0);
	    field[0][1] = new Card(10, 10, false, false, 0, 1);
	    field[1][0] = new Card(10, 10, false, false, 1, 0);
	    field[1][1] = new Card(10, 10, false, false, 1, 1);
	    
	    // Give these cards IDs
	    field[0][0].setPairId(1);
	    field[0][1].setPairId(1);
	    field[1][0].setPairId(2);
	    field[1][1].setPairId(2);
	    
	    // Add this field to the board model
	    boardModel.setField(field);
	    
	    // Create a playModel
	    PlayModel playModel = new PlayModel();
	    
	    // Add players to the play model - player 1 and player 2. These are the default names
	     playModel.setPlayerModel(2);
	    
	    // Create wonModel, timeModel, statisticModel and fileController
	    WonModel wonModel = new WonModel();
	    TimeModel timeModel = new TimeModel();
	    StatisticModel statisticModel = new StatisticModel();
	    FileController fileController = new FileController();
	    
	    // Add all of these to the domainController
	    DomainController domainController = new DomainController(boardModel, playModel, 
			wonModel, timeModel, statisticModel, fileController);
	   	    
		// Player 1 begins and turns a card
		domainController.turn(field[0][0]);
				
		// Turn a second card, which is the same
		domainController.turn(field[0][1]);
				
		// Player 1 turns another card
		domainController.turn(field[1][0]);
		
		// Turn a second card, which is the same
		domainController.turn(field[1][1]);
		
		// It must now be the case that the board is won
		assertEquals(boardModel.iswon(), true);
	}
}
