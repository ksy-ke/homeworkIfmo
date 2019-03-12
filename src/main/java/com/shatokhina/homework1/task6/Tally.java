package com.shatokhina.homework1.task6;

public class Tally {
    private final int number;
    private int maxNumeral = 0;

    public Tally(int number) { this.number = Math.abs(number); }

    public int findMax() {
        if (number == 0) return maxNumeral;
        int current = number;

        while (current > 0) {
            int remainder = current % 10;
            if (remainder > maxNumeral) maxNumeral = remainder;
            current /= 10;
        }

        return maxNumeral;
    }
}