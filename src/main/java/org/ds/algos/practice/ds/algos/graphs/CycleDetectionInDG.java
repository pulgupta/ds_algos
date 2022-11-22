package org.ds.algos.practice.ds.algos.graphs;

public class CycleDetectionInDG {
    public boolean cycleInGraph(int[][] edges) {
        boolean[] visitedInCurrent = new boolean[edges.length];
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if(visited[i]) continue;
            boolean isCycle = dfs(i, edges, visited, visitedInCurrent);
            if (isCycle) {
                return true;
            }
        }
        return false;
    }

    boolean dfs(int node, int[][] edges, boolean[] visited, boolean[] visitedInCurrent) {
        visited[node] = true;
        visitedInCurrent[node] = true;
        boolean result = false;
        for (int i = 0; i < edges[node].length; i++) {
            int connectedNode = edges[node][i];
            if (!visited[connectedNode]) {
                result = dfs(connectedNode, edges, visited, visitedInCurrent);
            }
            if(result) return true;
            if(visitedInCurrent[connectedNode]) return true;
        }
        visitedInCurrent[node] = false;
        return false;
    }
}
