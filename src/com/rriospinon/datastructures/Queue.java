package com.rriospinon.datastructures;

/**
 * Created by rodrigo.rios on 2019-03-31.
 */
public class Queue {

    private static Node head;
    private static Node tail;


    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.print();

        queue.dequeue();
        queue.print();

        System.out.println("First element in queue: " + queue.peek());

        queue.enqueue(10);
        queue.enqueue(11);
        queue.print();

        queue.dequeue();
        queue.print();

        System.out.println("First element in queue: " + queue.peek());


    }

    private static boolean isEmpty() {

        return head == null;

    }

    private static void enqueue(int value) { //put element on the queue

        if (isEmpty()) {
            head = new Node(value, head, tail);
            tail = head;
        } else {

            tail.next = new Node(value, null, tail);
            tail = tail.next;
        }

    }

    private static int dequeue() { //remove an element from the queue

        if (isEmpty()) {
            throw new IllegalArgumentException("Empty com.rriospinon.datastructures.Queue");
        }

        int value = head.value;
        head = head.next;
        head.previous = null;

        return value;

    }


    private static int peek() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Empty com.rriospinon.datastructures.Queue");
        }

        return head.value;
    }

    private static void print() {

        Node current = head;

        while (current != null) {

            System.out.print(current.value + " ");
            current = current.next;

        }

        System.out.println();

    }


    static class Node {

        int value;
        Node next;
        Node previous;

        Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;

        }
    }

}
