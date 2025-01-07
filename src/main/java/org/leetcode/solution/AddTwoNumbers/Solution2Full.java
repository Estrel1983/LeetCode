package org.leetcode.solution.AddTwoNumbers;

public class Solution2Full {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return makeSum (l1, l2, 0);
    }
    private ListNode makeSum (ListNode l1, ListNode l2, int add){
        if (l1 == null && l2 == null){
            if (add > 0)
                return new ListNode(1);
            return null;
            }
        int result = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
        if (result >= 10)
            return new ListNode(result-10, makeSum(l1 == null ? null : l1.next, l2 == null ? null : l2.next, 1));
        return new ListNode(result, makeSum(l1 == null ? null : l1.next, l2 == null ? null : l2.next, 0));
    }
}
