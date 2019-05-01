package com.rriospinon.datastructures;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


/**
 * Created by rodrigo.rios on 2019-04-16.
 */
public class BinarySearchTree {

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

        BinarySearchTree binarySearchTree2 = new BinarySearchTree();

        binarySearchTree2.insert(52);
        binarySearchTree2.insert(-14);
        binarySearchTree2.insert(-14);
        binarySearchTree2.insert(2);
        binarySearchTree2.insert(51);
        binarySearchTree2.insert(-1);
        binarySearchTree2.insert(40);
        binarySearchTree2.insert(40);
        binarySearchTree2.insert(40);
        binarySearchTree2.insert(0);
        binarySearchTree2.insert(0);
        binarySearchTree2.printTree();
        System.out.println();

//    System.out.print("PRE: ");
//    binarySearchTree2.pre(binarySearchTree2.root);
//    System.out.println();

        System.out.print("IN: ");
        binarySearchTree2.in(binarySearchTree2.root);
        System.out.println();

//    System.out.print("POST: ");
//    binarySearchTree2.post(binarySearchTree2.root);
//    System.out.println();
//    // PRE
//    // IN
//    // POST
//    binarySearchTree2.printBfs();
//    binarySearchTree2.printDfs();


    }

    private void insert(int value) {

        if (root == null) {
            root = new Node(value);
        } else {

            Node tmp = root;

            while (tmp != null) {

                if (value == 2) {
                    System.out.println("Value " + tmp.value);
                }

                if (tmp.left == null && value <= tmp.value) {
                    tmp.left = new Node(value);
                    tmp = null;
                } else if (tmp.right == null && value > tmp.value) {
                    tmp.right = new Node(value);
                    tmp = null;
                } else {
                    if (value <= tmp.value) {
                        tmp = tmp.left;
                    } else {
                        tmp = tmp.right;
                    }
                }

            }
        }

    }


    private void printTree() {

        if (root != null) {

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

    private void pre(Node root) {

        if (root != null) {
            System.out.print(root.value + " ");
            pre(root.left);
            pre(root.right);
        }

    }

    private void in(Node root) {

        if (root != null) {
            in(root.left);
            System.out.print(root.value + " ");
            in(root.right);
        }

    }

    private void post(Node root) {

        if (root != null) {
            post(root.left);
            post(root.right);
            System.out.print(root.value + " ");
        }

    }

    private void printDfs() {

        System.out.print("DFS: ");

        if (root != null) {

            Stack<BinarySearchTree.Node> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {

                BinarySearchTree.Node current = stack.pop();

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

            java.util.Queue<BinarySearchTree.Node> queue = new ArrayDeque<>();

            queue.add(root);

            while (!queue.isEmpty()) {

                BinarySearchTree.Node current = queue.remove();

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


}
