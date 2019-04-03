package com.shatokhina.homework10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WarAndPeace {
    private final Path path;

    WarAndPeace(String path) {
        this.path = Paths.get(path);
    }

    private Stream<String> createStream() {
        Stream<String> streamLines = null;
        try {
            streamLines = Files.lines(path)
                    .map(String::toLowerCase);
        } catch (IOException e) { e.printStackTrace(); }
        return streamLines;
    }

    Map<String, Double> literal() {
        Map<String, Double> letters = new HashMap<>();
        createStream()
                .flatMap(WarAndPeace::literalInString)
                .forEach(literal -> letters.merge(literal, 1.0, Double::sum));

        int sum = 0;
        for (Double d : letters.values()) sum += d;

        final double totalNumber = sum;
        letters.forEach((key, value) -> letters.put(key, value * 100 / totalNumber));

        return letters;
    }

    Map<Integer, Set<String>> collectWordsBySize() {
        Map<Integer, Set<String>> wordsBySize = new HashMap<>();
        createStream()
                .flatMap(WarAndPeace::wordInString)
                .forEach(word -> wordsBySize.computeIfAbsent(word.length(), HashSet::new).add(word));
        return wordsBySize;
    }

    Map<String, Integer> countWords() {
        Map<String, Integer> words = new HashMap<>();
        createStream()
                .flatMap(WarAndPeace::wordInString)
                .forEach(word -> words.merge(word, 1, Integer::sum));
        return words;
    }

    Map<String, Integer> topWords() {
        Map<String, Integer> countTopWords = new LinkedHashMap<>();
        countWords()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(pair -> countTopWords.put(pair.getKey(), pair.getValue()));
        return countTopWords;
    }

    private static Stream<String> wordInString(String string) {
        return Pattern.compile("([\\p{Alpha}]+\'[\\p{Alpha}]+)|([\\p{Alpha}]{2,})")
                .matcher(string)
                .results()
                .map(MatchResult::group);
    }

    private static Stream<String> literalInString(String string) {
        return Pattern.compile("[\\p{Alpha}]{1}")
                .matcher(string)
                .results()
                .map(MatchResult::group);
    }

    public static void main(String[] args) {
        WarAndPeace warAndPeace = new WarAndPeace("C:\\temp\\wp.txt");

        System.out.println("Word frequency: ");
        warAndPeace.countWords().forEach((word, count) -> System.out.println(word + " " + count));
        System.out.println("\nGroups of words along their length: ");
        warAndPeace.collectWordsBySize().forEach((length, set) -> System.out.println(length + ": \n " + set.toString()));
        System.out.println("\nTop 10 words:");
        warAndPeace.topWords().forEach((word, count) -> System.out.println(word + " " + count));
        System.out.println("\nPercentage of letters: ");
        warAndPeace.literal().forEach((literal, count) -> System.out.println(literal + " " + count));
    }
}