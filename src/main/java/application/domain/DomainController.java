package application.domain;


import java.util.Vector;

import application.services.FileController;
import application.services.PlayerScore;

public class DomainController {




		//domaincontrollerclass should contain all intern logic, which is independent of the graphics.
		//constructor containing models
	public DomainController(BoardModel boardModel, PlayModel playModel, 
			WonModel wonModel, TimeModel timeModel, 
			StatisticModel statisticModel, FileController fileController) {

		this.boardModel = boardModel;
		this.playModel = playModel;
		this.wonModel = wonModel;
		this.statisticModel = statisticModel;
		this.timeModel = timeModel;
		this.fileController = fileController;

	}
	
	//model objects
	private BoardModel boardModel;
	private PlayModel playModel;
	private WonModel wonModel;
	private TimeModel timeModel;
	private StatisticModel statisticModel;
	
	//service object
	private FileController fileController;

		
		//checks whether two cards are "the same" by comparing their pairIds
	public boolean isTheSame(Card cardOne, Card cardTwo) {
		if(cardOne.getPairId() == cardTwo.getPairId()) {
			return true;
		}
		else {
			return false;
		}
	}


	
	//this is the main game logic. This Method controls the flow of each players turn and if they are allowed 
	public void turn(Card card) {		
		switch(playModel.getTurn()) { //playmodels turn tells me which case we have: 0 -> no card is open, 1 -> one card is open, 2 -> two cards are open
		case 0:
			if(!card.isOpen()) { //when card is not open and not found yet
				if(!card.isFound()) {
					playModel.setPosition(card); //updates playModelcurrent and last coordinates of cards (see PlayModel class)
					boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setOpen(true); //changes open value of this card to true -> propertychangefire happens -> field gets updated(see boardview)
					playModel.setTurn(playModel.getTurn()+1);	//setting the turn to next phase
					return; //stop here (not necessary but I hope runtime is slower)
				}				
			}
			return;
		case 1:
			if(!card.isOpen() && !card.isFound() ) { //same statement here
				playModel.setPosition(card);	//update playmodel coordinates again
				boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setOpen(true); //set current card to open -> propertychangefire -> update field
				if(isTheSame(card, boardModel.getField()[playModel.getLastX()][playModel.getLastY()])) { //have two same cards been opened?
					playModel.getPlayerModel()[playModel.getPlayerTurn()].addPoint(); //player gets point -> firepropertychange -> label on the left gets updated
					boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setFound(true); //you get it now
					boardModel.getField()[playModel.getLastX()][playModel.getLastY()].setFound(true); //...
					if(boardModel.iswon()) { //tests if game is won
						wonModel.setWon(true);	//yeah won -> firePropertyChange -> show stats (see boardview)
						
					}
					playModel.setRound(playModel.getRound()+1); //total round +1
					playModel.setTurn(0);						//turn starts at zero again, because "no card is open now"
				}
				else { //if it is not the same card, go to case 2 where cards get turned back down when clicked
					playModel.setTurn(playModel.getTurn()+1);
				}
				return;
			}
			return;
		case 2:
			//there is no if because I dont care where the player clicks but I want the player to click so he can decide, when the cards should be turned down.
			boardModel.getField()[playModel.getCurrentX()][playModel.getCurrentY()].setOpen(false); //same again, open = false -> firepropertychange -> update field
			boardModel.getField()[playModel.getLastX()][playModel.getLastY()].setOpen(false);
			playModel.setTurn(0); //starting at turn zero again (no card is open)
			playModel.setPlayerTurn((playModel.getPlayerTurn()+1)%playModel.getPlayerModel().length); //next player is up to play
			playModel.setRound(playModel.getRound()+1); //next round
			return;
		}
		return;
	}
	
	/*
	 * 		turn zero				turn 1												turn 2
	 * 	
	 * 		first card open			second card open
	 * 
	 * 							yes						yes							no
	 * 	->	(clicked card allowed) ->(clicked card allowed) ->	(cards are the same) --> cards turned	   
	 * 	|			|no					|							|						next player
	 * 	|			|					|							|yes					turn to zero
	 * 	|			v					v							v						round added
	 * 	|		nothing happens		nothing happens				cards are left open				|
	 * 	|														cards are found					|
	 * 	--------------------<----------------------------------	no player changed				|
	 * 	| - - - -<- - - - - - - - - - - - - - - - -<- - - - - -	turn to zero - - - - - -<- - - - 
	 * 															round added
	 * 																|
	 * 																|won 
	 * 																v
	 * 															show stats
	 * 
	 */																

	
	

	public void setWon(boolean won) {
		wonModel.setWon(won);
	}

	public boolean iswon() {
		return boardModel.iswon();
	}

	public void setPlayerName(int i, String name) {
		playModel.getPlayerModel()[i].setName(name);
	}

	public void setBoardSize (int a) {
		boardModel.setBoardSize(a);
	}

	public BoardModel getBoardModel() {
		return boardModel;
	}

	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}

	public void setNumberOfPlayers(int a) {
		playModel.setPlayerModel(a);
	}

	public int getNumberOfPlayers() {
		return playModel.getPlayerModel().length;
	}

	public int getPlayerPoint(int i) {
		return playModel.getPlayerPoint(i);
	}

	public String getPlayerName(int i) {
		return playModel.getPlayerModel()[i].getName();
	}

	public PlayerModel[] getPlayersModel() {
		return playModel.getPlayerModel();
	}


	public FileController getFileController() {
		return fileController;
	}

	public void setFileController(FileController fileController) {
		this.fileController = fileController;
	}

	public PlayModel getPlayModel() {
		return playModel;
	}

	public void setPlayModel(PlayModel playModel) {
		this.playModel = playModel;
	}

	public WonModel getWonModel() {
		return wonModel;
	}

	public void setWonModel(WonModel wonModel) {
		this.wonModel = wonModel;
	}

	public TimeModel getTimeModel() {
		return timeModel;
	}

	public void setTimeModel(TimeModel timeModel) {
		this.timeModel = timeModel;

	}



	public StatisticModel getStatisticModel() {
		return statisticModel;
	}



	public void setStatisticModel(StatisticModel statisticModel) {
		this.statisticModel = statisticModel;
	}

}
