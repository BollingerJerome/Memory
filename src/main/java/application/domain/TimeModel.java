package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TimeModel {
	
	public TimeModel() {
		this.currentTime = 0;
	}

	private int currentTime;
	
	public void reset() {
		this.currentTime = 0;
	}
	

	
	public String getTimeString() {
		if(currentTime> 3600) {
			String string = "Time: " + currentTime/3600 + "h "+ (currentTime%3600)/60 + "min " + (currentTime%60) +"s";
			return string;
		}
		else {
			if(currentTime>60) {
				String string = "Time: " + (currentTime/60) + "min " + (currentTime%60) +"s";
				return string;
			}
			else {
				String string = "Time: " + currentTime +"s";
				return string;
			}
		}
		
	}


	public int getCurrentTime() {
		return currentTime;
	}


	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

}
