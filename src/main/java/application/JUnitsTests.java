package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitsTests {

	@Test
	public void cardsCorrectlyIdentified() { // This tests whether two cards are correctly identified as the same or different
		// Create two cards
		Card cardOne = new Card(10, 10, true, true, 10, 10); // height, width, x and y are irrelevant. open and found true to simulate case 2 
				// in turn function
		Card cardTwo = new Card(10, 10, true, true, 20, 20);
		
		// Set the IDs of the cards using setPairId
		cardOne.setPairId(1);
		cardTwo.setPairId(1);
		
		// Assert that isTheSame(cardOne, cardTwo) returns true
		assertEquals(isTheSame(cardOne, cardTwo), true);	
		
	}
}
