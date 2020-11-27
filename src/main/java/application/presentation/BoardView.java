package application.presentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.domain.BoardModel;
import application.domain.Card;
import application.domain.PathStrings;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class BoardView {


	public BoardView(BoardModel boardModel) {

		this.boardModel = boardModel;
	}


	private BoardModel boardModel;
	private Rectangle[][] rectangles;
	
	
	public Group setupCards() {
		Group board = new Group();
		int hor = boardModel.getHorizontalTiles();
		int ver = boardModel.getVerticalTiles();
		rectangles = new Rectangle[hor][ver];
		double width = boardModel.getField()[0][0].getWidht();
		double height = boardModel.getField()[0][0].getHeight();
		for(int i = 0; i<hor; i++) {
			for(int j = 0; j<ver; j++) {
				Card card = boardModel.getField()[i][j];
				rectangles[i][j] = new Rectangle(i*width, j*height, width, height);
			}
		}
		int tiles = hor*ver;
		int[][] posIndex = boardModel.getPositonsOfIndex();
		
		String path, which;
		String[] ofWhich;
		if((tiles/2) <= PathStrings.getProfsFotos().length) {
			path = "src/main/resources/Fotos Memory/Profs Fotos/";
			ofWhich = PathStrings.getProfsFotos();
		}
		else {
			path = "src/main/resources/Fotos Memory/Sehenswuerdigkeiten Fotos/";
			ofWhich = PathStrings.getSehenswuerdigkeitenFotos();
		}
		
		FileInputStream fileInputStream;
		for(int i = 0; i<tiles; i++) {
			
			which = ofWhich[posIndex[1][i]];
			String finalPath = path+which;
			int x = posIndex[0][i]%hor;
			int y = posIndex[0][i]/hor;
			
			try {
				System.out.println(x);
				System.out.println(y);
				fileInputStream = new FileInputStream(finalPath);
				rectangles[x][y].setFill(new ImagePattern(new Image(fileInputStream)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			board.getChildren().add(rectangles[x][y]);
		}
		
		return board;
	}
	
}
