package com.shaundashjian.uvt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UvtCalculator {

	private List<Fragment> fragments;	
	
    public UvtCalculator() {
		fragments = new ArrayList<>();
	}

	public void addFragment(Fragment fragment) {
		fragments.add(fragment);
	}

	public int getUvt() {
		Map<Integer, Boolean> viewMap = new HashMap<>();
		for (Fragment fragment : fragments) {
			for (int i = fragment.getStartTime(); i < fragment.getEndTime(); i++) {
				if (!viewMap.containsKey(i)) {
					viewMap.put(i, true);
				}
			}
		}
		return viewMap.size();
	}

}