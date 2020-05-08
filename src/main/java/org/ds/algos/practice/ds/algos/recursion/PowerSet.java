package org.ds.algos.practice.ds.algos.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Power set is a set of all the subsets of a string.
 * What we are doing here is generating the bits for the subsets.
 * In case a bit is 1 then that element is included in the set
 * Else that element is not included in the set.
 */
public class PowerSet {

    void getPowerSetOfString(int current, int[] bits, List<List<Integer>> bitStrings) {

        // Base condition to check if current has become next
        if (current == bits.length) {

            List<Integer> newAddition = new ArrayList<>();
            for (int i : bits) {
                newAddition.add(i);
            }
            bitStrings.add(newAddition);
        } else {
            // Try both the scenarios
            // Make current as 1 for the first time
            bits[current] = 1;
            getPowerSetOfString(current + 1, bits, bitStrings);
            // Make current as 0 for the second time
            bits[current] = 0;
            getPowerSetOfString(current + 1, bits, bitStrings);
        }
    }

    public static void main(String[] args) {
        String data = "abcd";
        List<List<Integer>> bitStrings = new ArrayList<>();
        int[] bits = new int[data.length()];
        PowerSet powerSet = new PowerSet();
        powerSet.getPowerSetOfString(0, bits, bitStrings);

        for (List<Integer> list : bitStrings) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 1)
                    System.out.print(data.charAt(i));
            }
            System.out.println();
        }
    }


}
