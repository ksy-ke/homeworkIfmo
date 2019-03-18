package com.shatokhina.homework4.task2;

import com.shatokhina.homework4.task2.element.Line;
import com.shatokhina.homework4.task2.element.Point;

import static java.lang.Math.sqrt;
import static java.util.Objects.requireNonNull;

public class Triangle implements Shape {
    private final Line ab;
    private final Line bc;
    private final Line ca;
    private double area;
    private double perimeter;

    public Triangle(Point a, Point b, Point c) {
        requireNonNull(a);
        requireNonNull(b);
        requireNonNull(c);

        if (a.equalsForTriangle(b, c)) { throw new IllegalArgumentException("It's not triangle"); }

        ab = new Line(a, b);
        bc = new Line(b, c);
        ca = new Line(c, a);
    }

    @Override
    public double getArea() { return area != 0 ? area : area(); }

    private double area() {
        double p = getPerimeter() / 2;
        area = sqrt(p * (p - ab.getLength()) * (p - bc.getLength()) * (p - ca.getLength()));
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter != 0 ? perimeter :
                (perimeter = ab.getLength() + bc.getLength() + ca.getLength());
    }
}