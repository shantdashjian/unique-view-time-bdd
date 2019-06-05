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
		
	Scenario: Two fragments, second inside the first
		When the user views a fragment from 0 to 100000 milliseconds
		When the user views a fragment from 0 to 50000 milliseconds
		Then the UVT should be 100000 milliseconds
		
	Scenario: Two separate fragments
		When the user views a fragment from 0 to 100000 milliseconds
		When the user views a fragment from 200000 to 300000 milliseconds
		Then the UVT should be 200000 milliseconds
		
	Scenario: Two overlapping fragments
		When the user views a fragment from 0 to 100000 milliseconds
		When the user views a fragment from 50000 to 300000 milliseconds
		Then the UVT should be 300000 milliseconds