package org.ds.algos.practice.ds.algos.dp;

public class LongestCommonSubstring {

    public static String getLongestSubString(String a, String b) {
        int maxCordinateX = 0, maxCordinateY = 0;
        int max = 0;
        StringBuilder result = new StringBuilder("");
        int[][] memo = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    if (memo[i][j] > max) {
                        max = memo[i][j];
                        maxCordinateX = i;
                        maxCordinateY = j;
                    }
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        // Once we have filled up the memo, lets travel and print the sub-string
        int i = maxCordinateX;
        int j = maxCordinateY;
        while (i > 0 && j > 0) {
            if (memo[i][j] == 0)
                return result.reverse().toString();
            result.append(a.charAt(i - 1));
            i--;
            j--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "GeeksForGeeks";
        String b = "aaeeksForGeeDummyData";
        System.out.println(getLongestSubString(a, b));
    }
}
