package application.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileController {
	
	public boolean create() {
		
		try {
		      File myObj = new File("4x4stats.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        return true;
		      } else {
		        System.out.println("File already exists.");
		        return false;
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return false;
	}
	
	public void write(String entry, String file) {
		try {
		      FileWriter myWriter = new FileWriter(file);
		      myWriter.write(entry);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public String read(String file) {
		String data = null;
		try {
		      File myObj = new File(file);
		      Scanner myReader = new Scanner(myObj);
		     
		      while (myReader.hasNextLine()) {
		        data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return data;
	}
	
	
	
	
}
