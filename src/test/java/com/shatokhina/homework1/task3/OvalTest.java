package com.shatokhina.homework1.task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class OvalTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDecimeters() {
        // given
        int area = -35;
        // when
        Oval.ofDecimeters(area);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCentimeters() {
        // given
        int area = -35;
        // when
        Oval.ofCentimeters(area);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractionOfBiggerOval() {
        // given
        Oval small = Oval.ofCentimeters(35);
        Oval big = Oval.ofDecimeters(35);
        // when

        small.minus(big);

        // then
        // Exception thrown
    }

    @Test
    public void testSubtraction() {
        // given
        Oval small = Oval.ofCentimeters(30);
        Oval big = Oval.ofDecimeters(3);

        // when
        int result = big.minus(small);

        // then
        assertEquals(270, result);
    }


}
