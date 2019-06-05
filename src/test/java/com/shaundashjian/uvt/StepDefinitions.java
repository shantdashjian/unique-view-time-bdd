package com.shaundashjian.uvt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	private UvtCalculator uvtCalculator;
	
	@Given("a UVT calculator")
	public void a_UVT_calculator() {
	    uvtCalculator = new UvtCalculator();
	}
	
	@When("the user views a fragment from {int} to {int} milliseconds")
	public void the_user_views_a_fragment_from_to_milliseconds(Integer startTime, Integer endTime) {
		uvtCalculator.addFragment(new Fragment(startTime, endTime));
	}

	@Then("the UVT should be {int} milliseconds")
	public void the_UVT_should_be_milliseconds(Integer expectedUvt) {
	    assertEquals(expectedUvt, uvtCalculator.getUvt());
	}

}
