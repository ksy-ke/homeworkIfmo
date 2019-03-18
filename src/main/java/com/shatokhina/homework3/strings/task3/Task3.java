package com.shatokhina.homework3.strings.task3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in).nextLine();
        int[] numbers = Pattern.compile("\\d+").matcher(input)
                .results()
                .map(MatchResult::group)
                .mapToInt(Integer::valueOf)
                .toArray();
        System.out.println(Arrays.toString(numbers));
   }
}