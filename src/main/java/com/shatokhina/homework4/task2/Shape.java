package com.shatokhina.homework4.task2;

import com.shatokhina.homework4.task2.element.Point;

public interface Shape {
    double getArea();

    double getPerimeter();

    static Shape of(Point... points) {
        switch (points.length) {
            case 2:
                return new Circle(points[0], points[1]);
            case 3:
                return new Triangle(points[0], points[1], points[2]);
            case 4:
                return new Rectangle(points[0], points[1], points[2], points[3]);
            default:
                throw new IllegalArgumentException("No shape with " + points.length + " exist");
        }
    }
}