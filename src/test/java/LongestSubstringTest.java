import org.junit.jupiter.api.Test;
import org.leetcode.solution.LongestSubstring.SolutionLongestSubstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringTest {
    @Test
    public void SimpleStringTest() {
        SolutionLongestSubstring solution = new SolutionLongestSubstring();
        int result = solution.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, result);
    }
    @Test
    public void AllEqvStringTest() {
        SolutionLongestSubstring solution = new SolutionLongestSubstring();
        int result = solution.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, result);
    }
    @Test
    public void AnotherStringTest() {
        SolutionLongestSubstring solution = new SolutionLongestSubstring();
        int result = solution.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, result);
    }
    @Test
    public void TwoAStringTest() {
        SolutionLongestSubstring solution = new SolutionLongestSubstring();
        int result = solution.lengthOfLongestSubstring("aab");
        assertEquals(2, result);
    }
    @Test
    public void NotFullStringTest() {
        SolutionLongestSubstring solution = new SolutionLongestSubstring();
        int result = solution.lengthOfLongestSubstring("dvdf");
        assertEquals(3, result);
    }
}
