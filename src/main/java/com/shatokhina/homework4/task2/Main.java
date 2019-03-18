package com.shatokhina.homework4.task2;

import com.shatokhina.homework4.task2.element.Point;

public class Main {
    public static void main(String[] args) {
        Shape triangle = Shape.of(new Point(1, 5), new Point(1, 1), new Point(4, 1));
        System.out.println("Triangle. Area: " + triangle.getArea() + " and perimeter: " + triangle.getPerimeter());

        Shape rectangle = Shape.of(new Point(-2, 1), new Point(1, 1), new Point(1, 0), new Point(-2, 0));
        System.out.println("Rectangle. Area: " + rectangle.getArea() + " and perimeter: " + rectangle.getPerimeter());

        Shape circle = Shape.of(new Point(-2, 1), new Point(0, 2));
        System.out.println("Circle. Area: " + circle.getArea() + " and circumference: " + circle.getPerimeter());
    }
}
