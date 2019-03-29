package com.shatokhina.homework4.task4;

public class Cat {
    private final String name;
    private final int age;
    private final int weight;
    private final int strength;

    /**
     * @param strength min value = 0, max value = 10
     * @param name     nonnull
     * @param age      min value = 0
     * @param weight   min value = 1
     * @throws IllegalArgumentException age or weight less than the min value,
     *                                  strength out of range or passed name is null
     */
    public Cat(String name, int age, int weight, int strength) {
        if (age < 0 || strength < 0 || weight <= 0 || strength > 10 || name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    /**
     * Calculates the utility coefficient for age
     */
    private double ageRatio() {
        if (age >= 3 && age <= 6) {
            return 1;
        } else if (age < 3 || age < 10) {
            return 0.5;
        } else { return 0.25; }
    }

    /**
     * Calculates the utility coefficient for weight
     */
    private double weightRatio() {
        if (weight >= 2 && weight <= 5) {
            return 1;
        } else if (weight < 2) {
            return 0.25;
        } else {
            return 0.5;
        }
    }

    /**
     * Calculates the utility coefficient for strength
     */
    private double strengthRatio() { return (double) strength / 10; }

    /**
     * @param that nonnull object Cat with correct values
     * @throws IllegalArgumentException that = null or the same cat
     */
    public boolean fight(Cat that) {
        if (this == that) throw new IllegalArgumentException("Cat can't fight with itself");
        if (that == null) throw new IllegalArgumentException("No opponent");
        return (this.ageRatio() + this.strengthRatio() + this.weightRatio()) >
                (that.ageRatio() + that.strengthRatio() + that.weightRatio());
    }

    public String getName() { return name; }
}
