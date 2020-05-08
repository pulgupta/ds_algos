package org.ds.algos.practice.ds.algos.recursion;

public class TowerOfHanoi {

    public void TOH(int n, int A, int B, int C) {
        if (n > 0) {
            TOH(n - 1, A, C, B);
            System.out.println("move disc from " + A + " to " + C);
            TOH(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        toh.TOH(4, 1, 2, 3);
    }
}
