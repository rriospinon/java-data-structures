package com.rriospinon.datastructures;

/**
 * Created by rodrigo.rios on 2019-03-31.
 */
public class CustomStack {

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();

        stack.pop();
        stack.print();

        System.out.println(stack.peek());
        stack.print();

        stack.pop();
        stack.print();

        stack.pop();
        stack.print();

        stack.pop();
        stack.print();

    }

    private static class Stack {

        private static Node root;

        private int peek() { //get the top of the stack

            if (isEmpty()) {
                throw new IllegalArgumentException("Empty Stack");
            }

            return root.value;

        }

        private boolean isEmpty() {

            return root == null;

        }

        private int pop() { //remove top of the stack

            if (isEmpty()) {
                throw new IllegalArgumentException("Empty Stack");
            }

            int value = root.value;

            root = root.next;

            return value;

        }

        private void push(int value) {

            root = new Node(value, root);

        }

        private void print() {

            Node current = root;

            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }

            System.out.println();

        }

    }

    static class Node {

        int value;
        Node next;

        Node(int value, Node next) {
            this.next = next;
            this.value = value;

        }
    }

}
