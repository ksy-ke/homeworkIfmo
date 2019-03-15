package com.shatokhina.homework2.task5;

public class FibonacciSequence {
    private final int howMany;
    private final int[] sequence;

    public FibonacciSequence(int howMany) {
        if (howMany <= 0) { throw new IllegalArgumentException(); }
        this.howMany = howMany;
        sequence = new int[this.howMany];
        fibonacci();
    }

    private void fibonacci() {
        for (int current = 0; current < howMany; current++) {
            if (current <= 1) {
                sequence[current] = 1;
                continue;
            }
            sequence[current] = sequence[current - 1] + sequence[current - 2];
        }
    }

    public int[] getSequence() { return sequence.clone(); }
}