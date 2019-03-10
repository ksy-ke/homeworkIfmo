package com.shatokhina.homework1.task5;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class QuadraticEquationTest {
    @Test
    public void testPositiveD() {
        // given

        // when
        QuadraticEquation quadraticEquation = new QuadraticEquation(1, -8, 12);

        // then
        assertEquals(Optional.of(2.0), quadraticEquation.getSquareRoot1());
        assertEquals(Optional.of(6.0), quadraticEquation.getSquareRoot2());
    }

    @Test
    public void testNegativeD() {
        // when
        QuadraticEquation quadraticEquation = new QuadraticEquation(4, 5, 3);

        // then
        assertEquals(Optional.empty(), quadraticEquation.getSquareRoot1());
        assertEquals(Optional.empty(), quadraticEquation.getSquareRoot2());
    }

    @Test
    public void testZeroD() {
        // given

        // when
        QuadraticEquation quadraticEquation = new QuadraticEquation(1, 12, 36);

        // then
        assertEquals(Optional.of(-6.0), quadraticEquation.getSquareRoot1());
        assertEquals(Optional.empty(), quadraticEquation.getSquareRoot2());
    }

    @Test
    public void testZeroA() {
        // when
        QuadraticEquation quadraticEquation = new QuadraticEquation(0, 5, 3);

        // then
        assertEquals(Optional.empty(), quadraticEquation.getSquareRoot1());
        assertEquals(Optional.empty(), quadraticEquation.getSquareRoot2());
    }
}