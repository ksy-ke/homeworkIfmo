package com.shatokhina.homework1.task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class GardenPlotTest {
    @Test
    public void testPositiveSides() {
        // given
        int lengthPlot = 52;
        int widthPlot = 25;
        int lengthBed = 5;
        int widthBed = 10;

        // when
        GardenPlot gardenPlot = new GardenPlot(lengthPlot, widthPlot);

        // then
        assertEquals(50, gardenPlot.remainderArea(widthBed, lengthBed));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSidePlot() {
        // given
        int lengthPlot = 52;
        int widthPlot = -25;

        // when
        GardenPlot gardenPlot = new GardenPlot(lengthPlot, widthPlot);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithZeroSidePlot() {
        // given
        int lengthPlot = 52;
        int widthPlot = 0;

        // when
        GardenPlot gardenPlot = new GardenPlot(lengthPlot, widthPlot);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSideBed() {
        // given
        int lengthPlot = 52;
        int widthPlot = 25;
        int lengthBed = -5;
        int widthBed = 10;

        // when
        GardenPlot gardenPlot = new GardenPlot(lengthPlot, widthPlot);
        gardenPlot.remainderArea(widthBed, lengthBed);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithZeroSideBed() {
        // given
        int lengthPlot = 52;
        int widthPlot = 25;
        int lengthBed = 5;
        int widthBed = 0;

        // when
        GardenPlot gardenPlot = new GardenPlot(lengthPlot, widthPlot);
        gardenPlot.remainderArea(widthBed, lengthBed);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBedSideBiggerPlotSide() {
        // given
        int lengthPlot = 32;
        int widthPlot = 25;
        int lengthBed = 45;
        int widthBed = 10;

        // when
        GardenPlot gardenPlot = new GardenPlot(lengthPlot, widthPlot);
        gardenPlot.remainderArea(widthBed, lengthBed);

        // then
        // Exception thrown
    }
}