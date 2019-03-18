package com.shatokhina.homework4.task4;

public class Cat {
    private final String name;
    private final int age;
    private final int weight;
    private final int strength;

    public Cat(String name, int age, int weight, int strength) {
        if (age < 0 || strength > 10) { throw new IllegalArgumentException(); }
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    private double ageRatio() {
        if (age >= 3 && age <= 6) {
            return 1;
        } else if (age < 3 || age < 10) {
            return 0.5;
        } else { return 0.25; }
    }

    private double weightRatio() {
        if (weight >= 2 && weight <= 5) {
            return 1;
        } else if (weight < 2) {
            return 0.25;
        } else {
            return 0.5;
        }
    }

    private double strengthRatio() { return (double) strength / 10; }

    public boolean fight(Cat that) {
        if (this == that) throw new IllegalArgumentException("Cat can't fight with itself");
        if (that == null) throw new IllegalArgumentException("No opponent");
        return (this.ageRatio() + this.strengthRatio() + this.weightRatio()) >
                (that.ageRatio() + that.strengthRatio() + that.weightRatio());
    }
}
