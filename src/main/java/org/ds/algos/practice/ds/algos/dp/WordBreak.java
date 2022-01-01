package org.ds.algos.practice.ds.algos.dp;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words. Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Each index i tells if the s.substring(i) can be formed from wordDict
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // For each substring we will try to compare all the words
            for (String el : wordDict) {
                if (i >= el.length() - 1) { // we can only take smaller words than the current
                    // if we have just started with the first word
                    // OR
                    // the last matched substring was a success match
                    if (i == el.length() - 1 || dp[i - el.length()]) {
                        // If the last substring was successful and this substring is also a match we can
                        // successfully make this bigger substring
                        if (s.substring(i - el.length() + 1, i + 1).equals(el)) {
                            dp[i] = true;
                        }
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
