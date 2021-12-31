package org.ds.algos.practice.ds.algos.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParenthesis {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        placeParenthesis("", n, n);
        return result;

    }

    void placeParenthesis(String sb, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sb);
        }

        if (left > 0)
            placeParenthesis(sb + "(", left - 1, right);

        // This will ensure that we are not closing a brace before it is opened
        if (right > left)
            placeParenthesis(sb + ")", left, right - 1);
    }
}
