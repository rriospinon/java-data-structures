package com.rriospinon.datastructures;

/**
 * Created by rodrigo.rios on 2019-03-28.
 */
public class CustomDoubleLinkedList {


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.push(1);
        linkedList.printList();
        linkedList.printReverse();
        linkedList.push(2);
        linkedList.printList();
        linkedList.printReverse();
        linkedList.push(3);
        linkedList.printList();
        linkedList.printReverse();

        linkedList.push(4);
        linkedList.printList();
        linkedList.printReverse();

        linkedList.delete(3);
        linkedList.printList();
        linkedList.printReverse();


        linkedList.insertAfter(1, 0);

        linkedList.printList();
        linkedList.printReverse();

        linkedList.append(5);

        linkedList.printList();
        linkedList.printReverse();

        linkedList.push(5, 3);

        linkedList.printList();
        linkedList.printReverse();


    }


    static class LinkedList {

        private Node root;

        LinkedList() {
            root = null;
        }

        private void push(int value) {
            root = new Node(value, null, root);

            if (root.next != null) {
                root.next.previous = root;
            }

        }

        private int get() {

            return root.value;

        }

        private void insertAfter(int referenceValue, int value) {  // insert after a node

            if (isEmpty()) {
                throw new IllegalArgumentException("Empty List");
            }

            Node current = root;

            boolean insertedNode = false;

            do {

                if (current.value == referenceValue) {

                    Node newNode = new Node(value, current, current.next);

                    if (current.next != null) {
                        current.next.previous = newNode;

                    }

                    current.next = newNode;

                    insertedNode = true;

                }

                current = current.next;

            } while (!insertedNode && current != null);


        }


        private void append(int value) { // add at the end

            Node current = root;

            if (isEmpty()) {

                root = new Node(value, null, root);
            }

            while (current.next != null) {

                current = current.next;


            }

            current.next = new Node(value, current, current.next);


        }

        private void push(int headValue, int value) { // insert before the head node

            if (isEmpty()) {
                throw new IllegalArgumentException("Empty List");
            }

            Node current = root;

            boolean insertedNode = false;

            do {

                if (current.value == headValue) {

                    Node newNode = new Node(value, current.previous, current);

                    current.previous.next = newNode;
                    current.previous = newNode;

                    insertedNode = true;

                }

                current = current.next;

            } while (!insertedNode && current != null);

        }


        private int remove() { //Get the head

            if (!isEmpty()) {

                int value = root.value;

                root = root.next;
                root.previous = null;

                return value;

            } else {

                throw new IllegalArgumentException("emptyList");
            }


        }

        private void delete(int value) {

            if (!isEmpty() && root.value == value) {
                root = root.next;
                root.previous = null;
            } else {

                Node previous = root;
                Node current = previous.next;

                while (current != null) {
                    if (current.value == value) {
                        previous.next = current.next;
                        if (current.next != null) {
                            current.next.previous = previous;
                        }
                        current = null;
                    } else {
                        previous = current;
                        current = current.next;
                    }
                }

            }
        }

        private boolean isEmpty() {

            return root == null;

        }

        public void printList() {
            Node current = root;
            while (current != null) {
                System.out.print(current.value + "->");
                current = current.next;
            }
            System.out.println();
        }

        public void printReverse() {

            if (!isEmpty()) {

                Node previous = root;
                Node current = previous.next;

                while (current != null) {
                    current = current.next;
                    previous = previous.next;
                }

                while (previous != null) {
                    System.out.print(previous.value + "<-");
                    previous = previous.previous;
                }

                System.out.println();

            }


        }

        @Override
        public String toString() {

            StringBuilder linkedListAppender = new StringBuilder("[");

            Node current = root;

            while (!isEmpty() && current.next != null) {

                linkedListAppender.append(current.value).append(",");

                current = current.next;
            }

            if (current != null) {
                linkedListAppender.append(current.value);
            }

            linkedListAppender.append("]");

            return linkedListAppender.toString();

        }

    }


    static class Node {

        private int value;
        private Node next;
        private Node previous;

        Node(int value) {

            this.value = value;

        }

        Node(int value, Node previous, Node next) {

            this.value = value;
            this.next = next;
            this.previous = previous;

        }

    }

}
