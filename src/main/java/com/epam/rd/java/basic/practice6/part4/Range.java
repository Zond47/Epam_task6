package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Range class, which would be a range of numbers [n, m].
 */
public class Range implements Iterable<Integer> {
    private int[] array;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        array = new int[secBound - firstBound + 1];
        for (int i = 0; i < array.length; i++) {
            if (reversedOrder) {
                array[i] = secBound;
                secBound--;
            } else {
                array[i] = firstBound;
                firstBound++;
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<Integer> {
        int lastIndex = -1;

        @Override
        public boolean hasNext() {
            return lastIndex != array.length - 1;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                lastIndex++;
                return array[lastIndex];
            }
            throw new NoSuchElementException();
        }
    }
}
