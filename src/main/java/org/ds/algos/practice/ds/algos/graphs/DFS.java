package org.ds.algos.practice.ds.algos.graphs;

public class DFS {
    /**
     * | 0 1 1 1 0 |
     * | 1 0 0 1 1 |
     * | 1 0 0 0 0 |
     * | 1 1 0 0 1 |
     * | 0 1 0 1 0 |
     *
     * A-----B----E
     * | \   /   /
     * C  \ |   /
     *     D----
     */
    int[][] adjacencyMatrix = {{0,1,1,1,0},{1,0,0,1,1},{1,0,0,0,0},{1,1,0,0,1},{0,1,0,1,0}};
    int size = 5;
    boolean[] visited = new boolean[size];

    /**
     * Traverse the tree in depth first search order
     * @param starting: Starting node for the traversal
     */
    public void traverseDf(int starting) {
        // mark this node as visited
        this.visited[starting] = true;
        // Check all the nodes reachable from this node
        System.out.println("Reached Node " + starting);
        for(int i=0; i<size; i++) {
            // check first if this node has a path to the other node and the other node is not visited
            if(adjacencyMatrix[starting][i] == 1 && !visited[i]) {
                System.out.println("Starting travel from " + starting + " to " + i);
                // lets first visit this connected node thus going in depth of this node connections
                traverseDf(i);
            }
        }
    }
    public static void main(String[] args) {
        DFS obj = new DFS();
        for(int i=0;i<5;i++) {
            obj.visited[i] = false;
        }
        obj.traverseDf(0);
    }
}
