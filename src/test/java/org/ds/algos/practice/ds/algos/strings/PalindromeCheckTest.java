package org.ds.algos.practice.ds.algos.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PalindromeCheckTest {

    PalindromeCheck pc = new PalindromeCheck();

    @Test
    void shouldReturnFalseForNonPalindrome() {
        String s = "rAce a Car";
        assertThat(pc.isPalindrome(s), is(false));
    }

    @Test
    void shouldReturnTrueForEmptyString() {
        String s = "";
        assertThat(pc.isPalindrome(s), is(true));
    }

    @Test
    void shouldReturnTrueForSingleCharString() {
        String s = "a";
        assertThat(pc.isPalindrome(s), is(true));
    }

    @Test
    void shouldReturnTrueForPalindromeTwoCharString() {
        String s = "Aa";
        assertThat(pc.isPalindrome(s), is(true));
    }

    @Test
    void shouldReturnFlaseForTwoCharString() {
        String s = "ab";
        assertThat(pc.isPalindrome(s), is(false));
    }

    @Test
    void shouldReturnFalseForTwoCharStringWithNumbers() {
        String s = "A0";
        assertThat(pc.isPalindrome(s), is(false));
    }

    @Test
    void shouldReturnTrueForThreeCharStringWithNumbers() {
        String s = "A0a";
        assertThat(pc.isPalindrome(s), is(true));
    }

}