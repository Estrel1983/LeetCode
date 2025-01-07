
import org.junit.jupiter.api.Test;
import org.leetcode.solution.AddTwoNumbers.ListNode;
import org.leetcode.solution.AddTwoNumbers.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTwoNumbersTest {
    Solution solution = new Solution();
    @Test
    void firstTest(){
        ListNode result = solution.addTwoNumbers(createNode(152), createNode(3567));
        assertEquals(createNode(3719), result, "5 - 3 должно быть равно 2");
    }
    @Test
    void secondTest(){
        ListNode result = solution.addTwoNumbers(createNode(9999999991L), createNode(9));
        assertEquals(createNode(10000000000L), result, "5 - 3 должно быть равно 2");
    }
    private ListNode createNode(long num){
        if (num == 0)
            return null;
        return (new ListNode((int) num % 10, createNode(num / 10)));
    }
}
