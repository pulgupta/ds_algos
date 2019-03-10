package org.ds.algos.practice.ds_algos.dp;

/**
 * Each item can be added either fully or not added at all
 * The aim is the have the maximum value in the bag
 * @author pulgupta
 */
public class KnapsackProblem {

	public static int getMaximumValue(int[] values, int[] weights, int capacity, int item) {
		// Item list is exhausted
		if(item<=0) {
			return 0;
		} 
		// If the current weight is more than the capacity then simply skip it 
		if (weights[item-1] > capacity) {
			return getMaximumValue(values, weights, capacity, item-1);
		} else {
			// Include the item and add the value, Don't include the item and choose the maximum
			return Math.max(values[item-1] + getMaximumValue(values, weights, capacity-weights[item-1], item-1), 
					getMaximumValue(values, weights, capacity, item-1));
		}
	}
	
	public static void main(String[] args) {
		int[] values = { 1, 2, 3 };
		int[] weights = { 4, 5, 1 };
		System.out.println(getMaximumValue(values, weights, 4, values.length));
	}
}
