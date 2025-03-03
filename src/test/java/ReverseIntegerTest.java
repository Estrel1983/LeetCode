import org.junit.jupiter.api.Test;
import org.leetcode.solution.ReverseInteger.ReverseIntegerSolution;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {
    private final ReverseIntegerSolution ris = new ReverseIntegerSolution();
    @Test
    public void simpleIntegerTest(){
        int result = ris.solution(123);
        assertEquals(321, result);
    }
    @Test
    public void simpleNegativeIntegerTest(){
        int result = ris.solution(-123);
        assertEquals(-321, result);
    }
    @Test
    public void simpleFirstNullTest(){
        int result = ris.solution(120);
        assertEquals(21, result);
    }
    @Test
    public void maxValueTest(){
        int result = ris.solution(1534236469);
        assertEquals(0, result);
    }

}
