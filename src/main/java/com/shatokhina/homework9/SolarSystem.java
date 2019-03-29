package com.shatokhina.homework9;

public enum SolarSystem {
    MERCURY(3.3 * Math.pow(10, 23), 2.4, 58),
    VENUS(4.9 * Math.pow(10, 24), 6.1, 108),
    EARTH(6.0 * Math.pow(10, 24), 6.4, 150),
    MARS(6.4 * Math.pow(10, 23), 3.4, 228),
    JUPITER(1.9 * Math.pow(10, 27), 71.0, 778),
    SATURN(5.7 * Math.pow(10, 26), 60.0, 1429),
    URANUS(8.7 * Math.pow(10, 25), 26.0, 2871),
    NEPTUNE(1.0 * Math.pow(10, 26), 25.0, 4504);

    private double mass;
    private double radius;
    private int orbitRadius;

    SolarSystem(double mass, double radius, int orbitRadius) {
        this.mass = mass;
        this.radius = radius;
        this.orbitRadius = orbitRadius;
    }

    public double getMass() { return mass; }

    public double getRadius() { return radius; }

    public int getOrbitRadius() { return orbitRadius; }
}
