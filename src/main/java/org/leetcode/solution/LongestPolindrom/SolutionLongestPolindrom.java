package org.leetcode.solution.LongestPolindrom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SolutionLongestPolindrom {
    public static int maxSize;
    public static int left;
    public static int right;
    {
        maxSize = 0;
        left = 0;
        right = 0;
    }
    public String longestPalindrome(String s) {
        char[] incom = s.toCharArray();
        int size = incom.length;
        if (size == 1)
            return s;
        if (size == 2) {
            if (incom[0] == incom[1])
                return s;
            else return s.substring(0, 1);
        }
        for (int i = 1; i < size - 1; i++) {
            if (incom[i-1] == incom[i+1])
                checkCenter(incom, i);
            if (incom[i] == incom [i-1])
                checkLeft(incom, i);
            if (incom[i] == incom [i+1])
                checkRight(incom, i);
        }
        return s.substring(left, right+1);
    }

    private void checkCenter(char[] incom, int center) {
        int curLeft = center - 1;
        int curRight = center + 1;
        while (curLeft >= 0 && curRight < incom.length) {
            if (incom[curLeft] != incom[curRight]) {
                if (maxSize < (curRight - curLeft - 1)) {
                    maxSize = (curRight - curLeft - 1);
                    left = curLeft+1;
                    right = curRight-1;
                }
                return;
            }
            curLeft--;
            curRight++;
        }
        if (maxSize < (curRight - curLeft - 1)) {
            maxSize = (curRight - curLeft - 1);
            left = curLeft+1;
            right = curRight-1;
        }
    }
    private void checkRight(char[] incom, int center){
        int curRight = center + 1;
        int curLeft = center;
        while (curLeft >= 0 && curRight < incom.length) {
            if (incom[curLeft] != incom[curRight]) {
                if (maxSize < (curRight - curLeft - 1)) {
                    maxSize = (curRight - curLeft - 1);
                    left = curLeft+1;
                    right = curRight-1;
                }
                return;
            }
            curLeft--;
            curRight++;
        }
        if (maxSize < (curRight - curLeft - 1)) {
            maxSize = (curRight - curLeft - 1);
            left = curLeft+1;
            right = curRight-1;
        }
    }
    private void checkLeft(char[] incom, int center){
        int curRight = center;
        int curLeft = center-1;
        while (curLeft >= 0 && curRight < incom.length) {
            if (incom[curLeft] != incom[curRight]) {
                if (maxSize < (curRight - curLeft - 1)) {
                    maxSize = (curRight - curLeft - 1);
                    left = curLeft+1;
                    right = curRight-1;
                }
                return;
            }
            curLeft--;
            curRight++;
        }
        if (maxSize < (curRight - curLeft - 1)) {
            maxSize = (curRight - curLeft - 1);
            left = curLeft+1;
            right = curRight-1;
        }
    }
        public String longestPalindrome_middleAgain (String s){
            char[] incom = s.toCharArray();
            int size = incom.length;
            if (size == 1)
                return s;
            if (size == 2) {
                if (incom[0] == incom[1])
                    return s;
                else return s.substring(0, 1);
            }
            int maxLength = incom.length;
            for (; maxLength > 1; maxLength--) {
                for (int i = 0, k = i + maxLength - 1; k < size; i++, k++)
                    if (isPolindrom(incom, i, k)) {
                        return s.substring(i, k + 1);
                    }
            }
            return s.substring(0, 1);
        }
        public String longestPalindrome_timeOf (String s){
            char[] incom = s.toCharArray();
            int size = incom.length;
            if (size == 1)
                return s;
            if (size == 2) {
                if (incom[0] == incom[1])
                    return s;
                else return s.substring(0, 1);
            }
            int maxSize = 0;
            int maxFirst = 0;
            int maxLast = 0;
            for (int i = 0; i < size - 1 && size - i > maxSize; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (incom[i] == incom[j])
                        if (isPolindromicStr(s.substring(i, j + 1)) && j - i > maxSize) {
                            maxSize = j - i;
                            maxFirst = i;
                            maxLast = j;
                        }
                }
            }
            return s.substring(maxFirst, maxLast + 1);
        }
        private boolean isPolindromicStr (String s){
            if (s.length() % 2 != 1)
                return s.substring(0, s.length() / 2).equals(revertString(s.substring(s.length() / 2)));
            else
                return s.substring(0, s.length() / 2).equals(revertString(s.substring(s.length() / 2 + 1)));
        }
        public String revertString (String s){
            char[] arr = s.toCharArray();
            int low = 0;
            int high = arr.length - 1;
            String result = "";
            while (low < high) {
                arr[low] = (char) (arr[low] ^ arr[high]);
                arr[high] = (char) (arr[low] ^ arr[high]);
                arr[low] = (char) (arr[low] ^ arr[high]);
                low++;
                high--;
            }
            for (int i = 0; i < arr.length; i++) {
                result = result + arr[i];
            }
            return result;
        }
        public String longestPalindrome_shortestForm (String s){
            char[] incom = s.toCharArray();
            int size = incom.length;
            if (size == 1)
                return s;
            if (size == 2) {
                if (incom[0] == incom[1])
                    return s;
                else return s.substring(0, 1);
            }
            int maxSize = 0;
            int maxFirst = 0;
            int maxLast = 0;
            for (int i = 0; i < size - 1 && size - i > maxSize; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (incom[i] == incom[j]) {
                        if (isPolindrom(incom, i, j) && j - i > maxSize) {
                            maxSize = j - i;
                            maxFirst = i;
                            maxLast = j;
                        }
                    }
                }
            }
            return s.substring(maxFirst, maxLast + 1);
        }
        public String longestPalindrome_monstrous (String s){
            char[] incom = s.toCharArray();
            int size = incom.length;
            if (size == 1)
                return s;
            if (size == 2) {
                if (incom[0] == incom[1])
                    return s;
                else return s.substring(0, 1);
            }
            int maxSize = 0;
            int maxFirst = 0;
            int maxLast = 0;
            HashMap<Character, ArrayList<Integer>> charSelect = new HashMap<>();
            for (int i = 0; i < size; i++) {
                if (charSelect.containsKey(incom[i]))
                    charSelect.get(incom[i]).add(i);
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    charSelect.put(incom[i], list);
                }
            }
            for (Map.Entry<Character, ArrayList<Integer>> entr : charSelect.entrySet()) {
                if (entr.getValue().size() > 1) {
                    for (int i = 0; i < entr.getValue().size() - 1; i++) {
                        for (int j = i + 1; j < entr.getValue().size(); j++) {
                            if (isPolindrom(incom, entr.getValue().get(i), entr.getValue().get(j))) {
                                if (entr.getValue().get(j) - entr.getValue().get(i) > maxSize) {
                                    maxSize = entr.getValue().get(j) - entr.getValue().get(i);
                                    maxFirst = entr.getValue().get(i);
                                    maxLast = entr.getValue().get(j);
                                }
                            }
                        }
                    }
                }
            }
            return s.substring(maxFirst, maxLast + 1);
        }
        private boolean isPolindrom ( char[] c, int first, int last){
            boolean isPol = true;
            do {
                if (c[first] != c[last])
                    isPol = false;
                first++;
                last--;
            } while (isPol && first < last);
            return isPol;
        }
        public String longestPalindrome_firstTry (String s){
            char[] incom = s.toCharArray();
            int size = incom.length;
            if (size == 1)
                return s;
            if (size == 2) {
                if (incom[0] == incom[1])
                    return s;
                else return s.substring(0, 1);
            }
            int curFirst = 0;
            int curLast = 0;
            int maxFirst = 0;
            int maxLast = 0;
            int maxSize = 0;
            for (int i = 0; i < size - 1; i++) {
                for (int z = size - 1; z > i && z - i > maxSize; z--) {
                    if (incom[i] == incom[z]) {
                        if (i + 1 == z) {
                            if (1 > maxSize) {
                                if (size - 1 - i <= maxSize)
                                    return s.substring(i, z + 1);
                                else {
                                    maxSize = 1;
                                    maxFirst = i;
                                    maxLast = z;
                                }
                            }
                        } else if (i + 1 == z - 1) {
                            if (2 > maxSize) {
                                if (size - 1 - i <= maxSize)
                                    return s.substring(i, z + 1);
                                else {
                                    maxSize = 2;
                                    maxFirst = i;
                                    maxLast = z;
                                }
                            }
                        } else {
                            boolean isPolindrom = true;
                            curFirst = i + 1;
                            curLast = z - 1;
                            do {
                                if (incom[curFirst] != incom[curLast])
                                    isPolindrom = false;
                                curFirst++;
                                curLast--;
                            } while (isPolindrom && curFirst < curLast);
                            if (isPolindrom && z - i > maxSize) {
                                maxFirst = i;
                                maxLast = z;
                                maxSize = z - i;
                            }
                        }
                    }
                }
            }
            return s.substring(maxFirst, maxLast + 1);
        }

        private String makeStringByIndex (String s,int first, int last){
            return s.substring(first, last + 1);
        }
    }
