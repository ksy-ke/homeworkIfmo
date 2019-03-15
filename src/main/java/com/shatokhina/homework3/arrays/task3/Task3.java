package com.shatokhina.homework3.arrays.task3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Task3 {
    public static void main(String[] args) {
        int[] randomNumbers = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10))
                .limit(15)
                .toArray();
        System.out.println(Arrays.toString(randomNumbers));

        System.out.println(stream(randomNumbers)
                .filter(number -> number % 2 == 0)
                .count());
    }
}
