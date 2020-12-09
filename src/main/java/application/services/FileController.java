package application.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class FileController {


	//This Class manages the entry making and which file should be used or created

	//method to get the correct file
	public String getPath(int size) {
		String file4path = "src/main/java/application/services/4x4stats.txt";
		String file6path = "src/main/java/application/services/6x6stats.txt";
		String file8path = "src/main/java/application/services/8x8stats.txt";
		String file10path = "src/main/java/application/services/10x10stats.txt";
		String neededPath = null;

		switch (size) {
		case 4:
			neededPath = file4path;
			break;
		case 6:
			neededPath = file6path;
			break;
		case 8:
			neededPath = file8path;
			break;
		case 10:
			neededPath = file10path;
			break;

		}
		return neededPath;
	}

	//creates a file if necessary and makes the entry
	public void makeEntry(int size, String entry) {
		create(getPath(size));
		write(getPath(size), entry);
	}


	//this method creates the file if it is not created yet
	public boolean create(String file) {

		try {
			File myObj = new File(file);
			if (myObj.createNewFile()) {
				return true;
			} 
			else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	//this method reads first all entries and saves it on an array, puts the Score in the right spot and writes it down again
	public void write(String path, String entry) {
		try {

			File myObj = new File(path);	//creating File object 
			Scanner myReader = new Scanner(myObj);	//this object has the method to read files

			//TODO playername cannot contain a "."
			String[] newEntry = entry.split("\\.|\n");
			String[][] newTable = new String[10][3];
			newTable = plsSortIt(read(path), newEntry);	

			FileWriter myWriter = new FileWriter(path, false);
			for(int i = 0; i<10; i++) {
				if(newTable[i][0] != null) {
					myWriter.write(newTable[i][0] + "." + newTable[i][1] + "." + newTable[i][2] + "\n");
				}
			}

			myWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String[][] plsSortIt(String[][] oldBoard, String[] newEntry) {
		/*
		 * 	making new highscore
		 *oldBoard[10][3]
		 * 
		 */
		String[][] finalString = new String[10][3];

		int[] rounds = new int[10];
		int[] time = new int[10];
		int boardLength = 0;

		int newRounds = Integer.parseInt(newEntry[2]);
		int newTime = Integer.parseInt(newEntry[1]);

		//having a nice format for the points and knowing how many entries there are already
		for(int i = 0; i<10; i++) {
			if(oldBoard[i][2] == null) {
				boardLength = i;
				break;
			}
			rounds[i] = Integer.parseInt(oldBoard[i][2]);
			time[i] = Integer.parseInt(oldBoard[i][1]);
		}
		for(int i = 0; i<10; i++) {
			if(rounds[i] >= newRounds || rounds[i] == 0 ) {
				if(time[i] >= newTime  || time[i] == 0) {
					for(int j=9; j>i; j--) {
						// um 1 verschieben
						if(oldBoard[j-1][0] != null) {
							oldBoard[j][0] = oldBoard[j-1][0];
							oldBoard[j][1] = oldBoard[j-1][1];
							oldBoard[j][2] = oldBoard[j-1][2];
						}
						
					}
					oldBoard[i][0] = newEntry[0];
					oldBoard[i][1] = newEntry[1];
					oldBoard[i][2] = newEntry[2];
					return oldBoard;
				}
			}
		}
		return oldBoard;
	}



	public String[][] read(int size) {

		try {
			File myObj = new File(getPath(size));	//creating File object 
			Scanner myReader = new Scanner(myObj);	//this object has the method to read files


			String[][] reading = new String[10][3];

			int counter = 0;
			
			while (myReader.hasNextLine()) {		//as long as the txt goes
				String input = myReader.nextLine();	//saves the line on input
				String[] data = input.split("\\.|\r");		//splits the info of the file
				reading[counter][0] = data[0];
				reading[counter][1] = data[1];
				reading[counter][2] = data[2];
				counter++;
			}
			myReader.close();		//proper closing of the file

			return reading;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		//should an error occur
	}

	public String[][] read(String path) {

		try {
			File myObj = new File(path);	//creating File object 
			Scanner myReader = new Scanner(myObj);	//this object has the method to read files


			String[][] reading = new String[10][3];

			int counter = 0;

			if(myReader.hasNextLine()) {
			}
			else {
			}
			while (myReader.hasNextLine()) {		//as long as the .txt goes
				String input = myReader.nextLine();	//saves the line on input
				String[] data = input.split("\\.|\r");		//splits the info of the file
				reading[counter][0] = data[0];
				reading[counter][1] = data[1];
				reading[counter][2] = data[2];
				counter++;
			}
			myReader.close();		//proper closing of the file

			return reading;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		//should an error occur
	}


}
