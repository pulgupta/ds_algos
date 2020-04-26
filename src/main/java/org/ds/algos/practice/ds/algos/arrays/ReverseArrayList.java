package org.ds.algos.practice.ds.algos.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * In this we are trying to reverse an arrayList in java using recursion
 * @author pulgupta
 *
 */
public class ReverseArrayList {

	public static List<Integer> reverse(List<Integer> start, int index) {
		//END CONDITION
		if(index > start.size()/2 -1){ 
			return start;
		}
		//SWAP LOGIC
		int temp = start.get(index);
		int temp2 = start.get(start.size()-index-1);
		start.set(index, temp2);
		start.set(start.size()-index-1, temp);
		
		//RECURSIVE CALL
		return reverse(start, index+1);
	}
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(40);
		List<Integer> result = ReverseArrayList.reverse(arrayList, 0);
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}
}
