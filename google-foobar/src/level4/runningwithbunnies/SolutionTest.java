package level4.runningwithbunnies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testCase1() {
        int[][] times = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
        int times_limit = 3;
        int[] output = {0, 1};
        assertArrayEquals(output, Solution.solution(times, times_limit));
    }

    @Test
    public void testCase2() {
        int[][] times ={{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}};
        int times_limit = 1;
        int[] output = {1, 2};
        assertArrayEquals(output, Solution.solution(times, times_limit));
    }
}
