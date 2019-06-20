package org.ds.algos.practice.ds_algos.arrays;

public class RotateTwoDMatrix {

    public static void rotateMatrix(int[][] matrix, int size) {
        // Assuming that the matrix is square matrix
        // We can also add a check to verify this and move forward only in case we are good

        for(int i=0; i<size; i++) {
            int start = i;
            int end = size-i-1;

            for(int j=start; j<end; j++) {
                // Now we can swap
                int top = matrix[start][j];
                int offset = size-start-1;

                matrix[start][j] = matrix[offset][j];
                matrix[offset][i] = matrix[offset][end-j];
                matrix[j][end-j] = matrix[start][j];
                matrix[start][j] = top;

            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 2, 3, 4, 5, 6},
                { 7, 8, 9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30},
                {31,32,33,34,35,36}
        };
        rotateMatrix(matrix, 6);
    }
}
