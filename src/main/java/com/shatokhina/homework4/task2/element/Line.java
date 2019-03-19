package com.shatokhina.homework4.task2.element;

import static java.lang.Math.sqrt;
import static java.util.Objects.requireNonNull;

public class Line {
    private final int lineX;
    private final int lineY;
    private final double length;

    public Line(Point a, Point b) {
        requireNonNull(a);
        requireNonNull(b);
        lineX = b.getX() - a.getX();
        lineY = b.getY() - a.getY();
        length = sqrt(lineX * lineX + lineY * lineY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (Line) o;
        return this.length == that.length;
    }

    public double doubleTriangleAreaWith(Line that) { return (this.lineX * that.lineY - that.lineX * this.lineY); }

    public double getLength() { return length; }
}