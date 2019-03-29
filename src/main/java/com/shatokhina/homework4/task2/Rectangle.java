package com.shatokhina.homework4.task2;

import com.shatokhina.homework4.task2.element.Line;
import com.shatokhina.homework4.task2.element.Point;

import static java.util.Objects.requireNonNull;

public class Rectangle implements Shape {
    private final Line ab;
    private final Line bc;
    private double area;
    private double perimeter;

    /**
     * @param a nonnull left top point
     * @param b nonnull right top point
     * @param c nonnull right bot point
     * @param d nonnull left bot point
     * @throws IllegalArgumentException the passed points can't create a rectangle
     * @throws NullPointerException     the passed point is null
     */
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
        this.bc = new Line(b, c);
    }

    @Override
    public double getArea() { return area != 0 ? area : (area = ab.getLength() * bc.getLength()); }

    @Override
    public double getPerimeter() {
        return perimeter != 0 ? perimeter :
                (perimeter = 2 * (ab.getLength() + bc.getLength()));
    }
}
