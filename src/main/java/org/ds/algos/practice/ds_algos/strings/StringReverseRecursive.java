package org.ds.algos.practice.ds_algos.strings;

public class StringReverseRecursive {

    public void printReverse(String string) {
        if(string == null || string.isEmpty())
            return;
        if(string.length()>0) {
            String subString = Character.toString(string.charAt(0));
            printReverse(string.substring(1));
            System.out.print(subString);
        }
    }

    public static void main(String[] args) {
        StringReverseRecursive recursive = new StringReverseRecursive();
        recursive.printReverse("This is a string");
    }
}
