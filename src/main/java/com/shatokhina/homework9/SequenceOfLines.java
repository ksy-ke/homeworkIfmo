package com.shatokhina.homework9;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceOfLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = Stream.generate(scanner::nextLine)
                .limit(10)
                .collect(Collectors.toList());

        int count = 0;
        for (String line:lines) {
            if (line.length() > count) count = line.length();
            else {
                System.out.println(line);
                break;
            }
        }
    }
}
