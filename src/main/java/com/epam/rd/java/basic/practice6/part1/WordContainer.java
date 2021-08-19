package com.epam.rd.java.basic.practice6.part1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * WordContainer - contains the required functionality.
 */
public class WordContainer {
    private HashMap<String, Word> map;

    public WordContainer() {
        this.map = new HashMap<>();
    }

    public static void main(String[] args) {
        WordContainer wc = new WordContainer();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            if (!line.equals("stop")) {
                addWord(wc, line);
            } else {
                break;
            }
        }
        wc.map.entrySet().stream()
                .sorted(Comparator.comparingInt(w -> -w.getValue().getFrequency()))
                .forEach(w -> System.out.println(w.getValue().getContent() + " : " + w.getValue().getFrequency()));
    }

    private static void addWord(WordContainer wc, String line) {
        if (wc.map.containsKey(line) && wc.map.get(line).getContent().compareTo(line) == 0) {
            wc.map.get(line).increaseFrequency();
        } else {
            wc.map.put(line, new Word(line));
        }
    }
}
