package com.shatokhina.homework4.task2.element;

import static java.lang.Math.sqrt;
import static java.util.Objects.requireNonNull;

public class Line {
    private final double line;

    public Line(Point a, Point b) {
        requireNonNull(a);
        requireNonNull(b);
        int lineX = b.getX() - a.getX();
        int lineY = b.getY() - a.getY();
        line = sqrt(lineX * lineX + lineY * lineY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (Line) o;
        return this.line == that.line;
    }

    public double getLength() { return line; }
}