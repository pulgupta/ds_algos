package org.ds.algos.practice.ds.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            int num1 = array[i];
            int updatedTargetSum = targetSum - num1;

            int left = i+1;
            int right = array.length-1;
            while(left<right) {
                if(array[left] + array[right] < updatedTargetSum) {
                    left++;
                } else if(array[left] + array[right] > updatedTargetSum) {
                    right--;
                } else {
                    Integer[] arr = {num1, array[left], array[right]};
                    result.add(arr);
                    left++;
                }
            }
        }
        return result;
    }
}
