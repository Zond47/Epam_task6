package com.epam.rd.java.basic.practice6.part2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Part2Test {
    List<Integer> arrList;
    List<Integer> linkList;
    final int K = 3;

    @Before
    public void setUp() {
        arrList = new ArrayList<>();
        linkList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            arrList.add(i);
        }
        for (int i = 0; i < 10000; i++) {
            linkList.add(i);
        }
    }

    @After
    public void restoreStreams() {
        arrList = new ArrayList<>();
        linkList = new LinkedList<>();
    }

    @Test
    public void removeByIndex_ArrayListShouldBeFasterAtLeastFourTimesThanLinkedList() {
        long arrTime = Part2.removeByIndex(arrList, K);
        long linkTime = Part2.removeByIndex(linkList, K);
        assertTrue(linkTime / arrTime > 4);
    }

    @Test
    public void removeByIterator_LinkedListShouldBeFasterInMostCasesThanArrayList() {
        long arrTime = Part2.removeByIterator(arrList, K);
        long linkTime = Part2.removeByIterator(linkList, K);
        assertTrue(linkTime < arrTime);
    }
}