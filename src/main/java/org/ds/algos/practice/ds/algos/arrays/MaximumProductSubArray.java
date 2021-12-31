package org.ds.algos.practice.ds.algos.arrays;

import java.util.Arrays;

public class MaximumProductSubArray {

    /**
     * The idea is that we will keep track of the min and max at each level. This way at each step we have the
     * result. It is bottom up way of DP. As we move forward we pick an element and multiply that with the previous
     * min and max.
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int previousMax = nums[0];
        int previousMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int[] current = new int[3];
            current[0] = nums[i];
            current[1] = previousMax * nums[i];
            current[2] = previousMin * nums[i];
            Arrays.sort(current);

            previousMax = current[2];
            previousMin = current[0];

            if (previousMax > max)
                max = previousMax;
        }
        return max;
    }

}
