package org.ds.algos.practice.ds.algos.arrays;

public class ReplaceZeroForMaxSubArray {

    int findMaxSubArrayLength(int[] array) {

        int maxCount = 0;
        int count = 0;
        int lastZeroIndex = 0;

        for (int i=0; i< array.length; i++) {
            if(array[i] == 1) {
                count++;
            } else {
                count = i - lastZeroIndex;
                lastZeroIndex = i;
            }
            if(count > maxCount) {
                maxCount = count;
                // index which should be replaced to get this count is nothing but the lastZeroIndex
            }
        }
        return maxCount;
    }
}
