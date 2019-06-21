package org.ds.algos.practice.ds_algos.arrays;

/**
 * INCOMPLETE
 */
public class RotateTwoDMatrix {

    public static void rotateMatrix(int[][] matrix, int size) {
        // Assuming that the matrix is square matrix
        // We can also add a check to verify this and move forward only in case we are good

        for(int i=0; i<size/2; i++) {
            int start = i;
            int end = size-i-1;

            for(int j=start; j<end; j++) {
                // Now we can swap
                int top = matrix[start][j];
                int offset = j-start;

                matrix[start][j] = matrix[offset][j];
                matrix[offset][i] = matrix[offset][end-j];
                matrix[offset][end-j] = matrix[start][offset];
                matrix[start][offset] = top;

            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9,10,11,12},
                {13,14,15,16}
        };
        rotateMatrix(matrix, 4);
    }
}
