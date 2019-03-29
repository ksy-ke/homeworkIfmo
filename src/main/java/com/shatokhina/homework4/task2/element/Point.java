package com.shatokhina.homework4.task2.element;

import static java.util.Objects.hash;

public final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (Point) o;
        return this.x == that.x &&
                this.y == that.y;
    }

    @Override
    public int hashCode() { return hash(x, y); }
}
