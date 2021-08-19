package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Demo class demonstrates the functionality of all the subtasks.
 */


public class Demo {
    private static final InputStream STD_IN = System.in;
    public static final String INPUT = "--input";
    public static final String FILENAME = "part6.txt";
    public static final String TASK = "--task";


    public static void main(String[] args) {
        System.out.println("________Part1_____________");
        System.setIn(new ByteArrayInputStream(("asd^43^asdf^asd^43\n" +
                "^434^asdf" +
                "\n^kasdf^asdf^stop^asdf" +
                "\n^stop\n\n").replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part1.main(new String[]{});
        System.setIn(STD_IN);
        System.out.println("________Part2_____________");
        Part2.main(new String[]{});
        System.out.println("________Part3_____________");
        Part3.main(new String[]{});
        System.out.println("________Part4_____________");
        Part4.main(new String[]{});
        System.out.println("________Part5_____________");
        Part5.main(new String[]{});

        System.out.println("~~~~~~~~~~~~Part6");
        Part6.main(new String[]{INPUT, FILENAME, TASK, "frequency"});
        Part6.main(new String[]{INPUT, FILENAME, TASK, "length"});
        Part6.main(new String[]{INPUT, FILENAME, TASK, "duplicates"});

    }

}
