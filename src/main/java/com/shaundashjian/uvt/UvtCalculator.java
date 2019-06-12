package com.shaundashjian.uvt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Range;

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

	public int getUvtSlow() {
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

	public int getUvt() {
		// Sort the fragments
		Collections.sort(fragments);
		// Create list of ranges
		List<Fragment> mergedRanges = new ArrayList<>();
		// Loop through fragments
		START_OVER:
		for (int i = 0; i < fragments.size(); i++) {
			Fragment fragment = fragments.get(i);
			boolean covered = false;
			// If fragment is already fully covered, do nothing
			for (Fragment range : mergedRanges) {
				if (fragment.getStartTime() >= range.getStartTime() && fragment.getStartTime() <= range.getEndTime()
						&& fragment.getEndTime() >= range.getStartTime()
						&& fragment.getEndTime() <= range.getEndTime()) {
					covered = true;
					break;
				}
			}
			// If fragment is not already fully covered
			if (!covered) {
				// Check if the fragment partially overlaps an existing range
				
				for (Fragment range : mergedRanges) {
					if (fragment.getStartTime() >= range.getStartTime() && fragment.getStartTime() <= range.getEndTime()
							&& fragment.getEndTime() > range.getEndTime()) {
						fragment.setStartTime(range.getEndTime() + 1);
						i--;
						continue START_OVER;
					}
					if (fragment.getStartTime() < range.getStartTime() 
							&& fragment.getEndTime() >= range.getStartTime()
							&& fragment.getEndTime() <= range.getEndTime()) {
						fragment.setEndTime(range.getStartTime() - 1);
						i--;
						continue START_OVER;	
					}
				}

				mergedRanges.add(fragment);

			}
		}
		// Calculate uvt using all merged ranges
		int uvt = 0;
		for (Fragment fragment : mergedRanges) {
			uvt += fragment.getEndTime() - fragment.getStartTime() + 1;
		}
		return uvt;
	}

}