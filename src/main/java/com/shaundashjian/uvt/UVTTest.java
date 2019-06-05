package com.shaundashjian.uvt;

import java.util.Scanner;

public class UVTTest {

	public static void main(String[] args) {
		UvtCalculator uvtCalculator = new UvtCalculator();
		
		if (args.length == 0) {
			System.out.println("**********************************************");
			System.out.println("*** Welcome to Unique View Time Calculator ***");
			System.out.println("**********************************************");
			System.out.println("Enter viewed fragments as pairs of times in milliseconds,");
			System.out.println("separated by a space. Enter a pair per line.");
			System.out.println();
			System.out.println("Example:");
			System.out.println("10 1000");
			System.out.println("10000 20000");
			System.out.println("10 100");
			System.out.println("50 1000");
			System.out.println();
			System.out.println("***********************************************");
			System.out.println();
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.print("Enter fragment (or empty line to end): ");
				String line = scanner.nextLine();
				if (line.isEmpty()) {
					break;
				}
				String[] times = line.split(" ");
				try {
					uvtCalculator.addFragment(
							new Fragment(Integer.parseInt(times[0]), 
									Integer.parseInt(times[1])));
				} catch (Exception e) {
					System.out.println("Incorrect number or format of input. Try again.");
					continue;
				}
			}
			System.out.println("Unique View Time: " + uvtCalculator.getUvt() + " milliseconds");
			scanner.close();
		} else {
			if (args.length % 2 != 0) {
				System.out.println("Incorrect number of fragments. Goodbye!!");
			} else {
				for (int i = 0; i < args.length; i += 2) {
					try {
						uvtCalculator.addFragment(
								new Fragment(Integer.parseInt(args[i]), 
										Integer.parseInt(args[i + 1])));
					} catch (Exception e) {
						System.out.println("Incorrect format of input. Gootbye!!");
						System.exit(0);
					}
				}
				System.out.println("Unique View Time: " + uvtCalculator.getUvt() + " milliseconds");
			}
		}
	}
}
