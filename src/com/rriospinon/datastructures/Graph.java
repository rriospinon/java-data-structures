package com.rriospinon.datastructures;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by rodrigo.rios on 2019-04-21.
 */
public class Graph {

    private int[][] nodes = new int[6][6];

  /*
    [[2,3],[2,1],[1,5],[3,1],[4,5],[5,2], 1]
    [[2,3],[2,1],[1,5],[3,1],[4,5],[5,2], 0]
    [[List of edges], bidirectional(1=true)]
   */

    public static void main(String[] args) {

        Graph graphUnidirectional = new Graph();
        String str1 = "[[2,3,2],[2,1,10],[1,5,4],[3,1,7],[4,5,4],[5,2,-1], 0]";
        graphUnidirectional.readGraph(str1);
        graphUnidirectional.dfs(5, 0);
        System.out.println();
        graphUnidirectional.dfs(5, -1);
        System.out.println();
        graphUnidirectional.bfs(5, 0);
        System.out.println();
        graphUnidirectional.bfs(5, -1);
        System.out.println();

        Graph graphBidirectional = new Graph();
        String str2 = "[[2,3,3],[2,1,4],[1,5,6],[3,1,-8],[4,5,-2],[5,2,1], 1]";
        graphBidirectional.readGraph(str2);
//    graphBidirectional.printAdjacencyList();
//    graphBidirectional.printMatrix();
        graphBidirectional.dfs(5, 0);
        System.out.println();
        graphBidirectional.dfs(5, -1);
        System.out.println();
        graphBidirectional.bfs(5, 0);
        System.out.println();
        graphBidirectional.bfs(5, -1);
//    graphBidirectional.bfs(5, 3);
//    System.out.println();
//    graphBidirectional.bfs(5, 4);

    }

    private void readGraph(String str) {

        String[] splitString = str.split("],");

        splitString[splitString.length - 1] = splitString[splitString.length - 1].replaceAll("]", "").replaceAll(" ", "");

        boolean bidirectional = "1".equals(splitString[splitString.length - 1]);

        splitString[0] = splitString[0].substring(1);

        for (int i = 0; i < splitString.length - 1; i++) {

            int a = Integer.parseInt(splitString[i].substring(1, 2));
            int b = Integer.parseInt(splitString[i].substring(3, 4));
            int c = Integer.parseInt(splitString[i].substring(5));

            nodes[a][b] = c;
            if (bidirectional) {
                nodes[b][a] = c;
            }

        }


    }


    private void printAdjacencyList() {

        for (int i = 1; i < nodes.length; i++) {

            System.out.print(i + " -> ");

            for (int j = 1; j < nodes[i].length; j++) {

                if (nodes[i][j] != 0) {
                    System.out.print("[" + j + "," + nodes[i][j] + "]");
                }

            }
            System.out.println();

        }

    }

    private void printMatrix() {

        for (int i = 1; i < nodes.length; i++) {

            for (int j = 1; j < nodes[i].length; j++) {

                System.out.print(nodes[i][j] + " ");

            }

            System.out.println();

        }

    }

    private void dfs(int startingIndex, int elementToFind) {

        int[] visited = new int[nodes.length];

        Stack<Integer> nodesStack = new Stack<>();

        nodesStack.push(startingIndex);

        while (!nodesStack.isEmpty() && nodesStack.peek() != elementToFind) {

//      System.out.println("Stack - " + nodesStack.toString());

            Integer pop = nodesStack.pop();

            if (visited[pop] != 1) {

                visited[pop] = 1;

                System.out.println("Search at node " + pop);

                for (int i = nodes[pop].length - 1; i > 0; i--) {
//          System.out.print(i + " Visited[i] " + visited[i]);
//          System.out.println("nodes[pop][i] " + nodes[pop][i]);
                    if (visited[i] != 1 && nodes[pop][i] != 0) {

//            System.out.println("Adding " + i);
                        nodesStack.push(i);
                    }

                }


            }

        }

        if (!nodesStack.isEmpty()) {

            System.out.println("Search at node " + elementToFind);
            System.out.println("Node " + elementToFind + " found");
            nodesStack.clear();

        } else {
            System.out.println("Node not found");
        }


    }


    private void bfs(int startingIndex, int elementToFind) {

        int[] visited = new int[nodes.length];

        java.util.Queue<Integer> nodesQueue = new ArrayDeque<>();

        nodesQueue.add(startingIndex);

        while (!nodesQueue.isEmpty() && nodesQueue.peek() != elementToFind) {

//      System.out.println("com.rriospinon.datastructures.Queue - " + nodesQueue.toString());

            Integer pop = nodesQueue.remove();

            if (visited[pop] != 1) {

                visited[pop] = 1;

                System.out.println("Search at node " + pop);

//        for (int i = nodes[pop].length - 1; i > 0; i--) {
                for (int i = 1; i < nodes[pop].length; i++) {
//          System.out.print(i + " Visited[i] " + visited[i]);
//          System.out.println("nodes[pop][i] " + nodes[pop][i]);
                    if (visited[i] != 1 && nodes[pop][i] != 0) {

                        nodesQueue.add(i);
                    }

                }


            }

        }

        if (!nodesQueue.isEmpty()) {

            System.out.println("Search at node " + elementToFind);
            System.out.println("Node " + elementToFind + " found");
            nodesQueue.clear();

        } else {
            System.out.println("Node not found");
        }

    }


}
