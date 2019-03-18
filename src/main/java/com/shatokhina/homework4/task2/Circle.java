package com.shatokhina.homework4.task2;

import com.shatokhina.homework4.task2.element.Point;

import static java.lang.Math.*;
import static java.util.Objects.requireNonNull;

public final class Circle implements Shape {
    private final Point center;
    private final Point point;
    private double radius;
    private double area;
    private double perimeter;

    public Circle(Point center, Point pointOfCircle) {
        requireNonNull(center);
        requireNonNull(pointOfCircle);
        if (center.equals(pointOfCircle)) { throw new IllegalArgumentException(); }
        this.center = center;
        this.point = pointOfCircle;
    }

    @Override
    public double getArea() { return area != 0 ? area : (area = 2 * PI * getRadius()); }

    @Override
    public double getPerimeter() { return perimeter != 0 ? perimeter : (perimeter = PI * pow(getRadius(), 2)); }

    private double getRadius() {
        if (radius != 0) return radius;

        int deltaX = point.getX() - center.getX();
        int deltaY = point.getY() - center.getY();
        return radius = sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}