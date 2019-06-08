package com.shaundashjian.uvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UvtCalculatorUnitTests {

	private UvtCalculator uvtCalculator;
	
	@Before
	public void setup() {
		uvtCalculator = new UvtCalculator();
	}
	
    @Test
    public void test_one_fragment_1_100000_should_return_100000() {
        uvtCalculator.addFragment(new Fragment(1, 100000));
        int expectedUvt = 100000;
        
        assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_fragments_second_inside_the_first_1_100000_1_50000_should_return_100000() {
    	uvtCalculator.addFragment(new Fragment(1, 100000));
    	uvtCalculator.addFragment(new Fragment(1, 50000));
    	int expectedUvt = 100000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_separate_fragments_1_100000_200001_300000_should_return_200000() {
    	uvtCalculator.addFragment(new Fragment(1, 100000));
    	uvtCalculator.addFragment(new Fragment(200001, 300000));
    	int expectedUvt = 200000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_overlapping_fragments_1_100000_50001_300000_should_return_300000() {
    	uvtCalculator.addFragment(new Fragment(1,100000));
    	uvtCalculator.addFragment(new Fragment(50001, 300000));
    	int expectedUvt = 300000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }

}