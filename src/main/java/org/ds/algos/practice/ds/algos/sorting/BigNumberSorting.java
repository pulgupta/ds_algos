package org.ds.algos.practice.ds.algos.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class BigNumberSorting {

    // The trick here is to understand that string comparator works correctly as long as a
    // the numbers have the same length.
    // If the length differs than it is more of a string comparision than a number comparision.
    // For this reason we are doing number comparisions ourselves and rest is left to String Comparator.
    static class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            if (a.length() > b.length())
                return 1;
            else if (a.length() < b.length())
                return -1;
            else {
                return a.compareTo(b);
            }
        }
    }

    static String[] sorting(String[] unsorted) {
        Arrays.sort(unsorted, new MyComparator());
        return unsorted;
    }

    public static void main(String[] args) {
        String[] array = {
                "10",
                "2569874563251",
                "2569874563250",
                "235698956232356978741147798952",
                "256",
                "1",
        };
        String[] result = sorting(array);
        for (String i : result)
            System.out.print(i + " ");
    }

}
