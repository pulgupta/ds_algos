package org.ds.algos.practice.ds.algos;

import java.util.Scanner;

/**
 * Solving the fibonacci series in O(n).
 * There is one more way of doing this using recursion + memoization
 * which is nothing but a good implementation of DP
 *
 * @author pulgupta
 */
public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        if (n >= 1)
            System.out.print(a + " ");
        int b = 1;
        if (n >= 2)
            System.out.print(b + " ");
        //linear time and constant space
        for (int i = 2; i < n; i = i + 2) {
            a = a + b;
            b = b + a;
            if (n - i == 1) {
                System.out.print(a);
                break;
            } else {
                System.out.print(a + " " + b + " ");
            }
        }
        in.close();
    }
}
