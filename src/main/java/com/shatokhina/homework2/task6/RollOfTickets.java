package com.shatokhina.homework2.task6;

import java.util.HashMap;
import java.util.Map;

public class RollOfTickets {
    public static int luckyTickets() {
        int sumRepeat = 0;

        Map<Integer, Integer> repeatCount = new HashMap<>();
        for (int key = 1; key <= 27; key++) { repeatCount.put(key, 0); }

        for (int number = 1; number <= 999; number++) {
            int current = number;
            int sum = 0;
            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }
            repeatCount.put(sum, repeatCount.get(sum) + 1);
        }

        for (int value : repeatCount.values()) { sumRepeat += Math.pow(value, 2); }

        return sumRepeat;
    }
}