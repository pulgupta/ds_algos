package org.ds.algos.practice.ds.algos.strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromeCheck {

    public boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;

        List<Character> arr = sanitizeString(s);
        boolean isPalindrome = true;
        for(int i=0; i<arr.size()/2; i++) {
            if(arr.get(i) != arr.get(arr.size()-1-i))
                isPalindrome = false;
        }
        return isPalindrome;
    }

    List<Character> sanitizeString(String s) {
        s = s.toLowerCase();
        List<Character> arr = new ArrayList<>();
        char[] arrTemp = s.toCharArray();
        for(char c: arrTemp)
            if((c >= 97 && c <= 122) || (c >= 48 && c <= 57))
                arr.add(c);
        return arr;
    }
}