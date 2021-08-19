package com.epam.rd.java.basic.practice6.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * Parking class simulates the operation of an n-local car parking.
 */

public class Parking {
    private List<Integer> list;
    private final int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            list.add(0);
        }
    }

    public boolean arrive(int k) {
        if (k < 0 || k > capacity - 1) {
            throw new IllegalArgumentException();
        }

        if (list.get(k) == 0) {
            list.set(k, 1);
            return true;
        }

        if (seekPosition(k, capacity)) {
            return true;
        }
        return seekPosition(0, k);
    }

    private boolean seekPosition(int k, int capacity) {
        for (int i = k; i < capacity; i++) {
            if (list.get(i) == 0) {
                list.set(i, 1);
                return true;
            }
        }
        return false;
    }

    public boolean depart(int k) {
        if (k < 0 || k > capacity - 1) {
            throw new IllegalArgumentException();
        }

        if (list.get(k) == 1) {
            list.set(k, 0);
            return true;
        }
        return false;
    }

    public void print() {
        for (Integer slot : list) {
            System.out.print(slot);
        }
        System.out.print(System.lineSeparator());
    }
}
