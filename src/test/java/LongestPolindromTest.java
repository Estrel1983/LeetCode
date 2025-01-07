import org.junit.jupiter.api.Test;
import org.leetcode.solution.LongestPolindrom.SolutionLongestPolindrom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongestPolindromTest {
    @Test
    public void simpleString(){
        SolutionLongestPolindrom solution = new SolutionLongestPolindrom();
        String answer = solution.longestPalindrome("babad");
        assertTrue("bab".equals(answer) || "aba".equals(answer));
    }
    @Test
    public void simpleStringTwo(){
        SolutionLongestPolindrom solution = new SolutionLongestPolindrom();
        String answer = solution.longestPalindrome("cbbd");
        assertEquals("bb", answer);
    }
    @Test
    public void shortString(){
        SolutionLongestPolindrom solution = new SolutionLongestPolindrom();
        String answer = solution.longestPalindrome("ab");
        assertEquals("a", answer);
    }
    @Test
    public void identicString(){
        SolutionLongestPolindrom solution = new SolutionLongestPolindrom();
        String answer = solution.longestPalindrome("aaaa");
        assertEquals("aaaa", answer);
    }
    @Test
    public void longString(){
        SolutionLongestPolindrom solution = new SolutionLongestPolindrom();
        String answer = solution.longestPalindrome("aacabdkacaa");
        assertEquals("aca", answer);
    }
    @Test
    public void simmetricString(){
        SolutionLongestPolindrom solution = new SolutionLongestPolindrom();
        String answer = solution.longestPalindrome("abcba");
        assertEquals("abcba", answer);
    }
}
