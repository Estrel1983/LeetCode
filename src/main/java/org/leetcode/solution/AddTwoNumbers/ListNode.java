package org.leetcode.solution.AddTwoNumbers;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public boolean equals (Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ListNode exampl = (ListNode) obj;
        boolean res = false;
        try {
            res = this.val == exampl.val && ((this.next == null && exampl.next == null) || (this.next).equals(exampl.next));
        } catch (Exception e){
            return false;
        }
        return res;
    }
}
