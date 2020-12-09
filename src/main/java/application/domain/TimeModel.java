package application.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TimeModel {
	
		//constructor sets the current time on zero
	public TimeModel() {
		this.currentTime = 0;
		this.pause = false;
	}
	
	//only variable I need for the timer. 
	//it is not the timer but every second while playing, a one gets added to this varible
	//the real timer is in the boardview class
	private int currentTime;
	private boolean pause;
	
	//resets the time
	public void reset() {
		this.currentTime = 0;
	}
	
	//outputting time in a String format (xh xmin xs)
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

	//getter and setter
	public int getCurrentTime() {
		return currentTime;
	}


	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

}
