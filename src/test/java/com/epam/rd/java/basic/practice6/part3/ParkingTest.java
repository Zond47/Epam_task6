package com.epam.rd.java.basic.practice6.part3;

import org.junit.Assert;
import org.junit.Test;

public class ParkingTest {

    public static final int CAPACITY = 4;

    @Test
    public void testArrive() {
        Parking parking = new Parking(CAPACITY);
        Assert.assertTrue(parking.arrive(1));
    }

    @Test
    public void testArrivetoFullParking() {
        Parking parking = new Parking(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            parking.arrive(0);
        }
        Assert.assertFalse(parking.arrive(1));
    }

    @Test
    public void testDepart() {
        Parking parking = new Parking(CAPACITY);
        Assert.assertFalse(parking.depart(1));

    }
}