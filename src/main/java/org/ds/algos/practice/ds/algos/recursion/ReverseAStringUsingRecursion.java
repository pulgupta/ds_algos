package org.ds.algos.practice.ds.algos.recursion;

public class ReverseAStringUsingRecursion {
    public void reverseString(char[] s) {
        if (s == null || s.length < 1)
            return;
        reverse(s, s[0], 0, s.length);
    }

    private void reverse(char[] s, char item, int low, int high) {
        if (low < high - 1) {
            reverse(s, s[low + 1], low + 1, high);
        }
        s[high - (low + 1)] = item;
    }
}
