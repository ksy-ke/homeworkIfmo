package com.shatokhina.homework4.task2;

import com.shatokhina.homework4.task2.element.Line;
import com.shatokhina.homework4.task2.element.Point;

import static java.util.Objects.requireNonNull;

public class Triangle implements Shape {
    private final Line ab;
    private final Line bc;
    private final Line ac;
    private double area;
    private double perimeter;

    public Triangle(Point a, Point b, Point c) {
        requireNonNull(a);
        requireNonNull(b);
        requireNonNull(c);

        ab = new Line(a, b);
        bc = new Line(b, c);
        ac = new Line(a, c);
        double doubleTriangleArea = ab.doubleTriangleAreaWith(ac);
        if (doubleTriangleArea == 0) { throw new IllegalArgumentException("It's not triangle"); }
        this.area = doubleTriangleArea / 2;
    }

    @Override
    public double getArea() { return area; }

    @Override
    public double getPerimeter() {
        return perimeter != 0 ? perimeter :
                (perimeter = ab.getLength() + bc.getLength() + ac.getLength());
    }
}