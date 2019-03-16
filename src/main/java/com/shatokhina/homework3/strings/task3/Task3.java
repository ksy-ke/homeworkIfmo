package com.shatokhina.homework3.strings.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d+");
        String input = new Scanner(System.in).nextLine();

        Matcher matcher = pattern.matcher(input);
        List<String> numbers = new ArrayList<>();
        while (matcher.find()) { numbers.add(matcher.group()); }

        for (String current : numbers) { System.out.print(current + " "); }
    }
}
