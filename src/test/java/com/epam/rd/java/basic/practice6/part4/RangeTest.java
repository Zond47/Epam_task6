package com.epam.rd.java.basic.practice6.part4;

import org.junit.Test;

public class RangeTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfPlaceIndexIsOutOfRange() {
        Range range = new Range(3, 4);
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d ", range.iterator());
        }
    }
}
