package com.shatokhina.homework1.task6;

import org.junit.Test;

import static org.junit.Assert.*;

public class TallyTest {
    @Test
    public void testPositiveNumber() {
        // when
        Tally tally = new Tally(47493);

        // then
        assertEquals(9, tally.findMax());
    }

    @Test
    public void testNegativeTest() {
        // when
        Tally tally = new Tally(-837);

        // then
        assertEquals(8, tally.findMax());
    }

    @Test
    public void testZero() {
        // when
        Tally tally = new Tally(0);

        // then
        assertEquals(0, tally.findMax());
    }
}