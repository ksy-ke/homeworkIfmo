package com.shatokhina.homework1.task5;

import java.util.Optional;

public class QuadraticEquation {
    private final Double firstRoot;
    private final Double secondRoot;

    public QuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            firstRoot = secondRoot = null;
            return;
        }

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant == 0) {
            firstRoot = -b / 2 * a;
            secondRoot = null;
        } else if (discriminant > 0) {
            firstRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            secondRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
        } else {
            firstRoot = secondRoot = null;
        }
    }

    public Optional<Double> getSquareRoot1() { return Optional.ofNullable(firstRoot); }

    public Optional<Double> getSquareRoot2() { return Optional.ofNullable(secondRoot); }
}