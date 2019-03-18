package com.shatokhina.homework4.task2;

import com.shatokhina.homework4.task2.element.Line;
import com.shatokhina.homework4.task2.element.Point;

import static java.util.Objects.requireNonNull;

public class Rectangle implements Shape {
    private final Line ab;
    private final Line cd;
    private double area;
    private double perimeter;

    public Rectangle(Point a, Point b, Point c, Point d) {
        requireNonNull(a);
        requireNonNull(b);
        requireNonNull(c);
        requireNonNull(d);

        Line ab = new Line(a, b);
        Line cd = new Line(c, d);
        Line ac = new Line(a, c);
        Line bd = new Line(b, d);
        if (!(ab.equals(cd) && ac.equals(bd))) { throw new IllegalArgumentException("It's not rectangle"); }
        this.ab = ab;
        this.cd = cd;
    }

    @Override
    public double getArea() { return area != 0 ? area : (area = ab.getLength() * cd.getLength()); }

    @Override
    public double getPerimeter() {
        return perimeter != 0 ? perimeter :
                (perimeter = 2 * (ab.getLength() + cd.getLength()));
    }
}
