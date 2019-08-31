package org.ds.algos.practice.ds_algos;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 */
public class Divide {

    public static int divide(int dividend, int divisor) {
        int result = 0;
        boolean makeNegative = false;
        if(dividend<0) {
            dividend = Math.abs(dividend);
            makeNegative = true;
        }
        if(divisor<0) {
            divisor = Math.abs(divisor);
            makeNegative = !makeNegative;
        }
        int temp = divisor;
        if(divisor > dividend)
            return result;
        for(int i=0;i<dividend;i++) {
            if(temp == dividend) {
                result = i+1;
                break;
            }
            if(temp>dividend) {
                result = i;
                break;
            }
            temp = temp+divisor;
        }
        if(makeNegative) {
            result = (~result) + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(divide(-2147483648, -1));
    }
}
