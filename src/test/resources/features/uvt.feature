Feature: UVT Calculation
	The program takes a collection of records, each representing a
	viewed fragment of a given video. Each fragment has two values
	a start time, and an end time, each in milliseconds. It then 
	calculates the UVT, unique view time.
	
	Background: 
		Given a UVT calculator
		
	Scenario: One fragment
		When the user views a fragment from 0 to 100000 milliseconds
		Then the UVT should be 100000 milliseconds