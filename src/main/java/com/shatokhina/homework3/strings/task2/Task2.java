package com.shatokhina.homework3.strings.task2;

import java.util.LinkedHashSet;
import java.util.Scanner;

import static java.util.stream.Collectors.toCollection;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Enter string: ");
        new Scanner(System.in).nextLine().chars()
                .filter(character -> character != ' ')
                .mapToObj(code -> (char) code)
                .collect(toCollection(LinkedHashSet::new))
                .forEach(System.out::print);
    }
}