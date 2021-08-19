package com.epam.rd.java.basic.practice6.part6;

import java.util.*;

/**
 * Part61 to find the three longest words.
 */
public class Part62 {
    public static void main(String[] args) {
        length(args[0]);
    }

    private static void length(String fileName) {
        String[] numbers = Part6.getInput(fileName).split("[ \r\n]+");
        Map<String, Integer> longest = new LinkedHashMap<>();
        Arrays.stream(numbers).forEach(e -> longest.put(e, e.length()));
        longest.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed())
                .limit(3)
                .forEach(e -> System.out.printf("%s ==> %d%n", e.getKey(), e.getValue()));
    }
}
