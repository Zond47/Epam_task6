package com.epam.rd.java.basic.practice6.part2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Part 3 - deletes every third element from the array.
 */
public class Part2 {
    private static final int N = 10000;
    private static final int K = 4;

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();
        fillList(arrList, N);
        System.out.println("ArrayList#Index: " + removeByIndex(arrList, K) + " ms");
        fillList(linkList, N);
        System.out.println("LinkedList#Index: " + removeByIndex(linkList, K) + " ms");

        arrList = new ArrayList<>();
        fillList(arrList, N);
        System.out.println("ArrayList#Iterator: " + removeByIterator(arrList, K) + " ms");
        linkList = new LinkedList<>();
        fillList(linkList, N);
        System.out.println("LinkedList#Iterator: " + removeByIterator(linkList, K) + " ms");
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long startTime = Instant.now().toEpochMilli();
        int local = 0;
        while (list.size() != 1) {
            local += (k - 1);
            while (local >= list.size()) {
                local = local - list.size();
            }
            list.remove(local);
        }
        long endTime = Instant.now().toEpochMilli();
        return endTime - startTime;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long startTime = Instant.now().toEpochMilli();
        int count = 0;
        Iterator<Integer> it = list.iterator();
        while (list.size() > 1) {
            if (it.hasNext()) {
                it.next();
                count++;
                if (count == k) {
                    it.remove();
                    count = 0;
                }
            } else {
                it = list.iterator();
            }
        }
        long endTime = Instant.now().toEpochMilli();
        return endTime - startTime;
    }

    private static void fillList(List<Integer> list, int number) {
        for (int i = 0; i < number; i++) {
            list.add(i);
        }
    }

}
