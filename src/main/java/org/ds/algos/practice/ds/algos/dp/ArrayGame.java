package org.ds.algos.practice.ds.algos.dp;

import java.util.Scanner;

public class ArrayGame {

    static int[] arrDesc;
    static int[] arrAsc;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            arrAsc = new int[n];
            arrDesc = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i] = in.nextInt();
            }
            for (int j = 1; j < n; j++) {
                arrAsc[i] = arrAsc[i - 1] + arrAsc[i];
            }
            for (int j = n - 2; j <= 0; j--) {
                arr[i] = arrAsc[i] + arrAsc[i + 1];
            }
            System.out.println(maxScore(arr, 0, n, 0));
        }
        in.close();
    }

    static int maxScore(int[] arr, int start, int end, int count) {
        for (int i = start; i < end; i++) {
            if (arrAsc[i] == arrDesc[i + 1]) {
                count++;
                //int a = maxScore(arr, 0 , n, 0)
            }
        }
        return count;
    }
}
