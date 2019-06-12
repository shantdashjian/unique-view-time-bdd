Feature: UVT Calculation
	The program takes a collection of records, each representing a
	viewed fragment of a given video. Each fragment has two values:
	a start time, and an end time, each in milliseconds. It then 
	calculates the UVT, unique view time.
	
	Background: 
		Given a UVT calculator
		
	Scenario: One fragment
		When the user views a fragment from 1 to 10 milliseconds
		Then the UVT should be 10 milliseconds
		
	Scenario: Two fragments, second inside the first
		When the user views a fragment from 1 to 10 milliseconds
		And the user views a fragment from 1 to 5 milliseconds
		Then the UVT should be 10 milliseconds
		
	Scenario: Two fragments, first inside the second
		When the user views a fragment from 5 to 10 milliseconds
		And the user views a fragment from 1 to 20 milliseconds
		Then the UVT should be 20 milliseconds
		
	Scenario: Two separate fragments
		When the user views a fragment from 1 to 10 milliseconds
		And the user views a fragment from 21 to 30 milliseconds
		Then the UVT should be 20 milliseconds
		
	Scenario: Two overlapping fragments from the right
		When the user views a fragment from 1 to 10 milliseconds
		And the user views a fragment from 5 to 15 milliseconds
		Then the UVT should be 15 milliseconds
		
	Scenario: Two overlapping fragments from the left
		When the user views a fragment from 10 to 20 milliseconds
		And the user views a fragment from 5 to 15 milliseconds
		Then the UVT should be 16 milliseconds
		
	Scenario: Three Fragments Second Separate From First
		When the user views a fragment from 6 to 10 milliseconds
		And the user views a fragment from 11 to 15 milliseconds
		And the user views a fragment from 9 to 13 milliseconds
		Then the UVT should be 10 milliseconds
		
	Scenario: Three Fragments Second Right After The First
		When the user views a fragment from 6 to 10 milliseconds
		And the user views a fragment from 16 to 20 milliseconds
		And the user views a fragment from 9 to 17 milliseconds
		Then the UVT should be 15 milliseconds
		
	Scenario: Three Fragments Second Overlaps The First
		When the user views a fragment from 1 to 10 milliseconds
		And the user views a fragment from 5 to 15 milliseconds
		And the user views a fragment from 7 to 13 milliseconds
		Then the UVT should be 15 milliseconds