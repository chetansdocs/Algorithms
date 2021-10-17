package org.example.graphs;

import java.util.*;

/**
 * Graph traversal for connected graphs. Modify logic for disconnected
 */
public class Graph {
    private final Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public void initializeGraph(int vertexCount) {
        for(int i = 0; i < vertexCount; i++) {
            adjacencyList.put(i, new ArrayList<>(vertexCount));
        }
    }

    public void addEdge(int vertex, int nextVertex) {
        adjacencyList.get(vertex).add(nextVertex);
    }

    public void BFSTraversal(int startingVertex, int vertexCount) {
        Queue<Integer> integerQueue = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        visited[startingVertex] = true;
        integerQueue.add(startingVertex);
        while (!integerQueue.isEmpty()) {
            int currentPolled = integerQueue.poll();
            System.out.println(currentPolled);
            for(int i: adjacencyList.get(currentPolled)) {
                if(!visited[i]) {
                    integerQueue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFSTraversal(boolean[] visited, int vertex) {
        visited[vertex] = true;
        System.out.println(vertex);
        for(int currentVertex: adjacencyList.get(vertex)) {
            if(!visited[currentVertex]) {
                DFSTraversal(visited, currentVertex);
            }
        }
    }

    public void DFSForDisconnected(int startIndex, int vertexCount) {
        boolean[] visited = new boolean[vertexCount];
        DFSTraversal(visited, startIndex);
        for(int i = 0; i < vertexCount; i++) {
            if(!visited[i]) {
                DFSTraversal(visited, i);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.initializeGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        System.out.println("BFS Traversal");
        graph.BFSTraversal(0, 5);
        System.out.println("DFS Traversal");
        graph.DFSForDisconnected(0, 5);
    }
}
