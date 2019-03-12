package com.shatokhina.homework2.task1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class IncreasingSequenceTest {
    @Test
    public void testPositiveNumbers() {
        // given
        int a = 5;
        int b = 13;
        int c = 1;

        // when
        IncreasingSequence increasingSequence = new IncreasingSequence(a, b, c);

        // then
        assertArrayEquals(new int[] {c, a, b}, increasingSequence.getSequenceOrder());
    }

    @Test
    public void testNegativeNumber() {
        // given
        int a = 5;
        int b = -13;
        int c = 1;

        // when
        IncreasingSequence increasingSequence = new IncreasingSequence(a, b, c);

        // then
        assertArrayEquals(new int[] {b, c, a}, increasingSequence.getSequenceOrder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSameNumbers() {
        // given
        int a = 5;
        int b = -13;
        int c = 5;

        // when
        IncreasingSequence increasingSequence = new IncreasingSequence(a, b, c);

        // then
        // Exception thrown
    }
}