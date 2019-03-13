package com.shatokhina.homework2.task2;

public class PositiveSequence {
    private final int firstNumber;
    private final int step;

    public PositiveSequence(int firstNumber, int step) {
        this.firstNumber = firstNumber;
        this.step = step;
        sequence();
    }

    private void sequence() {
        int current = firstNumber;
        while (current >= step) {
            System.out.print(current + " ");
            current -= step;
        }
        if (current < step && current >= 0) { System.out.println(current); }
    }
}
