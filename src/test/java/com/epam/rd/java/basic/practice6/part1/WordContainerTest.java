package com.epam.rd.java.basic.practice6.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class WordContainerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream STD_OUT = System.out;
    private final InputStream STD_IN = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream(("A^B^A^A^B\n" +
                "\n^A^B^stop^C" +
                "\n^stop\n\n").replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
    }

    @After
    public void restoreStreams() {
        System.setOut(STD_OUT);
        System.setIn(STD_IN);
    }

    @Test
    public void shouldIgnoreWordsAfterStop() {
        Part1.main(new String[]{});
        String expected = "A : 4\r\nB : 3\r\nC : 1\n";
        Assert.assertNotEquals(expected, outContent.toString());
    }

    @Test
    public void shouldCalculateWordsCorrectly() {
        Part1.main(new String[]{});
        String expected = "A : 4\r\nB : 3\r\n";
        Assert.assertEquals(expected, outContent.toString());
    }
}
