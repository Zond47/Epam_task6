package com.epam.rd.java.basic.practice6.part1;

import java.util.Objects;

/**
 * Word - is set in correspondence to a model ‘a word with information about its frequency in the text’.
 */
public class Word implements Comparable<Word> {
    private String content;
    private int frequency;

    public Word(String content) {
        this.content = content;
        frequency = 1;
    }

    public String getContent() {
        return content;
    }

    public void increaseFrequency() {
        frequency++;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Word o) {
        if (!this.content.equals(o.content)) {
            return this.content.compareTo(o.content);
        }
        return this.frequency - o.frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return frequency == word.frequency && Objects.equals(content, word.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, frequency);
    }
}
