package com.epam.rd.java.basic.practice6.part5;

/**
 * Demonstrate the functionality of the Tree application.
 */
public class Part5 {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        System.out.println(tree.add(3));
        System.out.println(tree.add(3));
        tree.add(new Integer[]{1, 2, 5, 4, 6, 0});
        tree.print();
        System.out.println(tree.remove(5));
        System.out.println(tree.remove(5));
        tree.print();
    }
}
