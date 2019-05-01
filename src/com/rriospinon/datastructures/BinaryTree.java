package com.rriospinon.datastructures;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rodrigo.rios on 2019-04-16.
 */
public class BinaryTree {

    private Node root;
    private int size;

    private class Node {

        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {

//    com.rriospinon.datastructures.BinaryTree binaryTree = new com.rriospinon.datastructures.BinaryTree();
//
//    binaryTree.insert(1);
//    binaryTree.insert(2);
//    binaryTree.insert(3);
//
//    System.out.println("Size: " + binaryTree.getSize());
//    System.out.println("Depth: " + binaryTree.getDepth());
//
//    binaryTree.insert(4);
//    binaryTree.insert(5);
//
//    System.out.println("Size: " + binaryTree.getSize());
//    System.out.println("Depth: " + binaryTree.getDepth());
//
//    System.out.println(binaryTree.find(3));
//    System.out.println(binaryTree.find(7));
//
//    binaryTree.insert(6);

        BinaryTree binaryTree2 = new BinaryTree();

        binaryTree2.insert(1);
        binaryTree2.insert(2);
        binaryTree2.insert(3);
        binaryTree2.insert(4);
        binaryTree2.insert(5);
        binaryTree2.insert(6);
        binaryTree2.insert(7);
        binaryTree2.insert(8);
        binaryTree2.insert(9);
        binaryTree2.insert(10);
        binaryTree2.insert(11);
        binaryTree2.insert(12);
        binaryTree2.insert(13);
        binaryTree2.insert(14);
        binaryTree2.insert(15);

        binaryTree2.printBfs();
        binaryTree2.printDfs();
        binaryTree2.printTree();


    }

    private void insert(int value) {

        if (root == null) {
            root = new Node(value);
        } else {

            java.util.Queue<Node> queue = new ArrayDeque<>();

            queue.add(root);

            while (!queue.isEmpty()) {

                Node current = queue.remove();

                if (current.left == null) {
                    System.out.println("insert " + value + " on left of " + current.value);
                    current.left = new Node(value);
                    queue.clear();
                } else {
                    queue.add(current.left);

                    if (current.right == null) {
                        System.out.println("insert " + value + " on right of " + current.value);
                        current.right = new Node(value);
                        queue.clear();
                    } else {
                        queue.add(current.right);
                    }
                }


            }

        }

        size++;

    }

    private boolean find(int elementToFind) {

        if (root == null) {
            return false;
        }

        Stack<Node> nodeStack = new Stack<>();

        nodeStack.push(root);

        while (!nodeStack.empty()) {

            Node current = nodeStack.pop();

            if (current.value == elementToFind) {
                return true;
            } else {
                if (current.left != null) {
                    nodeStack.push(current.left);
                }
                if (current.right != null) {
                    nodeStack.push(current.right);
                }
            }

        }

        return false;

    }

    private int getSize() {
        return size;
    }

    private int getDepth() {

        int depth = 0;
        int tmp = size;
        while (tmp > 0) {
            tmp = tmp / 2;
            depth++;
        }

        return depth;

    }


    private void printDfs() {

        System.out.print("DFS: ");

        if (root != null) {

            Stack<Node> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {

                Node current = stack.pop();

                System.out.print(current.value + " ");

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }

            }

        }

        System.out.println();

    }

    private void printBfs() {

        System.out.print("BFS: ");

        if (root != null) {

            java.util.Queue<Node> queue = new ArrayDeque<>();

            queue.add(root);

            while (!queue.isEmpty()) {

                Node current = queue.remove();

                System.out.print(current.value + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }


            }

        }

        System.out.println();


    }

    private void printTree() {

        if (root != null) {

            System.out.println("Level: ");

            Queue queue = new ArrayDeque<>();

            queue.add(-1);
            queue.add(1);
            queue.add(root);

            int previousParent = -1;
            int previousLevel = 0;

            while (!queue.isEmpty()) {

                int currentParent = (int) queue.remove();
                int currentLevel = (int) queue.remove();
                Node current = (Node) queue.remove();

                if (current.left != null) {
                    queue.add(current.value);
                    queue.add(currentLevel + 1);
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.value);
                    queue.add(currentLevel + 1);
                    queue.add(current.right);
                }

                if (previousLevel != currentLevel) {
                    previousLevel = currentLevel;
                    System.out.println();
                } else if (previousParent != currentParent) {
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }

                System.out.print(current.value);

                previousParent = currentParent;

            }

        }
    }

}
