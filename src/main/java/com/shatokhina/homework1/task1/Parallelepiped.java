package com.shatokhina.homework1.task1;

public class Parallelepiped {
    private final int height;
    private final int length;
    private final int width;
    private int area = 0;

    public Parallelepiped(int height, int length, int width) {
        if (height <= 0 || length <= 0 || width <= 0) { throw new IllegalArgumentException(); }
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int area() {
        if (area == 0) { area = 2 * (height * length + length * width + height * width); }
        return area;
    }

    public boolean isWidth() { return width > length; }
}