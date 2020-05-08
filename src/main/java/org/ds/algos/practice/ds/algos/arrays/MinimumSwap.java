package org.ds.algos.practice.ds.algos.arrays;

public class MinimumSwap {

    static int minimumSwaps(int[] arr) {
        int result = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            // we are not in correct position so we can now swap 
            if (arr[i] != i + 1) {
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] == i + 1) {
                        // swap the two elements
                        arr[j] = arr[i];
                        arr[i] = i + 1;
                        result++;
                        break;
                    }
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        int arr[] = {5, 9, 6, 2, 7, 1, 8, 3, 4};
        System.out.println(minimumSwaps(arr));
    }

    // Answer is 7 
    // 1 9 6 2 7 5 8 3 4 
    // 1 2 6 9 7 5 8 3 4 
    // 1 2 3 9 7 5 8 6 4 
    // 1 2 3 4 8 5 8 6 9
    // 1 2 3 4 5 7 8 6 9
    // 1 2 3 4 5 6 8 7 9
    // 1 2 3 4 5 6 7 8 9
}

