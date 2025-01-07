package org.leetcode.solution.LongestSubstring;

import java.util.HashSet;

public class SolutionLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        char [] thisString = s.toCharArray();
        int first = 0;
        int last = 0;
        int size = 0;
        for (int i = 1; i < thisString.length; i++){
            for (int k = first; k <= last; k++) {
                if (thisString[k] == thisString[i]) {
                    if (size < last - first + 1)
                        size = last - first + 1;
                    first = k + 1;
                    break;
                }
            }
            last++;
        }
        if (size < last - first + 1)
            return last - first + 1;
        else return size;
    }

    public int lengthOfLongestSubstring_Wrong(String s) {
        HashSet<Character> alreadyUsd = new HashSet<>();
        int counter = 0;
        int maxCounter = 0;
        for (char ch : s.toCharArray()){
            if (alreadyUsd.contains(ch)){
                alreadyUsd.clear();
                if (maxCounter < counter)
                    maxCounter = counter;
                counter = 1;
                alreadyUsd.add(ch);
            }
            else {
                alreadyUsd.add(ch);
                counter++;
            }
        }
        if (counter > maxCounter)
            maxCounter = counter;
        return maxCounter;
    }
}
