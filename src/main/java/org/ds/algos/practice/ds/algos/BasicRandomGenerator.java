package org.ds.algos.practice.ds.algos;

public class BasicRandomGenerator {

    public static Long randomNumber() {
        return System.currentTimeMillis() % 16;
    }

    public static void main(String[] args) {
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
        System.out.println(BasicRandomGenerator.randomNumber());
    }
}
