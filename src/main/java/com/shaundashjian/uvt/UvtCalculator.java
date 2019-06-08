package com.shaundashjian.uvt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UvtCalculator {

	// Instance variable
	private List<Fragment> fragments;	
	
	// Constructor
    public UvtCalculator() {
		fragments = new ArrayList<>();
	}
    
	public void addFragment(Fragment fragment) {
		fragments.add(fragment);
	}

	public int getUvt() {
		// Create a temporary hash map that has an entry for each viewed millisecond
		Map<Integer, Boolean> viewedMilliseconds = new HashMap<>();
		
		// For each fragment:
		// 		add an entry for each millisecond not already added to the viewedMilliseconds map
		for (Fragment fragment : fragments) {
			int startTime = fragment.getStartTime();
			int endTime = fragment.getEndTime();
			for (int i = startTime; i <= endTime; i++) {
				if (!viewedMilliseconds.containsKey(i)) {
					viewedMilliseconds.put(i, true);
				}
			}
		}
		
		// The size of the viewedMilliseconds map is the total number of milliseconds viewed, i.e. UVT
		return viewedMilliseconds.size();
	}

}