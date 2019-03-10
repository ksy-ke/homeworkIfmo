package com.shatokhina.homework1.task4;

public class NearestIdentifier {
    private final double base;

    public NearestIdentifier(double base) { this.base = base; }

    public double nearest(double first, double second) {
        return Math.abs(base - first) < Math.abs(base - second) ?
                first : second;
    }
}
