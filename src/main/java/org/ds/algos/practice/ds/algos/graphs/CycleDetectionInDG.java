package org.ds.algos.practice.ds.algos.graphs;

public class CycleDetectionInDG {
    public boolean cycleInGraph(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            boolean[] visitedInCurrent = new boolean[edges.length];
            boolean[] visited = new boolean[edges.length];
            boolean isCycle = dfs(i, edges, visited, visitedInCurrent);
            if (isCycle) {
                return true;
            }
        }
        return false;
    }

    boolean dfs(int node, int[][] edges, boolean[] visited, boolean[] visitedInCurrent) {
        if (visitedInCurrent[node]) {
            return true;
        }
        visitedInCurrent[node] = true;
        boolean result = false;
        for (int i = 0; i < edges[node].length; i++) {
            int connectedNode = edges[node][i];
            if (!visited[connectedNode]) {
                visited[connectedNode] = true;
                result = dfs(connectedNode, edges, visited, visitedInCurrent);
                if (result)
                    break;
            }
        }
        return result;
    }
}
