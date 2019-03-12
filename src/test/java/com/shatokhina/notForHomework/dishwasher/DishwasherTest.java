package com.shatokhina.notForHomework.dishwasher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DishwasherTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCleanser() {
        // given
        double cleanser = -3;
        int plate = 4;

        // when
        Dishwasher dishwasher = new Dishwasher(plate, cleanser);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePlate() {
        // given
        double cleanser = 3;
        int plate = -4;

        // when
        Dishwasher dishwasher = new Dishwasher(plate, cleanser);

        // then
        // Exception thrown
    }

    @Test
    public void testZeroCleanser() {
        // given
        double cleanser = 0;
        int plate = 4;
        Dishwasher dishwasher = new Dishwasher(plate, cleanser);

        // when
        Dishwasher.Remained remainders = dishwasher.wash();

        // then
        assertEquals(4, remainders.getPlate());
        assertEquals(0, remainders.getCleanser(), 0.01);
    }

    @Test
    public void testZeroPlate() {
        // given
        double cleanser = 3;
        int plate = 0;
        Dishwasher dishwasher = new Dishwasher(plate, cleanser);

        // when
        Dishwasher.Remained remainders = dishwasher.wash();

        // then
        assertEquals(0, remainders.getPlate());
        assertEquals(3, remainders.getCleanser(), 0.01);
    }

    @Test
    public void testPositivePlate() {
        // given
        double cleanser = 3;
        int plate = 3;
        Dishwasher dishwasher = new Dishwasher(plate, cleanser);

        // when
        Dishwasher.Remained remainders = dishwasher.wash();

        // then
        assertEquals(0, remainders.getPlate());
        assertEquals(1.5, remainders.getCleanser(), 0.01);
    }

    @Test
    public void testPositiveCleanser() {
        // given
        double cleanser = 2;
        int plate = 10;
        Dishwasher dishwasher = new Dishwasher(plate, cleanser);

        // when
        Dishwasher.Remained remainders = dishwasher.wash();

        // then
        assertEquals(6, remainders.getPlate());
        assertEquals(0, remainders.getCleanser(), 0.01);
    }
}