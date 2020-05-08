package org.ds.algos.practice.ds.algos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberAPalindromeTest {

    NumberAPalindrome palindromeChecker;

    NumberAPalindromeTest() {
        palindromeChecker = new NumberAPalindrome();
    }

    @Test
    void shouldReturnTrueForAValidPalindrome() {
        int number = 1991;
        assertTrue(this.palindromeChecker.isPalindrome(number));
    }

    @Test
    void shouldReturnFalseForAInValidPalindrome() {
        int number = 1992;
        assertFalse(this.palindromeChecker.isPalindrome(number));
    }

}