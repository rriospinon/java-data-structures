package com.rriospinon.datastructures;

import java.util.Arrays;


/**
 * Created by rodrigo.rios on 2019-04-19.
 */
public class Heap {

    public static void main(String[] args) {

        MinHeap min = new MinHeap();

        min.insert(5);
        min.insert(7);
        min.insert(2);
        min.insert(6);
        min.insert(1);

        min.print();

        System.out.println("MIN: " + min.removeMin());
        System.out.println("MIN: " + min.removeMin());
        min.print();
        min.insert(0);

        min.print();

    }


    static class MinHeap {

        private int[] heap = new int[15];
        private int indexToInsert = 0;

        MinHeap() {
            Arrays.fill(heap, Integer.MIN_VALUE);
        }


        void insert(int value) {

            heap[indexToInsert++] = value;

            indexHelper(indexToInsert - 1);


        }

        private void indexHelper(int index) {

            if (index > 0) {

                int parentIndex = getParent(index);

                if (heap[index] < heap[parentIndex]) {

                    swap(index, parentIndex);

                }

                indexHelper(parentIndex);
            }

        }

        private void print() {
            for (int i = 0; i < indexToInsert; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println("\nNext Index: " + indexToInsert);
        }

        int getParent(int index) {
            return (index - 1) / 2;
        }

        private void heapify() {

            int parentIndex = 0;
            int leftChildIndex;
            int rightChildIndex;

            while (parentIndex < (indexToInsert / 2)) {

                leftChildIndex = getLeftChild(parentIndex);
                rightChildIndex = getRightChild(parentIndex);

                if (heap[parentIndex] > heap[leftChildIndex] || heap[parentIndex] > heap[rightChildIndex]) {

                    if (heap[leftChildIndex] < heap[rightChildIndex]) {
                        swap(leftChildIndex, parentIndex);
                        parentIndex = leftChildIndex;
                    } else {
                        if (rightChildIndex < indexToInsert) {
                            swap(rightChildIndex, parentIndex);
                            parentIndex = rightChildIndex;
                        } else {
                            parentIndex = indexToInsert;
                        }
                    }

                } else {
                    parentIndex = indexToInsert;
                }

            }

        }


        private void swap(int indexOne, int indexTwo) {

            System.out.println("Swap: " + heap[indexOne] + ", " + heap[indexTwo]);

            int tmp = heap[indexOne];
            heap[indexOne] = heap[indexTwo];
            heap[indexTwo] = tmp;

        }

        int getLeftChild(int index) {
            return (index * 2) + 1;
        }

        int getRightChild(int index) {
            return (index * 2) + 2;
        }

        int getMin() {
            return heap[0];
        }

        int removeMin() {

            int min = heap[0];

            heap[0] = heap[indexToInsert - 1];
            heap[indexToInsert - 1] = Integer.MIN_VALUE;

            indexToInsert--;

            System.out.print("Before heapify:");
            print();

            heapify();

            return min;

        }


    }


//
//  int removeMin() {
//
//    if (heap.isEmpty()) {
//      return Integer.MIN_VALUE;
//    }
//
//    return heap.remove(0);
//
//  }

    //getMin
    //ExtractMin
    //Insert

//}

}
