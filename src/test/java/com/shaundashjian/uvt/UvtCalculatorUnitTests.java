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
    public void test_one_fragment_1_10_should_return_10() {
        uvtCalculator.addFragment(new Fragment(1, 10));
        int expectedUvt = 10;
        
        assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_fragments_second_inside_the_first_1_10_1_5_should_return_10() {
    	uvtCalculator.addFragment(new Fragment(1, 10));
    	uvtCalculator.addFragment(new Fragment(1, 5));
    	int expectedUvt = 10;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_fragments_first_inside_the_second_5_10_1_20_should_return_20() {
    	uvtCalculator.addFragment(new Fragment(5, 10));
    	uvtCalculator.addFragment(new Fragment(1, 20));
    	int expectedUvt = 20;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_separate_fragments_1_10_21_30_should_return_20() {
    	uvtCalculator.addFragment(new Fragment(1, 10));
    	uvtCalculator.addFragment(new Fragment(21, 30));
    	int expectedUvt = 20;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_overlapping_fragments_from_the_right_1_10_5_15_should_return_15() {
    	uvtCalculator.addFragment(new Fragment(1,10));
    	uvtCalculator.addFragment(new Fragment(5, 15));
    	int expectedUvt = 15;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_two_overlapping_fragments_from_the_left_10_20_5_15_should_return_16() {
    	uvtCalculator.addFragment(new Fragment(10,20));
    	uvtCalculator.addFragment(new Fragment(5, 15));
    	int expectedUvt = 16;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_three_fragments_second_separate_from_first_6_10_16_20_9_17_should_return_15() {
    	uvtCalculator.addFragment(new Fragment(6,10));
    	uvtCalculator.addFragment(new Fragment(16, 20));
    	uvtCalculator.addFragment(new Fragment(9, 17));
    	int expectedUvt = 15;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    @Test
    public void test_three_fragments_second_right_after_first_6_10_11_15_9_13_should_return_10() {
    	uvtCalculator.addFragment(new Fragment(6,10));
    	uvtCalculator.addFragment(new Fragment(11, 15));
    	uvtCalculator.addFragment(new Fragment(9, 13));
    	int expectedUvt = 10;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }

}