package com.epam.rd.java.basic.practice6.part5;

/**
 * Tree class that implements a binary search tree data structure.
 *
 * @param <E>
 */

public class Tree<E extends Comparable<E>> {
    private static final String INDENT = "  ";
    Node<E> root;

    public Tree() {
        this.root = null;
    }

    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(null, element);
            return true;
        }
        return addRecursive(root, element);
    }

    private boolean addRecursive(Node<E> current, E element) {
        if (element.compareTo(current.element) < 0) {
            if (current.left == null) {
                current.left = new Node<>(current, element);
                return true;
            }
            return addRecursive(current.left, element);

        } else if (element.compareTo(current.element) > 0) {
            if (current.right == null) {
                current.right = new Node<>(current, element);
                return true;
            }
            return addRecursive(current.right, element);
        }
        return false;
    }

    public void add(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public boolean remove(E element) {
        if (root == null) {
            return false;
        }
        return removeRecursive(root, element);
    }

    private boolean removeRecursive(Node<E> current, E element) {
        if (element.compareTo(current.element) < 0) {
            if (current.left == null) {
                return false;
            }
            return removeRecursive(current.left, element);
        } else if (element.compareTo(current.element) > 0) {
            if (current.right == null) {
                return false;
            }
            return removeRecursive(current.right, element);
        } else if (element.compareTo(current.element) == 0) {
            return nodeToDeleteFound(current, element);
        }
        return false;
    }

    private boolean nodeToDeleteFound(Node<E> current, E element) {
        // 1 case: node has no children
        if (nodeHasNoChildren(current)) {
            return true;
        }
        //2 case: node doesn't have left or right child
        if ((current.right == null || current.left == null) && element == current.parent.left.element) {
            return goingByLeftSide(current);
        } else if ((current.right == null || current.left == null) && element == current.parent.right.element) {
            return goingByRightSide(current);
        } else {
            //3 case: node has left and right children
            return nodeHasBothChildren(current);
        }
    }

    private boolean nodeHasBothChildren(Node<E> current) {
        if (current.right == null) {
            return false;
        }
        E smallestValue = findSmallestValue(current.right);
        current.element = smallestValue;
        removeRecursive(current.right, smallestValue);
        return true;
    }

    private boolean goingByRightSide(Node<E> current) {
        if (current.right == null) {
            current.parent.right = current.left;
            return true;
        } else if (current.left == null) {
            current.parent.right = current.right;
            return true;
        }
        return false;
    }

    private boolean goingByLeftSide(Node<E> current) {
        if (current.right == null) {
            current.parent.left = current.left;
            return true;
        } else if (current.left == null) {
            current.parent.left = current.right;
            return true;
        }
        return false;
    }

    private boolean nodeHasNoChildren(Node<E> current) {
        if (current.left == null && current.right == null) {
            if (current.parent.left == current) {
                current.parent.left = null;
            } else {
                current.parent.right = null;
            }
            return true;
        }
        return false;
    }

    private E findSmallestValue(Node<E> current) {
        return current.left == null ? current.element : findSmallestValue(current.left);
    }

    public void print() {
        print(root, "");
    }

    private void print(final Node<E> current, final String indent) {
        if (current == null) {
            return;
        }
        print(current.left, indent + INDENT);
        System.out.println(indent + current.element);
        print(current.right, indent + INDENT);
    }

    private static final class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(Node<E> parent, E element) {
            this.parent = parent;
            this.element = element;
            right = null;
            left = null;
        }
    }
}
