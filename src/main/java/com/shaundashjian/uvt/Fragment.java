package com.shaundashjian.uvt;

public class Fragment {
	
	// Instance variables
	private int startTime;
	private int endTime;
	
	// Constructor
	public Fragment(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	// Getters and setters
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}
