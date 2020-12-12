package application.domain;

import junit.framework.TestCase;

public class PlayModelTest extends TestCase {

	public void testReset() {
		PlayModel playModel = new PlayModel();
		playModel.setTurn(3);
		playModel.setRound(8);
		playModel.setPlayerTurn(2);
		
		playModel.reset();
		
		assertEquals(0, playModel.getTurn());
		assertEquals(0, playModel.getRound());
		assertEquals(0, playModel.getPlayerTurn());
		
	}
	
	public void testSetPlayerModel() {
		PlayModel playModel = new PlayModel();
		playModel.setPlayerModel(3);
		
		assertEquals(3, playModel.getPlayerModel().length);
		assertEquals("Player 2", playModel.getPlayerModel()[1].getName());
	}
	
}
