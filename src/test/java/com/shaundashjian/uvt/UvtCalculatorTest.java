package com.shaundashjian.uvt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UvtCalculatorTest {

	private UvtCalculator uvtCalculator;
	
	@BeforeEach
	public void setup() {
		uvtCalculator = new UvtCalculator();
	}
	
    @Test
    void test_0_100000_should_return_100000() {
        uvtCalculator.addFragment(new Fragment(0, 100000));
        int expectedUvt = 100000;
        
        assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    void test_0_100000_200000_300000_should_return_200000() {
    	uvtCalculator.addFragment(new Fragment(0, 100000));
    	uvtCalculator.addFragment(new Fragment(200000, 300000));
    	int expectedUvt = 200000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    void test_0_100000_0000_50000_should_return_100000() {
    	uvtCalculator.addFragment(new Fragment(0, 100000));
    	uvtCalculator.addFragment(new Fragment(0, 50000));
    	int expectedUvt = 100000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }
    
    @Test
    void test_100000_200000_50000_150000_should_return_250000() {
    	uvtCalculator.addFragment(new Fragment(100000,200000));
    	uvtCalculator.addFragment(new Fragment(50000, 150000));
    	int expectedUvt = 150000;
    	
    	assertEquals(expectedUvt, uvtCalculator.getUvt());
    }

}