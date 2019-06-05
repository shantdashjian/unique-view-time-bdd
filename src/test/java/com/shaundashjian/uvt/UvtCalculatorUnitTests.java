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
    public void test_0_100000_should_return_100000() {
        uvtCalculator.addFragment(new Fragment(0, 100000));
        int expectedUvt = 100000;
        
        assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_0_100000_0_50000_should_return_100000() {
    	uvtCalculator.addFragment(new Fragment(0, 100000));
    	uvtCalculator.addFragment(new Fragment(0, 50000));
    	int expectedUvt = 100000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_0_100000_200000_300000_should_return_200000() {
    	uvtCalculator.addFragment(new Fragment(0, 100000));
    	uvtCalculator.addFragment(new Fragment(200000, 300000));
    	int expectedUvt = 200000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    public void test_0_100000_50000_300000_should_return_300000() {
    	uvtCalculator.addFragment(new Fragment(0,100000));
    	uvtCalculator.addFragment(new Fragment(50000, 300000));
    	int expectedUvt = 300000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }

}