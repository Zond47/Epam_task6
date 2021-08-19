package com.epam.rd.java.basic.practice6.part6;

import java.util.*;

/**
 * Part61 to find the most frequent three words.
 */

public class Part61 {
    private static void frequency(String fileName) {
        String[] numbers = Part6.getInput(fileName).split("[ \r\n]+");
        Map<String, Integer> duplicates = new LinkedHashMap<>();
        Arrays.stream(numbers).forEach(e -> duplicates.put(e, duplicates.get(e) == null ? 1 : duplicates.get(e) + 1));
        duplicates.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed())
                .limit(3)
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getKey).reversed())
                .forEach(e -> System.out.printf("%s ==> %d%n", e.getKey(), e.getValue()));
    }

    public static void main(String[] args) {
        frequency(args[0]);
    }

}
