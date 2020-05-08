package org.ds.algos.practice.ds.algos;

import java.util.Scanner;

public class MaxSubsetNonDivisible {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt() % k;
            if (!hasZero)
                if (arr[i] == 0)
                    hasZero = true;
        }
        int totalSet = 0;
        // now we will always try to check which is a bigger set i or k-i
        int limit;
        if (k % 2 == 0)
            limit = k / 2;
        else
            limit = k / 2 + 1;
        for (int i = 1; i < limit; i++) {
            int set1 = 0;
            int set2 = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i)
                    set1++;
                if (arr[j] == k - i)
                    set2++;
            }
            if (set1 > set2)
                totalSet += set1;
            else
                totalSet += set2;
        }
        if (hasZero)
            totalSet++;
        boolean hasHalf = false;
        if (k % 2 == 0) {
            for (int i : arr) {
                if (i == k / 2) {
                    hasHalf = true;
                    break;
                }
            }
        }
        if (hasHalf)
            totalSet++;
        System.out.println(totalSet);
        in.close();
    }

}
