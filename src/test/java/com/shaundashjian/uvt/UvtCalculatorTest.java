package com.shaundashjian.uvt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UvtCalculatorTest {

    @Test
    void test_0000_100000_should_return_100000() {
        UvtCalculator uvtCalculator = new UvtCalculator();
        uvtCalculator.addFragment(new Fragment(0, 100000));
        
        int expectedUvt = 100000;
        
        assertEquals(expectedUvt, uvtCalculator.getUvt());
    }

}