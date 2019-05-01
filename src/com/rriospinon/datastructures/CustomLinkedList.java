package com.rriospinon.datastructures;

/**
 * Created by rodrigo.rios on 2019-03-28.
 */
public class CustomLinkedList<T> {


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.printList();
        linkedList.insert(2);
        linkedList.printList();
        linkedList.insert(3);
        linkedList.printList();

//    linkedList.remove();
//    linkedList.remove();
//    linkedList.remove();
//    linkedList.printList();
//
//    linkedList.insert(1);
//    linkedList.insert(2);
//    linkedList.insert(3);
//
//    linkedList.printList();

        linkedList.delete(3);
        linkedList.delete(2);
        linkedList.printList();


    }


    static class LinkedList {

        private Node root;

        LinkedList() {
            root = null;
        }

        private void insert(int value) {
            root = new Node(value, this.root);
        }

        private int get() {

            return root.value;

        }

        private int remove() { //Get the head

            if (!isEmpty()) {

                int value = root.value;

                root = root.next;

                return value;

            } else {

                throw new IllegalArgumentException("emptyList");
            }


        }

        private void delete(int value) {

            if (!isEmpty() && root.value == value) {
                root = root.next;
            } else {

                Node previous = root;
                Node current = previous.next;

                while (current != null) {
                    if (current.value == value) {
                        previous.next = current.next;
                        current = null;
                    } else {
                        previous = current;
                        current = current.next;
                    }
                }

                if (current == null) {
                    System.out.println("Value not found");
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

        Node(int value) {

            this.value = value;

        }

        Node(int value, Node next) {

            this.value = value;
            this.next = next;

        }

    }

}
