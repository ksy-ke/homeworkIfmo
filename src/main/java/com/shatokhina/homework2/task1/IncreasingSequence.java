package com.shatokhina.homework2.task1;

public class IncreasingSequence {
    private final int[] sequence;

    public IncreasingSequence(int... sequence) {
        this.sequence = sequence.clone();
        validateSequence(this.sequence);
        sort();
    }

    private void validateSequence(int[] sequence) {
        if (sequence.length == 0) { throw new IllegalArgumentException(); }
        for (int outer = 0; outer < sequence.length - 1; outer++) {
            for (int inner = outer + 1; inner < sequence.length; inner++) {
                if (sequence[outer] == sequence[inner]) { throw new IllegalArgumentException("Duplicate numbers"); }
            }
        }
    }

    private void sort() {
        for (int outer = 1; outer < sequence.length; outer++) {
            int temp = sequence[outer];
            int inner = outer;
            while (inner > 0 && sequence[inner - 1] >= temp) {
                sequence[inner] = sequence[inner - 1];
                inner--;
            }
            sequence[inner] = temp;
        }
    }

    public int[] getSequenceOrder() { return sequence.clone(); }
}