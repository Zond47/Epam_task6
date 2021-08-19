package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * part 63 - find the first three words that have duplicates.
 */
public class Part63 {
    public static void main(String[] args) {
        duplicates(args[0]);
    }

    private static void duplicates(String fileName) {
        String[] numbers = Part6.getInput(fileName).split("[ \r\n]+");
        Map<String, Integer> duplicates = new LinkedHashMap<>();
        Arrays.stream(numbers).forEach(e -> duplicates.put(e, duplicates.get(e) == null ? 1 : duplicates.get(e) + 1));
        duplicates.entrySet().stream()
                .filter(v -> (v.getValue() > 1))
                .limit(3)
                .forEach(e -> System.out.println(new StringBuilder(e.getKey()).reverse().toString().toUpperCase()));
    }
}
