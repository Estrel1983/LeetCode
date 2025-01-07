import org.junit.jupiter.api.Test;
import org.leetcode.solution.MedianOfTwoSortedArray.SolutionMedianOf2SortedArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOf2SortedArrayTest {
    @Test
    public void firstTest() {
        SolutionMedianOf2SortedArray solution = new SolutionMedianOf2SortedArray();
        double result = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assertEquals(2D, result);
    }
    @Test
    public void secondTest() {
        SolutionMedianOf2SortedArray solution = new SolutionMedianOf2SortedArray();
        double result = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        assertEquals(2.5, result);
    }
    @Test
    public void thirdTest() {
        SolutionMedianOf2SortedArray solution = new SolutionMedianOf2SortedArray();
        double result = solution.findMedianSortedArrays(new int[]{1, 8, 12, 15, 19}, new int[]{3, 8, 10, 11, 20, 22});
        assertEquals(11, result);
    }
}
