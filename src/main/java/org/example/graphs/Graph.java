package org.example.graphs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void topologicalSort() {
          int[] inDegree = new int[adjacencyList.size()];
          adjacencyList.forEach((vertex, connectedVertex) -> {
            connectedVertex.forEach(currentVertex -> inDegree[currentVertex]++);
          });
          Queue<Integer> queue = new LinkedList<>();
          Arrays.stream(inDegree).filter(currentValue -> currentValue == 0).forEach(queue::add);
          while(!queue.isEmpty()) {
              int currentJob = queue.poll();
              System.out.println(currentJob);
              for(int i: adjacencyList.get(currentJob)) {
                  if(--inDegree[i] == 0) {
                      queue.add(i);
                  }
              }
          }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.initializeGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(1, 4);
        System.out.println("Topological");
        graph.topologicalSort();
        System.out.println("BFS Traversal");
        graph.BFSTraversal(0, 5);
        System.out.println("DFS Traversal");
        graph.DFSForDisconnected(0, 5);
    }
}
