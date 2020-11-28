package application.presentation;

import application.domain.Card;
import application.domain.DomainController;

public class Controller {

	public Controller(DomainController domainController) {
		this.domainController = domainController;
	}

	private DomainController domainController;
	
	public void setBoardSize(int size) {
		domainController.setBoardSize(size);
	}
	public void turn(Card card) {
		domainController.turn(card);
	}
	
	
}
