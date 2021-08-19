package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Part6 accepts command line arguments.
 */

public class Part6 {
    private static String fileName;
    private static String task;

    public static void main(String[] args) {
        if (args[0].equals("-i") || args[0].equals("--input")) {
            fileName = args[1];
        } else if (args[2].equals("-i") || args[2].equals("--input")) {
            fileName = args[3];
        }
        if (args[2].equals("-t") || args[2].equals("--task")) {
            task = args[3];
        } else if (args[0].equals("-t") || args[0].equals("--task")) {
            task = args[1];
        }

        switch (task) {
            case "frequency":
                Part61.main(new String[]{fileName});
                break;
            case "length":
                Part62.main(new String[]{fileName});
                break;
            case "duplicates":
                Part63.main(new String[]{fileName});
                break;
            default:
                System.out.print("Such task does not exist.");
        }
    }

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
        return sb.toString();
    }
}
