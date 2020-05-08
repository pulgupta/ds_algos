package org.ds.algos.practice.ds.algos;

/**
 * Check if a number is a palindrome
 *
 * @author pulgupta
 */
public class NumberAPalindrome {

    // The idea here it to get the left key and the right key
    // If always both the key matches then we are good.
    // If at any time they are not matching then we can return false
    public boolean isPalindrome(int num) {

        int places = Integer.toString(num).length();
        int powerRhs = 1;
        int powerLhs = places - 1;
        for (int i = 0; i < places / 2; i++) {

            int rhs = num % calculatePow(10, powerRhs);
            rhs = rhs / calculatePow(10, powerRhs - 1);
            powerRhs++;

            int lhs = num / calculatePow(10, powerLhs);
            lhs = lhs % calculatePow(10, 1);
            powerLhs--;

            if (rhs != lhs)
                return false;
        }

        return true;
    }

    static int calculatePow(int num, int pow) {
        int temp = num;
        if (pow == 0)
            return 1;
        for (int i = 1; i < pow; i++)
            num = num * temp;
        return num;
    }
}
