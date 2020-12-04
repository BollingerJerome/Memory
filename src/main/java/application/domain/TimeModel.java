package application.domain;

public class TimeModel {
	
	public TimeModel() {
		this.startTime = 0;
		this.stopTime = 0;
		this.totalTime = 0;
	}
	private long startTime;
	private long stopTime;
	private long totalTime;
	
	public long calculateTotalTime() {
		totalTime = stopTime-startTime;
		return totalTime;
	}
	
	
	public void start() {
		setStartTime(System.currentTimeMillis());
		System.out.println("Start time: " + System.currentTimeMillis());
	}
	public void stop() {
		setStopTime(System.currentTimeMillis());
		System.out.println("Stop time: " + System.currentTimeMillis());
		calculateTotalTime();
	}
	
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getStopTime() {
		return stopTime;
	}
	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}
	public long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

}