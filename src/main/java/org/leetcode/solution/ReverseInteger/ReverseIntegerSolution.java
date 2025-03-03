package org.leetcode.solution.ReverseInteger;

public class ReverseIntegerSolution {
    public int solution(int x) {
        if (x == 0 )
            return 0;
        int result = 0;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -1 * x;
        }
        do {
            if (result > (Integer.MAX_VALUE - x%10)/10)
                return 0;
            result = result * 10 + x % 10;
            x = x/10;
        } while (x > 0);

        return isNegative ? -result : result;
    }
}
