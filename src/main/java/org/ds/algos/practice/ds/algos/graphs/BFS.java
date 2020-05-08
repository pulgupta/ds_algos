package org.ds.algos.practice.ds.algos.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /**
     * | 0 1 1 1 0 |
     * | 1 0 0 1 1 |
     * | 1 0 0 0 0 |
     * | 1 1 0 0 1 |
     * | 0 1 0 1 0 |
     * <p>
     * A-----B----E
     * | \   /   /
     * C  \ |   /
     * D----
     */
    int[][] adjacencyMatrix = {{0, 1, 1, 1, 0}, {1, 0, 0, 1, 1}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 1, 0, 1, 0}};
    int size = 5;
    boolean[] visited = new boolean[size];

    /**
     * Traverse the tree in breath first search order
     * Time Complexity: O(V^2)
     * Space Complexity: O(V)
     * These complexities are strictly in case we are using adjacency matrix for graph representation
     * In case we are using adjacency list then the time complexity will be O(V+E)
     *
     * @param starting: Starting node for the traversal
     */
    public void traverseBf(int starting) {
        // Space complexity O(V)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(starting);
        // Time complexity O(V)
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[current]) {
                visited[current] = true;
                System.out.println("Visited " + current);
                // Time complexity: O(V) * O(V) as it is inside the outer loop
                for (int i = 0; i < size; i++) {
                    if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                        System.out.println("Adding " + i + " in the queue to be visited");
                        // add all the vertex which are connected with this node and have not been visited yet
                        queue.add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS obj = new BFS();
        for (int i = 0; i < 5; i++) {
            obj.visited[i] = false;
        }
        obj.traverseBf(0);
    }
}
