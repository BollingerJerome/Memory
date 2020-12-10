package application.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileControllerTest {

	@Test
	public void testGetPath() {
		FileController fileController = new FileController();
		
		int st4 = 4;
		String path4 = fileController.getPath(st4);
		assertEquals(path4, "src/main/java/application/services/4x4stats.txt");
		
		int sth6 = 6;
		String path6 = fileController.getPath(sth6);
		assertEquals(path6, "src/main/java/application/services/6x6stats.txt");
		
		int st8 = 8;
		String path8 = fileController.getPath(st8);
		assertEquals(path8, "src/main/java/application/services/8x8stats.txt");
		
		int st10 = 10;
		String path10 = fileController.getPath(st10);
		assertEquals(path10, "src/main/java/application/services/10x10stats.txt");

	}

	@Test
	public void testPlsSortIt() {
		
		FileController fileController = new FileController(); 
		String[][] oldBoard = new String[10][3];
		
		//first place
		oldBoard[0][0] = "Harold";	//name
		oldBoard[0][1] = "25";		//time
		oldBoard[0][2] = "40";		//round	
		
		//current second place but will be third after the tested method
		oldBoard[1][0] = "Ohne offen bischi";	//name
		oldBoard[1][1] = "10";		//time
		oldBoard[1][2] = "50";		//round
		
		//the new entry which should be second place afterwards
		String[] newEntry = new String[3];
		newEntry[0] = "I'm second place";
		newEntry[1] = "20";
		newEntry[2] = "45";
		
		//second entry which has the same round score like number one but a better time
		String[] newEntry2 = new String[3];
		newEntry2[0] = "I'm faster than Harold";
		newEntry2[1] = "20";
		newEntry2[2] = "40";
		
	
		String[][] newString = fileController.plsSortIt(oldBoard, newEntry);
		
		assertEquals(oldBoard[0][0], newString[0][0]);	//first place
		assertEquals(oldBoard[0][1], newString[0][1]);
		assertEquals(oldBoard[0][2], newString[0][2]);

		assertEquals(newEntry[0], newString[1][0]);		//second place
		assertEquals(newEntry[1], newString[1][1]);
		assertEquals(newEntry[2], newString[1][2]);	
		
		assertEquals(oldBoard[1][0], newString[2][0]);		//third place
		assertEquals(oldBoard[1][1], newString[2][1]); 
		assertEquals(oldBoard[1][2], newString[2][2]); 
		
		String[][] newNewString = fileController.plsSortIt(oldBoard, newEntry2);
		
		assertEquals(newEntry2[0], newNewString[0][0]);		//Im faster than Harold
		assertEquals(newEntry2[1], newNewString[0][1]);
		assertEquals(newEntry2[2], newNewString[0][2]);	
		
		assertEquals(oldBoard[0][0], newNewString[1][0]);	//Harold
		assertEquals(oldBoard[0][1], newNewString[1][1]);
		assertEquals(oldBoard[0][2], newNewString[1][2]);
		
		assertEquals(oldBoard[1][0], newNewString[2][0]);		//Ohne offen Bischi
		assertEquals(oldBoard[1][1], newNewString[2][1]); 
		assertEquals(oldBoard[1][2], newNewString[2][2]); 
		
	}                                                  
	

}
