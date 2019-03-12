package com.shatokhina.homework2.task3;

public class DegreesOfNumber {
    public DegreesOfNumber(int what, int amount) {
        if (what <= 0 || amount <= 0) { throw new IllegalArgumentException(); }
        for (int i = 1; i <= amount; i++) {
            System.out.print((int) Math.pow(what, i) + " ");
        }
    }
}