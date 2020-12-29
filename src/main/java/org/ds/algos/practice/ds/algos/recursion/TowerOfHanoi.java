package org.ds.algos.practice.ds.algos.recursion;

public class TowerOfHanoi {

    public void TOH(int numberOfPegs, String source, String target, String temp) {
        if (numberOfPegs <= 0) {
            return;
        }
        TOH(numberOfPegs - 1, source, temp, target);
        System.out.println("move disc " + numberOfPegs + " from " + source + " to " + target);
        TOH(numberOfPegs - 1, temp, target, source);
    }

    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        toh.TOH(4, "Source", "Target", "Temp");
    }
}
