package org.ds.algos.practice.ds.algos.arrays;

/**
 * In an array of size n and containing numbers from 1...n calculate
 * the frequencies of all the numbers
 *
 * @author pulgupta
 */
public class CountArrayFrequenciesIn_On {

    public static int[] calculateFrequencies(int[] arr) {
        /*
         * The idea here is to store all the counts as negatives
         */
        int i = 0;
        while (i < arr.length) {
            // If the index has negative value then we already have a count
            if (arr[i] <= 0) {
                i++;
            } else {
                int index = arr[i] - 1;
                // We can increment the count
                if (arr[index] < 0) {
                    arr[index]--;
                    arr[i] = 0; // Since we have counted it so we can remove it from the array
                    i++;
                } else {
                    // Swap the number to current, and set -1 as the count
                    arr[i] = arr[index];
                    arr[index] = -1;
                }
            }
        }
        for (i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * -1;
        }
        return arr;
    }

}
