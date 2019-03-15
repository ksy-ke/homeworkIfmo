package com.shatokhina.homework3.arrays.task2;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.iterate;

public class OddNumbers {
    public static void main(String[] args) {
        int[] odds = IntStream.range(1, 100).filter(number -> number % 2 != 0).toArray();
        System.out.println(IntStream.of(odds).mapToObj(String::valueOf).collect(joining(" ")));

        System.out.println(iterate(odds.length - 1, i -> --i).limit(odds.length)
                .map(index -> odds[index])
                .mapToObj(String::valueOf)
                .collect(joining(" ")));
    }
}
