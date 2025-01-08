package org.leetcode.solution.ZigzagConversion;

public class ZigzagConversionSolution {
    public String solution(String s, int numRows){
        if(numRows == 1)
            return s;
        char[] incom = s.toCharArray();
        int size = incom.length;
        char[] result = new char[size];
        int curRes = 0;
        for (int i = 0; i < numRows && i < size; i++){
            for (int k = i; k < size; k = k + 2* (numRows - 1)) {
                result[curRes] = incom[k];
                curRes++;
                if (i != 0 && i != numRows -1 && k+2*(numRows - i - 1) < size){
                    result[curRes] = incom[k+2*(numRows - i - 1)];
                    curRes++;
                }
            }
        }
        return new String(result);
    }
}
