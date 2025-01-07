package org.leetcode.solution.AddTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return makeList (makeInt(l1)+makeInt(l2));
    }
    private long makeInt (ListNode lN){
        long num1 = 0;
        long i = 1;
        do {
            num1 += lN.val * i;
            if (lN.next == null)
                return num1;
            lN = lN.next;
            i = i * 10;
        } while (true);
    }
    private ListNode makeList (long num){
        char [] intAsChar = Long.toString(num).toCharArray();
        ListNode unswer = null;
        for (char ch :intAsChar){
            unswer = new ListNode(Character.getNumericValue(ch), unswer);
        }
        return unswer;
    }
}
