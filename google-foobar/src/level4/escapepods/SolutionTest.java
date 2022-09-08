package level4.escapepods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testCase1() {
        int[] entrances = {0, 1};
        int[] exits = {4, 5};
        int[][] path = {{0, 0, 4, 6, 0, 0}, {0, 0, 5, 2, 0, 0}, {0, 0, 0, 0, 4, 4}, {0, 0, 0, 0, 6, 6}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int solution = Solution.solution(entrances, exits, path);
        assertEquals(16, solution);
    }

    @Test
    public void testCase2() {
        int[] entrances = {0};
        int[] exits = {3};
        int[][] path = {{0, 7, 0, 0}, {0, 0, 6, 0}, {0, 0, 0, 8}, {9, 0, 0, 0}};
        int solution = Solution.solution(entrances, exits, path);
        assertEquals(6, solution);
    }
}