package com.shaundashjian.uvt;

public class Fragment implements Comparable< Fragment >{
	
	// Instance variables
	private Integer startTime;
	private Integer endTime;
	
	// Constructor
	public Fragment(Integer startTime, Integer endTime) {
		setStartTime(startTime);
		setEndTime(endTime);
	}
	
	// Getters and setters
	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Fragment [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(Fragment fragment) {
		return this.getStartTime().compareTo(fragment.getStartTime());
	}
}
