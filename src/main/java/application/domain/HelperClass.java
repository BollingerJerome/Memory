package application.domain;



public class HelperClass {

	
	//I need an Array which has two rows. the upper row contains the index of the picture
	// the lower row contains the index of the card
	
	
	public static int[][] randomizeMemoryBoard (int hor, int ver) {

		/*creates the card fronts in a random fashion
		 *each tile gets a random float. then they get sorted and assigned the indexes
		 *
		 * tiles[color(in TileColorsArray][random] = {1,	2,	 	3,	 	4, 		5,		 6,		 7,		 8, 	9, 		10...}
		 * 							 {0.41, 0.25, 0.9999, 0.1111, 0.7523, 0.6541, 0.251,   0.548,  0.335    0.875...}
		 *
		 * sorted:					{	4,		2,  	7,		9,		1,	  8,	6,  	  5,     10,    3...	}
		 * 							{0.1111,  0.25,   0.251,  0.335, 0.41, 0.548, 0.6541, 0.7523,  0.875, 0.9999...	}
		 *
		 * 	numbered:			{4, 2, 7, 9, 1, 8, 6, 5, 10, 3...	}
		 * 						{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,...}
		 */
		
		int tiles = hor*ver;	//tiles in total = horizontalTiles * verticalTiles
		
		double[][] tile = new double[2][tiles];	//array[2][tiles] which will be manipulated a lot afterwards
		int[][] randomPosition = new int[2][tiles]; //this is the final array, which will be returned from the method
		
		//each number in tile[1][i] gets a random number
		//while tile[0][i] gets counted up: 0, 1, 2, 3...
		for (int i = 0; i < tiles; i++) {
			tile[0][i] = i;
			tile[1][i] = Math.random()*10*Math.random();
		}
		
		//Bubble sort algorithm
		for (int i = 0; i < tiles; i++) {
			for(int j = 0; j < tiles-1; j++) {
				if(tile[1][j] > tile[1][j+1]) {
					double helperZero = tile[0][j+1];
					double helperOne = tile[1][j+1];
					tile[0][j+1] = tile[0][j];
					tile[1][j+1] = tile[1][j];
					tile[0][j] = helperZero;
					tile[1][j] = helperOne;
				}
			}
		}
		
		//I want that tile[1][i] has ints in pairs: 1,2,3,4,5,6... -> 1,1,2,2,3,3...
		for(int j = 0; j < tiles; j++) {
			if(j%2 == 1) {	//if int is not even, subtract one and half it: 5 -> 4 -> 2
				tile[1][j] = (j-1)/2;
			}
			else {
				//if int is even, half it -> 4 -> 2
				tile[1][j] = j/2;
			}
		}
		
		//now give those values to an array which safes ints instead of floats
		for (int i = 0; i < tiles; i++) {
			randomPosition[0][i] = (int) tile[0][i];
			randomPosition[1][i] = (int) tile[1][i];
		}

		return randomPosition;
	}
	
	
}
