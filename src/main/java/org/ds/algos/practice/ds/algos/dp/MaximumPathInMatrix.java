package org.ds.algos.practice.ds.algos.dp;

public class MaximumPathInMatrix {

    private static int findMaxPath(int[][] matrix, int[][] dp, int row, int col) {
        int size = matrix[0].length;
        if (row >= size || row < 0 || col >= size || col < 0)
            return 0;
        // Since all the elements are unique there can only be a single direction where
        // we can move at a particular point
        if (row<size-1 && 1 + matrix[row][col] == matrix[row + 1][col])
            return dp[row][col] = 1 + findMaxPath(matrix, dp, row + 1, col);
        if (row>0 && 1 + matrix[row][col] == matrix[row - 1][col])
            return dp[row][col] = 1 + findMaxPath(matrix, dp, row - 1, col);
        if (col<size-1 && 1 + matrix[row][col] == matrix[row][col+1])
            return dp[row][col] = 1 + findMaxPath(matrix, dp, row, col+1);
        if(col>0 && 1 + matrix[row][col] == matrix[row][col-1])
            return dp[row][col] = 1 + findMaxPath(matrix,dp,row, col-1);
        return dp[row][col] = 1;
    }
    public static int maximumPathLength(int[][] matrix) {
        int size = matrix[0].length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = findMaxPath(matrix, dp, i, j);
            }
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(max<dp[i][j])
                    max = dp[i][j];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,9},{5,3,8},{4,6,7}};
        System.out.println(maximumPathLength(matrix));
    }
}
