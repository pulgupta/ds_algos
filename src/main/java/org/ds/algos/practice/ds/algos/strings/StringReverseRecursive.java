package org.ds.algos.practice.ds.algos.strings;

public class StringReverseRecursive {

    public String printReverse(String string) {
        if (string == null || string.isEmpty())
            return "";
        String subString = Character.toString(string.charAt(0));
        return printReverse(string.substring(1)) + subString;
    }

    public static void main(String[] args) {
        StringReverseRecursive recursive = new StringReverseRecursive();
        System.out.println(recursive.printReverse("This is a string"));
    }
}
