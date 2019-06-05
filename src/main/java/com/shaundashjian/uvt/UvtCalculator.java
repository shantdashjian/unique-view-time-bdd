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
		Map<Integer, Boolean> viewMap = new HashMap<>();
		
		// Loop through each fragment entered
		// For each fragment, add an entry for each millisecond not already in the view map
		for (Fragment fragment : fragments) {
			for (int i = fragment.getStartTime(); i < fragment.getEndTime(); i++) {
				if (!viewMap.containsKey(i)) {
					viewMap.put(i, true);
				}
			}
		}
		
		// The size of the view map is the total number of milliseconds viewed, i.e. UVT
		return viewMap.size();
	}

}