package com.shatokhina.homework3.arrays.task1;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class EvenNumbers {
    public static void main(String[] args) {
        int[] evens = IntStream.range(1, 21).filter(number -> number % 2 == 0).toArray();

        Supplier<Stream<String>> createStream = () -> stream(evens).mapToObj(String::valueOf);

        String horizontal = createStream.get().collect(joining(" "));
        String vertical = createStream.get().collect(joining("\n\n"));

        System.out.println(horizontal + "\n" + vertical);
    }
}