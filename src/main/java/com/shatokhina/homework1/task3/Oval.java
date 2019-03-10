package com.shatokhina.homework1.task3;

public class Oval {
    private final int area;

    private Oval(int areaInCentimeters) {
        if (areaInCentimeters <= 0) { throw new IllegalArgumentException(); }
        area = areaInCentimeters;
    }

    public static Oval ofCentimeters(int areaInCentimeters) {
        return new Oval(areaInCentimeters);
    }

    public static Oval ofDecimeters(int areaInDecimeters) {
        return new Oval(areaInDecimeters * 100);
    }

    public int minus(Oval that) {
        if (this.area <= that.area){ throw new IllegalArgumentException("Can't subtract a larger oval"); }
        return this.area - that.area; }
}
