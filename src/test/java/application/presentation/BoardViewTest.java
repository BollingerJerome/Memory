package application.presentation;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import application.domain.BoardModel;
import application.domain.DomainController;
import application.domain.TimeModel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class BoardViewTest {

	@Test
	public void testFillRectangles() {
		
		BoardModel boardModel = new BoardModel(400,400);
		DomainController domainController = new DomainController(boardModel, null, null, null, null, null);
		Controller controller = new Controller(null, domainController, null, null, null, null, null, null);
		BoardView boardView = new BoardView(controller, 200,200, Color.ALICEBLUE);
		controller.setBoardView(boardView);
		
		boardModel.setBoardSize(2);
		boardView.fillRectangles();
		
		assertTrue(boardView.getRectangles()[0][0] instanceof Rectangle);
		assertTrue(boardView.getRectangles()[0][1] instanceof Rectangle);
		assertTrue(boardView.getRectangles()[1][0] instanceof Rectangle);
		assertTrue(boardView.getRectangles()[1][1] instanceof Rectangle);
		
	}
	
	@Test
	public void testIsWhichCardObject(){
		
		BoardModel boardModel = new BoardModel(400,400);
		DomainController domainController = new DomainController(boardModel, null, null, null, null, null);
		Controller controller = new Controller(null, domainController, null, null, null, null, null, null);
		BoardView boardView = new BoardView(controller, 200,200, Color.ALICEBLUE);
		controller.setBoardView(boardView);
		
		boardModel.setBoardSize(2);
		boardView.fillRectangles();
		
		assertEquals(boardModel.getField()[0][0] ,boardView.isWhichCardObject(boardView.getRectangles()[0][0]));
		
		Rectangle rectangle = new Rectangle();
		assertEquals(null, boardView.isWhichCardObject(rectangle));
		}
	
	@Test
	public void testSetCardsImage() {
		
		BoardModel boardModel = new BoardModel(400,400);
		DomainController domainController = new DomainController(boardModel, null, null, null, null, null);
		Controller controller = new Controller(null, domainController, null, null, null, null, null, null);
		BoardView boardView = new BoardView(controller, 200,200, Color.ALICEBLUE);
		controller.setBoardView(boardView);
		
		boardModel.setBoardSize(2);
		
		boardView.setCardsImage();
			
		assertTrue(boardView.getCardsBack()[1][1] instanceof Color);
		assertTrue(boardView.getCardsBack()[1][1] != null);
		assertTrue(boardView.getCardsFront()[1][1] instanceof ImagePattern);
		assertTrue(boardView.getCardsBack()[1][1] != null);
		
		boardModel.setBoardSize(8);
		boardView.setCardsImage();
		
		assertTrue(boardView.getCardsBack()[1][1] instanceof Color);
		assertTrue(boardView.getCardsBack()[1][1] != null);
		assertTrue(boardView.getCardsFront()[1][1] instanceof ImagePattern);
		assertTrue(boardView.getCardsBack()[1][1] != null);
		
	}
	

}
