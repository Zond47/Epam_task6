package com.epam.rd.java.basic.practice6.part6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part6Test {
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
    public void shouldExecuteFrequencyTask() {
        Part6.main(new String[]{"--input", "part6.txt", "--task", "frequency"});
        String expected = "whale ==> 3\r\n" +
                "cheetah ==> 4\r\n" +
                "bison ==> 3\r\n";
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldExecuteLengthTask() {
        Part6.main(new String[]{"--input", "part6.txt", "--task", "length"});
        String expected = "chimpanzee ==> 10\r\n" +
                "mongoose ==> 8\r\n" +
                "tortoise ==> 8\r\n";
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldExecuteDuplicatesTask() {
        Part6.main(new String[]{"--input", "part6.txt", "--task", "duplicates"});
        String expected = "RAUGAJ\r\n" +
                "NOSIB\r\n" +
                "ELAHW\r\n";
        Assert.assertEquals(expected, outContent.toString());
    }
}
