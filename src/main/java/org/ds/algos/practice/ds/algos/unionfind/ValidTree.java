package org.ds.algos.practice.ds.algos.unionfind;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where
 * edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 */
public class ValidTree {
    int[] root;

    public boolean validTree(int n, int[][] edges) {
        root = new int[n];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            if (connected(edge[0], edge[1])) {
                return false;
            }
            union(edge[0], edge[1]);
        }
        for (int i = 0; i < root.length - 1; i++) {
            if (find(root[i]) != find(root[i + 1])) return false;
        }
        return true;
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            root[rootI] = rootJ;
        }
    }

    private int find(int i) {
        if (root[i] == i) {
            return i;
        }
        root[i] = find(root[i]); // Path Compression
        return root[i];
    }

    private boolean connected(int i, int j) {
        return find(i) == find(j);
    }
}
