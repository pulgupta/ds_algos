package org.ds.algos.practice.ds_algos.strings;

public class StringPermutations {

    public static void printPermutations(String str, int low, int high) {
        if(low == high)
            System.out.println(str);
        else {
            for(int i=low;i<=high;i++){
                str = swap(str, low, i);
                printPermutations(str, low+1, high);
                str = swap(str, low, i);
            }
        }

    }

    private static String swap(String str, int low, int high) {
        char[] array = str.toCharArray();
        char temp = array[low];
        array[low] = array[high];
        array[high] = temp;
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        printPermutations("ABC", 0, 2);
    }
}
