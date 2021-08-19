package com.epam.rd.java.basic.practice6.part5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TreeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream STD_OUT = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(STD_OUT);
    }


    @Test
    public void shouldAddElement() {
        Tree<Integer> tree = new Tree<>();
        Assert.assertTrue(tree.add(3));
    }

    @Test
    public void shouldAddElements() {
        Tree<Integer> tree = new Tree<>();
        tree.add(new Integer[]{1, 2, 5, 4, 6, 0});
        tree.print();
        String expected = "  0\r\n" + "1\r\n" + "  2\r\n" + "      4\r\n" + "    5\r\n" + "      6\r\n";
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldRemoveElement() {
        Tree<Integer> tree = new Tree<>();
        tree.add(3);
        tree.add(1);
        tree.add(4);
        Assert.assertTrue(tree.remove(4));
    }
}
