import org.junit.jupiter.api.Test;
import org.leetcode.solution.ZigzagConversion.ZigzagConversionSolution;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigZagConversionTest {
    private static final ZigzagConversionSolution solution = new ZigzagConversionSolution();
    @Test
    public void basicTest_1 (){
        String result = solution.solution("PAYPALISHIRING", 3);
        assertEquals("PAHNAPLSIIGYIR", result);
    }
    @Test
    public void basicTest_2 (){
        String result = solution.solution("PAYPALISHIRING", 4);
        assertEquals("PINALSIGYAHRPI", result);
    }
    @Test
    public void sjortTest (){
        String result = solution.solution("A", 1);
        assertEquals("A", result);
    }
}
