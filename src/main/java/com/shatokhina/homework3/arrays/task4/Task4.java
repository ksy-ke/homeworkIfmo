package com.shatokhina.homework3.arrays.task4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.of;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray;
        do {
            System.out.println("Enter a positive even number: ");
            sizeArray = scanner.nextInt();
        }
        while (sizeArray <= 0 || sizeArray % 2 != 0);
        int[] randomNumbers = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(-5, 6))
                .limit(sizeArray)
                .toArray();
        System.out.println(Arrays.toString(randomNumbers));

        int average = sizeArray / 2;
        int left = of(randomNumbers).limit(average).sum();
        int right = of(randomNumbers).skip(average).sum();

        if (left > right) {
            System.out.println("The left side of the array is large");
        } else if (right > left) {
            System.out.println("The right side of the array is large");
        } else {
            System.out.println("The parts of the array are equal");
        }
    }
}
