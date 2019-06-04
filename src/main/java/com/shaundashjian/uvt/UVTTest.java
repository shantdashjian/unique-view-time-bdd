package com.shaundashjian.uvt;

public class UVTTest {

	public static void main(String[] args) {
		UvtCalculator uvtCalculator = new UvtCalculator();
		
		if (args.length == 0) {
			System.out.println("No viewed fragments entered");
		} else {
			if (args.length % 2 != 0) {
				System.out.println("Incorrect format of fragments");
			} else {
				for (int i = 0; i < args.length; i += 2) {
					uvtCalculator.addFragment(
							new Fragment(Integer.parseInt(args[i]), 
										Integer.parseInt(args[i + 1])));
				}
				System.out.println("Unique View Time: " + uvtCalculator.getUvt() + " milliseconds");
			}
		}

	}

}
