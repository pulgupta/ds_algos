package org.ds.algos.practice.ds.algos.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-provinces/
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
 * directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
public class FindProvince {
    int[] rank;
    int[] root;

    public int findCircleNum(int[][] isConnected) {
        root = new int[isConnected.length];
        rank = new int[isConnected.length];
        for (int i = 0; i < root.length; i++) {
            rank[i] = 1;
            root[i] = i;
        }
        for (int i = 0; i < root.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(i, j);
                }
            }
        }
        Set<Integer> result = new HashSet<>();
        for (int j : root) {
            result.add(find(j));
        }
        return result.size();
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (rank[i] > rank[j]) { // Union by rank, optimisation of quick union
                root[rootJ] = rootI;
            } else if (rank[i] < rank[j]) {
                root[rootI] = rootJ;
            } else {
                root[rootI] = rootJ;
                rank[j] += 1;
            }
        }
    }

    private int find(int i) {
        if (root[i] == i) {
            return i;
        }
        root[i] = find(root[i]); // Path Compression
        return root[i];
    }
}
